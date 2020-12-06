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
            DB::table('users')->insert(
                [
                    [
                        'id' => 1,
                        'email' => 'rest@rest.com',
                        'password' => Hash::make('rest_pass'),
                        'token' => NULL
                    ],
                    [
                        'id' => 2,
                        'email' => 'pmswga@gmail.com',
                        'password' => Hash::make('12345678'),
                        'token' => NULL
                    ],
                ]
            );
        }
    }
}
