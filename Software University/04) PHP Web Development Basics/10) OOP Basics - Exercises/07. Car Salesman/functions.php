<?php

use Van\Classes\Engine;

function findEngine(array $engines, string $model): Engine
{
    foreach ($engines as $engine) {
        if ($engine->getModel() === $model) {
            return $engine;
        }
    }
}
