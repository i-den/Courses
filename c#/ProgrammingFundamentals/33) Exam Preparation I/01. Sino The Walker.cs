using System;
using System.Linq;

class Program
{
    static void Main()
    {
        var input = Console.ReadLine()
            .Split(':')
            .Select(int.Parse)
            .ToArray();

        var hours = input[0];
        var minutes = input[1];
        var seconds = input[2];

        var stepsCount = int.Parse(Console.ReadLine());
        var stepSec = int.Parse(Console.ReadLine());
        var stepSecondsToAdd = stepsCount * (long)stepSec;

        var totalStartSeconds = seconds + (minutes * 60) + (hours * (60 * 60));
        var totalSeconds = totalStartSeconds + stepSecondsToAdd;

        var sec = totalSeconds % 60;
        var min = (totalSeconds / 60) % 60;
        var hr = (totalSeconds / (60 * 60)) % 24;

        Console.WriteLine($"Time Arrival: {hr:D2}:{min:D2}:{sec:D2}");
    }
}