<?php


namespace Commands;



class DetainCommand extends Command
{

    public function execute()
    {
        $fakeId = trim(fgets(STDIN));

        foreach ($this->getCity()->getCitizen() as $citizen) {
            $lastDigits = substr($citizen->getId(), strlen($fakeId) * -1);
            if ($lastDigits === $fakeId) {
                $citizen->detain();
            }
        }
    }
}