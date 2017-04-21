using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _01.Fruit_Bazaar
{
    class Program
    {
        static void Main(string[] args)
        {

            double vegPrice = double.Parse(Console.ReadLine());
            double fruPrice = double.Parse(Console.ReadLine());
            double vegKg = int.Parse(Console.ReadLine());
            double fruKg = int.Parse(Console.ReadLine());

            double income = (vegPrice * vegKg + fruPrice * fruKg) / 1.94;
            Console.WriteLine("{0:f2}",income);
        }
    }
}
