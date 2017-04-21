using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _06.Sums_3_Numbers
{
    class Program
    {
        static void Main(string[] args)
        {
            var a = int.Parse(Console.ReadLine());
            var b = int.Parse(Console.ReadLine());
            var c = int.Parse(Console.ReadLine());

            var min = Math.Min(a, (Math.Min(b, c)));
            var max = Math.Max(a, (Math.Max(b, c)));
            var mid = (a + b +c) - max - min;
            //Console.WriteLine("min: " + min);
            //Console.WriteLine("mid: " + mid);
            //Console.WriteLine("max: " + max);

            if (min + mid == max) Console.WriteLine($"{min}+{mid}={max}");
            else Console.WriteLine("No");

        }
    }
}
