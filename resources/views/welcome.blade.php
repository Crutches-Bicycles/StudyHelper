@extends('layout.app')

@section('content')

    <header class="masthead text-white text-center" style="background: url('assets/img/bg-masthead.jpg')no-repeat center center;background-size: cover;background-image: url(&quot;assets/img/eiEE4atmtwA%201.png&quot;);">
        <div class="overlay"></div>
        <div class="container">
            <div class="row">
                <div class="col-xl-9 mx-auto">
                    <h1 class="mb-5" style="margin-bottom: 0px;font-size: 60px;font-family: Roboto, sans-serif;">Добро пожаловать!</h1>
                    <p style="margin-top: -30px;font-size: 30px;font-family: Roboto, sans-serif;">StudyHelper - ваш личный помощник</p>
                </div>
                <div class="col-md-10 col-lg-8 col-xl-7 mx-auto" style="margin-top: 100px;">
                    <form>
                        <div class="form-row">
                            <div class="col-6 col-sm-4 col-md-4 col-lg-4 col-xl-4 offset-3 offset-sm-4 offset-md-4 offset-lg-4 offset-xl-4"><a class="btn btn-primary btn-block btn-lg borderroundbut" role="button" href="#top" style="background-color: #ffffff;color: rgb(0,0,0);font-family: Roboto, sans-serif;">Подробнее</a></div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </header>


    <section class="features-icons text-center" style="background-color: #f7f7f7;">
        <h1 id="top" style="margin-bottom: 50px;font-size: 50px;font-family: Roboto, sans-serif;">Возможности</h1>
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-md-6 col-lg-3 col-xl-2">
                    <div class="mx-auto features-icons-item mb-5 mb-lg-0 mb-lg-3">
                        <div class="d-flex features-icons-icon" style="background-image: url(&quot;assets/img/преподы.png&quot;);background-position: center;background-repeat: no-repeat;"></div>
                        <p class="lead mb-0" style="font-family: Roboto, sans-serif;">Вести список<br>преподавателей<br></p>
                    </div>
                </div>
                <div class="col-md-6 col-lg-3 col-xl-2">
                    <div class="mx-auto features-icons-item mb-5 mb-lg-0 mb-lg-3">
                        <div class="d-flex features-icons-icon" style="background-image: url(&quot;assets/img/группы.png&quot;);background-position: center;background-repeat: no-repeat;"></div>
                        <p class="lead mb-0" style="font-family: Roboto, sans-serif;">Вести список <br> группы<br></p>
                    </div>
                </div>
                <div class="col-md-6 col-lg-3 col-xl-2">
                    <div class="mx-auto features-icons-item mb-5 mb-lg-0 mb-lg-3">
                        <div class="d-flex features-icons-icon" style="background-image: url(&quot;assets/img/облако.png&quot;);background-position: center;background-repeat: no-repeat;"></div>
                        <p class="lead mb-0" style="font-family: Roboto, sans-serif;">Хранить материалы <br>группы<br></p>
                    </div>
                </div>
                <div class="col-md-6 col-lg-3 col-xl-2">
                    <div class="mx-auto features-icons-item mb-5 mb-lg-0 mb-lg-3">
                        <div class="d-flex features-icons-icon" style="background-image: url(&quot;assets/img/хранить%20м-лы%20одногр.png&quot;);background-position: center;background-repeat: no-repeat;"></div>
                        <p class="lead mb-0" style="font-family: Roboto, sans-serif;">Хранить материалы<br>одногруппников<br></p>
                    </div>
                </div>
            </div>
            <div class="row justify-content-center">
                <div class="col-md-6 col-lg-3 col-xl-2 offset-xl-0">
                    <div class="mx-auto features-icons-item mb-5 mb-lg-0 mb-lg-3">
                        <div class="d-flex features-icons-icon" style="background-image: url(&quot;assets/img/Group%2014.png&quot;);background-position: center;background-repeat: no-repeat;"></div>
                        <p class="lead mb-0" style="font-family: Roboto, sans-serif;">Вести учет<br> посещяемости<br></p>
                    </div>
                </div>
                <div class="col-md-6 col-lg-3 col-xl-2">
                    <div class="mx-auto features-icons-item mb-5 mb-lg-0 mb-lg-3">
                        <div class="d-flex features-icons-icon" style="background-image: url(&quot;assets/img/Vector.png&quot;);background-position: center;background-repeat: no-repeat;"></div>
                        <p class="lead mb-0" style="font-family: Roboto, sans-serif;">Вести расписание<br>занятий<br></p>
                    </div>
                </div>
                <div class="col-md-6 col-lg-3 col-xl-2">
                    <div class="mx-auto features-icons-item mb-5 mb-lg-0 mb-lg-3">
                        <div class="d-flex features-icons-icon" style="background-image: url(&quot;assets/img/отправка%20преподу.png&quot;);background-position: center;background-repeat: no-repeat;"></div>
                        <p class="lead mb-0" style="font-family: Roboto, sans-serif;">Отправлять материалы<br> преподавателям<br></p>
                    </div>
                </div>
                <div class="col-md-6 col-lg-3 col-xl-2">
                    <div class="mx-auto features-icons-item mb-5 mb-lg-0 mb-lg-3">
                        <div class="d-flex features-icons-icon" style="background-image: url(&quot;assets/img/Vector2.png&quot;);background-position: center;background-repeat: no-repeat;"></div>
                        <p class="lead mb-0" style="font-family: Roboto, sans-serif;">Вести список <br>дисциплин<br></p>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <section class="showcase">
        <h1 class="text-center" style="font-size: 50px;font-family: Roboto, sans-serif;">Платформы</h1>
        <div class="container" style="margin-top: 30px;">
            <div class="row justify-content-center">
                <div class="col-md-4 col-lg-3 col-xl-3">
                    <div class="mx-auto testimonial-item mb-5 mb-lg-0" style="background-image: url(&quot;assets/img/Group%2015.png&quot;);background-position: center;background-size: auto;background-repeat: no-repeat;height: 150px;"></div>
                </div>
                <div class="col-md-4 col-lg-3 col-xl-3">
                    <div class="mx-auto testimonial-item mb-5 mb-lg-0" style="height: 150px;background-image: url(&quot;assets/img/Group%2016.png&quot;);background-position: center;background-repeat: no-repeat;"></div>
                </div>
                <div class="col-md-4 col-lg-3 col-xl-3">
                    <div class="mx-auto testimonial-item mb-5 mb-lg-0" style="height: 150px;background-image: url(&quot;assets/img/Vect22or.png&quot;);background-position: center;background-repeat: no-repeat;"></div>
                </div>
            </div>
        </div>
    </section>
    <section class="testimonials text-center">
        <div class="container">
            <h2 class="mb-5" style="font-size: 50px;font-family: Roboto, sans-serif;">Наша команда</h2>
            <div class="row">
                <div class="col-md-6 col-lg-4">
                    <div class="mx-auto testimonial-item mb-5 mb-lg-0"><img class="rounded-circle img-fluid mb-3" src="assets/img/testimonials-1.jpg">
                        <h5 style="font-family: Roboto, sans-serif;">Щербаков Василий</h5>
                        <p class="font-weight-light mb-0" style="font-family: Roboto, sans-serif;">Продукт-Менеджер</p>
                    </div>
                </div>
                <div class="col-md-6 col-lg-4">
                    <div class="mx-auto testimonial-item mb-5 mb-lg-0"><img class="rounded-circle img-fluid mb-3" src="assets/img/testimonials-2.jpg">
                        <h5 style="font-family: Roboto, sans-serif;">Басыров Сергей</h5>
                        <p class="font-weight-light mb-0" style="font-family: Roboto, sans-serif;">Архитектор</p>
                    </div>
                </div>
                <div class="col-lg-4">
                    <div class="mx-auto testimonial-item mb-5 mb-lg-0"><img class="rounded-circle img-fluid mb-3" src="assets/img/testimonials-3.jpg">
                        <h5 style="font-family: Roboto, sans-serif;">Магеррам Зейналов</h5>
                        <p class="font-weight-light mb-0" style="font-family: Roboto, sans-serif;">Backend -разработчик</p>
                    </div>
                </div>
            </div>
            <div class="row" style="margin-top: 50px;">
                <div class="col-md-6 col-lg-4">
                    <div class="mx-auto testimonial-item mb-5 mb-lg-0"><img class="rounded-circle img-fluid mb-3" src="assets/img/testimonials-1.jpg">
                        <h5 style="font-family: Roboto, sans-serif;">Тимошкин Максим</h5>
                        <p class="font-weight-light mb-0" style="font-family: Roboto, sans-serif;">Тестировщик</p>
                    </div>
                </div>
                <div class="col-md-6 col-lg-4">
                    <div class="mx-auto testimonial-item mb-5 mb-lg-0"><img class="rounded-circle img-fluid mb-3" src="assets/img/testimonials-2.jpg">
                        <h5 style="font-family: Roboto, sans-serif;">Сидоров Вадим</h5>
                        <p class="font-weight-light mb-0" style="font-family: Roboto, sans-serif;">Дизайнер</p>
                    </div>
                </div>
                <div class="col-lg-4">
                    <div class="mx-auto testimonial-item mb-5 mb-lg-0"><img class="rounded-circle img-fluid mb-3" src="assets/img/testimonials-3.jpg">
                        <h5 style="font-family: Roboto, sans-serif;">Дорожков Кирилл</h5>
                        <p class="font-weight-light mb-0" style="font-family: Roboto, sans-serif;">Верстальщик/Frontend-разработчик</p>
                    </div>
                </div>
            </div>
        </div>
    </section>

@endsection

