using System;

class Program
{
    public static void Main()
    {
        var days = GetInt();
        var runnersCount = GetInt();
        var laps = Geusing System;
using System.Linq;

class Program
{
    public static void Main()
    {
        var bugField = new int[int.Parse(Console.ReadLine())];
        var bugPositions = Console.ReadLine()
            .Split()
            .Select(int.Parse)
            .ToArray();

        foreach (var bugPosition in bugPositions)
        {
            if (bugPosition < bugField.Length && bugPosition >= 0)
            {
                bugField[bugPosition] = 1;
            }
        }

        while (true)
        {
            var bugInfo = Console.ReadLine()
                .Split()
                .ToArray();

            if (bugInfo.First() == "end")
            {
                break;
            }

            var currentBugPosition = int.Parse(bugInfo.First());
            var directionToMove = bugInfo.Skip(1).First();
            var amountToMove = int.Parse(bugInfo.Skip(2).First());

            if (currentBugPosition < bugField.Length && currentBugPosition >= 0 && bugField[currentBugPosition] != 0)
            {
                bugField[currentBugPosition] = 0;
                var positionToMoveTo = directionToMove == "right"
                    ? currentBugPosition + amountToMove
                    : currentBugPosition - amountToMove;

                if (positionToMoveTo < bugField.Length && positionToMoveTo >= 0)
                {
                    while (bugField[positionToMoveTo] == 1)
                    {
                        positionToMoveTo += directionToMove == "right"
                            ? amountToMove
                            : -amountToMove;

                        if (!(positionToMoveTo < bugField.Length && positionToMoveTo >= 0))
                        {
                            break;
                        }
                    }
                }

                if (positionToMoveTo < bugField.Length && positionToMoveTo >= 0)
                {
                    bugField[positionToMoveTo] = 1;
                }
            }
        }

        Console.WriteLine(string.Join(" ", bugField));
    }
}tInt();
        var lapLength = GetInt();
        var trackCapacity = GetInt();
        var moneyPerKm = decimal.Parse(Console.ReadLine());

        var maxRunners = (long)trackCapacity * days;
        var runnersThatWillRun = maxRunners >= runnersCount
            ? runnersCount
            : maxRunners;

        var totalMetersRan = runnersThatWillRun * laps * lapLength;
        var totalKilometersRan = totalMetersRan / 1000;
        var moneyRaised = totalKilometersRan * moneyPerKm;

        Console.WriteLine($"Money raised: {moneyRaised:F2}");
    }

    public static int GetInt()
    {
        return int.Parse(Console.ReadLine());
    }
}