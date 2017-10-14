<?php


namespace Models;


use Utilities\Password\Angel5;
use Models\ICharacter;

class Archangel extends Nephilim implements ICharacter
{
    /** @var  float */
    private $mana;

    public function __construct(
        string  $username,
        float   $mana,
        int     $level
    )
    {
        $this->setMana($mana);
        $hashedPassword = $this->hashPassword($username);
        parent::__construct($username, $level, $hashedPassword);
    }

    public function __toString()
    {
        $archangelOutput = '"' . $this->getUsername() . '" | "'
            . $this->getHashedPassword() . '" -> '
            . substr(static::class, strrpos(static::class, '\\') + 1)
            . PHP_EOL . $this->getMana() * $this->getLevel() . PHP_EOL;

        return $archangelOutput;
    }

    /**
     * @return float
     */
    public function getMana(): float
    {
        return $this->mana;
    }

    /**
     * @param float $mana
     * @return Archangel
     */
    public function setMana(float $mana): Archangel
    {
        $this->mana = $mana;
        return $this;
    }

    public function hashPassword(string $username): string
    {
        $hasher = new Angel5();
        $hashedPassword = $hasher->hashPassword($username);

        return $hashedPassword;
    }
}