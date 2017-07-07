using System;

class Program
{
    public static void Main()
    {
        var Sarea = double.Parse(Console.ReadLine());
        var Karea = double.Parse(Console.ReadLine());

        var PricePerMeterSq = double.Parse(Console.ReadLine());

        var Barea = Sarea / 2.00;
        var SRarea = Sarea * 1.10;
        var TRarea = SRarea * 1.10;

        var Total = (Sarea + Karea + Barea + SRarea + TRarea) * 1.05;
        var TotalPrice = (Total * PricePerMeterSq);
        Console.WriteLine("{0:00.00}", TotalPrice);
    }
}