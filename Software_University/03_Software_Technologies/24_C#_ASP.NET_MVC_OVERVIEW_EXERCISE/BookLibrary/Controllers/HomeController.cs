﻿using System.Web.Mvc;

namespace BookLibrary.Controllers
{using System.Web.Mvc;
    public class HomeController : Controller
    {
        public ActionResult Index()
        {
            return RedirectToAction("Index", "Book");
        }
    }
}