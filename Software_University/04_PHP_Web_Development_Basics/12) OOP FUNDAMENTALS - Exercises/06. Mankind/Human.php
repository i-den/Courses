<?php

namespace Van\Classes\Sixth;


class Human
{
    /** @var  string */
    protected $firstName;

    /** @var  string */
    protected $lastName;

    protected function __construct(string $firstName, string $lastName){
        $this->setFirstName($firstName)
            ->setLastName($lastName);
    }

    protected function getFirstName(): string
    {
        return $this->firstName;
    }

    /**
     * @param string $firstName
     * @return Human
     * @throws \Exception
     */
    protected function setFirstName(string $firstName): Human
    {
        if (!ctype_upper($firstName[0])) {
            throw new \Exception('"Expected upper case letter!Argument: firstName"');
        } else if (strlen($firstName > 4)) {
            throw new \Exception('"Expected length at least 4 symbols!Argument: firstName"');
        }

        $this->firstName = $firstName;

        return $this;
    }

    protected function getLastname(): string
    {
        return $this->lastName;
    }

    /**
     * @param string $lastName
     * @return Human
     * @throws \Exception
     */
    protected function setLastName(string $lastName): Human
    {
        if (!ctype_upper($lastName[0])) {
            throw new \Exception('"Expected upper case letter!Argument: lastName"');
        } else if (strlen($lastName) < 3) {
            throw new \Exception('"Expected length at least 3 symbols!Argument: lastName"');
        }

        $this->lastName = $lastName;

        return $this;
    }
}
