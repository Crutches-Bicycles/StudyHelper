<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

class GuestPageController extends Controller
{

    public function welcome()
    {
        return view('welcome');
    }

    public function registration()
    {
        return view('registration');
    }

    public function login()
    {
        return view('login');
    }

}
