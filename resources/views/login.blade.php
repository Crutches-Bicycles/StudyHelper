@extends('layout.app')

@section('content')

    <div class="login-clean" style="background-color: rgba(241,247,252,0);">
        <form class="borderroundlog" method="post" style="width: 444px;height: 294px;background-color: #0085ff;">
            <h1 class="text-center" style="color: rgb(255,255,255);margin-bottom: 20px;margin-top: -10px;font-family: Muller;">Авторизация</h1>
            <div class="form-group"><input class="form-control" type="email" name="email" placeholder="Email" style="padding-left: 51px;background-image: url(&quot;assets/img/Group%2018.png&quot;);background-position: left;background-repeat: no-repeat;background-size: contain;"></div>
            <div
                class="form-group"><input class="form-control" type="password" name="password" placeholder="Password" style="padding-left: 52px;background-image: url(&quot;assets/img/Group%2019.png&quot;);background-position: left;background-size: contain;background-repeat: no-repeat;"></div>
            <a
                class="text-right forgot" href="#" style="color: rgb(0,0,0);margin-top: -12px;margin-right: 17px;font-family: Muller;font-style: normal;">Забыли пароль?</a>
            <div class="form-row">
                <div class="col-xl-4 offset-xl-4">
                    <div class="form-group" style="width: 113px;margin-left: 11;margin-top: -9px;height: 32px;margin-right: 4px;"><button class="btn btn-primary btn-block" type="submit" style="background-color: #ffd600;width: 109px;height: 33px;padding: 0px;color: rgb(0,0,0);margin-left: 2px;font-family: Muller;">Войти</button></div>
                </div>
            </div>
        </form>
    </div>

@endsection
