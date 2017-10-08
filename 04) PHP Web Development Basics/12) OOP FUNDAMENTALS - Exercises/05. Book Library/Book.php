<?php


namespace Van\Classes\Fifth;


class Book
{
    /** @var  string */
    protected $title;

    /** @var  string */
    protected $author;

    /** @var  float */
    protected $price;

    public function __construct(string $title, string $author, float $price)
    {
        $this->setTitle($title)
            ->setAuthor($author)
            ->setPrice($price);
    }

    public function __toString()
    {
        return 'OK' . PHP_EOL . $this->price;
    }

    /**
     * @param string $title
     * @return Book
     * @throws \Exception
     */
    protected function setTitle(string $title): Book
    {
        if (strlen($title) < 3) {
            throw new \Exception('Title not valid!');
        }

        $this->title = $title;

        return $this;
    }

    /**
     * @param string $author
     * @return Book
     * @throws \Exception
     */
    protected function setAuthor(string $author): Book
    {
        $authorSecondName = explode(' ', $author)[1];

        if (is_numeric($authorSecondName)) {
            throw new \Exception('Author not valid!');
        }

        $this->author = $author;

        return $this;
    }

    /**
     * @return float
     */
    public function getPrice(): float
    {
        return $this->price;
    }

    /**
     * @param float $price
     * @return Book
     * @throws \Exception
     */
    protected function setPrice(float $price): Book
    {
        if ($price <= 0) {
            throw new \Exception('Price not valid!');
        }

        $this->price = $price;

        return $this;
    }
}