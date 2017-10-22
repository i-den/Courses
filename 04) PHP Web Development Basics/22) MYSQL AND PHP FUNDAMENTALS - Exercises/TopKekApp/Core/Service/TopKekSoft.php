<?php


namespace Core\Service;

use Core\Adapter\TotallyDoctrine;
use Core\Service\Commands\SecondCommand;

class TopKekSoft
{
    /**
     * @var TotallyDoctrine
     */
    private $database;

    private $zadachki;
    private $usloviq;

    public function __construct(
        TotallyDoctrine $database
    )
    {
        $this->setDatabase($database)
            ->buildZadachkiAndUsloviq();
    }

    public function start()
    {
        $this->announceZadachki();

        $zadachkaNumber = $this->getZadachkaNumber();

        $this->announceUslovie($zadachkaNumber);

        $zadachka = null;

        switch ($zadachkaNumber) {
            case 2:
                $zadachka = new SecondCommand($this->getDatabase());
        }

        try {
            $zadachka->execute();
        } catch (\Exception $exception) {
            exit($exception->getMessage());
        }
    }

    private function buildZadachkiAndUsloviq()
    {
        $this->zadachki = array(
            'Изберете си задачка ' . PHP_EOL,
            'Задачка 2: HR Application Insert Employee' . PHP_EOL,
            'Задачка 3: Insert Email' . PHP_EOL,
            'Задачка 4: Insert Phones 3=)' . PHP_EOL,
            'Задачка 5: Get Emails of Employee' . PHP_EOL,
            'Задачка 6: Get Emails and Phones' . PHP_EOL
        );
        $this->usloviq = array(
            '[ first_name ], [ middle_name ], [ last_name ], [ department ], [ position ], [  passport_id ]' . PHP_EOL,

        );
    }

    private function announceZadachki()
    {
        foreach ($this->zadachki as $zadachka) {
            echo $zadachka;
        }
    }

    private function announceUslovie(int $zadachkaNumber)
    {
        echo $this->usloviq[$zadachkaNumber - 2];
    }

    private function getZadachkaNumber(): int
    {
        while (true) {
            $zadachka = intval(trim(fgets(STDIN)));

            if ($zadachka > 1 && $zadachka <= 6) {
                return $zadachka;
            }

            echo 'Въведи правилен номер на задачка...' . PHP_EOL;
        }

        return null;
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
     * @return TopKekSoft
     */
    public function setDatabase(TotallyDoctrine $database): TopKekSoft
    {
        $this->database = $database;
        return $this;
    }
}
