<?php


namespace Utilities\Password;


class BDaemon implements IHashable
{
    const BDAEM_MULTIPLIER = 217;

    public function hashPassword(string $username): string
    {
        return (string)(strlen($username) * self::BDAEM_MULTIPLIER);
    }
}