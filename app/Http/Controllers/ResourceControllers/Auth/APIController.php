<?php

namespace App\Http\Controllers\ResourceControllers\Auth;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\DB;
use Illuminate\Support\Facades\Http;

class APIController extends Controller
{

    private static function getAPIUser()
    {
        return DB::table('users')->where('email', '=', env('BASE_API_EMAIL'))->first();
    }

    private static function isAPIUserExists()
    {
        return DB::table('users')->where('email', env('BASE_API_EMAIL'))->exists();
    }

    private static function updateToken()
    {
        DB::table('users')
            ->where('email', env('BASE_API_EMAIL'))
            ->update(['token' => self::login()->json('token')]);
    }

    private static function login()
    {
        $response = Http::asForm()->post(env('BASE_API') . '/auth/login', [
            'email' => env('BASE_API_EMAIL'),
            'password' => env('BASE_API_PASSWORD')
        ]);

        return $response;
    }

    public static function isTokenExpired()
    {
        return Http::withToken(self::getAPIUser()->token);
    }

    public static function request()
    {
        if (self::isTokenExpired()) {
            self::updateToken();
        }

        return Http::withToken($apiUser->token);
    }

}
