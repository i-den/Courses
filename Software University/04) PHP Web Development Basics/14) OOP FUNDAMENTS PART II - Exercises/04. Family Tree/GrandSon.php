<?php


namespace Family;


class GrandSon extends Son
{
    const GENERATION_NUMBER = 3;

    public function getGenerationNum()
    {
        return self::GENERATION_NUMBER;
    }
}