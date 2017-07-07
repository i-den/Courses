using System;

class Program
{
    public static void Main()
    {
        double distance = double.Parse(Console.ReadLine());
        string solus = Console.ReadLine().ToLower();

        double taxiFee = double.MaxValue;
        double busFee = double.MaxValue;
        double trainFee = double.MaxValue;

        if (solus == "day")
            taxiFee = 0.70 + 0.79 * distance;
        else
            taxiFee = 0.70 + 0.9 * distance;

        if (distance >= 20)
            busFee = 0.09 * distance;

        if (distance >= 100)
            trainFee = 0.06 * distance;

        Console.WriteLine(Math.Min(Math.Min(taxiFee, busFee), trainFee));
    }
}