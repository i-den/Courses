<?php


namespace Models;


interface IBuyer
{
    public function buyFood();

    public function getFood(): int;
}