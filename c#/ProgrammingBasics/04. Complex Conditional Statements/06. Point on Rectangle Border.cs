using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _06.Point_on_Rectangle_Border
{
    class Program
    {
        static void Main(string[] args)
        {
            //Define the Rectangle
            double x1 = double.Parse(Console.ReadLine());
            double y1 = double.Parse(Console.ReadLine());
            double x2 = double.Parse(Console.ReadLine());
            double y2 = double.Parse(Console.ReadLine());
            //Define testing point
            double x = double.Parse(Console.ReadLine());
            double y = double.Parse(Console.ReadLine());

            //Define Maximum X & Y
            double xmax = Math.Max(x1, x2);
            double xmin = Math.Min(x1, x2);
            double ymax = Math.Max(y1, y2);
            double ymin = Math.Min(y1, y2);

            //Wether it's on the border or not
            bool borderX = x >= xmin && x <= xmax && (y == ymin || y == ymax);
            bool borderY = y >= ymin && y <= ymax && (x == xmin || x == xmax);

            if (borderX || borderY)
                Console.WriteLine("Border");
            else
                Console.WriteLine("Inside / Outside");

        }
    }
}
