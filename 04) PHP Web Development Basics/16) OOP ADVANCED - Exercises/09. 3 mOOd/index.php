<?php

use Commands\ListCommand;
use Commands\TakeInputCommand;
use Core\Game;

require_once __DIR__ . '\\Utilities\\autoload.php';

$game = new Game();

$inputCommand = new TakeInputCommand($game);
$listCommand = new ListCommand($game);

$inputCommand->execute();
$listCommand->execute();
