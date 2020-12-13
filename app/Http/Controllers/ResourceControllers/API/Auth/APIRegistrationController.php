<?php

namespace App\Http\Controllers\ResourceControllers\API\Auth;

use App\Http\Controllers\Controller;
use App\Http\Controllers\ResourceControllers\API\APIController;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Http;

class APIRegistrationController extends APIController
{

    public static function apiCreateAccount($email, $password, $isElder)
    {
        $accountData = [
            'email' => $email,
            'password' => $password,
            'i' => $isElder
        ];

        return Http::asForm()->post(self::$baseAPI . '/auth/register', $accountData);
    }

    public static function apiCreateStudent($secondName, $firstName, $patronymic, $idGroup, $idAccount)
    {
        $studentData = [
            'secondName' => $secondName,
            'firstName' => $firstName,
            'patronymic' => $patronymic,
            'idGroup' => $idGroup,
            'idAccount' => $idAccount
        ];

        return self::request()->asForm()->post(self::$baseAPI . '/students', $studentData);
    }

    public static function apiCreateGroup($caption, $email)
    {
        $groupData = [
            'caption' => $caption,
            'email' => $email
        ];

        return Http::asForm()->post(self::$baseAPI . '/groups', $groupData);
    }


}
