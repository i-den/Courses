using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _03.Hotel_Room
{
    class Program
    {
        static void Main(string[] args)
        {

            string Season = Console.ReadLine().ToLower();
            int SleepOvers = int.Parse(Console.ReadLine());

            double Studio = 0.0;
            double Apartment = 0.0;

            if (Season == "may" || Season == "october")
            {
                Studio = 50.00;
                Apartment = 65.00;
                if (SleepOvers > 7 && SleepOvers <= 14)
                    Studio = 50.00 * 0.95;
                else if (SleepOvers > 14)
                    Studio = 50.00 * 0.70;
            }
            else if (Season == "june" || Season == "september")
            {
                Studio = 75.20;
                Apartment = 68.70;
                if (SleepOvers > 14)
                    Studio = 75.20 * 0.8;
            }
            else
            {
                Studio = 76.00;
                Apartment = 77.00;
            }
            if (SleepOvers > 14)
                Apartment *= 0.9;

            Console.WriteLine("Apartment: {0:f2} lv.",Apartment * SleepOvers);
            Console.WriteLine("Studio: {0:f2} lv.", Studio * SleepOvers);



        }
    }
}
