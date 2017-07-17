using System;

public class Program
{
    public static void Main()
    {
        var input = Console.ReadLine().Split(':');
        var stepsToMake = int.Parse(Console.ReadLine());
        var secondPerStep = int.Parse(Console.ReadLine());

        var startingHours = int.Parse(input[0]);
        var startingMinutes = int.Parse(input[1]);
        var startingSeconds = int.Parse(input[2]);

        var totalSecondsToAdd = (long)stepsToMake * (long)secondPerStep;

        long totalStartingSeconds = startingSeconds + startingMinutes * 60 + startingHours * 60 * 60;
        var totalSeconds = totalStartingSeconds + totalSecondsToAdd;

        var printingSeconds = totalSeconds % 60;
        var printingMinutes = (totalSeconds / 60) % 60;
        var printingHours = ((totalSeconds / 60) / 60) % 24;

        Console.WriteLine($"Time Arrival: {printingHours:D2}:{printingMinutes:D2}:{printingSeconds:D2}");
    }
}