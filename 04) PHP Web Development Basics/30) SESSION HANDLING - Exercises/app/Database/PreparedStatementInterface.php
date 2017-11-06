<?php


namespace Database;


interface PreparedStatementInterface
{
    public function execute(array $params = array()): ResultSetInterface;
}