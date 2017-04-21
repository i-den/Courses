using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _15._3_Equal_Numbers
{
    class Program
    {
        static void Main(string[] args)
        {
            var a = Console.ReadLine();
            var b = Console.ReadLine();
            var c = Console.ReadLine();

            if (a == b & a == c & b == c)
                Console.WriteLine("yes");

            else
                Console.WriteLine("no");

        }
    }
}
