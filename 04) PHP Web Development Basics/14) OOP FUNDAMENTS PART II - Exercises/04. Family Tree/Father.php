<?php


namespace Family;


class Father extends Person
{
    const GENERATION_NUMBER = 1;

    public function getGenerationNum()
    {
        return self::GENERATION_NUMBER;
    }
}