using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _08.Increasing_Elements
{
    class Program
    {
        static void Main(string[] args)
        {
            var n = int.Parse(Console.ReadLine());
            var len = 0;
            var maxlen = 0;
            var prev = int.MinValue;
            for (int i = 0; i < n; i++)
            {
                var num = int.Parse(Console.ReadLine());
                if ((i == 0) || (num > prev))
                    len++;
                else
                    len = 1;
                if (len > maxlen) maxlen = len;
                prev = num;
            }
            Console.WriteLine(maxlen);
        }
    }
}