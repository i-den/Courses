<?php


namespace Van\Controllers;


use Core\Database\EloInsert;
use Core\Database\EloFind;
use Core\Database\EloUpdate;
use Van\Entity\Cat;

class CatController extends Controller
{
    public function list()
    {
        $dbList = new EloFind();

        $allCats = $dbList->getAllCats();

        $this->render('Cats/list.php', compact('allCats'));
    }

    public function getAddCat()
    {
        $this->render('Cats/add-new.php');
    }

    public function insertCat()
    {
        $name = htmlspecialchars($_POST['name']);
        $age = htmlspecialchars($_POST['age']);
        $cat = new Cat($name, $age);

        $dbInsert = new EloInsert();
        $dbInsert->insertCat($cat);

        $message = 'The cat ' . $name . ' has been registered!';
        $this->render('Cats/success.php', compact('message'));
    }

    public function getEditCat()
    {
        if (!isset($_GET['id'])) {
            throw new \Exception('No cat specified');
        }

        $id = $_GET['id'];

        $dbFind = new EloFind();
        $cat = $dbFind->getCatById($id);

        $this->render('Cats/edit-cat.php', compact('id', 'cat'));
    }

    public function editCat()
    {
        if (!isset($_POST['id'])) {
            throw new \Exception('No ID came through, hax..');
        }

        $id = $_POST['id'];

        $dbUpdate = new EloUpdate();
        $cat = new Cat($_POST['name'], $_POST['age']);

        $dbUpdate->updateCat($id, $cat);

        $message = 'Cat\'s details updated!';
        $this->render('Cats/success.php', compact('message'));
    }
}