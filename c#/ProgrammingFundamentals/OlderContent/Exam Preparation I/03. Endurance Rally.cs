using System;
using System.Linq;

public class Program
{
    public static void Main()
    {
        var rallyParticipants = Console.ReadLine().Split().ToArray();
        var trackLayoutZones = GetRallyLayoutAndCheckpoints();
        var checkpoints = GetRallyLayoutAndCheckpoints();

        foreach (var participant in rallyParticipants)
        {
            var currentFuel = (double)(participant.First());

            for (int i = 0; i < trackLayoutZones.Length; i++)
            {
                var currentZone = trackLayoutZones[i];

                if (checkpoints.Contains(i))
                {
                    currentFuel += currentZone;
                }
                else
                {
                    currentFuel -= currentZone;

                    if (currentFuel <= 0)
                    {
                        Console.WriteLine($"{participant} - reached {i}");
                        break;
                    }
                }
            }

            if (currentFuel > 0)
            {
                Console.WriteLine($"{participant} - fuel left {currentFuel:F2}");
            }
        }
    }

    public static double[] GetRallyLayoutAndCheckpoints()
    {

        return Console.ReadLine()
            .Split()
            .Select(double.Parse)
            .ToArray();
    }
}