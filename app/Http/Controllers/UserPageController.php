<?php


namespace App\Http\Controllers;


use Illuminate\Support\Facades\Auth;

class UserPageController extends Controller
{

    public function __construct()
    {
        $this->middleware('auth');
    }

    public function logout()
    {
        Auth::logout();
        return redirect()->route('welcome');
    }

    public function profile()
    {
        return view('profile');
    }

    public function group()
    {
        return view('group');
    }

    public function schedule()
    {
        return 'Set Schedule by elder';
    }

    public function delegate()
    {
        return 'Delegate ';
    }

    public function traffic()
    {
        return view('traffic');
    }

}
