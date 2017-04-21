using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _13.Point_in_the_Figure
{
    class Program
    {
        static void Main(string[] args)
        {
            var h = int.Parse(Console.ReadLine());
            var x = int.Parse(Console.ReadLine());
            var y = int.Parse(Console.ReadLine());

            //Lower rectangle
            var xminlower = 0;
            var xmaxlower = h * 3;
            var yminlower = 0;
            var ymaxlower = h;

            //Upper rectangle
            var xminupper = h;
            var xmaxupper = h * 2;
            var yminupper = h;
            var ymaxupper = h * 4;


            if (x >= xminupper + 0.1 && x <= xmaxupper - 0.1 && y == ymaxlower)
            {
                Console.WriteLine("inside");
            }
            else if (x >= xminlower + 0.1 && x <= xmaxlower - 0.1 && y >= yminlower + 0.1 && y <= ymaxlower - 0.1)
            {
                Console.WriteLine("inside");
            }
            else if (x >= xminupper + 0.1 && x <= xmaxupper - 0.1 && y >= yminupper + 0.1 && y <= ymaxupper - 0.1)
            {
                Console.WriteLine("inside");
            }
            // nai doly ____
            else if (x >= xminlower && x <= xmaxlower && y == 0)
            {
                Console.WriteLine("border");
            }

            //nai lqvo doly |||
            else if (x == 0 && y >= yminlower && y <= ymaxlower)
            {
                Console.WriteLine("border");
            }

            //vtori red lqv ___
            else if (x >= xminlower && x <= xminupper && y == h )
            {
                Console.WriteLine("border");
            }
            // upper lqv |||
            else if (x == xminupper && y >= yminupper && y <= ymaxupper)
            {
                Console.WriteLine("border");
            }

            // top ___
            else if (x >= xminupper && x <= xmaxupper && y == ymaxupper)
            {
                Console.WriteLine("border");
            }

            // upper desen |||
            else if (x == xmaxupper && y >= yminupper && y <= ymaxupper)
            {
                Console.WriteLine("border");
            }

            // vtori red desen ___
            else if (x >= xmaxupper && x <= xmaxlower && y == ymaxlower)
            {
                Console.WriteLine("border");
            }

            // desen |||
            else if ( y >= 0 && y<= h && x == h * 3)
            {
                Console.WriteLine("border");
            }

            // else
            else
            {
                Console.WriteLine("outside");
            }

        }
    }
}
