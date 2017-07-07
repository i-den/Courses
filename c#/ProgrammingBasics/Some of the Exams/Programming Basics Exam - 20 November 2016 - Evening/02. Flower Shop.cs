using System;

class Program
{
    public static void Main()
    {
        var magnolii = int.Parse(Console.ReadLine());
        var zumb = int.Parse(Console.ReadLine());
        var rozi = int.Parse(Console.ReadLine());
        var kekt = int.Parse(Console.ReadLine());
        var cena = double.Parse(Console.ReadLine());

        var magProf = magnolii * 3.25;
        var zumProf = zumb * 4.00;
        var rozProf = rozi * 3.50;
        var kekProf = kekt * 8.00;

        var Profit = magProf + zumProf + rozProf + kekProf;

        var Money = Profit * 0.95;

        if (Money >= cena) Console.WriteLine("She is left with {0} leva.", Math.Floor(Money - cena));
        else Console.WriteLine("She will have to borrow {0} leva.", Math.Ceiling(cena - Money));
    }
}