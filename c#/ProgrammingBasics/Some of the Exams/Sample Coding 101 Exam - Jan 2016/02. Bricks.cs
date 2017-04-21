using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _02.Bricks
{
    class Program
    {
        static void Main(string[] args)
        {

            int bricks = int.Parse(Console.ReadLine());
            int workers = int.Parse(Console.ReadLine());
            int quantity = int.Parse(Console.ReadLine());

            double PerLoad = workers * quantity;
            double bla = bricks / PerLoad;
            Console.WriteLine(Math.Ceiling(bricks / PerLoad));

        }
    }
}
