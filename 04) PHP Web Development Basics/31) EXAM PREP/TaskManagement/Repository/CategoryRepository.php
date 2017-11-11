<?php


namespace TaskManagement\Repository;


use Database\DatabaseInterface;
use TaskManagement\DTO\CategoryDTO;

class CategoryRepository implements CategoryRepositoryInterface
{
    /**
     * @var DatabaseInterface
     */
    private $database;

    public function __construct(DatabaseInterface $database)
    {
        $this->database = $database;
    }

    public function findAll(): \Generator
    {
        $query = "
            SELECT
              id,
              `name`
            FROM
              categories
        ";

        return $this->database->query($query)
            ->execute()
            ->fetch(CategoryDTO::class);
    }

    public function findOne(int $id): CategoryDTO
    {
        $query = "
            SELECT
              id,
              `name`
            FROM
              categories
            WHERE
              id = ?
        ";

        return $this->database->query($query)
            ->execute($id)
            ->fetch(CategoryDTO::class)
            ->current();
    }

    public function findTasksPerGroup(): \Generator
    {
        $query = "
            SELECT
              categories.id,
              `name`,
              COUNT(tasks.id) AS taskCount
            FROM
              categories
            INNER JOIN
              tasks
            ON categories.id = tasks.category_id
            GROUP BY
              name
            ORDER BY
              taskCount DESC,
              `name` ASC
        ";

        return $this->database->query($query)
            ->execute()
            ->fetch(CategoryDTO::class);
    }
}