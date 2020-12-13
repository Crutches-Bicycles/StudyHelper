<?php

namespace App\Http\Controllers\ResourceControllers\API\Auth;

use App\Http\Controllers\Controller;
use App\Http\Controllers\ResourceControllers\API\APIController;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Http;

class APILoginController extends APIController
{

    public static function login($email, $password)
    {
        if (!empty($email) && !empty($password)) {
            $response = Http::asForm()->post(self::$baseAPI . '/auth/login', [
                'email' => $email,
                'password' => $password
            ]);

            if (!array_key_exists('status', $response->json())) {
                return $response;
            }
        }

        return null;
    }

}
