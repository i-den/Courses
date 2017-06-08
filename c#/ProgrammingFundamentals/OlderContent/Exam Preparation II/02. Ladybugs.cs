using System;
using System.Linq;

public class Program
{
    public static void Main()
    {
        var bugsField = new int[int.Parse(Console.ReadLine())];
        var ladybugPositions = Console.ReadLine().Split().Select(int.Parse).ToList();

        foreach (var currentBugPosition in ladybugPositions)
        {
            if (currentBugPosition < bugsField.Length && currentBugPosition >= 0)
            {
                bugsField[currentBugPosition] = 1;
            }
        }

        while (true)
        {
            var currentInput = Console.ReadLine().Split();

            if (currentInput[0] == "end")
            {
                break;
            }

            var currentLadybugIndex = long.Parse(currentInput[0]);
            var directionToMove = currentInput[1];
            var amountToMove = long.Parse(currentInput[2]);

            if (currentLadybugIndex < bugsField.Length && currentLadybugIndex >= 0 && bugsField[currentLadybugIndex] != 0)
            {
                var indexToMoveTo = directionToMove == "right" ?
                    currentLadybugIndex + amountToMove : currentLadybugIndex - amountToMove;

                bugsField[currentLadybugIndex] = 0;

                if (indexToMoveTo < bugsField.Length && indexToMoveTo >= 0)
                {
                    while (bugsField[indexToMoveTo] == 1)
                    {
                        indexToMoveTo += (directionToMove == "right") ? amountToMove : -amountToMove;

                        if (!(indexToMoveTo < bugsField.Length && indexToMoveTo >= 0))
                        {
                            break;
                        }
                    }
                }

                if (!(indexToMoveTo < bugsField.Length && indexToMoveTo >= 0))
                {
                    continue;
                }

                bugsField[indexToMoveTo] = 1;
            }
        }

        Console.WriteLine(string.Join(" ", bugsField));
    }
}