<?php


namespace TaskManagement\DTO;


class UserDTO
{
    const FIELDS_MAX_LEN = 255;

    const USERNAME_MIN_LEN = 4;
    const PASSWORD_MIN_LEN = 6;
    const FIRST_NAME_MIN_LEN = 3;
    const LAST_NAME_MIN_LEN = 3;

    private $id;
    private $username;
    private $password;
    private $firstName;
    private $lastName;


    public function getId()
    {
        return $this->id;
    }

    public function setId($id)
    {
        $this->id = $id;
    }

    public function getUsername()
    {
        return $this->username;
    }

    public function setUsername($username)
    {
        DTOValidator::validate(
            self::USERNAME_MIN_LEN,
            self::FIELDS_MAX_LEN,
            $username,
            'Username length out of range'
        );

        $this->username = $username;
    }

    public function getPassword()
    {
        return $this->password;
    }

    public function setPassword($password)
    {
        DTOValidator::validate(
            self::PASSWORD_MIN_LEN,
            self::FIELDS_MAX_LEN,
            $password,
            'Username length out of range'
        );

        $this->password = $password;
    }

    public function getFirstName()
    {
        return $this->firstName;
    }

    public function setFirstName($firstName)
    {
        DTOValidator::validate(
            self::FIRST_NAME_MIN_LEN,
            self::FIELDS_MAX_LEN,
            $firstName,
            'Username length out of range'
        );

        $this->firstName = $firstName;
    }

    public function getLastName()
    {
        return $this->lastName;
    }

    public function setLastName($lastName)
    {
        DTOValidator::validate(
            self::LAST_NAME_MIN_LEN,
            self::FIELDS_MAX_LEN,
            $lastName,
            'Username length out of range'
        );

        $this->lastName = $lastName;
    }
}