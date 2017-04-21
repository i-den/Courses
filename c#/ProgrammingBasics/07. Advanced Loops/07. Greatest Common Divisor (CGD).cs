using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _07.Greatest_Common_Divisor__CGD_
{
    class Program
    {
        static void Main(string[] args)
        {
            var a = int.Parse(Console.ReadLine());
            var b = int.Parse(Console.ReadLine());
            var aa = Math.Max(a, b);
            var bb = Math.Min(a, b);
            //for (int i = int.MaxValue; i >= 1; i--)
            //{
            //    if (a % i == 0 && b % i == 0)
            //    {
            //        Console.WriteLine(i);
            //        break;
            //    }
            //}

            while (bb != 0)
            {
                var rem = bb;
                bb = aa % bb;
                aa = rem;
            }
            Console.WriteLine($"GCD = {aa})");
        }
    }
}
