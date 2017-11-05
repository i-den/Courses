<?php


namespace Van\Entity;


class Cat
{
    /**
     * @var string  Cat's name
     */
    private $name;

    /**
     * @var int Cat's age
     */
    private $age;

    public function __construct(string $name, string $age)
    {
        $this->setName($name)
            ->setAge($age);
    }

    /**
     * @return string
     */
    public function getName(): string
    {
        return $this->name;
    }

    /**
     * @param string $name
     * @return Cat
     * @throws \Exception
     */
    public function setName(string $name): Cat
    {
        if (is_numeric($name) || empty($name)) {
            throw new \Exception('Faulty Cat Name!');
        }

        $this->name = $name;
        return $this;
    }

    /**
     * @return int
     */
    public function getAge(): int
    {
        return $this->age;
    }

    /**
     * @param string $age
     * @return Cat
     * @throws \Exception
     */
    public function setAge(string $age): Cat
    {
        if (!is_numeric($age) || empty($age)) {
            throw new \Exception('Age isn\' right');
        }

        $this->age = intval($age);
        return $this;
    }
}