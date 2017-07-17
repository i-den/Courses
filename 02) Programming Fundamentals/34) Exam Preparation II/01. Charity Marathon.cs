using System;

class Program
{
    public static void Main()
    {
        var days = GetInt();
        var runnersCount = GetInt();
        var laps = GetInt();
        var lapLength = GetInt();
        var trackCapacity = GetInt();
        var moneyPerKm = decimal.Parse(Console.ReadLine());

        var maxRunners = (long)trackCapacity * days;
        var runnersThatWillRun = maxRunners >= runnersCount
            ? runnersCount
            : maxRunners;

        var totalMetersRan = runnersThatWillRun * laps * lapLength;
        var totalKilometersRan = totalMetersRan / 1000;
        var moneyRaised = totalKilometersRan * moneyPerKm;

        Console.WriteLine($"Money raised: {moneyRaised:F2}");
    }

    public static int GetInt()
    {
        return int.Parse(Console.ReadLine());
    }
}