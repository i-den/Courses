<?php
namespace AppBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Entity
 *
 * @ORM\Table(name="entities")
 * @ORM\Entity(repositoryClass="AppBundle\Repository\EntityRepository")
 */
class Entity
{
    /**
     * @var int
     *
     * @ORM\Column(name="id", type="integer")
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="AUTO")
     */
    private $id;
	
    /**
     * @var string
     *
     * @ORM\Column(name="stringProperty", type="string", length=255)
     */
    private $stringProperty;	
	
	/**
     * @var int
     *
     * @ORM\Column(name="intProperty", type="integer")
     */
    private $intProperty;
	
    /**
     * @return int
     */
    public function getId(): ?int
    {
        return $this->id;
    }

//    /**
//     * @param int $id
//     */
//    public function setId(?int $id): Entity
//    {
//        $this->id = $id;
//        return $this;
//    }

    /**
     * @return string
     */
    public function getStringProperty(): ?string
    {
        return $this->stringProperty;
    }
	
    /**
     * @param string $stringProperty
     * @return Entity
     */
    public function setTitle(?string $stringProperty): Entity
    {
        $this->stringProperty = $stringProperty;
        return $this;
    }	

    /**
     * @return int
     */
    public function getIntProperty(): ?int
    {
        return $this->intProperty;
    }

    /**
     * @param int $intProperty
     * @return Entity
     */
    public function setYear(?int $intProperty): Entity
    {
        $this->year = $intProperty;
        return $this;
    }
	
}