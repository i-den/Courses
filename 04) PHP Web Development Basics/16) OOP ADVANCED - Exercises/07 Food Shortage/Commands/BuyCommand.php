<?php


namespace Commands;


class BuyCommand extends Command implements IExecutable
{

    public function execute()
    {
        while (true) {
            $name = trim(fgets(STDIN));

            if ($name == 'End') {
                break;
            }

            $person = $this->getCity()->findPerson($name);

            if (isset($person)) {
                $person->buyFood();
            }
        }
    }
}