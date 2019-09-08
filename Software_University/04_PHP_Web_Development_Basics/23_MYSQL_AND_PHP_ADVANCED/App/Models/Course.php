<?php


namespace Models;


class Course
{
    /** @var  string */
    private $name;

    public function __construct(string $name)
    {
        $this->setName($name);
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
     * @return Course
     */
    public function setName(string $name): Course
    {
        $this->name = $name;
        return $this;
    }
}