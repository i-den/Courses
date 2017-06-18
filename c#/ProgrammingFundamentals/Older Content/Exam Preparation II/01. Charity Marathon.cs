using System;
using System.Numerics;

public class Program
{
    public static void Main()
    {
        var marathonDays = int.Parse(Console.ReadLine());
        var runnersCount = int.Parse(Console.ReadLine());
        var avgLaps = int.Parse(Console.ReadLine());
        var lapLength = int.Parse(Console.ReadLine());
        var trackCapacity = int.Parse(Console.ReadLine());
        var moneyPerKilometer = double.Parse(Console.ReadLine());

        var moneyRaised = 0D;
        var totalRunnerSpots = trackCapacity * marathonDays;

        var validRunners = totalRunnerSpots >= runnersCount ? runnersCount : totalRunnerSpots;
        var totalMeters = (BigInteger)validRunners * avgLaps * lapLength;
        var totalKilometers = totalMeters / 1000;

        moneyRaised = (double)totalKilometers * moneyPerKilometer;
        Console.WriteLine($"Money raised: {moneyRaised:F2}");
    }
}