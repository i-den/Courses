using System;

public class Program
{
    public static void Main()
    {
        var hour = int.Parse(Console.ReadLine());
        var minutes = int.Parse(Console.ReadLine());

        var totalTime = hour * 60 + minutes + 30;

        hour = (totalTime / 60) % 24;
        minutes = totalTime % 60;

        Console.WriteLine($"{hour}:{minutes:D2}");
    }
}