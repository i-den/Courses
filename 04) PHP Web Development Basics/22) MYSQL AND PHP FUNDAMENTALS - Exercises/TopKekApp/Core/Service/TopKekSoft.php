<?php


namespace Core\Service;

use Core\Adapter\TotallyDoctrine;
use Core\Service\Commands\FourthCommand;
use Core\Service\Commands\SecondCommand;
use Core\Service\Commands\ThirdCommand;

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
        $options = null;

        switch ($zadachkaNumber) {
            case 2:
                $zadachka = new SecondCommand($this->getDatabase());
                break;
            case 3:
                $zadachka = new ThirdCommand($this->getDatabase());
                $options = array('Email');
                break;
            case 4:
                $zadachka = new ThirdCommand($this->getDatabase());
                $options = array('Phone');
                break;
            case 5:
                $zadachka = new FourthCommand($this->getDatabase());
                break;
        }

        try {
            $zadachka->execute($options);
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
            'Задачка 5: Get Employee Information' . PHP_EOL,
        );
        $this->usloviq = array(
            '[ first_name ], [ middle_name ], [ last_name ], [ department ], [ position ], [  passport_id ]' . PHP_EOL,
            '[ employee_id ]? [ first_name ], [ middle_name ], [ last_name ], emails, [ email_info ]+' . PHP_EOL,
            '[ employee_id ]? [ first_name ], [ middle_name ], [ last_name ], phones, [ phone_info ]+' . PHP_EOL,
            'Info, [ first_name ], [ last_name ]' . PHP_EOL
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

            if ($zadachka > 1 && $zadachka <= 5) {
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
