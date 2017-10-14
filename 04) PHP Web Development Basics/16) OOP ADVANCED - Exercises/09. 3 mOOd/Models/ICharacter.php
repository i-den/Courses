<?php


namespace Models;


interface ICharacter
{
    public function hashPassword(string $username): string;
}