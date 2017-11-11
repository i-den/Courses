<?php


namespace TaskManagement\DTO;


class CategoryDTO
{
    const NAME_MIN_LEN = 3;
    const NAME_MAX_LEN = 50;

    private $id;
    private $name;
    private $taskCount;

    /**
     * @return mixed
     */
    public function getTaskCount()
    {
        return $this->taskCount;
    }

    /**
     * @param mixed $taskCount
     */
    public function setTaskCount($taskCount)
    {
        $this->taskCount = $taskCount;
    }

    public function getId()
    {
        return $this->id;
    }

    public function setId($id)
    {
        $this->id = $id;
    }

    public function getName()
    {
        return $this->name;
    }

    public function setName($name)
    {
        DTOValidator::validate(
            self::NAME_MIN_LEN,
            self::NAME_MAX_LEN,
            $name,
            'Name out of range'
        );

        $this->name = $name;
    }
}