<?php


namespace Van\Classes\Fifth;


class SpecialBook extends Book
{
    public function __construct($title, $author, $price)
    {
        parent::__construct($title, $author, $price * 1.3);
    }
}