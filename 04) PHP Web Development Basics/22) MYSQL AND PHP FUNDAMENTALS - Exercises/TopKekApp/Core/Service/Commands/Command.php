<?php

namespace Core\Service\Commands;

use Core\Adapter\TotallyDoctrine;

/**
 * Class Command
 * Holds the Database for any Command
 * to be able to interact with it
 *
 * @package Core\Service\Commands
 */
abstract class Command implements IExecutable
{
    const SEARCH_PASS_ID = 1;
    const SEARCH_TABLE_ID = 2;
    const SEARCH_NAMES_EXACT = 1;
    const SEARCH_NAMES_WILDCARD = 2;

    /** @var  TotallyDoctrine */
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
