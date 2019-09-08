<?php

use Game\Game;
use Models\Ships\Cruiser;
use Models\Ships\Dreadnought;
use Models\Ships\Frigate;

require './Core/autoload.php';

$game = new Game();
$game->start();

