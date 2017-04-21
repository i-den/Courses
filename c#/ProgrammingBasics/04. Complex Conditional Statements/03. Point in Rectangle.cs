using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _03.Point_in_Rectangle
{
    class Program
    {
        static void Main()
        {
            //Define Rectangle Points
            double x1 = double.Parse(Console.ReadLine());
            double y1 = double.Parse(Console.ReadLine());
            double x2 = double.Parse(Console.ReadLine());
            double y2 = double.Parse(Console.ReadLine());
            //Define Rectangle Sides
            double xmax = Math.Max(x1, x2); 
            double xmin = Math.Min(x1, x2); 
            double ymax = Math.Max(y1, y2);
            double ymin = Math.Min(y1, y2);

            //Get the testing point x & y
            double x = double.Parse(Console.ReadLine());
            double y = double.Parse(Console.ReadLine());

            //Rules for being inside
            bool isInsideX = x >= xmin && x <= xmax;
            bool isInsideY = y >= ymin && y <= ymax;
            bool isInside = isInsideX && isInsideY;

            //Print the output
            if (isInside)
                Console.WriteLine("Inside");
            else
                Console.WriteLine("Outside");
        }
    }
}
