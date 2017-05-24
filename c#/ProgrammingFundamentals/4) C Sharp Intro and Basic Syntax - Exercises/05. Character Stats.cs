using System;

public class Program
{
    public static void Main()
    {
        var charName = Console.ReadLine();
        var charCurrHealth = int.Parse(Console.ReadLine());
        var charMaxHealth = int.Parse(Console.ReadLine());
        var charCurrEnergy = int.Parse(Console.ReadLine());
        var charMaxEnergy = int.Parse(Console.ReadLine());

        Console.WriteLine($"Name: {charName}");
        PrintCurrentStats(charCurrHealth, charMaxHealth, "Health");
        PrintCurrentStats(charCurrEnergy, charMaxEnergy, "Energy");
    }

    public static void PrintCurrentStats(int currentStat, int maxStat, string currStatType)
    {
        Console.Write($"{currStatType}: |");

        for (int i = 1, j = 0; i <= maxStat; i++)
        {
            if (j < currentStat)
            {
                j++;
            }

            if (i == j)
            {
                Console.Write("|");
            }
            else
            {
                Console.Write(".");
            }
        }

        Console.WriteLine("|");
    }
}