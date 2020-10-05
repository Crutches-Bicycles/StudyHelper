<?php


namespace App\Http\Controllers;


class UserPageController extends Controller
{

    public function __construct()
    {
        $this->middleware('auth');
    }

    function profile()
    {
        return 'User profile page';
    }

    function group()
    {
        return 'Group page';
    }

    function signIn()
    {
        return 'Sign in to group';
    }

    function schedule()
    {
        return 'Set Schedule by elder';
    }

    function delegate()
    {
        return 'Delegate ';
    }

    function traffic()
    {
        return 'Set traffic by elder';
    }

}
