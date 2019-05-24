<?php


namespace Commands;


class ListCommand extends Command
{

    public function execute()
    {
        $this->getGame()->printCharacters();
    }
}