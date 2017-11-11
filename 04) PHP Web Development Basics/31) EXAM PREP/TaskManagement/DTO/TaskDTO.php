<?php


namespace TaskManagement\DTO;


class TaskDTO
{
    const TITLE_MIN_LEN = 3;
    const TITLE_MAX_LEN = 50;

    const DESC_MIN_LEN = 10;
    const DESC_MAX_LEN = 10000;

    const LOCATION_MIN_LEN = 3;
    const LOCATION_MAX_LEN = 100;

    /**
     * @var UserDTO
     */
    private $author;

    /**
     * @var CategoryDTO
     */
    private $category;

    private $id;
    private $title;
    private $description;
    private $location;
    private $startedOn;
    private $dueDate;


    public function getAuthor(): UserDTO
    {
        return $this->author;
    }

    public function setAuthor(UserDTO $author)
    {
        $this->author = $author;
    }

    public function getCategory(): CategoryDTO
    {
        return $this->category;
    }

    public function setCategory(CategoryDTO $category)
    {
        $this->category = $category;
    }

    public function getId()
    {
        return $this->id;
    }

    public function setId($id)
    {
        $this->id = $id;
    }

    public function getTitle()
    {
        return $this->title;
    }

    public function setTitle($title)
    {
        DTOValidator::validate(
            self::TITLE_MIN_LEN,
            self::TITLE_MAX_LEN,
            $title,
            'Title out of range'
        );

        $this->title = $title;
    }


    public function getDescription()
    {
        return $this->description;
    }


    public function setDescription($description)
    {
        DTOValidator::validate(
            self::DESC_MIN_LEN,
            self::DESC_MAX_LEN,
            $description,
            'Description out of range'
        );

        $this->description = $description;
    }

    public function getLocation()
    {
        return $this->location;
    }

    public function setLocation($location)
    {
        DTOValidator::validate(
            self::LOCATION_MIN_LEN,
            self::LOCATION_MAX_LEN,
            $location,
            'Location out of range'
        );

        $this->location = $location;
    }

    public function getStartedOn()
    {
        return $this->startedOn;
    }

    public function setStartedOn($startedOn)
    {
        $this->startedOn = $startedOn;
    }

    public function getDueDate()
    {
        return $this->dueDate;
    }

    public function setDueDate($dueDate)
    {
        $this->dueDate = $dueDate;
    }
}