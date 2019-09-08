<?php


namespace Models;


abstract class Nephilim
{
    /** @var  string */
    protected $username;
    /** @var  string */
    protected $hashedPassword;
    /** @var  int */
    protected $level;

    protected function __construct(
        string  $username,
        int     $level,
        string  $hashedPassword
    )
    {
        $this->setUsername($username)
            ->setLevel($level)
            ->setHashedPassword($hashedPassword);
    }

    /**
     * @return string
     */
    public function getUsername(): string
    {
        return $this->username;
    }

    /**
     * @param string $username
     * @return Nephilim
     */
    protected function setUsername(string $username): Nephilim
    {
        $this->username = $username;
        return $this;
    }

    /**
     * @return string
     */
    protected function getHashedPassword(): string
    {
        return $this->hashedPassword;
    }

    /**
     * @param string $hashedPassword
     * @return Nephilim
     */
    protected function setHashedPassword(string $hashedPassword): Nephilim
    {
        $this->hashedPassword = $hashedPassword;
        return $this;
    }

    /**
     * @return int
     */
    protected function getLevel(): int
    {
        return $this->level;
    }

    /**
     * @param int $level
     * @return Nephilim
     */
    protected function setLevel(int $level): Nephilim
    {
        $this->level = $level;
        return $this;
    }
}