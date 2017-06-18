using System;
using System.Collections.Generic;
using System.Linq;

public class Program
{
    public static void Main()
    {
        var playerCards = new Dictionary<string, HashSet<string>>();
        var playerScore = new Dictionary<string, long>();
        var test = new HashSet<string>();

        while (true)
        {
            var input = Console.ReadLine();

            if (input == "JOKER")
            {
                break;
            }

            var currUser = input.Split(':')[0];
            var currHand = input.Split(':')[1].Split(new[] { ' ', ',' , }, StringSplitOptions.RemoveEmptyEntries);

            if (!playerCards.ContainsKey(currUser))
            {
                playerCards[currUser] = new HashSet<string>();
            }

            foreach (var handCard in currHand)
            {
                playerCards[currUser].Add(handCard);
            }
        }

        foreach (var playerInfo in playerCards)
        {
            var currPlayer = playerInfo.Key;
            var currPlayerAllCards = playerInfo.Value;
            var totalPlayerScore = 0L;

            foreach (var currCard in currPlayerAllCards)
            {
                totalPlayerScore += GetCurrentCardScore(currCard);
            }

            if (!playerScore.ContainsKey(currPlayer))
            {
                playerScore[currPlayer] = 0L;
            }

            playerScore[currPlayer] += totalPlayerScore;
        }

        foreach (var kvp in playerScore)
        {
            var currPlayer = kvp.Key;
            var currPlayerScore = kvp.Value;

            Console.WriteLine($"{currPlayer}: {currPlayerScore}");
        }
    }

    public static long GetCurrentCardScore(string currCard)
    {
        var numToReturn = 0L;
        var cardPower = 0L;
        var cardType = 0;

        var cardPowerStr = currCard.First();
        var cardTypeStr = currCard.Last();

        try
        {
            cardPower = long.Parse(cardPowerStr.ToString());
            cardPower = cardPower == 1 ? 10 : cardPower;
        }
        catch (Exception)
        {
            switch (cardPowerStr)
            {
                case 'J':
                    cardPower = 11;
                    break;
                case 'Q':
                    cardPower = 12;
                    break;
                case 'K':
                    cardPower = 13;
                    break;
                case 'A':
                    cardPower = 14;
                    break;
            }
        }

        switch (cardTypeStr)
        {
            case 'S':
                cardType = 4;
                break;
            case 'H':
                cardType = 3;
                break;
            case 'D':
                cardType = 2;
                break;
            case 'C':
                cardType = 1;
                break;
        }

        numToReturn = cardPower * cardType;
        return numToReturn;
    }
}