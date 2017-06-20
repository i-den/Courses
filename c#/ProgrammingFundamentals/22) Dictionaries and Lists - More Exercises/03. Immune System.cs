using System;
using System.Collections.Generic;

class Program
{
    static void Main()
    {
        var immuneHealth = int.Parse(Console.ReadLine());
        var top = immuneHealth;
        var viruses = new Dictionary<string, int>();

        while (true)
        {
            var currVirus = Console.ReadLine();
            var timeToDefeatSec = 0;

            if (currVirus == "end")
            {
                break;
            }

            if (!viruses.ContainsKey(currVirus))
            {
                var currVirusStr = GetCurrStr(currVirus);
                viruses[currVirus] = currVirusStr;
                timeToDefeatSec = viruses[currVirus] * currVirus.Length;
            }
            else
            {
                timeToDefeatSec = viruses[currVirus] * currVirus.Length / 3;
            }

            var min = timeToDefeatSec / 60;
            var sec = timeToDefeatSec % 60;

            // prints 1st line
            Console.WriteLine($"Virus {currVirus}: {viruses[currVirus]} => {timeToDefeatSec} seconds");

            if (immuneHealth - timeToDefeatSec > 0)
            {
                immuneHealth -= timeToDefeatSec;
                Console.WriteLine($"{currVirus} defeated in {min}m {sec}s.");
                Console.WriteLine($"Remaining health: {immuneHealth}");

                if (immuneHealth + immuneHealth * 0.2 > top)
                {
                    immuneHealth = top;
                }
                else
                {
                    immuneHealth += (int)(immuneHealth * 0.2);
                }
            }
            else
            {
                Console.WriteLine($"Immune System Defeated.");
                return;
            }
        }

        Console.WriteLine($"Final Health: {immuneHealth}");
    }

    public static int GetCurrStr(string currVirus)
    {
        var sum = 0;

        foreach (var charA in currVirus)
        {
            sum += (int)charA;
        }

        return sum / 3;
    }
}