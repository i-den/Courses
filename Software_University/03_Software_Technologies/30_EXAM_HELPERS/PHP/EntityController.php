<?php
namespace AppBundle\Controller;

use AppBundle\Entity\Entity;
use AppBundle\Form\EntityType;
use Sensio\Bundle\FrameworkExtraBundle\Configuration\Route;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Symfony\Component\HttpFoundation\Request;

class EntityController extends Controller
{
    /**
     * @param Request $request
     * @Route("/", name="index")
     * @return \Symfony\Component\HttpFoundation\Response
     */
    public function index(Request $request)
    {
        $entityRepository = $this->getDoctrine()->getRepository(Entity::class);
		
		$firstStatusEntities = $entityRepository->findBy(["property" => "firstStatus"]);
        $secondtStatusEntities = $entityRepository->findBy(["property" => "secondStatus"]);
        $thirdStatusEntities = $entityRepository->findBy(["property" => "thirdStatus"]);
		
        return $this->render(':entity:index.html.twig', [
            "firstStatusEntities" => $firstStatusEntities,
            "secondtStatusEntities" => $secondtStatusEntities,
            "thirdStatusEntities" => $thirdStatusEntities
        ]);		
		
        $entities = $entityRepository->findAll();
		
        return $this->render(':entity:index.html.twig', [
            'films' => $films
        ]);
    }

    /**
     * @param Request $request
     * @Route("/create", name="create")
     * @return \Symfony\Component\HttpFoundation\Response
     */
    public function create(Request $request)
    {
        $entity = new Entity();
		
        $form = $this->createForm(EntityType::class, $entity);
        $form->handleRequest($request);
		
        if ($form->isSubmitted() && $form->isValid()) {
            $entityManager = $this->getDoctrine()->getManager();
            $entityManager->persist($entity);
            $entityManager->flush();
			
            return $this->redirectToRoute('index');
        }
		
        return $this->render(':entity:create.html.twig', [
            'form' => $form->createView()
        ]);
    }

    /**
     * @param int $id
     *
     * @Route("/entity/{id}", name="entity_view")
     *
     * @return \Symfony\Component\HttpFoundation\RedirectResponse
     */
    public function viewEntity($id)
    {
        $entityRepository = $this->getDoctrine()->getRepository(Entity::class)
		
		$entity = $entityRepository->find($id);
		
        if ($entity == null) {
            return $this->redirectToRoute("index");
        }
		
        return $this->render(':entity:details.html.twig', [
			'entity' => $entity
		]);
    }

    /**
     * @Route("/edit/{id}", name="edit")
     *
     * @param $id
     * @param Request $request
     * @return \Symfony\Component\HttpFoundation\Response
     */
    public function edit($id, Request $request)
    {
        $entityRepository = $this->getDoctrine()->getRepository(Entity::class);
		
        $entity = $entityRepository->find($id);
		
        if ($entity == null) {
            return $this->redirect("/");
        }
		
        $form = $this->createForm(EntityType::class, $entity);
        $form->handleRequest($request);
		
        if ($form->isSubmitted() && $form->isValid()) {
            $entityManager = $this->getDoctrine()->getManager();
            $entityManager->merge($entity);
            $entityManager->flush();
			
            return $this->redirect("/");
        }
		
        return $this->render(":entity:edit.html.twig", [
            "entity" => $entity,
            "form" => $form->createView()
        ]);
    }

    /**
     * @Route("/delete/{id}", name="delete")
     *
     * @param $id
     * @param Request $request
     * @return \Symfony\Component\HttpFoundation\Response
     */
    public function delete($id, Request $request)
    {
        $entityRepository = $this->getDoctrine()->getRepository(Entity::class);
		
        $entity = $entityRepository->find($id);
		
        if ($entity == null) {
            return $this->redirectToRoute('index');
        }
		
        $form = $this->createForm(EntityType::class, $entity);
        $form->handleRequest($request);
		
        if ($form->isSubmitted() && $form->isValid()) {
            $entityManager = $this->getDoctrine()->getManager();
            $entityManager->remove($entity);
            $entityManager->flush();
			
            return $this->redirectToRoute('index');
        }
		
        return $this->render(':entity:delete.html.twig', [
           'entity' => $entity,
            'form' => $form->createView()
        ]);
    }	
}