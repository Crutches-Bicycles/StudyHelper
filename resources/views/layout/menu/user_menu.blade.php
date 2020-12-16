<nav class="navbar navbar-light navbar-expand navigation-clean" style="background-color: #0085ff;">
    <div class="container">
        <a class="navbar-brand" href="#" style="font-family: 'Fredoka One', cursive;font-size: 28px;">
            <img src="assets/img/Group%2017.png" style="width: 50px;margin-right: 5px;margin-top: -5px;">StudyHelper
        </a>
        <button data-toggle="collapse" class="navbar-toggler" data-target="#navcol-1"></button>
        <div class="collapse navbar-collapse" id="navcol-1">
            <ul class="nav navbar-nav">
                <li class="nav-item" role="presentation">
                    <a class="nav-link active" href="{{ route('group') }}" style="color: rgba(255,255,255,0.9);font-size: 18px;font-family: Muller;">Моя группа</a>
                </li>
            </ul>
            <div class="dropdown show border rounded-0 border-dark ml-auto" style="background-color: #ffd600;padding: 0px;padding-right: 5px;padding-left: 5px;">
                <a class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true" href="#" style="color: rgb(0,0,0);font-size: 16px;font-family: 'Fredoka One', cursive;font-weight: normal;">{{ Auth::user()->getEmail() }}</a>
                <div class="dropdown-menu dropdown-menu-right " role="menu">
                    <a class="dropdown-item" role="presentation" href="{{ route('profile') }}">Профиль</a>
                    <a class="dropdown-item" role="presentation" href="{{ route('logout') }}">Выход</a>
                    <!-- todo: check user type. If is elder then show it  -->
                    <a class="dropdown-item" role="presentation" href="{{ route('traffic') }}">Посещаемость</a>
                </div>
            </div>
        </div>
    </div>
</nav>
