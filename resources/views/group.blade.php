@extends('layout.app')

@section('title') Моя группа @endsection

@section('content')

    <div class="container">
        <div class="row">
            <div class="col" style="padding-bottom: 9px;">
                <div class="carousel slide" data-ride="carousel" id="carousel-1" data-interval="false">
                    <div class="carousel-inner" role="listbox">
                        <div class="carousel-item active">
                            <div class="card" style="margin-top: 50px;">
                                <div class="card-header" style="background-color: rgb(255,214,0);margin-top: 0;">
                                    <div class="row">
                                        <div class="col-lg-1 col-xl-1"><i class="fas fa-arrow-left" style="font-size: 25px;"></i></div>
                                        <div class="col">
                                            <h5 class="text-center mb-0" style="color: rgb(0,0,0);font-family: Muller;font-style: normal;font-weight: bold;font-size: 24px;">Понедельник</h5>
                                        </div>
                                        <div class="col-lg-1 col-xl-1"><i class="fas fa-arrow-right" style="margin-top: 0px;margin-right: 0px;margin-left: 38px;font-size: 25px;"></i></div>
                                    </div>
                                </div>
                                <div class="card-body" style="padding-bottom: 0px;background-image: url(&quot;assets/img/Rectangle%2034.png&quot;);background-size: contain;background-repeat: no-repeat;background-position: bottom;" data-spy="scroll">
                                    <div class="table-responsive">
                                        <table class="table">
                                            <thead>
                                            <tr>
                                                <th>№</th>
                                                <th class="text-center">Начало</th>
                                                <th class="text-center">Конец<br></th>
                                                <th class="text-center" style="padding: -2px;padding-bottom: 0px;padding-top: 0px;height: 73px;">
                                                    <div class="dropdown" style="margin-top: 0px;padding-top: 17px;padding-bottom: 0px;height: 31px;"><button class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-expanded="false" type="button" style="color: rgb(0,0,0);font-weight: 700;background-color: rgba(67,67,67,0);padding-top: 0px;padding-bottom: 0px;">Неделя</button>
                                                        <div
                                                            class="dropdown-menu" role="menu" style="padding-bottom: 8px;"><a class="dropdown-item" role="presentation" href="#">Четная</a><a class="dropdown-item" role="presentation" href="#">Нечетная</a></div>
                                                    </div><br></th>
                                                <th class="text-center">Предмет<br></th>
                                                <th class="text-center">Вид</th>
                                                <th class="text-center">Преподватель</th>
                                                <th class="text-center">Аудитория</th>
                                            </tr>
                                            </thead>
                                            <tbody class="text-left">
                                            <tr>
                                                <td style="background-color: #ffd600;">1</td>
                                                <td class="text-center">9:00<br></td>
                                                <td class="text-center">10:30</td>
                                                <td class="text-center" style="padding-top: 12px;">Четная</td>
                                                <td class="text-center">4,8,10,14 н. Проектирование и разработка баз данных<br></td>
                                                <td class="text-center">пр</td>
                                                <td class="text-center">Рачков А.В<br></td>
                                                <td class="text-center">Г-227-1<br></td>
                                            </tr>
                                            <tr>
                                                <td style="background-color: #ffd600;">2</td>
                                                <td class="text-center">10:40</td>
                                                <td class="text-center">12:10</td>
                                                <td class="text-center">Четная<br></td>
                                                <td class="text-center">4,8,10,14 н. Проектирование и разработка баз данных<br></td>
                                                <td class="text-center">пр</td>
                                                <td class="text-center">Рачков А.В<br></td>
                                                <td class="text-center">Г-227-1<br></td>
                                            </tr>
                                            <tr>
                                                <td style="background-color: #ffd600;">3</td>
                                                <td class="text-center">12:40</td>
                                                <td class="text-center">14:10</td>
                                                <td class="text-center">Четная<br></td>
                                                <td class="text-center">4,8,10,14 н. Проектирование и разработка баз данных<br></td>
                                                <td class="text-center">пр</td>
                                                <td class="text-center">Рачков А.В<br></td>
                                                <td class="text-center">Г-227-1<br></td>
                                            </tr>
                                            <tr>
                                                <td style="background-color: #ffd600;">4</td>
                                                <td class="text-center">14:20</td>
                                                <td class="text-center">15:50</td>
                                                <td class="text-center">Четная<br></td>
                                                <td class="text-center">4,8,10,14 н. Проектирование и разработка баз данных<br></td>
                                                <td class="text-center">пр</td>
                                                <td class="text-center">Рачков А.В<br></td>
                                                <td class="text-center">Г-227-1<br></td>
                                            </tr>
                                            <tr>
                                                <td style="background-color: #ffd600;">5</td>
                                                <td class="text-center">16:20</td>
                                                <td class="text-center">17:50</td>
                                                <td class="text-center">Четная<br></td>
                                                <td class="text-center">4,8,10,14 н. Проектирование и разработка баз данных<br></td>
                                                <td class="text-center">пр</td>
                                                <td class="text-center">Рачков А.В<br></td>
                                                <td class="text-center">Г-227-1<br></td>
                                            </tr>
                                            <tr>
                                                <td style="background-color: #ffd600;">6</td>
                                                <td class="text-center">18:00</td>
                                                <td class="text-center">19:30</td>
                                                <td class="text-center">Четная<br></td>
                                                <td class="text-center">4,8,10,14 н. Проектирование и разработка баз данных<br></td>
                                                <td class="text-center">пр</td>
                                                <td class="text-center">Рачков А.В<br></td>
                                                <td class="text-center">Г-227-1<br></td>
                                            </tr>
                                            <tr></tr>
                                            </tbody>
                                        </table>
                                    </div>
                                    <div class="row" style="height: 43px;padding-top: 2px;padding-bottom: 18px;background-color: rgba(23,23,23,0);">
                                        <div class="col-lg-2 col-xl-4 offset-lg-10 offset-xl-8"><button class="btn btn-primary" type="button" style="padding-bottom: 2px;padding-top: 2px;margin-top: -6px;margin-left: 17px;">Сохранить</button><button class="btn btn-primary" type="button" style="padding-bottom: 2px;padding-top: 2px;margin-top: -6px;margin-left: 17px;">Редактировать</button></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="carousel-item">
                            <div class="card" style="margin-top: 50px;">
                                <div class="card-header" style="background-color: rgb(255,214,0);margin-top: 0;">
                                    <div class="row">
                                        <div class="col-lg-1 col-xl-1"><i class="fas fa-arrow-left" style="font-size: 25px;"></i></div>
                                        <div class="col">
                                            <h5 class="text-center mb-0" style="color: rgb(0,0,0);font-family: Muller;font-style: normal;font-weight: bold;font-size: 24px;">Вторник</h5>
                                        </div>
                                        <div class="col-lg-1 col-xl-1"><i class="fas fa-arrow-right" style="margin-top: 0px;margin-right: 0px;margin-left: 38px;font-size: 25px;"></i></div>
                                    </div>
                                </div>
                                <div class="card-body" style="padding-bottom: 0px;background-image: url(&quot;assets/img/Rectangle%2034.png&quot;);background-size: contain;background-repeat: no-repeat;background-position: bottom;" data-spy="scroll">
                                    <div class="table-responsive">
                                        <table class="table">
                                            <thead>
                                            <tr>
                                                <th>№</th>
                                                <th class="text-center">Начало</th>
                                                <th class="text-center">Конец<br></th>
                                                <th class="text-center" style="padding: -2px;padding-bottom: 0px;padding-top: 0px;height: 73px;">
                                                    <div class="dropdown" style="margin-top: 0px;padding-top: 17px;padding-bottom: 0px;height: 31px;"><button class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-expanded="false" type="button" style="color: rgb(0,0,0);font-weight: 700;background-color: rgba(67,67,67,0);padding-top: 0px;padding-bottom: 0px;">Неделя</button>
                                                        <div
                                                            class="dropdown-menu" role="menu" style="padding-bottom: 8px;"><a class="dropdown-item" role="presentation" href="#">Четная</a><a class="dropdown-item" role="presentation" href="#">Нечетная</a></div>
                                                    </div><br></th>
                                                <th class="text-center">Предмет<br></th>
                                                <th class="text-center">Вид</th>
                                                <th class="text-center">Преподватель</th>
                                                <th class="text-center">Аудитория</th>
                                            </tr>
                                            </thead>
                                            <tbody class="text-left">
                                            <tr>
                                                <td style="background-color: #ffd600;">1</td>
                                                <td class="text-center">9:00<br></td>
                                                <td class="text-center">10:30</td>
                                                <td class="text-center" style="padding-top: 12px;">Четная</td>
                                                <td class="text-center">4,8,10,14 н. Проектирование и разработка баз данных<br></td>
                                                <td class="text-center">пр</td>
                                                <td class="text-center">Рачков А.В<br></td>
                                                <td class="text-center">Г-227-1<br></td>
                                            </tr>
                                            <tr>
                                                <td style="background-color: #ffd600;">2</td>
                                                <td class="text-center">10:40</td>
                                                <td class="text-center">12:10</td>
                                                <td class="text-center">Четная<br></td>
                                                <td class="text-center">4,8,10,14 н. Проектирование и разработка баз данных<br></td>
                                                <td class="text-center">пр</td>
                                                <td class="text-center">Рачков А.В<br></td>
                                                <td class="text-center">Г-227-1<br></td>
                                            </tr>
                                            <tr>
                                                <td style="background-color: #ffd600;">3</td>
                                                <td class="text-center">12:40</td>
                                                <td class="text-center">14:10</td>
                                                <td class="text-center">Четная<br></td>
                                                <td class="text-center">4,8,10,14 н. Проектирование и разработка баз данных<br></td>
                                                <td class="text-center">пр</td>
                                                <td class="text-center">Рачков А.В<br></td>
                                                <td class="text-center">Г-227-1<br></td>
                                            </tr>
                                            <tr>
                                                <td style="background-color: #ffd600;">4</td>
                                                <td class="text-center">14:20</td>
                                                <td class="text-center">15:50</td>
                                                <td class="text-center">Четная<br></td>
                                                <td class="text-center">4,8,10,14 н. Проектирование и разработка баз данных<br></td>
                                                <td class="text-center">пр</td>
                                                <td class="text-center">Рачков А.В<br></td>
                                                <td class="text-center">Г-227-1<br></td>
                                            </tr>
                                            <tr>
                                                <td style="background-color: #ffd600;">5</td>
                                                <td class="text-center">16:20</td>
                                                <td class="text-center">17:50</td>
                                                <td class="text-center">Четная<br></td>
                                                <td class="text-center">4,8,10,14 н. Проектирование и разработка баз данных<br></td>
                                                <td class="text-center">пр</td>
                                                <td class="text-center">Рачков А.В<br></td>
                                                <td class="text-center">Г-227-1<br></td>
                                            </tr>
                                            <tr>
                                                <td style="background-color: #ffd600;">6</td>
                                                <td class="text-center">18:00</td>
                                                <td class="text-center">19:30</td>
                                                <td class="text-center">Четная<br></td>
                                                <td class="text-center">4,8,10,14 н. Проектирование и разработка баз данных<br></td>
                                                <td class="text-center">пр</td>
                                                <td class="text-center">Рачков А.В<br></td>
                                                <td class="text-center">Г-227-1<br></td>
                                            </tr>
                                            <tr></tr>
                                            </tbody>
                                        </table>
                                    </div>
                                    <div class="row" style="height: 43px;padding-top: 2px;padding-bottom: 18px;background-color: rgba(23,23,23,0);">
                                        <div class="col-lg-2 col-xl-4 offset-lg-10 offset-xl-8"><button class="btn btn-primary" type="button" style="padding-bottom: 2px;padding-top: 2px;margin-top: -6px;margin-left: 17px;">Сохранить</button><button class="btn btn-primary" type="button" style="padding-bottom: 2px;padding-top: 2px;margin-top: -6px;margin-left: 17px;">Редактировать</button></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="carousel-item">
                            <div class="card" style="margin-top: 50px;">
                                <div class="card-header" style="background-color: rgb(255,214,0);margin-top: 0;">
                                    <div class="row">
                                        <div class="col-lg-1 col-xl-1"><i class="fas fa-arrow-left" style="font-size: 25px;"></i></div>
                                        <div class="col">
                                            <h5 class="text-center mb-0" style="color: rgb(0,0,0);font-family: Muller;font-style: normal;font-weight: bold;font-size: 24px;">Среда</h5>
                                        </div>
                                        <div class="col-lg-1 col-xl-1"><i class="fas fa-arrow-right" style="margin-top: 0px;margin-right: 0px;margin-left: 38px;font-size: 25px;"></i></div>
                                    </div>
                                </div>
                                <div class="card-body" style="padding-bottom: 0px;background-image: url(&quot;assets/img/Rectangle%2034.png&quot;);background-size: contain;background-repeat: no-repeat;background-position: bottom;" data-spy="scroll">
                                    <div class="table-responsive">
                                        <table class="table">
                                            <thead>
                                            <tr>
                                                <th>№</th>
                                                <th class="text-center">Начало</th>
                                                <th class="text-center">Конец<br></th>
                                                <th class="text-center" style="padding: -2px;padding-bottom: 0px;padding-top: 0px;height: 73px;">
                                                    <div class="dropdown" style="margin-top: 0px;padding-top: 17px;padding-bottom: 0px;height: 31px;"><button class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-expanded="false" type="button" style="color: rgb(0,0,0);font-weight: 700;background-color: rgba(67,67,67,0);padding-top: 0px;padding-bottom: 0px;">Неделя</button>
                                                        <div
                                                            class="dropdown-menu" role="menu" style="padding-bottom: 8px;"><a class="dropdown-item" role="presentation" href="#">Четная</a><a class="dropdown-item" role="presentation" href="#">Нечетная</a></div>
                                                    </div><br></th>
                                                <th class="text-center">Предмет<br></th>
                                                <th class="text-center">Вид</th>
                                                <th class="text-center">Преподватель</th>
                                                <th class="text-center">Аудитория</th>
                                            </tr>
                                            </thead>
                                            <tbody class="text-left">
                                            <tr>
                                                <td style="background-color: #ffd600;">1</td>
                                                <td class="text-center">9:00<br></td>
                                                <td class="text-center">10:30</td>
                                                <td class="text-center" style="padding-top: 12px;">Четная</td>
                                                <td class="text-center">4,8,10,14 н. Проектирование и разработка баз данных<br></td>
                                                <td class="text-center">пр</td>
                                                <td class="text-center">Рачков А.В<br></td>
                                                <td class="text-center">Г-227-1<br></td>
                                            </tr>
                                            <tr>
                                                <td style="background-color: #ffd600;">2</td>
                                                <td class="text-center">10:40</td>
                                                <td class="text-center">12:10</td>
                                                <td class="text-center">Четная<br></td>
                                                <td class="text-center">4,8,10,14 н. Проектирование и разработка баз данных<br></td>
                                                <td class="text-center">пр</td>
                                                <td class="text-center">Рачков А.В<br></td>
                                                <td class="text-center">Г-227-1<br></td>
                                            </tr>
                                            <tr>
                                                <td style="background-color: #ffd600;">3</td>
                                                <td class="text-center">12:40</td>
                                                <td class="text-center">14:10</td>
                                                <td class="text-center">Четная<br></td>
                                                <td class="text-center">4,8,10,14 н. Проектирование и разработка баз данных<br></td>
                                                <td class="text-center">пр</td>
                                                <td class="text-center">Рачков А.В<br></td>
                                                <td class="text-center">Г-227-1<br></td>
                                            </tr>
                                            <tr>
                                                <td style="background-color: #ffd600;">4</td>
                                                <td class="text-center">14:20</td>
                                                <td class="text-center">15:50</td>
                                                <td class="text-center">Четная<br></td>
                                                <td class="text-center">4,8,10,14 н. Проектирование и разработка баз данных<br></td>
                                                <td class="text-center">пр</td>
                                                <td class="text-center">Рачков А.В<br></td>
                                                <td class="text-center">Г-227-1<br></td>
                                            </tr>
                                            <tr>
                                                <td style="background-color: #ffd600;">5</td>
                                                <td class="text-center">16:20</td>
                                                <td class="text-center">17:50</td>
                                                <td class="text-center">Четная<br></td>
                                                <td class="text-center">4,8,10,14 н. Проектирование и разработка баз данных<br></td>
                                                <td class="text-center">пр</td>
                                                <td class="text-center">Рачков А.В<br></td>
                                                <td class="text-center">Г-227-1<br></td>
                                            </tr>
                                            <tr>
                                                <td style="background-color: #ffd600;">6</td>
                                                <td class="text-center">18:00</td>
                                                <td class="text-center">19:30</td>
                                                <td class="text-center">Четная<br></td>
                                                <td class="text-center">4,8,10,14 н. Проектирование и разработка баз данных<br></td>
                                                <td class="text-center">пр</td>
                                                <td class="text-center">Рачков А.В<br></td>
                                                <td class="text-center">Г-227-1<br></td>
                                            </tr>
                                            <tr></tr>
                                            </tbody>
                                        </table>
                                    </div>
                                    <div class="row" style="height: 43px;padding-top: 2px;padding-bottom: 18px;background-color: rgba(23,23,23,0);">
                                        <div class="col-lg-2 col-xl-4 offset-lg-10 offset-xl-8"><button class="btn btn-primary" type="button" style="padding-bottom: 2px;padding-top: 2px;margin-top: -6px;margin-left: 17px;">Сохранить</button><button class="btn btn-primary" type="button" style="padding-bottom: 2px;padding-top: 2px;margin-top: -6px;margin-left: 17px;">Редактировать</button></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="carousel-item">
                            <div class="card" style="margin-top: 50px;">
                                <div class="card-header" style="background-color: rgb(255,214,0);margin-top: 0;">
                                    <div class="row">
                                        <div class="col-lg-1 col-xl-1"><i class="fas fa-arrow-left" style="font-size: 25px;"></i></div>
                                        <div class="col">
                                            <h5 class="text-center mb-0" style="color: rgb(0,0,0);font-family: Muller;font-style: normal;font-weight: bold;font-size: 24px;">Четверг</h5>
                                        </div>
                                        <div class="col-lg-1 col-xl-1"><i class="fas fa-arrow-right" style="margin-top: 0px;margin-right: 0px;margin-left: 38px;font-size: 25px;"></i></div>
                                    </div>
                                </div>
                                <div class="card-body" style="padding-bottom: 0px;background-image: url(&quot;assets/img/Rectangle%2034.png&quot;);background-size: contain;background-repeat: no-repeat;background-position: bottom;" data-spy="scroll">
                                    <div class="table-responsive">
                                        <table class="table">
                                            <thead>
                                            <tr>
                                                <th>№</th>
                                                <th class="text-center">Начало</th>
                                                <th class="text-center">Конец<br></th>
                                                <th class="text-center" style="padding: -2px;padding-bottom: 0px;padding-top: 0px;height: 73px;">
                                                    <div class="dropdown" style="margin-top: 0px;padding-top: 17px;padding-bottom: 0px;height: 31px;"><button class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-expanded="false" type="button" style="color: rgb(0,0,0);font-weight: 700;background-color: rgba(67,67,67,0);padding-top: 0px;padding-bottom: 0px;">Неделя</button>
                                                        <div
                                                            class="dropdown-menu" role="menu" style="padding-bottom: 8px;"><a class="dropdown-item" role="presentation" href="#">Четная</a><a class="dropdown-item" role="presentation" href="#">Нечетная</a></div>
                                                    </div><br></th>
                                                <th class="text-center">Предмет<br></th>
                                                <th class="text-center">Вид</th>
                                                <th class="text-center">Преподватель</th>
                                                <th class="text-center">Аудитория</th>
                                            </tr>
                                            </thead>
                                            <tbody class="text-left">
                                            <tr>
                                                <td style="background-color: #ffd600;">1</td>
                                                <td class="text-center">9:00<br></td>
                                                <td class="text-center">10:30</td>
                                                <td class="text-center" style="padding-top: 12px;">Четная</td>
                                                <td class="text-center">4,8,10,14 н. Проектирование и разработка баз данных<br></td>
                                                <td class="text-center">пр</td>
                                                <td class="text-center">Рачков А.В<br></td>
                                                <td class="text-center">Г-227-1<br></td>
                                            </tr>
                                            <tr>
                                                <td style="background-color: #ffd600;">2</td>
                                                <td class="text-center">10:40</td>
                                                <td class="text-center">12:10</td>
                                                <td class="text-center">Четная<br></td>
                                                <td class="text-center">4,8,10,14 н. Проектирование и разработка баз данных<br></td>
                                                <td class="text-center">пр</td>
                                                <td class="text-center">Рачков А.В<br></td>
                                                <td class="text-center">Г-227-1<br></td>
                                            </tr>
                                            <tr>
                                                <td style="background-color: #ffd600;">3</td>
                                                <td class="text-center">12:40</td>
                                                <td class="text-center">14:10</td>
                                                <td class="text-center">Четная<br></td>
                                                <td class="text-center">4,8,10,14 н. Проектирование и разработка баз данных<br></td>
                                                <td class="text-center">пр</td>
                                                <td class="text-center">Рачков А.В<br></td>
                                                <td class="text-center">Г-227-1<br></td>
                                            </tr>
                                            <tr>
                                                <td style="background-color: #ffd600;">4</td>
                                                <td class="text-center">14:20</td>
                                                <td class="text-center">15:50</td>
                                                <td class="text-center">Четная<br></td>
                                                <td class="text-center">4,8,10,14 н. Проектирование и разработка баз данных<br></td>
                                                <td class="text-center">пр</td>
                                                <td class="text-center">Рачков А.В<br></td>
                                                <td class="text-center">Г-227-1<br></td>
                                            </tr>
                                            <tr>
                                                <td style="background-color: #ffd600;">5</td>
                                                <td class="text-center">16:20</td>
                                                <td class="text-center">17:50</td>
                                                <td class="text-center">Четная<br></td>
                                                <td class="text-center">4,8,10,14 н. Проектирование и разработка баз данных<br></td>
                                                <td class="text-center">пр</td>
                                                <td class="text-center">Рачков А.В<br></td>
                                                <td class="text-center">Г-227-1<br></td>
                                            </tr>
                                            <tr>
                                                <td style="background-color: #ffd600;">6</td>
                                                <td class="text-center">18:00</td>
                                                <td class="text-center">19:30</td>
                                                <td class="text-center">Четная<br></td>
                                                <td class="text-center">4,8,10,14 н. Проектирование и разработка баз данных<br></td>
                                                <td class="text-center">пр</td>
                                                <td class="text-center">Рачков А.В<br></td>
                                                <td class="text-center">Г-227-1<br></td>
                                            </tr>
                                            <tr></tr>
                                            </tbody>
                                        </table>
                                    </div>
                                    <div class="row" style="height: 43px;padding-top: 2px;padding-bottom: 18px;background-color: rgba(23,23,23,0);">
                                        <div class="col-lg-2 col-xl-4 offset-lg-10 offset-xl-8"><button class="btn btn-primary" type="button" style="padding-bottom: 2px;padding-top: 2px;margin-top: -6px;margin-left: 17px;">Сохранить</button><button class="btn btn-primary" type="button" style="padding-bottom: 2px;padding-top: 2px;margin-top: -6px;margin-left: 17px;">Редактировать</button></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="carousel-item">
                            <div class="card" style="margin-top: 50px;">
                                <div class="card-header" style="background-color: rgb(255,214,0);margin-top: 0;">
                                    <div class="row">
                                        <div class="col-lg-1 col-xl-1"><i class="fas fa-arrow-left" style="font-size: 25px;"></i></div>
                                        <div class="col">
                                            <h5 class="text-center mb-0" style="color: rgb(0,0,0);font-family: Muller;font-style: normal;font-weight: bold;font-size: 24px;">Пятница</h5>
                                        </div>
                                        <div class="col-lg-1 col-xl-1"><i class="fas fa-arrow-right" style="margin-top: 0px;margin-right: 0px;margin-left: 38px;font-size: 25px;"></i></div>
                                    </div>
                                </div>
                                <div class="card-body" style="padding-bottom: 0px;background-image: url(&quot;assets/img/Rectangle%2034.png&quot;);background-size: contain;background-repeat: no-repeat;background-position: bottom;" data-spy="scroll">
                                    <div class="table-responsive">
                                        <table class="table">
                                            <thead>
                                            <tr>
                                                <th>№</th>
                                                <th class="text-center">Начало</th>
                                                <th class="text-center">Конец<br></th>
                                                <th class="text-center" style="padding: -2px;padding-bottom: 0px;padding-top: 0px;height: 73px;">
                                                    <div class="dropdown" style="margin-top: 0px;padding-top: 17px;padding-bottom: 0px;height: 31px;"><button class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-expanded="false" type="button" style="color: rgb(0,0,0);font-weight: 700;background-color: rgba(67,67,67,0);padding-top: 0px;padding-bottom: 0px;">Неделя</button>
                                                        <div
                                                            class="dropdown-menu" role="menu" style="padding-bottom: 8px;"><a class="dropdown-item" role="presentation" href="#">Четная</a><a class="dropdown-item" role="presentation" href="#">Нечетная</a></div>
                                                    </div><br></th>
                                                <th class="text-center">Предмет<br></th>
                                                <th class="text-center">Вид</th>
                                                <th class="text-center">Преподватель</th>
                                                <th class="text-center">Аудитория</th>
                                            </tr>
                                            </thead>
                                            <tbody class="text-left">
                                            <tr>
                                                <td style="background-color: #ffd600;">1</td>
                                                <td class="text-center">9:00<br></td>
                                                <td class="text-center">10:30</td>
                                                <td class="text-center" style="padding-top: 12px;">Четная</td>
                                                <td class="text-center">4,8,10,14 н. Проектирование и разработка баз данных<br></td>
                                                <td class="text-center">пр</td>
                                                <td class="text-center">Рачков А.В<br></td>
                                                <td class="text-center">Г-227-1<br></td>
                                            </tr>
                                            <tr>
                                                <td style="background-color: #ffd600;">2</td>
                                                <td class="text-center">10:40</td>
                                                <td class="text-center">12:10</td>
                                                <td class="text-center">Четная<br></td>
                                                <td class="text-center">4,8,10,14 н. Проектирование и разработка баз данных<br></td>
                                                <td class="text-center">пр</td>
                                                <td class="text-center">Рачков А.В<br></td>
                                                <td class="text-center">Г-227-1<br></td>
                                            </tr>
                                            <tr>
                                                <td style="background-color: #ffd600;">3</td>
                                                <td class="text-center">12:40</td>
                                                <td class="text-center">14:10</td>
                                                <td class="text-center">Четная<br></td>
                                                <td class="text-center">4,8,10,14 н. Проектирование и разработка баз данных<br></td>
                                                <td class="text-center">пр</td>
                                                <td class="text-center">Рачков А.В<br></td>
                                                <td class="text-center">Г-227-1<br></td>
                                            </tr>
                                            <tr>
                                                <td style="background-color: #ffd600;">4</td>
                                                <td class="text-center">14:20</td>
                                                <td class="text-center">15:50</td>
                                                <td class="text-center">Четная<br></td>
                                                <td class="text-center">4,8,10,14 н. Проектирование и разработка баз данных<br></td>
                                                <td class="text-center">пр</td>
                                                <td class="text-center">Рачков А.В<br></td>
                                                <td class="text-center">Г-227-1<br></td>
                                            </tr>
                                            <tr>
                                                <td style="background-color: #ffd600;">5</td>
                                                <td class="text-center">16:20</td>
                                                <td class="text-center">17:50</td>
                                                <td class="text-center">Четная<br></td>
                                                <td class="text-center">4,8,10,14 н. Проектирование и разработка баз данных<br></td>
                                                <td class="text-center">пр</td>
                                                <td class="text-center">Рачков А.В<br></td>
                                                <td class="text-center">Г-227-1<br></td>
                                            </tr>
                                            <tr>
                                                <td style="background-color: #ffd600;">6</td>
                                                <td class="text-center">18:00</td>
                                                <td class="text-center">19:30</td>
                                                <td class="text-center">Четная<br></td>
                                                <td class="text-center">4,8,10,14 н. Проектирование и разработка баз данных<br></td>
                                                <td class="text-center">пр</td>
                                                <td class="text-center">Рачков А.В<br></td>
                                                <td class="text-center">Г-227-1<br></td>
                                            </tr>
                                            <tr></tr>
                                            </tbody>
                                        </table>
                                    </div>
                                    <div class="row" style="height: 43px;padding-top: 2px;padding-bottom: 18px;background-color: rgba(23,23,23,0);">
                                        <div class="col-lg-2 col-xl-4 offset-lg-10 offset-xl-8">
                                            <!-- todo: check user type. If is elder then show it  -->
                                            <button class="btn btn-primary" type="button" style="padding-bottom: 2px;padding-top: 2px;margin-top: -6px;margin-left: 17px;">Сохранить</button>
                                            <button class="btn btn-primary" type="button" style="padding-bottom: 2px;padding-top: 2px;margin-top: -6px;margin-left: 17px;">Редактировать</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="carousel-item">
                            <div class="card" style="margin-top: 50px;">
                                <div class="card-header" style="background-color: rgb(255,214,0);margin-top: 0;">
                                    <div class="row">
                                        <div class="col-lg-1 col-xl-1"><i class="fas fa-arrow-left" style="font-size: 25px;"></i></div>
                                        <div class="col">
                                            <h5 class="text-center mb-0" style="color: rgb(0,0,0);font-family: Muller;font-style: normal;font-weight: bold;font-size: 24px;">Суббота</h5>
                                        </div>
                                        <div class="col-lg-1 col-xl-1"><i class="fas fa-arrow-right" style="margin-top: 0px;margin-right: 0px;margin-left: 38px;font-size: 25px;"></i></div>
                                    </div>
                                </div>
                                <div class="card-body" style="padding-bottom: 0px;background-image: url(&quot;assets/img/Rectangle%2034.png&quot;);background-size: contain;background-repeat: no-repeat;background-position: bottom;" data-spy="scroll">
                                    <div class="table-responsive">
                                        <table class="table">
                                            <thead>
                                            <tr>
                                                <th>№</th>
                                                <th class="text-center">Начало</th>
                                                <th class="text-center">Конец<br></th>
                                                <th class="text-center" style="padding: -2px;padding-bottom: 0px;padding-top: 0px;height: 73px;">
                                                    <div class="dropdown" style="margin-top: 0px;padding-top: 17px;padding-bottom: 0px;height: 31px;"><button class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-expanded="false" type="button" style="color: rgb(0,0,0);font-weight: 700;background-color: rgba(67,67,67,0);padding-top: 0px;padding-bottom: 0px;">Неделя</button>
                                                        <div
                                                            class="dropdown-menu" role="menu" style="padding-bottom: 8px;"><a class="dropdown-item" role="presentation" href="#">Четная</a><a class="dropdown-item" role="presentation" href="#">Нечетная</a></div>
                                                    </div><br></th>
                                                <th class="text-center">Предмет<br></th>
                                                <th class="text-center">Вид</th>
                                                <th class="text-center">Преподватель</th>
                                                <th class="text-center">Аудитория</th>
                                            </tr>
                                            </thead>
                                            <tbody class="text-left">
                                            <tr>
                                                <td style="background-color: #ffd600;">1</td>
                                                <td class="text-center">9:00<br></td>
                                                <td class="text-center">10:30</td>
                                                <td class="text-center" style="padding-top: 12px;">Четная</td>
                                                <td class="text-center">4,8,10,14 н. Проектирование и разработка баз данных<br></td>
                                                <td class="text-center">пр</td>
                                                <td class="text-center">Рачков А.В<br></td>
                                                <td class="text-center">Г-227-1<br></td>
                                            </tr>
                                            <tr>
                                                <td style="background-color: #ffd600;">2</td>
                                                <td class="text-center">10:40</td>
                                                <td class="text-center">12:10</td>
                                                <td class="text-center">Четная<br></td>
                                                <td class="text-center">4,8,10,14 н. Проектирование и разработка баз данных<br></td>
                                                <td class="text-center">пр</td>
                                                <td class="text-center">Рачков А.В<br></td>
                                                <td class="text-center">Г-227-1<br></td>
                                            </tr>
                                            <tr>
                                                <td style="background-color: #ffd600;">3</td>
                                                <td class="text-center">12:40</td>
                                                <td class="text-center">14:10</td>
                                                <td class="text-center">Четная<br></td>
                                                <td class="text-center">4,8,10,14 н. Проектирование и разработка баз данных<br></td>
                                                <td class="text-center">пр</td>
                                                <td class="text-center">Рачков А.В<br></td>
                                                <td class="text-center">Г-227-1<br></td>
                                            </tr>
                                            <tr>
                                                <td style="background-color: #ffd600;">4</td>
                                                <td class="text-center">14:20</td>
                                                <td class="text-center">15:50</td>
                                                <td class="text-center">Четная<br></td>
                                                <td class="text-center">4,8,10,14 н. Проектирование и разработка баз данных<br></td>
                                                <td class="text-center">пр</td>
                                                <td class="text-center">Рачков А.В<br></td>
                                                <td class="text-center">Г-227-1<br></td>
                                            </tr>
                                            <tr>
                                                <td style="background-color: #ffd600;">5</td>
                                                <td class="text-center">16:20</td>
                                                <td class="text-center">17:50</td>
                                                <td class="text-center">Четная<br></td>
                                                <td class="text-center">4,8,10,14 н. Проектирование и разработка баз данных<br></td>
                                                <td class="text-center">пр</td>
                                                <td class="text-center">Рачков А.В<br></td>
                                                <td class="text-center">Г-227-1<br></td>
                                            </tr>
                                            <tr>
                                                <td style="background-color: #ffd600;">6</td>
                                                <td class="text-center">18:00</td>
                                                <td class="text-center">19:30</td>
                                                <td class="text-center">Четная<br></td>
                                                <td class="text-center">4,8,10,14 н. Проектирование и разработка баз данных<br></td>
                                                <td class="text-center">пр</td>
                                                <td class="text-center">Рачков А.В<br></td>
                                                <td class="text-center">Г-227-1<br></td>
                                            </tr>
                                            <tr></tr>
                                            </tbody>
                                        </table>
                                    </div>
                                    <div class="row" style="height: 43px;padding-top: 2px;padding-bottom: 18px;background-color: rgba(23,23,23,0);">
                                        <div class="col-lg-2 col-xl-4 offset-lg-10 offset-xl-8">
                                            <button class="btn btn-primary" type="button" style="padding-bottom: 2px;padding-top: 2px;margin-top: -6px;margin-left: 17px;">Сохранить</button>
                                            <button class="btn btn-primary" type="button" style="padding-bottom: 2px;padding-top: 2px;margin-top: -6px;margin-left: 17px;">Редактировать</button> -->
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div>
                        <a class="carousel-control-prev" href="#carousel-1" role="button" data-slide="prev" style="height: 49px;width: 74px;margin-top: 52px;">
                            <span class="carousel-control-prev-icon" style="background-image: url(&quot;none&quot;);"></span>
                            <span class="sr-only">Previous</span>
                        </a>
                        <a class="carousel-control-next" href="#carousel-1" role="button" data-slide="next" style="height: 49px;width: 71px;margin-top: 53px;">
                            <span class="carousel-control-next-icon" style="background-image: url(&quot;none&quot;);"></span>
                            <span class="sr-only">Next</span>
                        </a>
                    </div>
                    <ol class="carousel-indicators d-none">
                        <li data-target="#carousel-1" data-slide-to="0" class="active"></li>
                        <li data-target="#carousel-1" data-slide-to="1"></li>
                        <li data-target="#carousel-1" data-slide-to="2"></li>
                        <li data-target="#carousel-1" data-slide-to="3"></li>
                        <li data-target="#carousel-1" data-slide-to="4"></li>
                        <li data-target="#carousel-1" data-slide-to="5"></li>
                    </ol>
                </div>
                <div class="card" style="margin-top: 50px;">
                    <div class="card-header" style="background-color: rgb(255,214,0);margin-top: 0;">
                        <h5 class="text-center mb-0" style="color: rgb(0,0,0);font-family: Muller;font-style: normal;font-weight: bold;font-size: 24px;">Файлы группы</h5>
                    </div>
                    <div class="card-body" style="padding-bottom: 0px;background-image: url(&quot;assets/img/Rectangle%2034.png&quot;);background-size: contain;background-repeat: no-repeat;background-position: bottom;" data-spy="scroll">
                        <!-- todo: show download file button  -->
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
                                                <form class="borderroundlog" method="post" style="width: 462px;height: 463px;background-color: #0085ff;">
                                                    <h1 class="text-center" style="color: rgb(255,255,255);margin-bottom: 20px;margin-top: -10px;font-family: Muller;">Преподаватель</h1>
                                                    <div class="form-group"><input class="form-control" type="text" placeholder="Фамилия"></div>
                                                    <div class="form-group"><input class="form-control" type="text" placeholder="Имя"></div>
                                                    <div class="form-group"><input class="form-control" type="text" placeholder="Отчество"></div>
                                                    <div class="form-group"><input class="form-control" type="text" placeholder="Дисциплина"></div>
                                                    <div class="form-group"><input class="form-control" type="email" placeholder="Email"></div>
                                                    <div class="form-row" style="height: 72px;margin-top: -3px;">
                                                        <div class="col-xl-6 offset-xl-3" style="padding: 0px;height: 71px;width: 159px;">
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
                <div class="card" style="margin-top: 50px;">
                    <div class="card-header" style="background-color: rgb(255,214,0);margin-top: 0;">
                        <h5 class="text-center mb-0" style="color: rgb(0,0,0);font-family: Muller;font-style: normal;font-weight: bold;font-size: 24px;">Группа</h5>
                    </div>
                    <div class="card-body" style="padding-bottom: 0px;background-image: url(&quot;assets/img/Rectangle%2034.png&quot;);background-size: contain;background-repeat: no-repeat;background-position: bottom;" data-spy="scroll">
                        <div class="table-responsive">
                            <table class="table">
                                <thead>
                                <tr>
                                    <th style="width: 46px;">№</th>
                                    <th class="text-center" style="width: 442px;">ФИО</th>
                                    <th class="text-center">Почта<br></th>
                                    <th></th>
                                </tr>
                                </thead>
                                <tbody class="text-left">

                                @foreach ($students as $student)
                                    <tr>
                                        <td>{{ $loop->index+1 }}</td>
                                        <td class="text-center" style="padding-left: 0px;padding-right: 0px;">{{ $student['secondName'] . ' ' . $student['firstName'] . ' ' . $student['patronymic'] }}</td>
                                        <td class="text-center"></td>
                                        <td><i class="icon ion-android-close" style="font-size: 22px;margin-left: 10px;" type="button"></i></td>
                                    </tr>
                                @endforeach

                                </tbody>
                            </table>
                        </div>
                        <div class="row" style="height: 43px;padding-top: 2px;padding-bottom: 18px;background-color: rgba(23,23,23,0);">
                            <div class="col-lg-2 col-xl-2 offset-lg-6 offset-xl-10">

                                <!-- todo: check user type. If is elder then show it  -->
                                <div class="text-center"><button class="btn btn-primary bs4_modal_trigger" type="button" data-modal-id="bs4_sngl_cmrce" data-toggle="modal">Добавить</button>
                                    <div id="bs4_sngl_cmrce2" class="modal fade bs4_modal2 bs4_blue bs4_bg_white bs4_bd_black bs4_bd_semi_trnsp bs4_none_radius bs4_shadow_none bs4_center bs4_animate bs4FadeInDown bs4_duration_md bs4_easeOutQuint bs4_size_sngl_cmrce"
                                         role="dialog" data-modal-backdrop="true" data-show-on="click" data-modal-delay="false" data-modal-duration="false">
                                        <div class="modal-dialog2">
                                            <div class="modal-content2 login-clean" style="background-color: rgba(255,255,255,0);">
                                                <form class="borderroundlog" method="post" style="width: 462px;height: 463px;background-color: #0085ff;">
                                                    <h1 class="text-center" style="color: rgb(255,255,255);margin-bottom: 20px;margin-top: -10px;font-family: Muller;">Ученик</h1>
                                                    <div class="form-group"><input class="form-control" type="text" placeholder="Фамилия"></div>
                                                    <div class="form-group"><input class="form-control" type="text" placeholder="Имя"></div>
                                                    <div class="form-group"><input class="form-control" type="text" placeholder="Отчество"></div>
                                                    <div class="form-group"><input class="form-control" type="email" placeholder="Email"></div>
                                                    <div class="form-row" style="height: 72px;margin-top: -3px;">
                                                        <div class="col-xl-6 offset-xl-3" style="padding: 0px;height: 71px;width: 159px;">
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
                <div class="card" style="margin-top: 50px;">
                    <div class="card-header" style="background-color: rgb(255,214,0);margin-top: 0;">
                        <h5 class="text-center mb-0" style="color: rgb(0,0,0);font-family: Muller;font-style: normal;font-weight: bold;font-size: 24px;">Преподаватели</h5>
                    </div>
                    <div class="card-body" style="padding-bottom: 0px;background-image: url(&quot;assets/img/Rectangle%2034.png&quot;);background-size: contain;background-repeat: no-repeat;background-position: bottom;" data-spy="scroll">
                        <div class="table-responsive">
                            <table class="table">
                                <thead>
                                <tr>
                                    <th style="width: 46px;">№</th>
                                    <th class="text-center" style="width: 442px;">ФИО</th>
                                    <th class="text-center">Почта<br></th>
                                    <th>Дисциплина</th>
                                    <th></th>
                                </tr>
                                </thead>
                                <tbody class="text-left">
                                <tr>
                                    <td>1</td>
                                    <td class="text-center" style="padding-left: 0px;padding-right: 0px;">Дорожков Кирилл Дмитриевич</td>
                                    <td class="text-center">dorozhkov.k@yandex.ru</td>
                                    <td>Матан</td>
                                    <td><i class="icon ion-android-close" style="font-size: 22px;margin-left: 10px;" type="button"></i></td>
                                </tr>
                                <tr>
                                    <td>2</td>
                                    <td class="text-center"></td>
                                    <td class="text-center"></td>
                                    <td></td>
                                    <td><i class="icon ion-android-close" style="font-size: 22px;margin-left: 10px;" type="button"></i></td>
                                </tr>
                                <tr>
                                    <td>3</td>
                                    <td class="text-center"></td>
                                    <td class="text-center"></td>
                                    <td></td>
                                    <td><i class="icon ion-android-close" style="font-size: 22px;margin-left: 10px;" type="button"></i></td>
                                </tr>
                                <tr>
                                    <td>4</td>
                                    <td class="text-center"></td>
                                    <td class="text-center"></td>
                                    <td></td>
                                    <td><i class="icon ion-android-close" style="font-size: 22px;margin-left: 10px;" type="button"></i></td>
                                </tr>
                                <tr>
                                    <td>5</td>
                                    <td class="text-center"></td>
                                    <td class="text-center"></td>
                                    <td></td>
                                    <td><i class="icon ion-android-close" style="font-size: 22px;margin-left: 10px;" type="button"></i></td>
                                </tr>
                                <tr>
                                    <td>6</td>
                                    <td class="text-center"></td>
                                    <td class="text-center"></td>
                                    <td></td>
                                    <td><i class="icon ion-android-close" style="font-size: 22px;margin-left: 10px;" type="button"></i></td>
                                    <td></td>
                                </tr>
                                <tr>
                                    <td>7</td>
                                    <td class="text-center"></td>
                                    <td class="text-center"></td>
                                    <td></td>
                                    <td><i class="icon ion-android-close" style="font-size: 22px;margin-left: 10px;" type="button"></i></td>
                                    <td></td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                        <div class="row" style="height: 43px;padding-top: 2px;padding-bottom: 18px;background-color: rgba(23,23,23,0);">
                            <div class="col-lg-2 col-xl-2 offset-lg-6 offset-xl-10">

                                <!-- todo: check user type. If is elder then show it  -->
                                <div class="text-center"><button class="btn btn-primary bs4_modal_trigger" type="button" data-modal-id="bs4_sngl_cmrce" data-toggle="modal">Добавить</button>
                                    <div id="bs4_sngl_cmrce" class="modal fade bs4_modal bs4_blue bs4_bg_white bs4_bd_black bs4_bd_semi_trnsp bs4_none_radius bs4_shadow_none bs4_center bs4_animate bs4FadeInDown bs4_duration_md bs4_easeOutQuint bs4_size_sngl_cmrce"
                                         role="dialog" data-modal-backdrop="true" data-show-on="click" data-modal-delay="false" data-modal-duration="false">
                                        <div class="modal-dialog">
                                            <div class="modal-content login-clean" style="background-color: rgba(255,255,255,0);">
                                                <form class="borderroundlog" method="post" style="width: 462px;height: 463px;background-color: #0085ff;">
                                                    <h1 class="text-center" style="color: rgb(255,255,255);margin-bottom: 20px;margin-top: -10px;font-family: Muller;">Преподаватель</h1>
                                                    <div class="form-group"><input class="form-control" type="text" placeholder="Фамилия"></div>
                                                    <div class="form-group"><input class="form-control" type="text" placeholder="Имя"></div>
                                                    <div class="form-group"><input class="form-control" type="text" placeholder="Отчество"></div>
                                                    <div class="form-group"><input class="form-control" type="text" placeholder="Дисциплина"></div>
                                                    <div class="form-group"><input class="form-control" type="email" placeholder="Email"></div>
                                                    <div class="form-row" style="height: 72px;margin-top: -3px;">
                                                        <div class="col-xl-6 offset-xl-3" style="padding: 0px;height: 71px;width: 159px;">
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
        </div>
    </div>

@endsection
