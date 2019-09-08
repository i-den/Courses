<?php


namespace Models;


class Email
{
    /** @var  string */
    private $address;

    /** @var  string */
    private $type;

    public function __construct(string $address, string $type)
    {
        $this->setAddress($address)
            ->setType($type);
    }

    /**
     * @return string
     */
    public function getAddress(): string
    {
        return $this->address;
    }

    /**
     * @param string $address
     * @return Email
     */
    public function setAddress(string $address): Email
    {
        $this->address = $address;
        return $this;
    }

    /**
     * @return string
     */
    public function getType(): string
    {
        return $this->type;
    }

    /**
     * @param string $type
     * @return Email
     */
    public function setType(string $type): Email
    {
        $this->type = $type;
        return $this;
    }
}
