using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _08.Metric_Converter
{
    class Program
    {
        static void Main(string[] args)
        {
            var amount = double.Parse(Console.ReadLine());
            var from = Console.ReadLine();
            var to = Console.ReadLine();

            var m = 1;
            var mm = 1000;
            var cm = 100;
            var mi = 0.000621371192;
            var inc = 39.3700787;
            var km = 0.001;
            var ft = 3.2808399;
            var yd = 1.0936133;

            if (from == "m")
            {
                if (to == "cm")
                {
                    Console.WriteLine(amount / m * cm);
                }
                if (to == "mi")
                {
                    Console.WriteLine(amount / m * mi);
                }
                if (to == "inc")
                {
                    Console.WriteLine(amount / m * inc);
                }
                if (to == "km")
                {
                    Console.WriteLine(amount / m * km);
                }
                if (to == "ft")
                {
                    Console.WriteLine(amount / m * ft);
                }
                if (to == "yd")
                {
                    Console.WriteLine(amount / m * mm);
                }
                if (to == "mm")
                {
                    Console.WriteLine(amount / m * yd);
                }
            }
        }
    }
}
