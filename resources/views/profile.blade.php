@extends('layout.app')

@section('title') Профиль @endsection

@section('content')

    <div class="container">
        <div class="row justify-content-center" style="margin-top: 35px;margin-bottom: 21px;">
            <div class="col-auto col-md-4 col-lg-3 col-xl-2"><img src="assets/img/Group%2011.png" style="margin-left: 23px;"><a class="btn btn-primary" role="button" style="color: rgb(0,0,0);margin-top: 9px;margin-left: 15px;font-size: 14px;" href="Repassword.html">Сменить пароль</a></div>
            <div class="col-md-4 col-lg-4 col-xl-4 offset-xl-1">
                <p style="font-family: Muller;font-size: 18px;margin-top: 20px;"><strong>ФИО</strong>: Сидоров Вадим Алексеевич<br></p>
                <p style="font-family: Muller;font-size: 18px;"><strong>Логин</strong>: Mylogin<br></p>
                <p style="font-family: Muller;font-size: 18px;"><strong>Email</strong>: {{ Auth::user()->getEmail() }}<br></p>
            </div>
            <div class="col-md-4 col-lg-5 col-xl-4">
                <p style="font-family: Muller;font-size: 18px;margin-top: 20px;"><strong>Группа</strong>: ИКБО-07-18<br></p>
                <p style="font-family: Muller;font-size: 18px;"><strong>Телефон</strong>: +79999999999<br></p>
                <p style="font-family: Muller;font-size: 18px;"><strong>Статус</strong>: Староста<br></p>
            </div>
        </div>
        <div class="row">
            <div class="col">
                <div class="card">
                    <div class="card-header" style="background-color: rgb(255,214,0);">
                        <h5 class="mb-0" style="color: rgb(0,0,0);font-family: Muller;font-style: normal;font-weight: normal;">Посещяемость и активность студента<br></h5>
                    </div>
                    <div class="card-body">
                        <div class="table-responsive">
                            <table class="table">
                                <thead>
                                <tr>
                                    <th>День</th>
                                    <th class="text-center">9:00<br></th>
                                    <th class="text-center">10:40<br></th>
                                    <th class="text-center">12:40<br></th>
                                    <th class="text-center">14:20<br></th>
                                    <th class="text-center">16:20<br></th>
                                    <th class="text-center">18:00<br></th>
                                </tr>
                                </thead>
                                <tbody class="text-left">
                                <tr>
                                    <td>Понедельник, 1.09.2020<br></td>
                                    <td class="text-center text-success"><i class="fa fa-check"></i></td>
                                    <td class="text-center text-success"><i class="fa fa-check"></i></td>
                                    <td class="text-center text-success"><i class="fa fa-check"></i></td>
                                    <td class="text-center text-danger"><i class="fa fa-times"></i></td>
                                    <td class="text-center text-success"><i class="fa fa-check"></i></td>
                                    <td class="text-center">-</td>
                                </tr>
                                <tr>
                                    <td>Вторник, 1.09.2020<br></td>
                                    <td class="text-center"></td>
                                    <td class="text-center"></td>
                                    <td class="text-center"></td>
                                    <td class="text-center"></td>
                                    <td class="text-center"></td>
                                    <td class="text-center"></td>
                                    <td></td>
                                </tr>
                                <tr>
                                    <td>Среда, 1.09.2020<br></td>
                                    <td class="text-center"></td>
                                    <td class="text-center"></td>
                                    <td class="text-center"></td>
                                    <td class="text-center"></td>
                                    <td class="text-center"></td>
                                    <td class="text-center"></td>
                                </tr>
                                <tr>
                                    <td>Четверг, 1.09.2020<br></td>
                                    <td class="text-center"></td>
                                    <td class="text-center"></td>
                                    <td class="text-center"></td>
                                    <td class="text-center"></td>
                                    <td class="text-center"></td>
                                    <td class="text-center"></td>
                                </tr>
                                <tr>
                                    <td>Пятница, 1.09.2020<br></td>
                                    <td class="text-center"></td>
                                    <td class="text-center"></td>
                                    <td class="text-center"></td>
                                    <td class="text-center"></td>
                                    <td class="text-center"></td>
                                    <td class="text-center"></td>
                                </tr>
                                <tr>
                                    <td>Суббота, 1.09.2020<br></td>
                                    <td class="text-center"></td>
                                    <td class="text-center"></td>
                                    <td class="text-center"></td>
                                    <td class="text-center"></td>
                                    <td class="text-center"></td>
                                    <td class="text-center"></td>
                                </tr>
                                <tr>
                                    <td><br></td>
                                    <td class="text-center"></td>
                                    <td class="text-center"></td>
                                    <td class="text-center"></td>
                                    <td class="text-center"></td>
                                    <td class="text-center"></td>
                                    <td class="text-center"></td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                        <div class="row">
                            <div class="col-xl-3 offset-xl-9">
                                <nav class="text-left">
                                    <ul class="pagination">
                                        <li class="page-item"><a class="page-link" href="#" aria-label="Previous"><span aria-hidden="true">«</span></a></li>
                                        <li class="page-item active"><a class="page-link" href="#">1</a></li>
                                        <li class="page-item"><a class="page-link" href="#">2</a></li>
                                        <li class="page-item"><a class="page-link" href="#">3</a></li>
                                        <li class="page-item"><a class="page-link" href="#">4</a></li>
                                        <li class="page-item"><a class="page-link" href="#">5</a></li>
                                        <li class="page-item"><a class="page-link" href="#" aria-label="Next"><span aria-hidden="true">»</span></a></li>
                                    </ul>
                                </nav>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="card" style="margin-top: 40px;">
            <div class="card-header" style="background-color: rgb(255,214,0);margin-top: 0px;">
                <h5 class="text-center mb-0" style="color: rgb(0,0,0);font-family: Muller;font-style: normal;font-weight: bold;font-size: 24px;">Мои файлы</h5>
            </div>
            <div class="card-body" style="background-image: url(&quot;assets/img/Rectangle%2034.png&quot;);background-size: contain;background-repeat: no-repeat;background-position: bottom;padding-bottom: 0px;" data-spy="scroll">
                <div class="table-responsive">
                    <table class="table">
                        <thead>
                        <tr>
                            <th>Имя файла</th>
                            <th class="text-center">Размер файла</th>
                            <th class="text-center">Тип<br></th>
                            <th class="text-center">Дата<br></th>
                            <th class="text-center">Дисциплина<br></th>
                            <th></th>
                        </tr>
                        </thead>
                        <tbody class="text-left">
                        <tr>
                            <td>Лабораторная работа №1</td>
                            <td class="text-center">3мб</td>
                            <td class="text-center">.docx</td>
                            <td class="text-center">12.10.2020<br></td>
                            <td class="text-center">ВМиС<br></td>
                            <td><i class="la la-download" style="font-size: 23px;" type="button"></i><i class="icon ion-android-close" style="font-size: 22px;margin-left: 10px;" type="button"></i></td>
                        </tr>
                        <tr>
                            <td><br></td>
                            <td class="text-center"></td>
                            <td class="text-center"></td>
                            <td class="text-center"></td>
                            <td class="text-center"></td>
                            <td></td>
                        </tr>
                        <tr>
                            <td><br></td>
                            <td class="text-center"></td>
                            <td class="text-center"></td>
                            <td class="text-center"></td>
                            <td class="text-center"></td>
                            <td></td>
                        </tr>
                        <tr>
                            <td><br></td>
                            <td class="text-center"></td>
                            <td class="text-center"></td>
                            <td class="text-center"></td>
                            <td class="text-center"></td>
                            <td></td>
                        </tr>
                        <tr>
                            <td><br></td>
                            <td class="text-center"></td>
                            <td class="text-center"></td>
                            <td class="text-center"></td>
                            <td class="text-center"></td>
                            <td></td>
                        </tr>
                        <tr>
                            <td><br></td>
                            <td class="text-center"></td>
                            <td class="text-center"></td>
                            <td class="text-center"></td>
                            <td class="text-center"></td>
                            <td></td>
                        </tr>
                        <tr>
                            <td><br></td>
                            <td class="text-center"></td>
                            <td class="text-center"></td>
                            <td class="text-center"></td>
                            <td class="text-center"></td>
                            <td></td>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <div class="row" style="height: 43px;padding-top: 2px;padding-bottom: 18px;background-color: rgba(23,23,23,0);">
                    <div class="col-lg-2 col-xl-2 offset-lg-6 offset-xl-10">
                        <div class="text-center"><button class="btn btn-primary bs4_modal_trigger" type="button" data-modal-id="bs4_sngl_cmrce" data-toggle="modal">Добавить</button>
                            <div id="bs4_sngl_cmrce" class="modal fade bs4_modal bs4_blue bs4_bg_white bs4_bd_black bs4_bd_semi_trnsp bs4_none_radius bs4_shadow_none bs4_center bs4_animate bs4FadeInDown bs4_duration_md bs4_easeOutQuint bs4_size_sngl_cmrce"
                                 role="dialog" data-modal-backdrop="true" data-show-on="click" data-modal-delay="false" data-modal-duration="false">
                                <div class="modal-dialog">
                                    <div class="modal-content login-clean" style="background-color: rgba(255,255,255,0);">
                                        <form class="borderroundlog" method="post" style="width: 462px;height: 388px;background-color: #0085ff;">
                                            <h1 class="text-center" style="color: rgb(255,255,255);margin-bottom: 20px;margin-top: -10px;font-family: Muller;">Выбор файлы</h1>
                                            <div class="form-group"><input class="form-control" type="text" placeholder="Название файла"></div>
                                            <div class="form-group"><input class="form-control" type="text" placeholder="Описание"></div>
                                            <div class="form-group"><input class="form-control" type="text" placeholder="Дисциплина">
                                                <div class="dropdown" style="margin-top: -41px;margin-left: 335px;"><button class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-expanded="false" type="button" style="background-color: rgba(244,71,107,0);color: rgb(0,0,0);font-size: 32px;height: 40px;padding-top: 0px;padding-bottom: 0px;margin-top: 0px;margin-left: 0px;"></button>
                                                    <div
                                                        class="dropdown-menu dropdown-menu-right" role="menu"><a class="dropdown-item" role="presentation" href="#">First Item</a><a class="dropdown-item" role="presentation" href="#">Second Item</a><a class="dropdown-item" role="presentation" href="#">Third Item</a></div>
                                                </div>
                                            </div>
                                            <div class="custom-file"><input type="file" class="custom-file-input border_r20"><label class="custom-file-label border_r20">Upload File</label></div>
                                            <div class="form-row" style="height: 72px;margin-top: -3px;">
                                                <div class="col-xl-6 offset-lg-3 offset-xl-3" style="padding: 0px;height: 71px;width: 159px;">
                                                    <div class="form-group" style="width: 144px;margin-left: 10px;"><button class="btn btn-primary btn-block swiper-next" type="submit" style="background-color: #ffd600;width: 172px;height: 36px;padding: 0px;color: rgb(0,0,0);font-size: 14px;font-weight: normal;font-family: Muller;">Добаивть</button></div>
                                                </div>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

@endsection
