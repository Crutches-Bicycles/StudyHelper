@extends('layout.app')

@section('title') Отметка посещаемости @endsection

@section('content')

    <div class="container">
        <div class="row">
            <div class="col" style="padding-bottom: 9px;">
                <div class="card">
                    <div class="card-header" style="background-color: rgb(255,214,0);margin-top: 54px;">
                        <div class="row">
                            <div class="col-lg-3 col-xl-3">
                                <h5 class="text-center mb-0" style="color: rgb(0,0,0);font-family: Muller;font-style: normal;font-weight: bold;font-size: 24px;">Посещаемость</h5>
                            </div>
                            <div class="col-lg-3 col-xl-3 offset-lg-6 offset-xl-6"><input type="date" style="margin-left: 30px;"></div>
                        </div>
                    </div>
                    <div class="card-body" style="padding-bottom: 0px;" data-spy="scroll">
                        <div class="table-responsive">
                            <table class="table">
                                <thead>
                                <tr>
                                    <th>№</th>
                                    <th class="text-center">ФИО</th>
                                    <th class="text-center">1<br></th>
                                    <th class="text-center">2<br></th>
                                    <th class="text-center">3<br></th>
                                    <th>4</th>
                                    <th>5</th>
                                    <th>6</th>
                                </tr>
                                </thead>
                                <tbody class="text-left">
                                <tr>
                                    <td>1</td>
                                    <td class="text-center">Дорожков Кирилл Дмитриевич</td>
                                    <td class="text-center"><input type="checkbox"></td>
                                    <td class="text-center"><input type="checkbox"></td>
                                    <td class="text-center"><input type="checkbox"></td>
                                    <td><input type="checkbox"></td>
                                    <td><input type="checkbox"></td>
                                    <td><input type="checkbox"></td>
                                </tr>
                                <tr>
                                    <td><br></td>
                                    <td class="text-center"></td>
                                    <td class="text-center"></td>
                                    <td class="text-center"></td>
                                    <td class="text-center"></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                </tr>
                                <tr>
                                    <td><br></td>
                                    <td class="text-center"></td>
                                    <td class="text-center"></td>
                                    <td class="text-center"></td>
                                    <td class="text-center"></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                </tr>
                                <tr>
                                    <td><br></td>
                                    <td class="text-center"></td>
                                    <td class="text-center"></td>
                                    <td class="text-center"></td>
                                    <td class="text-center"></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                </tr>
                                <tr>
                                    <td><br></td>
                                    <td class="text-center"></td>
                                    <td class="text-center"></td>
                                    <td class="text-center"></td>
                                    <td class="text-center"></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                </tr>
                                <tr>
                                    <td><br></td>
                                    <td class="text-center"></td>
                                    <td class="text-center"></td>
                                    <td class="text-center"></td>
                                    <td class="text-center"></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                </tr>
                                <tr>
                                    <td><br></td>
                                    <td class="text-center"></td>
                                    <td class="text-center"></td>
                                    <td class="text-center"></td>
                                    <td class="text-center"></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

@endsection
