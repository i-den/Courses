using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _03.Bike_Race
{
    class Program
    {
        static void Main(string[] args)
        {

            var Juniors = int.Parse(Console.ReadLine());
            var Seniors = int.Parse(Console.ReadLine());

            var type = Console.ReadLine();

            double jPrice = 0;
            double sPrice = 0;


            switch (type)
            {
                case "trail":
                    jPrice = 5.50;
                    sPrice = 7.00; break;
                case "cross-country":
                    jPrice = 8.00;
                    sPrice = 9.50; break;
                case "downhill":
                    jPrice = 12.25;
                    sPrice = 13.75; break;
                case "road":
                    jPrice = 20.00;
                    sPrice = 21.50; break;
            }
            var Total = Juniors * jPrice + Seniors * sPrice;
            if (Juniors + Seniors >= 50 && type == "cross-country") Total *= 0.75;
            var Donation = (Total * 0.95);
            Console.WriteLine("{0:00.00}", Donation);


        }
    }
}
