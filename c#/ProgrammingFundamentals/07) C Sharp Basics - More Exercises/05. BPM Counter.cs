using System;

public class Program
{
    public static void Main()
    {
        var beatsPerMinute = int.Parse(Console.ReadLine());
        var numberOfBeats = double.Parse(Console.ReadLine());

        var bars = Math.Round((numberOfBeats / 4D),1);
        var totalTime = (int)(numberOfBeats / beatsPerMinute * 60);
        var minutes = totalTime / 60;
        var seconds = totalTime % 60;

        Console.WriteLine($"{bars} bars - {minutes}m {seconds}s");
    }
}