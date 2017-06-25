using System;
using System.Collections.Generic;
using System.Linq;

namespace AverageGrades
{
    class Program
    {
        static void Main()
        {
            var studentsCount = int.Parse(Console.ReadLine());
            var studentsList = new List<Student>();

            for (int i = 0; i < studentsCount; i++)
            {
                var input = Console.ReadLine().Split();

                var name = input.First();
                var grades = input
                    .Skip(1)
                    .Select(double.Parse)
                    .ToArray();

                var currStudent = new Student
                {
                    Name = name,
                    ListOfGrades = grades
                };

                studentsList.Add(currStudent);
            }

            foreach (var currStudent in studentsList
                .Where(s => s.AverageGrade >= 5.00)
                .OrderBy(s => s.Name)
                .ThenByDescending(s => s.AverageGrade))
            {
                Console.WriteLine($"{currStudent.Name} -> {currStudent.AverageGrade:F2}");
            }
        }
    }

    class Student
    {
        public string Name { get; set; }

        public double[] ListOfGrades { get; set; }

        public double AverageGrade => this.ListOfGrades.Average();
    }
}