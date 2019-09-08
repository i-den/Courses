<?php


namespace Commands;


use Core\Game;

abstract class Command implements IExecutable
{
    protected $game;

    public function __construct(Game $game)
    {
        $this->game = $game;
    }

    public function getGame(): Game
    {
        return $this->game;
    }
}