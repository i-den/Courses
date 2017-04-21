using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _11.Cinema
{
    class Program
    {
        static void Main(string[] args)
        {
            var type = Console.ReadLine().ToLower();
            var rows = int.Parse(Console.ReadLine());
            var cols = int.Parse(Console.ReadLine());

            var cost = 0.0;
            

            switch (type)
            {
                case "premiere":
                    cost = 12.00;
                    break;
                case "normal":
                    cost = 7.50;
                    break;
                case "discount":
                    cost = 5.00;
                    break;

            }
            var inc = cost * rows * cols;
            Console.WriteLine("{0:00}",inc);

        }
    }
}
