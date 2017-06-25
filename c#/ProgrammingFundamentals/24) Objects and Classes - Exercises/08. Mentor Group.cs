using System;
using System.Collections.Generic;
using System.Globalization;
using System.Linq;

namespace MentorGroup
{
    class Program
    {
        static void Main()
        {
            var studentsList = new List<Student>();

            while (true)
            {
                var input = Console.ReadLine();

                if (input == "end of dates")
                {
                    break;
                }

                var tokens = input.Split(new[] { ' ', ',' }, StringSplitOptions.RemoveEmptyEntries);

                var name = tokens.First();
                var dates = tokens
                    .Skip(1)
                    .Select(x => DateTime.ParseExact(x, "dd/MM/yyyy", CultureInfo.InvariantCulture))
                    .ToList();

                studentsList.Add(new Student
                {
                    Name = name,
                    Comments = new List<string>(),
                    DatesAttended = dates
                });
            }

            while (true)
            {
                var input = Console.ReadLine();

                if (input == "end of comments")
                {
                    break;
                }

                var tokens = input.Split('-');
                var name = tokens[0];
                var comment = tokens[1];

                if (!studentsList.Any(c => c.Name == name))
                {
                    continue;
                }

                var currStudent = studentsList.First(c => c.Name == name);
                currStudent.Comments.Add(comment);
            }

            foreach (var currStudent in studentsList.OrderBy(c => c.Name))
            {
                Console.WriteLine($"{currStudent.Name}");
                Console.WriteLine("Comments:");

                foreach (var comment in currStudent.Comments)
                {
                    Console.WriteLine($"- {comment}");
                }

                Console.WriteLine("Dates attended:");

                foreach (var dateAttended in currStudent.DatesAttended.OrderBy(a => a))
                {
                    Console.WriteLine($"-- {dateAttended.ToString("dd/MM/yyyy")}");
                }
            }
        }
    }

    class Student
    {
        public string Name { get; set; }

        public List<string> Comments { get; set; }

        public List<DateTime> DatesAttended { get; set; }
    }
}