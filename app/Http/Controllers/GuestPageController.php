<?php

namespace App\Http\Controllers;

use App\Http\Controllers\ResourceControllers\API\APIController;
use App\Http\Controllers\ResourceControllers\API\Auth\APILoginController;
use App\Http\Controllers\ResourceControllers\API\Auth\APIRegistrationController;
use App\Models\User;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Auth;
use Illuminate\Support\Facades\DB;
use Illuminate\Support\Facades\Hash;
use Illuminate\Support\Facades\Http;
use Illuminate\Support\Facades\Session;

class GuestPageController extends Controller
{

    public function welcome()
    {
        return view('welcome');
    }

    public function regUser(Request $request)
    {
        $regData = $request->only('sn', 'fn', 'pt', 'email', 'password', 'repeatPassword', 'group', 'isElder');

        if (array_key_exists('isElder', $regData)) {
            $regData['isElder'] = $regData['isElder'] === 'on' ? 1 : 0;
        } else {
            $regData['isElder'] = 0;
        }

        //check password & repeat password

        try
        {
            DB::beginTransaction();

            $accountData = APIRegistrationController::apiCreateAccount($regData['email'], $regData['password'], $regData['isElder'])->json();

            if (!array_key_exists('status', $accountData)) {
                $loggedUser = APILoginController::login($regData['email'], $regData['password'])->json();

                if (!array_key_exists('status', $loggedUser)) {
                    $newAccount = new User();
                    $newAccount->id = $accountData['idAccount'];
                    $newAccount->email = $regData['email'];
                    $newAccount->password = Hash::make($regData['password']);
                    $newAccount->token = $loggedUser['token'];

                    if (!$newAccount->save()) {
                        throw new \Exception();
                    }

                    if (Auth::attempt(['email' => $regData['email'], 'password' => $regData['password']])) {
                        APIController::setCurrentUser(Auth::user());
                    } else {
                        throw new \Exception();
                    }
                } else {

                    //redirect with message: user can't login
                }

            } else {

                //redirect with message: user exists

            }

            if ($regData['isElder'] === 1) {
                $response = APIRegistrationController::apiCreateGroup($regData['group'], 'noset@group')->json();
                if (!array_key_exists('status', $response)) {
                    $regData['group'] = $response['idGroup'];
                }
            }

            APIRegistrationController::apiCreateStudent(
                $regData['sn'],
                $regData['fn'],
                $regData['pt'],
                $regData['group'],
                Auth::user()->getId()
            );

            DB::commit();
        } catch (\Exception $e) {
            DB::rollBack();
            //redirect back with message: error
        }

        return redirect()->route('group');
    }

    public function registration()
    {
        $groups = Http::get(APIController::getBaseAPI() . '/groups')->json();

        return view('registration', [
            'groups' => $groups
        ]);
    }

    public function loginUser(Request $request)
    {
        $email = $request->email;
        $password = $request->password;

        $response = APILoginController::login($email, $password);

        if ($response) {
            if (Auth::attempt([
                'email' => $email,
                'password' => $password
            ])) {
                return redirect()->route('group');
            }
        }

        Session::flash('msg', 'Неправильно были введены логин и/или пароль');
        return redirect()->route('login');
    }

    public function login()
    {
        return view('login');
    }

}
