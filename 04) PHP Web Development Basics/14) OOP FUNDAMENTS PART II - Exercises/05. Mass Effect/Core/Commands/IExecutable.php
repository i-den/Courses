<?php


namespace Core\Commands;


interface IExecutable
{
    public function execute(array $args);
}