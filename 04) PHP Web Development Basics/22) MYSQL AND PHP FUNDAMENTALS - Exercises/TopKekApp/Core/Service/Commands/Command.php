<?php

namespace Core\Service\Commands;

use Core\Adapter\TotallyDoctrine;

abstract class Command implements IExecutable
{
    /**
     * @var TotallyDoctrine
     */
    protected $database;

    protected function __construct(
        TotallyDoctrine $database
    )
    {
        $this->setDatabase($database);
    }

    /**
     * @return TotallyDoctrine
     */
    public function getDatabase(): TotallyDoctrine
    {
        return $this->database;
    }

    /**
     * @param TotallyDoctrine $database
     * @return Command
     */
    private function setDatabase(TotallyDoctrine $database): Command
    {
        $this->database = $database;
        return $this;
    }
}