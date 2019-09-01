using System;
using System.Linq;

class Program
{
    static void Main()
    {
        var racers = Console.ReadLine().Split();

        var track = GetInput();
        var checkpoints = GetInput();

        foreach (var currRacer in racers)
        {
            var currFuel = (double)currRacer.First();
            var index = 0;

            for (int i = 0; i < track.Length; i++)
            {
                if (checkpoints.Contains(i))
                {
                    currFuel += track[i];
                }
                else
                {
                    currFuel -= track[i];
                }

                if (currFuel <= 0)
                {
                    index = i;
                    break;
                }
            }

            if (currFuel > 0)
            {
                Console.WriteLine($"{currRacer} - fuel left {currFuel:F2}");
            }
            else
            {
                Console.WriteLine($"{currRacer} - reached {index}");
            }
        }
    }

    public static double[] GetInput()
    {
        return Console.ReadLine()
            .Split()
            .Select(double.Parse)
            .ToArray();
    }
}