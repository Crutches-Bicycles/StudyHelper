<?php

namespace App\Http\Controllers;

use App\Http\Controllers\ResourceControllers\Auth\APILoginController;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Auth;
use Illuminate\Support\Facades\Http;
use Illuminate\Support\Facades\Session;

class GuestPageController extends Controller
{

    public function welcome()
    {
        return view('welcome');
    }

    public function registration()
    {
        $groups = Http::get(env('BASE_API') . '/groups')->json();

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
