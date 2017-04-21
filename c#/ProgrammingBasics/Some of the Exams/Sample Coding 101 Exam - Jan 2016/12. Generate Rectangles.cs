using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _12.Generate_Rectangles
{
    class Program
    {
        static void Main(string[] args)
        {

            var n = int.Parse(Console.ReadLine());
            var m = int.Parse(Console.ReadLine());
            var count = 0;

            for (int left = -n ; left <= 0; left++)
            {
                for (int top = -n; top <= 0; top++)
                {
                    for (int right = 0; right <= n; right++)
                    {
                        for (int bot = 0; bot <= n; bot++)
                        {
                            var s1 = Math.Abs(Math.Max(left, right) -Math.Min(left,right));
                            var s2 = Math.Abs(Math.Max(top, bot) - Math.Min(top, bot));
                            var area = s1 * s2;
                            
                            if (area >= m)
                            {
                                Console.WriteLine("({0}, {1}) ({2}, {3}) -> {4}",left,top,right,bot,area);
                                count++;
                            }
                        }
                    }
                }
            }
            if (count == 0)
                Console.WriteLine("No");

        }
    }
}
