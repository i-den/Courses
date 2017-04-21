using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _01.Training_Lab
{
    class Program
    {
        static void Main(string[] args)
        {

            double w = double.Parse(Console.ReadLine());
            double h = double.Parse(Console.ReadLine());

            double wcm = w * 100;
            double hcm = h * 100;

            var hh = hcm - 100;
            int desk = (int)hh / 70;

            var rows = (int)wcm / 120;

            var places = desk * rows - 3;

            Console.WriteLine(places);

        }
    }
}
