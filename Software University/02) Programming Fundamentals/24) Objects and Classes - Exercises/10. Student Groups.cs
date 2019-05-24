using System;
using System.Collections.Generic;
using System.Globalization;
using System.Linq;
using System.Text.RegularExpressions;

namespace Students // Ref: https://github.com/stwel
{
    class Program
    {
        static void Main()
        {
            var towns = GetTowns();
            var groups = GetGroups(towns);
            PrintResults(groups);
        }

        public static void PrintResults(List<Group> groups)
        {
            var townsCount = groups
                .Select(x => x.Town)
                .Distinct()
                .Count();

            Console.WriteLine($"Created {groups.Count} groups in {townsCount} towns:");

            foreach (var group in groups.OrderBy(x => x.Town.Name))
            {
                Console.Write($"{group.Town.Name} => ");

                Console.WriteLine($"{string.Join(", ", group.Students.Select(x => x.Email))}");
            }
        }

        public static List<Group> GetGroups(List<Town> towns)
        {
            var groups = new List<Group>();

            foreach (var town in towns.OrderBy(x => x.Name))
            {
                IEnumerable<Student> students = town.Students
                    .OrderBy(x => x.RegistrationDate)
                    .ThenBy(x => x.Name)
                    .ThenBy(x => x.Email);

                while (students.Any())
                {
                    var group = new Group();

                    group.Town = town;
                    group.Students = students.Take(group.Town.SeatsCount).ToList();
                    students = students.Skip(group.Town.SeatsCount);
                    groups.Add(group);
                }
            }

            return groups;
        }

        public static List<Town> GetTowns()
        {
            var towns = new List<Town>();

            while (true)
            {
                var input = Console.ReadLine();

                if (input == "End")
                {
                    break;
                }

                if (input.Contains("=>"))
                {
                    var townName = input.Split().First();
                    var seats = int.Parse(Regex.Match(input, @"\d+").Value);

                    var currTown = new Town
                    {
                        Name = townName,
                        SeatsCount = seats,
                        Students = new List<Student>()
                    };

                    towns.Add(currTown);
                }
                else
                {
                    var tokens = input
                        .Split(new char[] { '|' }, StringSplitOptions.RemoveEmptyEntries)
                        .Select(x => x.Trim())
                        .ToList();

                    var studentName = tokens[0];
                    var email = tokens[1];
                    var regDate = DateTime.ParseExact(tokens[2], "d-MMM-yyyy", CultureInfo.InvariantCulture);

                    var currStudent = new Student
                    {
                        Name = studentName,
                        Email = email,
                        RegistrationDate = regDate
                    };

                    towns.LastOrDefault().Students.Add(currStudent);
                }
            }

            return towns;
        }
    }

    class Student
    {
        public string Name { get; set; }

        public string Email { get; set; }

        public DateTime RegistrationDate { get; set; }
    }

    class Town
    {
        public string Name { get; set; }

        public int SeatsCount { get; set; }

        public List<Student> Students { get; set; }
    }

    class Group
    {
        public Town Town { get; set; }

        public List<Student> Students { get; set; }
    }
}