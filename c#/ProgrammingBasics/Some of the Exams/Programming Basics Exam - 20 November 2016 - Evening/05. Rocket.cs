using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace rocket
{
    class Program
    {
        static void Main(string[] args)
        {
            var n = int.Parse(Console.ReadLine());

            for (int row = 0; row < n; row++)
                Console.WriteLine("{0}/{1}\\{0}", new string('.', (n / 2) + n - 1 - row), new string(' ', row * 2));
            Console.WriteLine("{0}{1}{0}", new string('.', n / 2), new string('*', n * 2));
            for (int row = 0; row < n * 2; row++)
                Console.WriteLine("{0}|{1}|{0}", new string('.', n / 2), new string('\\', (n - 1) * 2));
            for (int row = 0; row < n / 2; row++)
                Console.WriteLine("{0}/{1}\\{0}", new string('.', n / 2 - row), new string('*', (n - 1) * 2 + row * 2));
        }
    }
}
