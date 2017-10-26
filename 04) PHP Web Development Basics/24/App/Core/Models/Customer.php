<?php


namespace Models;

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
     * @param string $firstName
     * @return Customer
     */
    public function setFirstName(string $firstName): Customer
    {
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
     * @param string $familyName
     * @return Customer
     */
    public function setFamilyName(string $familyName): Customer
    {
        $this->familyName = $familyName;
        return $this;
    }
}