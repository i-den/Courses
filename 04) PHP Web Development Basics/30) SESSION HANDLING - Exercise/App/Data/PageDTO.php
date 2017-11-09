<?php


namespace Data;


class PageDTO
{
    const MAX_PAGES = 7;

    private $currentPage;
    private $maximumPages;
    private $pagesToPrint = array();

    public function __construct(int $currentPage, int $maximumPages)
    {
        $this->setCurrentPage($currentPage)
            ->setMaximumPages($maximumPages)
            ->setPagesToPrint();
    }

    private function setPagesToPrint()
    {
        $pages = array();

        $startingPage = $this->currentPage - floor(self::MAX_PAGES / 2) > 1
            ? $this->currentPage - floor(self::MAX_PAGES / 2)
            : 1;

        $endingPage = $this->currentPage + floor(self::MAX_PAGES / 2) < $this->maximumPages
            ? $this->currentPage + floor(self::MAX_PAGES / 2)
            : $this->maximumPages;

        for ($i = $startingPage; $i <= $endingPage; $i++) {
            $pages[] = $i;
        }

        $this->pagesToPrint = array_map('intval', $pages);
    }

    public function getPagesToPrint(): array
    {
        return $this->pagesToPrint;
    }

    public function getCurrentPage(): int
    {
        return $this->currentPage;
    }

    private function setCurrentPage(int $currentPage)
    {
        $this->currentPage = $currentPage;
        return $this;
    }

    public function getMaximumPages(): int
    {
        return $this->maximumPages;
    }

    private function setMaximumPages(int $maximumPages)
    {
        $this->maximumPages = $maximumPages;
        return $this;
    }
}