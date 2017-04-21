using System;

namespace _14.Time___15_Minutes
{
    class Program
    {
        static void Main()
        {
            //var hour = int.Parse(Console.ReadLine());
            //var min = int.Parse(Console.ReadLine());

            //var total = ((hour * 60) + min );
            //var hour2 = total / 60;
            //var min2 = total % 60;
            //if (hour2 >= 24)
            //    hour2 = hour2 % 24;

            //Console.WriteLine("Hour is {0}:{1:00}", hour2, min2);

            string hours = Console.ReadLine();
            string minutes = Console.ReadLine();
            string time = hours + ":" + minutes;
            Console.WriteLine(time);
            DateTime datey = DateTime.ParseExact(time, "h:mm", null);
            datey = datey.AddMinutes(15);
            Console.WriteLine(datey.ToString("h:mm"));

        }

    }
}

