using System;

public class Program
{
    public static void Main()
    {
        var firstBoat = char.Parse(Console.ReadLine());
        var secondBoat = char.Parse(Console.ReadLine());
        var stringsCount = int.Parse(Console.ReadLine());

        var firstBoatMoves = 0;
        var secondBoatMoves = 0;
        var currentIteration = 1;
        var canContinue = true;

        while (currentIteration <= stringsCount && canContinue)
        {
            var currentInput = Console.ReadLine();
            var currentMovesToAdvance = currentInput.Length;

            if (currentInput == "UPGRADE")
            {
                firstBoat = (char)(firstBoat + 3);
                secondBoat = (char)(secondBoat + 3);
            }
            else if (currentIteration % 2 != 0)
            {
                CalculateBoatAdvance(firstBoat, ref firstBoatMoves, currentMovesToAdvance, ref canContinue);
            }
            else
            {
                CalculateBoatAdvance(secondBoat, ref secondBoatMoves, currentMovesToAdvance, ref canContinue);
            }

            currentIteration++;
        }

        if (canContinue)
        {
            Console.WriteLine(firstBoatMoves > secondBoatMoves ? firstBoat : secondBoat);
        }
    }

    public static void CalculateBoatAdvance(char currentBoat, ref int currentBoatMoves, int currentMovesToAdvance, ref bool canContinue)
    {
        currentBoatMoves += currentMovesToAdvance;

        if (currentBoatMoves >= 50)
        {
            Console.WriteLine(currentBoat);
            canContinue = false;
        }
    }
}