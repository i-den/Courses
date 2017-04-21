using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _07.Sum_Seconds
{
    class Program
    {
        static void Main(string[] args)
        {
            var a = int.Parse(Console.ReadLine());
            var b = int.Parse(Console.ReadLine());
            var c = int.Parse(Console.ReadLine());
            //if (a <= 50 && b <= 50 && c <= 50)
            //{
            //    var sec = a + b + c;
            //    var min = sec / 60;

            //    sec = sec % 60;
            //     if (sec < 10)
            //        Console.WriteLine(min + ":0" + sec);

            //    else
            //        Console.WriteLine(min + ":" + sec);  
            //}

            TimeSpan timey = TimeSpan.FromSeconds(a + b + c);
            Console.WriteLine($"{timey.Minutes}:{timey.Seconds:d2}");


        }
    }
}
