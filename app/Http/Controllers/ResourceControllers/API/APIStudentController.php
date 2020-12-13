<?php

namespace App\Http\Controllers\ResourceControllers\API;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Auth;

class APIStudentController extends APIController
{

    public static function getGroup()
    {
        $id = Auth::user()->getId();

        return self::request()->asForm()->get(self::$baseAPI . '/accounts/' . $id)["student"]["group"];
    }

    public static function getStudent()
    {
        $id = Auth::user()->getId();

        return self::request()->asForm()->get(self::$baseAPI . '/accounts/' . $id)["student"];
    }

}
