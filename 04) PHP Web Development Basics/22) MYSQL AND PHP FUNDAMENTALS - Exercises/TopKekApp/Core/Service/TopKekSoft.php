<?php


namespace Core\Service;

use Core\Adapter\TotallyDoctrine;
use Core\Service\Commands\FourthCommand;
use Core\Service\Commands\SecondCommand;
use Core\Service\Commands\ThirdCommand;

/**
 * Class TopKekSoft
 *
 * The best Software for stupid п*тки
 * it comes for just $69 / 1337 years
 * for more info - contact the Author
 *
 * or kinda legit intro
 *
 * Software for HR capable of Managing Employee
 *
 * - Insert Employee
 *          - Email
 *          - Phone
 *
 * - List Employee
 *
 * @package Core\Service
 */
class TopKekSoft
{
    /** @var  TotallyDoctrine */
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

    /**
     * Entry point for the Application
     * It lists al the zadachki to the console
     * and then routes each one to the corresponding
     * Command class responsible for handling it
     */
    public function start()
    {
        // Announces all Zadachki to the console
        $this->announceZadachki();

        // Gets the desired Zadachka to reshi
        $zadachkaNumber = $this->getZadachkaNumber();

        // Announces the desired Zadachka's Uslovie
        $this->announceUslovie($zadachkaNumber);

        $zadachka = null;
        $options = null;

        switch ($zadachkaNumber) {
            // Insert Employee
            case 2:
                $zadachka = new SecondCommand($this->getDatabase());
                break;

            // Insert an Email
            case 3:
                $zadachka = new ThirdCommand($this->getDatabase());
                $options = array('Email');
                break;

            // Insert a Phone
            case 4:
                $zadachka = new ThirdCommand($this->getDatabase());
                $options = array('Phone');
                break;

            // List an Employee
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

    // I tyk li chetesh oshte..
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
            '[ first_name ], [ middle_name ], [ last_name ], [ department ], [ position ], [  passport_id ], [ country_info ]?' . PHP_EOL,
            '[ employee_id ]? [ first_name ], [ middle_name ], [ last_name ], emails, [ email_info ]+' . PHP_EOL,
            '[ employee_id ]? [ first_name ], [ middle_name ], [ last_name ], phones, [ phone_info ]+' . PHP_EOL,
            'Info, [ first_name ], [ last_name ]' . PHP_EOL
        );
    }

    /**
     * Announces all Zadachki to the console
     */
    private function announceZadachki()
    {
        foreach ($this->zadachki as $zadachka) {
            echo $zadachka;
        }
    }

    /**
     * Announces the desired Zadachka's Uslovie
     *
     * @param   int     $zadachkaNumber
     */
    private function announceUslovie(int $zadachkaNumber)
    {
        echo $this->usloviq[$zadachkaNumber - 2];
    }

    /**
     * Molq vuvedete legit nomerche na zadachka
     *
     * @return  int
     */
    private function getZadachkaNumber()
    {
        while (true) {
            $zadachka = intval(trim(fgets(STDIN)));

            if ($zadachka > 1 && $zadachka <= 5) {
                return $zadachka;
            }

            echo 'Въведи правилен номер на задачка...' . PHP_EOL;
        }
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
