using System;
using System.Linq;

namespace Circles
{
    class Program
    {
        static void Main()
        {
            var firstCircle = GetCircle();
            var secCircle = GetCircle();

            var intersects = 
                firstCircle.Center.DistanceTo(secCircle.Center) 
                <= firstCircle.Radius + secCircle.Radius;

            Console.WriteLine(intersects ? "Yes" : "No");
        }

        public static Circle GetCircle()
        {
            var input = Console.ReadLine()
                .Split()
                .Select(int.Parse)
                .ToArray();

            var center = new Point { X = input[0], Y = input[1] };
            var circle = new Circle { Center = center, Radius = input[2] };

            return circle;
        }
    }

    class Circle
    {
        public Point Center { get; set; }
        public int Radius { get; set; }
    }

    class Point
    {
        public int X { get; set; }
        public int Y { get; set; }

        public double DistanceTo(Point p)
        {
            var deltaX = Math.Abs(X - p.X);
            var deltaY = Math.Abs(Y - p.Y);

            return Math.Sqrt(deltaX * deltaX + deltaY * deltaY);
        }
    }
}