<?php

namespace Database\Seeders;

use Illuminate\Database\Seeder;
use Illuminate\Support\Facades\DB;
use Illuminate\Support\Facades\Hash;

class UserSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        if (DB::table('users')->count() === 0) {
            DB::table('users')->insert([
                'email' => 'pmswga@gmail.com',
                'password' => Hash::make('12345678'),
                'token' => NULL
            ]);
        }
    }
}
