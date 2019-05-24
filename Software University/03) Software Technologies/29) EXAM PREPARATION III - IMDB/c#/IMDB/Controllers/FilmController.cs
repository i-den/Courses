using System.Linq;
using System.Net;
using System.Web.Mvc;
using IMDB.Models;

namespace IMDB.Controllers
{
    [ValidateInput(false)]
    public class FilmController : Controller
    {
        [HttpGet]
        [Route("")]
        public ActionResult Index()
        {
            using (var db = new IMDBDbContext())
            {
                var films = db.Films.ToList();

                return View(films);
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
        public ActionResult Create(Film film)
        {
            if (ModelState.IsValid)
            {
                using (var db = new IMDBDbContext())
                {
                    if (db.Films.Any(f => f.Name == film.Name))
                    {
                        return View();
                    }

                    db.Films.Add(film);
                    db.SaveChanges();

                    return RedirectToAction("Index");
                }
            }

            return View();
        }

        [HttpGet]
        [Route("edit/{id}")]
        public ActionResult Edit(int? id)
        {
            if (id == null)
            {
                return HttpNotFound();
            }

            using (var db = new IMDBDbContext())
            {
                var films = db.Films.ToList();
                var film = films.FirstOrDefault(f => f.Id == id);

                if (film == null)
                {
                    return RedirectToAction("Index");
                }

                return View(film);
            }
        }

        [HttpPost]
        [Route("edit/{id}")]
        [ValidateAntiForgeryToken]
        public ActionResult EditConfirm(int? id, Film filmModel)
        {
            if (id == null)
            {
                return RedirectToAction("Index");
            }

            using (var db = new IMDBDbContext())
            {
                var films = db.Films.ToList();
                var film = films.FirstOrDefault(f => f.Id == id);

                if (film == null || !ModelState.IsValid)
                {
                    return RedirectToAction("Index");
                }

                film = filmModel;
                db.SaveChanges();

                return RedirectToAction("Index");
            }
        }

        [HttpGet]
        [Route("delete/{id}")]
        public ActionResult Delete(int? id)
        {
            if (id == null)
            {
                return RedirectToAction("Index");
            }

            using (var db = new IMDBDbContext())
            {
                var films = db.Films.ToList();
                var film = films.FirstOrDefault(f => f.Id == id);

                if (film == null)
                {
                    return RedirectToAction("Index");
                }

                return View(film);
            }
        }

        [HttpPost]
        [Route("delete/{id}")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirm(int? id, Film filmModel)
        {
            if (id == null)
            {
                return RedirectToAction("Index");
            }

            using (var db = new IMDBDbContext())
            {
                var films = db.Films.ToList();
                var film = films.SingleOrDefault(f => f.Id == id);

                if (film == null)
                {
                    return RedirectToAction("Index");
                }

                db.Films.Remove(film);
                db.SaveChanges();

                return RedirectToAction("Index");
            }
        }
    }
}