<?php


namespace Family;


class Son extends Father
{
    const GENERATION_NUMBER = 2;

    public function getGenerationNum()
    {
        return self::GENERATION_NUMBER;
    }
}