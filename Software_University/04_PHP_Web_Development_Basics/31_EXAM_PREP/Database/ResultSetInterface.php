<?php


namespace Database;


interface ResultSetInterface
{
    public function fetch(string $className = null): \Generator;

    public function fetchColumn(int $colNum = 0);
}