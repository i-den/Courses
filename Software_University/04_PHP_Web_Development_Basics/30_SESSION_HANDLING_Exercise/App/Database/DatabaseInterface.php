<?php


namespace Database;


interface DatabaseInterface
{
    public function prepare(string $queryString): PreparedStatementInterface;

    public function getLastError(): array;

    public function getLastInsertId(): string ;
}
