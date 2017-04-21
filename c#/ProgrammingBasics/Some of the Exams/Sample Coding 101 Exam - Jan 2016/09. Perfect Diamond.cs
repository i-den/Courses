using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _09.Perfect_Diamond
{
    class Program
    {
        static void Main(string[] args)
        {
            //var n = int.Parse(Console.ReadLine());
            //var spaces = n - 1;
            //for (int row = 1; row <= n; row++)
            //{
            //    Console.Write(new string(' ', spaces));
            //    Console.Write("*");
            //    for (int col = 2; col <= row; col++)
            //    {
            //        Console.Write("-*");
            //    }
            //    spaces--;
            //    Console.WriteLine();
            //}
            //spaces = n - (n - 1);
            //for (int row = n - 1; row >= 1; row--)
            //{
            //    Console.Write(new string(' ',spaces));
            //    Console.Write("*");
            //    for (int col = 1; col < row; col++)
            //    {
            //        Console.Write("-*");
            //    }
            //    spaces++;
            //    Console.WriteLine();

            var n = int.Parse(Console.ReadLine());

            for (int row = 1; row <= n; row++)
            {
                for (int col = 0; col < n - row; col++) Console.Write(" ");
                Console.Write("*");
                for (int col = 0; col < row - 1; col++) Console.Write("-*");
                Console.WriteLine();
            }
            for (int row = n - 1; row >= 1; row--)
            {
                for (int col = 1; col <= n - row; col++) Console.Write(" ");
                Console.Write("*");
                for (int i = 1; i <= row - 1; i++) Console.Write("-*");
                Console.WriteLine();
            }


        }
        }
    }
