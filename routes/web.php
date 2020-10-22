<?php

use Illuminate\Support\Facades\Route;

/*
|--------------------------------------------------------------------------
| Web Routes
|--------------------------------------------------------------------------
|
| Here is where you can register web routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| contains the "web" middleware group. Now create something great!
|
*/

Route::get('/', '\App\Http\Controllers\GuestPageController@welcome')->name('welcome');

Route::get('/login', '\App\Http\Controllers\GuestPageController@login')->name('login');
Route::get('/registration', '\App\Http\Controllers\GuestPageController@registration')->name('registration');

Route::get('/profile', '\App\Http\Controllers\UserPageController@profile')->name('profile');
Route::get('/group', '\App\Http\Controllers\UserPageController@group')->name('group');
Route::get('/sign-in', '\App\Http\Controllers\UserPageController@signIn')->name('signin');

Route::get('/schedule', '\App\Http\Controllers\UserPageController@schedule')->name('schedule');
Route::get('/traffic', '\App\Http\Controllers\UserPageController@traffic')->name('traffic');
Route::get('/delegate', '\App\Http\Controllers\UserPageController@delegate')->name('delegate');


Route::post('groups/create', function () { return 'create group'; });
