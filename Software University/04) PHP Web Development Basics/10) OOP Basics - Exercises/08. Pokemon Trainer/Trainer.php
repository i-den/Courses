<?php

namespace Van\Classes;

require_once './Pokemon.php';

class Trainer
{
    private $name;

    private $pokemons;

    private $badgesCount;

    public function __construct(string $name)
    {
        $this->name = $name;
        $this->pokemons = array();
        $this->badgesCount = 0;
    }

    public function addPokemon(Pokemon $pokemon): void
    {
        $this->pokemons[] = $pokemon;
    }

    public function hasPokemonOfElement(string $type): bool
    {
        foreach ($this->pokemons as $pokemon) {
            if ($pokemon->getElement() === $type) {
                return true;
            }
        }

        return false;
    }

    public function receiveBadge(): void
    {
        $this->badgesCount++;
    }

    public function loseBattle(): void
    {
        foreach ($this->pokemons as $pokemon) {
            $pokemon->loseHealth(10);
        }

        $this->filterAlivePokemons();
    }

    private function filterAlivePokemons(): void
    {
        $this->pokemons = array_filter(
            $this->pokemons,
            function ($pokemon) {
                return $pokemon->getHealth() > 0;
            }
        );
    }

    public function displayAchievements(): void
    {
        echo $this->name . ' ' . $this->badgesCount . ' ' . count($this->pokemons) . PHP_EOL;
    }

    /**
     * @return string
     */
    public function getName(): string
    {
        return $this->name;
    }
    public function getBadgesCount(): int
    {
        return $this->badgesCount;
    }
}
