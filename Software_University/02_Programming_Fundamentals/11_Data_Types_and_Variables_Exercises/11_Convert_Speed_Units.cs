using System;

public class Program
{
    public static void Main()
    {
        var distance = float.Parse(Console.ReadLine());
        var hours = float.Parse(Console.ReadLine());
        var minutes = float.Parse(Console.ReadLine());
        var seconds = float.Parse(Console.ReadLine());

        var totalSeconds = ((hours * 60) * 60) + (minutes * 60) + seconds;
        var totalHours = hours + (minutes / 60) + ((seconds / 60) / 60);

        var speedMetersPerSecond = distance / totalSeconds;
        var speedKilometersPerHour = distance / 1000 / totalHours;
        var milesPerHour = distance / 1609 / totalHours;

        Console.WriteLine(speedMetersPerSecond);
        Console.WriteLine(speedKilometersPerHour);
        Console.WriteLine(milesPerHour);
    }
}