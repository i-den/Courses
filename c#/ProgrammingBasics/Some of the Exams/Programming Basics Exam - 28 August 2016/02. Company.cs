using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _02.Company
{
    class Program
    {
        static void Main(string[] args)
        {

            int HoursNeeded = int.Parse(Console.ReadLine());
            int DeadlineDays = int.Parse(Console.ReadLine());
            int Workers = int.Parse(Console.ReadLine());

            double TrainingDays = (double)DeadlineDays * 0.9;
            double WorkingHours = TrainingDays * 8;
            double AllHours = WorkingHours + (Workers * 2 * DeadlineDays);
            double Hours = Math.Floor(AllHours);

            if (Hours >= HoursNeeded)
                Console.WriteLine("Yes!{0} hours left.",(Hours - HoursNeeded));
            else
                Console.WriteLine("Not enough time!{0} hours needed.",(HoursNeeded - Hours));



        }
    }
}
