<?php


namespace Data;


class EmailDTO
{
    private $id;
    private $userId;
    private $email;

    public static function create(string $email,
                                  string $userId,
                                  string $id = null)
    {
        return (new EmailDTO())->setEmail($email)
            ->setUserId($userId)
            ->setId($id);
    }

    public function getId()
    {
        return $this->id;
    }

    public function setId($id)
    {
        $this->id = $id;
        return $this;
    }

    public function getUserId()
    {
        return $this->userId;
    }

    public function setUserId($userId)
    {
        $this->userId = $userId;
        return $this;
    }

    public function getEmail()
    {
        return $this->email;
    }

    public function setEmail($email)
    {
        $this->email = $email;
        return $this;
    }
}