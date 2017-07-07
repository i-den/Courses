using System;

class Program
{
    public static void Main()
    {
        double vegPrice = double.Parse(Console.ReadLine());
        double fruPrice = double.Parse(Console.ReadLine());
        double vegKg = int.Parse(Console.ReadLine());
        double fruKg = int.Parse(Console.ReadLine());

        double income = (vegPrice * vegKg + fruPrice * fruKg) / 1.94;
        Console.WriteLine("{0:f2}", income);
    }
}