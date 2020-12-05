<?php

namespace App\Http\Controllers\ResourceControllers\Auth;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\DB;
use Illuminate\Support\Facades\Http;

class APIController extends Controller
{

    private static function getUser($email)
    {
        if (!empty($email)) {
            return DB::table('users')->where('email', '=', $email)->first();
        }

        return null;
    }

    private static function updateToken($email)
    {
        return DB::table('users')
            ->where('email', env('BASE_API_EMAIL'))
            ->update(['token' => self::login()->json('token')]);
    }

    public static function isTokenExpired()
    {
        return false;
    }

    public static function request()
    {
        if (self::isTokenExpired()) {
            self::updateToken();
        }

        return Http::withToken(self::getUser()->token);
    }

}
