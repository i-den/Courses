using System;

namespace _10.Radians_to_Degrees
{
    class Program
    {
        static void Main()
        {
            double rad = double.Parse(Console.ReadLine());
            double deg = (rad * 180) / Math.PI;
            Console.WriteLine(Math.Round(deg));
        }
    }
}
