<?php


namespace Database;


interface ResultSetInterface
{
    public function fetchObject(string $className): \Generator;

    public function fetchRow(string $key);
}
