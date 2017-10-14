<?php


namespace Utilities\Password;


class Angel5 implements IHashable
{
    const ANG5_MULTIPLIER = 21;

    public function hashPassword(string $username): string
    {
        return (strrev($username) . '"' . (strlen($username) * self::ANG5_MULTIPLIER));
    }
}