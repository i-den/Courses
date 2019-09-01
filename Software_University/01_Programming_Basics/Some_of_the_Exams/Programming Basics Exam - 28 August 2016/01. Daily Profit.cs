using System;

class Program
{
    public static void Main()
    {
        int WorkingDays = int.Parse(Console.ReadLine());
        double Pay = double.Parse(Console.ReadLine());
        double USDc = double.Parse(Console.ReadLine());

        double MonthlyPay = Pay * (double)WorkingDays;

        double AnnualPay = MonthlyPay * 14.5;

        double VatPay = AnnualPay * 0.75;

        double AnnualBGN = VatPay * USDc;

        Console.WriteLine("{0:f2}", AnnualBGN / 365);
    }
}