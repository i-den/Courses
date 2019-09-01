<?php


namespace Utilities\Password;


interface IHashable
{
    public function hashPassword(string $username): string;
}