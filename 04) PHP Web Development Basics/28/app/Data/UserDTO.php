<?php


namespace Data;


class UserDTO
{
    private $id;
    private $username;
    private $password;
    private $firstName;
    private $lastName;
    private $bornOn;

    public static function create(string $username,
                                  string $password,
                                  string $first_name,
                                  string $last_name,
                                  string $bornOn,
                                  string $id = null): UserDTO
    {
        return (new UserDTO())->setUsername($username)
            ->setPassword($password)
            ->setFirstName($first_name)
            ->setLastName($last_name)
            ->setBornOn($bornOn)
            ->setId(intval($id));
    }

    /**
     * @return int
     */
    public function getId()
    {
        return $this->id;
    }

    /**
     * @param int $id
     * @return UserDTO
     */
    public function setId(int $id): UserDTO
    {
        $this->id = $id;
        return $this;
    }

    /**
     * @return string
     */
    public function getUsername(): string
    {
        return $this->username;
    }

    /**
     * @param string $username
     * @return UserDTO
     */
    public function setUsername(string $username): UserDTO
    {
        $this->username = $username;
        return $this;
    }

    /**
     * @return string
     */
    public function getPassword(): string
    {
        return $this->password;
    }

    /**
     * @param string $password
     * @return UserDTO
     */
    public function setPassword(string $password): UserDTO
    {
        $this->password = $password;
        return $this;
    }

    /**
     * @return string
     */
    public function getFirstName(): string
    {
        return $this->firstName;
    }

    /**
     * @param string $firstName
     * @return UserDTO
     */
    public function setFirstName(string $firstName): UserDTO
    {
        $this->firstName = $firstName;
        return $this;
    }

    /**
     * @return string
     */
    public function getLastName(): string
    {
        return $this->lastName;
    }

    /**
     * @param string $lastName
     * @return UserDTO
     */
    public function setLastName($lastName): UserDTO
    {
        $this->lastName = $lastName;
        return $this;
    }

    /**
     * @return mixed
     */
    public function getBornOn()
    {
        return $this->bornOn;
    }

    /**
     * @param mixed $bornOn
     * @return UserDTO
     */
    public function setBornOn($bornOn)
    {
        $this->bornOn = $bornOn;
        return $this;
    }
}