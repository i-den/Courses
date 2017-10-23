<?php

namespace Core\Service\Commands;


interface IExecutable
{
    public function execute(array $options = null);
}
