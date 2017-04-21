using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _06.Max_Combination
{
    class Program
    {
        static void Main(string[] args)
        {

            var n = int.Parse(Console.ReadLine());

            var end = int.Parse(Console.ReadLine());

            var inter = int.Parse(Console.ReadLine());

            var rip = 0;

            for (int fir = n; fir <= end; fir++)
            {
                for (int sec = n; sec <= end; sec++)
                {
                    if (rip < inter)
                    {
                        Console.Write("<{0}-{1}>", fir, sec);
                        rip++;
                    }
                }
            }

        }
    }
}
