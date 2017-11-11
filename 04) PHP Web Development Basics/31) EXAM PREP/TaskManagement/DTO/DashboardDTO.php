<?php


namespace TaskManagement\DTO;


class DashboardDTO
{
    /**
     * @var \Generator | TaskDTO[]
     */
    private $tasks;

    private $currentPage;
    private $allPages;
    private $hasPrevious;
    private $hasNext;

    /**
     * @return \Generator|TaskDTO[]
     */
    public function getTasks()
    {
        return $this->tasks;
    }

    /**
     * @param \Generator|TaskDTO[] $tasks
     */
    public function setTasks($tasks)
    {
        $this->tasks = $tasks;
    }

    public function getCurrentPage()
    {
        return $this->currentPage;
    }

    public function setCurrentPage($currentPage)
    {
        $this->currentPage = $currentPage;
    }

    public function getAllPages()
    {
        return $this->allPages;
    }

    public function setAllPages($allPages)
    {
        $this->allPages = $allPages;
    }

    public function getHasPrevious()
    {
        return $this->hasPrevious;
    }

    public function setHasPrevious($hasPrevious)
    {
        $this->hasPrevious = $hasPrevious;
    }

    public function getHasNext()
    {
        return $this->hasNext;
    }

    public function setHasNext($hasNext)
    {
        $this->hasNext = $hasNext;
    }
}