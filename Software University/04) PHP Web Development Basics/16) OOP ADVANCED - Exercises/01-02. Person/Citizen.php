<?php


namespace Van\Classes\First;


class Citizen implements IPerson, IIdentifable, IBirthable
{
    private $name;
    private $age;
    private $id;
    private $birthdate;

    public function __construct(
        string $name,
        int $age,
        int $id,
        string $birthdate
    )
    {
        $this->setName($name)
            ->setAge($age)
            ->setId($id)
            ->setBirthdate($birthdate);
    }

    public function __toString()
    {
        $citizenOutput  = $this->name . ', ' . $this->age . ', ';
        $citizenOutput .= 'ID = ' . $this->id . ', ' . $this->birthdate;

        return $citizenOutput;
    }

    public function setIdBirthdate(int $id, string $birthdate): Citizen
    {
        $this->id = $id;
        $this->birthdate = $birthdate;
        return $this;
    }

    public function setBirthdate(string $birthdate, int $id): Citizen
    {
        $this->birthdate = $birthdate;
        $this->id = $id;
        return $this;
    }

    public function setName(string $name): Citizen
    {
        $this->name = $name;
        return $this;
    }

    public function setAge(int $age): Citizen
    {
        $this->age = $age;
        return $this;
    }
}