@extends('layout.app')

@section('content')

    <div class="container login-clean" style="background-color: rgba(241,247,252,0);">
        <form class="borderroundlog" method="post" style="width: 460px;height: 350px;background-color: #0085ff;">
            <h1 class="text-center" style="color: rgb(255,255,255);margin-bottom: 20px;margin-top: -10px;font-family: Muller;">Регистрация</h1>
            <div class="form-group"><input class="form-control" type="email" name="" placeholder="Почта" style="padding-left: 20px;" inputmode="email" required=""></div>
            <div class="form-group"><input class="form-control" type="password" name="password" placeholder="Пароль" style="padding-left: 20px;" required=""></div>
            <div class="form-group"><input class="form-control" type="password" name="password" placeholder="Повторите пароль" style="padding-left: 20px;" required=""></div><a class="text-right forgot" href="#" style="color: rgb(255,255,255);margin-top: -10px;margin-right: 17px;">Уже есть аккаут?</a>
            <div
                class="form-row">
                <div class="col-xl-3">
                    <div class="form-check" style="margin-top: -20px;margin-left: 17px;"><input class="form-check-input" type="checkbox" id="formCheck-1" style="margin-top: 7px;margin-left: -17px;"><label class="form-check-label" for="formCheck-1" style="color: rgb(0,0,0);font-size: 14px;margin-top: 0px;margin-bottom: 0px;padding-top: 0px;padding-bottom: 0px;">Староста</label></div>
                </div>
                <div class="col-xl-5 offset-xl-4">
                    <div class="form-group" style="width: 89px;margin-left: 75px;margin-right: 0px;margin-top: -12px;"><button class="btn btn-primary btn-block" type="submit" style="background-color: #ffd600;width: 86px;height: 28px;padding: 0px;color: rgb(0,0,0);margin-left: -7px;font-family: Muller;font-size: 18px;">далее</button></div>
                </div>
            </div>
        </form>
    </div>
    <div class="container login-clean" style="background-color: rgba(241,247,252,0);">
        <form class="borderroundlog" method="post" style="width: 460px;height: 350px;background-color: #0085ff;">
            <h1 class="text-center" style="color: rgb(255,255,255);margin-top: -10px;margin-bottom: 20px;font-family: Muller;">Регистрация</h1>
            <div class="form-group"><input class="form-control" type="text" placeholder="Фамилия*" required=""></div>
            <div class="form-group"><input class="form-control" type="text" placeholder="Имя*" required=""></div>
            <div class="form-group"><input class="form-control" type="text" placeholder="Отчество"></div>
            <div class="form-row" style="height: 72px;margin-top: -20px;">
                <div class="col-xl-6 offset-xl-3" style="padding: 0px;height: 71px;width: 159px;">
                    <div class="form-group" style="width: 144px;margin-left: 10px;"><button class="btn btn-primary btn-block swiper-next" type="submit" style="background-color: #ffd600;width: 172px;height: 36px;padding: 0px;color: rgb(0,0,0);font-size: 14px;font-weight: normal;font-family: Muller;">Зарегистрироваться</button></div>
                </div>
            </div>
        </form>
    </div>

@endsection
