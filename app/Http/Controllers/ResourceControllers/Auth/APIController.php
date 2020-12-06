<?php

namespace App\Http\Controllers\ResourceControllers\Auth;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\DB;
use Illuminate\Support\Facades\Http;

class APIController extends Controller
{
    protected static $baseAPI = 'https://studyhelper-api.herokuapp.com/api';
    protected static $currentUser;

    public static function getBaseAPI()
    {
        return self::$baseAPI;
    }

    public static function setCurrentUser($user)
    {
        self::$currentUser = $user;
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

    protected static function request()
    {
        return Http::withToken(self::$currentUser->getToken());
    }

}
