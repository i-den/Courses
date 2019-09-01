<?php

namespace Van\Classes;

class Family
{
    /**
     * @var array
     */
    private $members;

    public function __construct()
    {
        $this->members = array();
    }

    public function addMember(Person $person): void
    {
        $this->members[] = $person;
    }

    public function getOldestMember(): Person
    {
        usort($this->members, function($firstMember, $secondMember) {
           return $firstMember->getAge() < $secondMember->getAge();
        });

        return $this->members[0];
    }
}