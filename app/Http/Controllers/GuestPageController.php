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
        $groups = Http::get(env('BASE_API') . '/groups')->json();

        return view('registration', [
            'groups' => $groups
        ]);
    }

    public function login()
    {
        return view('login');
    }

}
