// ~/Models/Entity.cs

using System.ComponentModel.DataAnnotations;
using System.Web.Mvc;

namespace IMDB.Models
{
    public class Film
    {
        [Key]
        public int Id { get; set; }

        [Required]
		[StringLength(50)]
        [AllowHtml]
        public string String { get; set; }

        [Required]
        public int Year { get; set; }
    }
}