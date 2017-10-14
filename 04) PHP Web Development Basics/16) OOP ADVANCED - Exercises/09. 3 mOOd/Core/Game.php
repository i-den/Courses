<?php


namespace Core;


use Models\Nephilim;

class Game
{
    /** @var  Nephilim[] */
    private $characters = array();

    public function addCharacter(Nephilim $character)
    {
        $this->characters[] = $character;
    }

    public function printCharacters()
    {
        foreach ($this->characters as $character) {
            echo $character;
        }
    }

    /**
     * @param string $name
     * @return Nephilim|null
     */
    public function findCharacter(string $name)
    {
        foreach ($this->characters as $character) {
            if ($character->getUsername() === $name) {
                return $character;
            }
        }

        return null;
    }
}