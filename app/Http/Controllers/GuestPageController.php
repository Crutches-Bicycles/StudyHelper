<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

class GuestPageController extends Controller
{

    function registration()
    {
        return 'Registration page';
    }

    function login()
    {
        return 'Login page';
    }

}
