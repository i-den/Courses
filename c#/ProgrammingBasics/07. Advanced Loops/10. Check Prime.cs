using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _10.Check_Prime
{
    class Program
    {
        static void Main(string[] args)
        {
            
            var n = int.Parse(Console.ReadLine());
            var prime = (n > 1);

            for (int i = 2; i <= Math.Sqrt(n); i++)
            {
                if (n % i == 0)
                {
                    prime = false;
                    break;
                }
            }
            if (prime) Console.WriteLine("Prime");
            else Console.WriteLine("Not Prime");

        }
        }
    }

