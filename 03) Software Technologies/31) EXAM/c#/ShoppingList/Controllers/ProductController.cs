using System.Linq;
using System.Web.Mvc;
using ShoppingList.Models;
using System.Net;

namespace ShoppingList.Controllers
{
    [ValidateInput(false)]
    public class ProductController : Controller
    {
        [HttpGet]
        [Route("")]
        public ActionResult Index()
        {
            using (var database = new ShoppingListDbContext())
            {
                var products = database.Products.ToList();

                return View(products);
            }
        }

        [HttpGet]
        [Route("create")]
        public ActionResult Create()
        {
            return View();
        }

        [HttpPost]
        [Route("create")]
        [ValidateAntiForgeryToken]
        public ActionResult Create(Product product)
        {
            if (ModelState.IsValid)
            {
                using (var database = new ShoppingListDbContext())
                {
                    product.Status = "not bought";
                    database.Products.Add(product);
                    database.SaveChanges();

                    return RedirectToAction("Index");
                }
            }

            return RedirectToAction("Index");
        }

        [HttpGet]
        [Route("edit/{id}")]
        public ActionResult Edit(int? id)
        {
            using (var database = new ShoppingListDbContext())
            {
                var product = database.Products.Find(id);

                if (product == null)
                {
                    return HttpNotFound();
                }

                return View(product);
            }
        }

        [HttpPost]
        [Route("edit/{id}")]
        [ValidateAntiForgeryToken]
        public ActionResult EditConfirm(int? id, Product productModel)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }

            if (ModelState.IsValid)
            {
                using (var database = new ShoppingListDbContext())
                {
                    var product = database.Products.Find(id);

                    if (product == null)
                    {
                        return HttpNotFound();
                    }

                    product.Priority = productModel.Priority;
                    product.Name = productModel.Name;
                    product.Status = productModel.Status;
                    product.Quantity = productModel.Quantity;

                    database.SaveChanges();

                    return RedirectToAction("Index");
                }
            }
            return View(productModel);
        }
    }
}
