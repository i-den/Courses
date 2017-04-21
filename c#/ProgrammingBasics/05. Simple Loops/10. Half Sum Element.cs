using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _10.Half_Sum_Element
{
    class Program
    {
        static void Main(string[] args)
        {
            var n = int.Parse(Console.ReadLine());
            var currbiggestnum = 0;
            var numsum = 0;
            for (int i = 1; i <= n; i++)
            {
                var num = int.Parse(Console.ReadLine());
                if (num > currbiggestnum)
                {
                    currbiggestnum = num;
                }
                numsum += num;
            }
            if (currbiggestnum == (numsum - currbiggestnum))
            {
                Console.WriteLine("Yes, sum = " + currbiggestnum );
            }
            else
            {
                Console.WriteLine("No, diff = " + Math.Abs((currbiggestnum - (numsum - currbiggestnum))));
            }
        }
    }
}
