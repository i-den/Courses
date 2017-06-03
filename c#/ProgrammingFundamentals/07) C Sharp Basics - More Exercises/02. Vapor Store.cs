using System;
using System.Collections.Generic;

public class Program
{
    public static void Main()
    {
        var totalBalance = double.Parse(Console.ReadLine());
        var hasMoney = true;
        var gamesBought = new List<string>();
        var totalSpent = totalBalance;

        while (hasMoney)
        {
            var currentGame = Console.ReadLine();

            if (currentGame == "Game Time")
            {
                hasMoney = false;
                break;
            }

            var currentPrice = 0D;

            switch (currentGame)
            {
                case "OutFall 4":
                    currentPrice += 39.99;
                    currentGame = "Bought " + currentGame;
                    break;
                case "CS: OG":
                    currentPrice += 15.99;
                    currentGame = "Bought " + currentGame;
                    break;
                case "Zplinter Zell":
                    currentPrice += 19.99;
                    currentGame = "Bought " + currentGame;
                    break;
                case "Honored 2":
                    currentPrice += 59.99;
                    currentGame = "Bought " + currentGame;
                    break;
                case "RoverWatch":
                    currentPrice += 29.99;
                    currentGame = "Bought " + currentGame;
                    break;
                case "RoverWatch Origins Edition":
                    currentPrice += 39.99;
                    currentGame = "Bought " + currentGame;
                    break;
                default:
                    currentGame = "Not Found"; break;
            }

            totalBalance -= currentPrice;

            if (totalBalance == 0)
            {
                gamesBought.Add("Bought " + currentGame);
                gamesBought.Add("Out of money!");
                hasMoney = false;
                break;
            }
            else if (totalBalance < 0)
            {
                totalBalance += currentPrice;
                currentGame = "Too Expensive";
            }

            gamesBought.Add(currentGame);
        }

        foreach (var game in gamesBought)
        {
            Console.WriteLine($"{game}");
        }

        if (totalBalance > 0)
        {
            totalSpent -= totalBalance;
            Console.WriteLine($"Total spent: ${totalSpent:F2}. Remaining: ${totalBalance:F2}");
        }
    }
}