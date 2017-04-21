using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _01.Daily_Profit
{
    class Program
    {
        static void Main(string[] args)
        {

            int WorkingDays = int.Parse(Console.ReadLine());
            double Pay = double.Parse(Console.ReadLine());
            double USDc = double.Parse(Console.ReadLine());

            double MonthlyPay = Pay * (double)WorkingDays;

            double AnnualPay = MonthlyPay * 14.5;

            double VatPay = AnnualPay * 0.75;

            double AnnualBGN = VatPay * USDc;

            Console.WriteLine("{0:f2}",AnnualBGN / 365);
        }
    }
}
