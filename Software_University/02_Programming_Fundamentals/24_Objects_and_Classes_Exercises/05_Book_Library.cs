using System;
using System.Collections.Generic;
using System.Globalization;
using System.Linq;

namespace BookLibrary
{
    class Program
    {
        static void Main()
        {
            var booksCount = int.Parse(Console.ReadLine());
            var myLib = new Library
            {
                Name = "myLibrary",
                Books = new List<Book>()
            };

            for (int i = 0; i < booksCount; i++)
            {
                var input = Console.ReadLine().Split();

                var bookTitle = input[0];
                var bookAuthor = input[1];
                var publisher = input[2];
                var releaseDate = DateTime.ParseExact(input[3], "dd.MM.yyyy", CultureInfo.InvariantCulture);
                var isbn = input[4];
                var price = decimal.Parse(input[5]);

                var book = new Book(bookTitle, bookAuthor, publisher, releaseDate, isbn, price);

                myLib.Books.Add(book);
            }

            var authorSales = myLib.Books
                .Select(author => author.Author)
                .Distinct()
                .Select(author => new Author
                {
                    Name = author,
                    Sales = myLib.Books.Where(a => a.Author == author).Sum(z => z.Price)
                })
                .OrderByDescending(a => a.Sales)
                .ThenBy(a => a.Name)
                .ToArray();

            var bookDate = DateTime.ParseExact(Console.ReadLine(), "dd.MM.yyyy", CultureInfo.InvariantCulture);

            var bookSales = myLib.Books
                .Where(b => b.ReleaseDate > bookDate)
                .Select(b => new Bookz
                {
                    Name = b.Title,
                    ReleaseDate = b.ReleaseDate
                })
                .OrderBy(b => b.ReleaseDate)
                .ThenBy(b => b.Name)
                .ToArray();

            foreach (var item in bookSales)
            {
                Console.WriteLine($"{item.Name} -> {item.ReleaseDate.ToString("dd.MM.yyyy")}");
            }
        }
    }

    class Bookz
    {
        public string Name { get; set; } 
        public DateTime ReleaseDate { get; set; }
    }

    class Author
    {
        public string Name { get; set; }
        public decimal Sales { get; set; }
    }

    class Book
    {
        public Book(string title, string author, string publisher, DateTime releaseDate, string isbnNumber, decimal price)
        {
            this.Title = title;
            this.Author = author;
            this.Publisher = publisher;
            this.ReleaseDate = releaseDate;
            this.IsbnNumber = isbnNumber;
            this.Price = price;
        }

        public string Title { get; set; }

        public string Author { get; set; }

        public string Publisher { get; set; }

        public DateTime ReleaseDate { get; set; }

        public string IsbnNumber { get; set; }

        public decimal Price { get; set; }
    }

    class Library
    {
        public string Name { get; set; }

        public List<Book> Books { get; set; }
    }
}