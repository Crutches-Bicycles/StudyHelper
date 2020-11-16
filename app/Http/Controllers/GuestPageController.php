<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Http;

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
