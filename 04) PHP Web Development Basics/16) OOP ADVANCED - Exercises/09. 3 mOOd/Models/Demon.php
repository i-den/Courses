<?php


namespace Models;


use Utilities\Password\BDaemon;
use Models\ICharacter;

class Demon extends Nephilim implements ICharacter
{
    /** @var  float */
    private $energy;

    public function __construct(
        string  $username,
        float   $energy,
        int     $level
    )
    {
        $this->setEnergy($energy);
        $hashedPassword = $this->hashPassword($username);
        parent::__construct($username, $level, $hashedPassword);
    }

    public function __toString()
    {
        $formattedLevel = number_format($this->getLevel() * $this->getEnergy(), 1, '.', '');

        $demonOutput = '"' . $this->getUsername() . '" | "'
            . $this->getHashedPassword() . '" -> '
            . substr(static::class, strrpos(static::class, '\\') + 1)
            . PHP_EOL . $formattedLevel . PHP_EOL;

        return $demonOutput;
    }

    public function hashPassword(string $username): string
    {
        $hasher = new BDaemon();
        $hashedPassword = $hasher->hashPassword($username);

        return $hashedPassword;
    }

    /**
     * @return float
     */
    public function getEnergy(): float
    {
        return $this->energy;
    }

    /**
     * @param float $energy
     * @return Demon
     */
    public function setEnergy(float $energy): Demon
    {
        $this->energy = $energy;
        return $this;
    }
}