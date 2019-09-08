using System;

public class Program
{
    public static void Main()
    {
        var kegsCount = int.Parse(Console.ReadLine());

        var biggestKegType = string.Empty;
        var biggestKegSize = 0D;

        for (int i = 0; i < kegsCount; i++)
        {
            var currentKegType = Console.ReadLine();
            var currentKegRadius = double.Parse(Console.ReadLine());
            var currentKegHeight = double.Parse(Console.ReadLine());

            var currentKegSize = Math.PI *  Math.Pow(currentKegRadius, 2) * currentKegHeight;

            if (currentKegSize > biggestKegSize)
            {
                biggestKegType = currentKegType;
                biggestKegSize = currentKegSize;
            }
        }

        Console.WriteLine(biggestKegType);
    }
}