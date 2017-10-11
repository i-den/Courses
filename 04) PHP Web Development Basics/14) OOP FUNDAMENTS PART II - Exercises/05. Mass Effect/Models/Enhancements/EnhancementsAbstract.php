<?php


namespace Models\Enhancements;


abstract class EnhancementsAbstract implements EnhancementsInterface
{
    public function __toString()
    {
        return substr(static::class, strrpos(static::class, '\\') + 1);
    }
}