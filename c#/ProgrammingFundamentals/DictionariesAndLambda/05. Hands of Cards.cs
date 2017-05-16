using System;
using System.Collections.Generic;
using System.Linq;

public class Program
{
    public static void Main()
    {
        bool canContinue = true;

        var playerScoresList = new Dictionary<string, int>();
        var playerCardsDrawn = new Dictionary<string, string>();

        while (canContinue)
        {
            var input = Console.ReadLine().Split(':');

            var name = input[0];

            if (name == "JOKER")
            {
                canContinue = false;
                break;
            }

            var currentCardsDrawn = input[1];

            if (!playerCardsDrawn.ContainsKey(name))
            {
                playerCardsDrawn[name] = string.Empty;
            }

            playerCardsDrawn[name] += currentCardsDrawn;
        }

        foreach (var playerCardsPair in playerCardsDrawn)
        {
            var currentPlayerName = playerCardsPair.Key;
            var currentPlayerAllCardsDrawnRaw = playerCardsPair.Value;
            var currentPlayerTotalScore = 0;

            var separators = new char[] { ',', ' ' };
            var currentPlayerAllCardsDrawn = currentPlayerAllCardsDrawnRaw.Split(separators, StringSplitOptions.RemoveEmptyEntries).Distinct().ToList();

            foreach (var card in currentPlayerAllCardsDrawn)
            {
                currentPlayerTotalScore += GetHandScore(card);
            }

            playerScoresList[currentPlayerName] = currentPlayerTotalScore;
        }

        foreach (var playerTotalScorePair in playerScoresList)
        {
            var currentPlayerName = playerTotalScorePair.Key;
            var currentPlayerTotalScore = playerTotalScorePair.Value;

            Console.WriteLine($"{currentPlayerName}: {currentPlayerTotalScore}");
        }
    }

    private static int GetHandScore(string card)
    {
        string power = card[0].ToString();
        string type = card[card.Length - 1].ToString();

        if (power == "1")
        {
            power = "10";
        }

        int powerAsNumber = 0;
        int typeAsNumber = 0;
        bool numberPower = int.TryParse(power, out powerAsNumber);

        if (!numberPower)
        {
            switch (power)
            {
                case "J":
                    powerAsNumber = 11;
                    break;
                case "Q":
                    powerAsNumber = 12;
                    break;
                case "K":
                    powerAsNumber = 13;
                    break;
                case "A":
                    powerAsNumber = 14;
                    break;
            }
        }

        switch (type)
        {
            case "S":
                typeAsNumber = 4; break;
            case "H":
                typeAsNumber = 3; break;
            case "D":
                typeAsNumber = 2; break;
            case "C":
                typeAsNumber = 1; break;
        }

        int cardPoints = powerAsNumber * typeAsNumber;
        return cardPoints;
    }
}