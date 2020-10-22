<nav class="navbar navbar-light navbar-expand bg-light navigation-clean" style="/*background-color: #0085ff;*/">
    <div class="container">
        <a class="navbar-brand" href={{ route('welcome') }} style="font-family: 'Fredoka One', cursive;font-size: 28px;">
        <img src="assets/img/Group%2017.png" style="width: 50px;margin-right: 5px;margin-top: -5px;">StudyHelper</a>
        <button data-toggle="collapse" class="navbar-toggler" data-target="#navcol-1"></button>
        <div class="collapse navbar-collapse" id="navcol-1">
            <span class="ml-auto navbar-text actions">
                <a class="login" href={{ route('login') }} style="margin-right: 10px;font-family: Roboto, sans-serif;">Вход</a>
                <a class="btn btn-light action-button borderroundbut bordernone" role="button" href={{ route('registration') }} style="background-color: #0085ff;margin-top: -5px;color: rgba(255,255,255,0.9);font-family: Roboto, sans-serif;">Регистрация</a>
            </span>
        </div>
    </div>
</nav>
