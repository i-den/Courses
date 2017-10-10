<?php


namespace Van\Classes\Fourth;


class Child extends Person
{
    public function __construct($name, $age)
    {
        parent::setName($name);
        $this->setAge($age);
    }

    protected function setAge(int $age): Person
    {
        if ($age > 15) {
            throw new \Exception('Child\'s age must be less than 16!');
        }

        parent::setAge($age);

        return $this;
    }
}