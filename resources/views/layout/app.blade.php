<!DOCTYPE html>
<html lang="{{ str_replace('_', '-', app()->getLocale()) }}">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
        <title>StudyHelper</title>
        <link rel="stylesheet" href={{ asset('assets/bootstrap/css/bootstrap.min.css') }}>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Fredoka+One">
        <link rel="stylesheet" href={{ asset('assets/css/Muller.css') }}>
        <link rel="stylesheet" href={{ asset('assets/css/Muller%20Hairline.css') }}>
        <link rel="stylesheet" href={{ asset('assets/css/Muller%20Regular.css') }}>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto">
        <link rel="stylesheet" href={{ asset('assets/css/Footer-Dark.css') }}>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/Swiper/3.3.1/css/swiper.min.css">
        <link rel="stylesheet" href={{ asset('assets/css/Login-Form-Clean.css') }}>
        <link rel="stylesheet" href={{ asset('assets/css/Navigation-with-Button.css') }}>
        <link rel="stylesheet" href={{ asset('assets/css/Simple-Slider.css') }}>
        <link rel="stylesheet" href={{ asset('assets/css/untitled-1.css') }}>
        <link rel="stylesheet" href={{ asset('assets/css/untitled.css') }}>
    </head>
    <body>

        @include('components.menu')

        @yield('content')

        @include('components.footer')

        <script src="assets/js/jquery.min.js"></script>
        <script src="assets/bootstrap/js/bootstrap.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Swiper/3.3.1/js/swiper.jquery.min.js"></script>
        <script src="assets/js/Simple-Slider.js"></script>
    </body>
</html>
