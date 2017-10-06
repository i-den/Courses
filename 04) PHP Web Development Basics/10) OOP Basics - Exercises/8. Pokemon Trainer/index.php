<?php
declare(strict_types=1);

require_once './Trainer.php';
require_once './functions.php';

use Van\Classes\Trainer;
use Van\Classes\Pokemon;

$trainers = getTrainers();

doBattle($trainers);

listTournamentResults($trainers);
