using System;

namespace _07._2D_Rectangle_Area
{
    class Program
    {
        static void Main()
        {
            
            //Getting side's point parameters
            var x1 = double.Parse(Console.ReadLine()); 
            var y1 = double.Parse(Console.ReadLine());
            var x2 = double.Parse(Console.ReadLine());
            var y2 = double.Parse(Console.ReadLine());
            
            //Getting the exact side lengths
            double x = Math.Abs(x1 - x2);
            double y = Math.Abs(y1 - y2);
            
            //Calculating Area & Perimeter in #doubles
            double area = x * y;
            double perimeter = 2 * (x + y);
            //Writing area & output to STDOUT
            Console.WriteLine(area);
            Console.WriteLine(perimeter);
        }
    }
}
