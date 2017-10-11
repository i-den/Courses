<?php


namespace Generation;


use Family\Father;
use Family\GrandSon;
use Family\Son;

class Generation
{
    /** @var  Father */
    private $father;

    /** @var  Son[] */
    private $sons = array();
    /** @var  GrandSon[] */
    private $grandSons = array();

    /**
     * @param Son[] | GrandSon[] $people
     * @return int
     */
    static function getAverageSonsTimeSpan($people): int
    {
        $avgTimeSpan = 0;
        foreach ($people as $person) {
            $avgTimeSpan += intval($person->getTimeLived()->format('%y'));
        }
        return intval($avgTimeSpan / count($people));
    }

    public function setFather(Father $father)
    {
        $this->father = $father;
    }

    public function addSon(Son $son)
    {
        $this->sons[] = $son;
    }

    public function addGrandSon(GrandSon $grandSon)
    {
        $this->grandSons[] = $grandSon;
    }

    /**
     * @return Father
     */
    public function getFather(): Father
    {
        return $this->father;
    }

    /**
     * @return Son[]
     */
    public function getSons(): array
    {
        return $this->sons;
    }

    /**
     * @return GrandSon[]
     */
    public function getGrandSons(): array
    {
        return $this->grandSons;
    }
}