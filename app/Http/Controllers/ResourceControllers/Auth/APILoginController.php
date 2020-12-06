<?php

namespace App\Http\Controllers\ResourceControllers\Auth;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Http;

class APILoginController extends APIController
{

    public static function login($email, $password)
    {
        if (!empty($email) && !empty($password)) {
            $response = Http::asForm()->post(env('BASE_API') . '/auth/login', [
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
