<?php


namespace App\Models;

/**
 * Class Customer
 * @package Service
 */
class Customer
{
    /** @var  string */
    private $firstName;

    /** @var  string */
    private $familyName;

    public function __construct(string $firstName, string $familyName)
    {
        $this->setFirstName($firstName)
            ->setFamilyName($familyName);
    }

    /**
     * @return string
     */
    public function getFirstName(): string
    {
        return $this->firstName;
    }

    /**
     * @param   string  $firstName
     * @return  Customer
     * @throws \Exception
     */
    public function setFirstName(string $firstName): Customer
    {
        if (empty($firstName) || is_numeric($firstName)) {
            throw new \Exception('Invalid First Name!');
        }

        $this->firstName = $firstName;
        return $this;
    }

    /**
     * @return string
     */
    public function getFamilyName(): string
    {
        return $this->familyName;
    }

    /**
     * @param   string  $familyName
     * @return  Customer
     * @throws \Exception
     */
    public function setFamilyName(string $familyName): Customer
    {
        if (empty($familyName) || is_numeric($familyName)) {
            throw new \Exception('Invalid Family Name');
        }

        $this->familyName = $familyName;
        return $this;
    }
}
