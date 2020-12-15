<?php


namespace App\Http\Controllers;


use App\Http\Controllers\ResourceControllers\API\APIController;
use App\Http\Controllers\ResourceControllers\API\APIStudentController;
use Illuminate\Support\Facades\Auth;
use Illuminate\Support\Facades\Http;

class UserPageController extends Controller
{


    public function __construct()
    {
        $this->middleware('auth');
    }

    public function logout()
    {
        Auth::logout();
        return redirect()->route('welcome');
    }

    public function profile()
    {
        APIController::setCurrentUser(Auth::user());
        $studentData = APIStudentController::getStudent();
        $groupData = APIStudentController::getGroup();

        return view('profile', [
            'student' => $studentData,
            'group' => $groupData
        ]);
    }

    public function group()
    {
        APIController::setCurrentUser(Auth::user());
        $students = APIStudentController::getSogroups();

        return view('group', [
            'students' => $students
        ]);
    }

    public function schedule()
    {
        return 'Set Schedule by elder';
    }

    public function delegate()
    {
        return 'Delegate ';
    }

    public function traffic()
    {
        return view('traffic');
    }

}
