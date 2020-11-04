@extends('layout.app')

@section('title') Регистрация @endsection

@section('content')

    <div class="container login-clean" style="background-color: rgba(241,247,252,0);">
        <form class="borderroundlog" method="post" style="width: 462px;height: 695px;background-color: #0085ff;">
            <h1 class="text-center" style="color: rgb(255,255,255);margin-bottom: 20px;margin-top: -10px;font-family: Muller;">Регистрация</h1>
            <div class="border rounded" style="padding: 15px;">
                <p class="text-center" style="color: rgb(255,255,255);font-size: 12px;background-color: #0085ff;margin-top: -32px;width: 145px;padding: 7px;margin-left: 10px;">Основная информация</p>
                <div class="form-group"><input class="form-control" type="text" placeholder="Фамилия*" required=""></div>
                <div class="form-group"><input class="form-control" type="text" placeholder="Имя*" required=""></div>
                <div class="form-group"><input class="form-control" type="text" placeholder="Отчество"></div>
            </div>
            <div class="border rounded" style="padding: 15px;margin-top: 22px;">
                <p class="text-center" style="color: rgb(255,255,255);font-size: 12px;background-color: #0085ff;margin-top: -32px;width: 100px;padding: 7px;margin-left: 10px;">Учетная запись</p>
                <div class="form-group"><input class="form-control" type="email" name="" placeholder="Email" style="padding-left: 20px;" inputmode="email" required=""></div>
                <div class="form-group"><input class="form-control" type="password" name="password" placeholder="Пароль" style="padding-left: 20px;" required=""></div>
                <div class="form-group"><input class="form-control" type="password" name="password" placeholder="Повторите пароль" style="padding-left: 20px;" required=""></div>
                <div class="form-group"><input class="form-control" type="text" placeholder="Группа">
                    <div class="dropdown" style="margin-top: -64px;margin-left: 219px;height: 63px;width: 113px;"><button class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-expanded="false" type="button" style="background-color: rgba(255,255,255,0);color: rgb(0,0,0);width: 31px;height: 45px;margin-top: 14px;font-size: 27px;margin-left: 85px;"></button>
                        <div
                            class="dropdown-menu dropdown-menu-right" role="menu"><a class="dropdown-item" role="presentation" href="#">First Item</a><a class="dropdown-item" role="presentation" href="#">Second Item</a><a class="dropdown-item" role="presentation" href="#">Third Item</a></div>
                    </div>
                </div>
            </div><a class="text-right forgot" href="login.html" style="color: rgb(255,255,255);margin-top: -25px;margin-right: 33px;">Уже есть аккаут?</a>
            <div class="form-row" style="height: 72px;margin-top: -3px;">
                <div class="col-xl-3">
                    <div class="form-check" style="margin-left: 34px;margin-top: -18px;"><input class="form-check-input" type="checkbox" id="formCheck-1"><label class="form-check-label" for="formCheck-1" style="color: rgb(0,0,0);">Староста</label></div>
                </div>
                <div class="col-xl-6 offset-xl-0" style="padding: 0px;height: 71px;width: 159px;">
                    <div class="form-group" style="width: 144px;margin-left: 10px;"><button class="btn btn-primary btn-block swiper-next" type="submit" style="background-color: #ffd600;width: 172px;height: 36px;padding: 0px;color: rgb(0,0,0);font-size: 14px;font-weight: normal;font-family: Muller;">Зарегистрироваться</button></div>
                </div>
            </div>
        </form>
    </div>

@endsection
