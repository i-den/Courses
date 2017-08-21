// ~/Controllers/EntityController.cs

using System;
using System.Linq;
using System.Web.Mvc;
using Project.Models;

namespace Project.Controllers
{
    [ValidateInput(false)]
    public class EntityController : Controller
    {
	//
	// GET: INDEX
        [HttpGet]
        [Route("")]
        public ActionResult Index()
        {
            using (var database = new EntityDbContext())
            {
                var tasks = database.Entities.ToList();

                return View(tasks);
            }
        }
		
	//
	// GET: CREATE
	[HttpGet]
        [Route("create")]
        public ActionResult Create()
        {
            return View();
        }
		
	//
	// POST: CREATE
	[HttpPost]
        [Route("create")]
        [ValidateAntiForgeryToken]
        public ActionResult Create(Entity entity)
        {
            if (ModelState.IsValid)
            {
                using (var database = new EntityDbContext())
                {
		    if (database.Entities.Any(e => e.Property == entity.Property))
                    {
                        return View();
                    }
					
                    database.Entities.Add(entity);
                    database.SaveChanges();

                    return RedirectToAction("Index");
                }
            }

            return RedirectToAction("Index");
        }
		
	//
	// GET: READ/5
	[HttpGet]
        [Route("read/{id}")]
        public ActionResult Edit(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }

            using (var database = new EntityDbContext())
            {
                var entity = database.Entities.Find(id);
				
		// var entities = database.Entities.ToList();
                // var entity = entities.FirstOrDefault(e => e.Id == id);

                if (entity == null)
                {
                    return HttpNotFound();
                }

                return View(entity);
            }
        }
		
	//
	// GET: EDIT/5
	[HttpGet]
        [Route("edit/{id}")]
        public ActionResult Edit(int id)
        {
            using (var database = new EntityDbContext())
            {
                var entity = database.Entities.Find(id);
				
		// var entities = database.Entities.ToList();
                // var entity = entities.FirstOrDefault(e => e.Id == id);

                if (entity == null)
                {
                    return HttpNotFound();
                }

                return View(entity);
            }
        }
		
	//
	// POST: EDIT/5
	[HttpPost]
        [Route("edit/{id}")]
        [ValidateAntiForgeryToken]
        public ActionResult EditConfirm(int id, Entity entityViewModel)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }

            if (ModelState.IsValid)
            {
                using (var database = new EntityDbContext())
                {	
		   var entity = database.Entities.Find(id);

		   if (entity == null)
		   {
		      return HttpNotFound();
		   }

		   entity = entityViewModel;

		   database.SaveChanges();

		   return RedirectToAction("Index");
                }
            }
			
	return View(entityViewModel);
        }
		
	//
	// GET: DELETE/5
	[HttpGet]
        [Route("delete/{id}")]
        public ActionResult Delete(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }

            using (var database = new EntitybContext())
            {
                var entity = database.Entities.Find(id);
				
		// var entities = database.Entities.ToList();
                // var entity = entities.FirstOrDefault(e => e.Id == id);

                if (entity == null)
                {
                    return HttpNotFound();
                }

                return View(entity);
            }
        }
		
	//
	// POST: DELETE/5
	[HttpPost]
        [Route("delete/{id}")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirm(int? id, Entity entityViewModel)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }

            using (var database = new EntityDbContext())
            {
                var entity = database.Entities.Find(id);
				
		// var entities = database.Entities.ToList();
                // var entity = entities.FirstOrDefault(e => e.Id == id);

                if (entity == null)
                {
                    return HttpNotFound();
                }

                database.Entities.Remove(entity);
                database.SaveChanges();

                return RedirectToAction("Index");
            }
        }
    }
}
