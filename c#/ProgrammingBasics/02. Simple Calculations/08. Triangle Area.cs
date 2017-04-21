using System;

namespace _08.Triangle_Area
{
    class Program
    {
        static void Main()
        {
            //Getting triangle's side and height in #double
            var a = double.Parse(Console.ReadLine());
            var h = double.Parse(Console.ReadLine());
            
            //Calculating Area
            var area = a * h / 2;

            //Printing Area to STDOUT
            Console.WriteLine(Math.Round(area, 2));
        }
    }
}
