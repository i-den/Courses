using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _03.Point_on_Segment
{
    class Program
    {
        static void Main(string[] args)
        {

            var first = int.Parse(Console.ReadLine());
            var second = int.Parse(Console.ReadLine());
            var point = int.Parse(Console.ReadLine());

            int max = Math.Max(first, second);
            int min = Math.Min(first, second);
            var close = 0;
            if (max - point < point - min)
                close = max - point;
            else close = point - min;

            if (point >= min && point <= max)
                Console.WriteLine("in");
            else
                Console.WriteLine("out");
            Console.WriteLine(Math.Abs(close));
        }
    }
}
