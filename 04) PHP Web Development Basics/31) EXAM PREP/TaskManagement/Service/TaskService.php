<?php


namespace TaskManagement\Service;


use TaskManagement\DTO\DashboardDTO;
use TaskManagement\DTO\TaskDTO;
use TaskManagement\Repository\TaskRepositoryInterface;

class TaskService implements TaskServiceInterface
{
    const PER_PAGE = 5;

    /**
     * @var TaskRepositoryInterface
     */
    private $taskRepository;

    public function __construct(TaskRepositoryInterface $taskRepository)
    {
        $this->taskRepository = $taskRepository;
    }

    public function add(TaskDTO $task): bool
    {
        return $this->taskRepository->insert($task);
    }

    public function edit(TaskDTO $task, int $id): bool
    {
        $taskFromDb = $this->taskRepository->findOne($id);

        if (null === $taskFromDb) {
            throw new \Exception('Task does not exists');
        }

        return $this->taskRepository->update($task, $id);
    }

    public function remove(int $id): bool
    {
        $taskFromDb = $this->taskRepository->findOne($id);

        if (null === $taskFromDb) {
            throw new \Exception('Task does not exists');
        }

        return $this->taskRepository->delete($id);
    }

    public function view(int $id): TaskDTO
    {
        return $this->taskRepository->findOne($id);
    }

    public function getDashboard(int $pageNum): DashboardDTO
    {
        $limit = self::PER_PAGE;
        $offset = ($pageNum - 1) * self::PER_PAGE;

        $tasksPerPage = $this->taskRepository->findAll($limit, $offset);
        $allTasksCount= $this->taskRepository->count();
        $allPages = ceil($allTasksCount / self::PER_PAGE);

        $hasPrevious = $pageNum > 1;
        $hasNext = $pageNum < $allPages;

        $dashboardDTO = new DashboardDTO();
        $dashboardDTO->setTasks($tasksPerPage);
        $dashboardDTO->setCurrentPage($pageNum);
        $dashboardDTO->setAllPages($allPages);
        $dashboardDTO->setHasPrevious($hasPrevious);
        $dashboardDTO->setHasNext($hasNext);

        return $dashboardDTO;
    }
}