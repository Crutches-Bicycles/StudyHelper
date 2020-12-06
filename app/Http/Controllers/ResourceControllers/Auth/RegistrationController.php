<?php

namespace App\Http\Controllers\ResourceControllers\Auth;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Http;

class RegistrationController extends Controller
{

    private function apiCreateAccount($email, $password, $isElder)
    {
        $accountData = [
            'email' => $email,
            'password' => $password,
            'i' => 0
        ];

        if ($isElder) {
            $accountData['i'] = 1;
        }

        return Http::asForm()->post(env('BASE_API') . '/auth/register', $accountData);
    }

    private function apiCreateStudent($secondName, $firstName, $patronymic, $idGroup, $idAccount)
    {
        $studentData = [
            'secondName' => $secondName,
            'firstName' => $firstName,
            'patronymic' => $patronymic,
            'idGroup' => $idGroup,
            'idAccount' => $idAccount
        ];

        return Http::asForm()->post(env('BASE_API') . '/students', $studentData);
    }

    private function apiCreateGroup($caption, $email)
    {
        $groupData = [
            'caption' => $caption,
            'email' => $email
        ];

        return Http::asForm()->post(env('BASE_API') . '/groups', $groupData);
    }


    public function regUser(Request $request)
    {

        print_r(APIController::request());

        exit(env('BASE_API_TOKEN', 'default'));

        $data = $request->only([
            'fn', 'sn', 'pt', 'email', 'password', 'repeatPassword', 'group', 'isElder'
        ]);

        print_r("Create account <br>");

        //$newAccountResponse = $this->apiCreateAccount($data['email'], $data['password'], $data['isElder']);
        //$newAccount = null;
        //if ($newAccountResponse->ok()) {
        //    $newAccount = $newAccountResponse->json();
        //}

        if (($data['isElder'] && $data['group'] === 0) || ($data['isElder'] && is_string($data['group']) )) {

        }

        print_r("Create student <br>");



        //$newStudentResponse = $this->apiCreateStudent($data['sn'], $data['fn'], $data['pt'], $data['group'], $newAccount['idAccount']);

        //if ($newStudentResponse->ok()) {

        //}

        echo "<pre>";
        print_r($data);
        echo "</pre>";

        exit('Hello World');
    }


}
