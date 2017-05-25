using System;

public class Program
{
    public static void Main()
    {
        var roundHouseKickDamage = int.Parse(Console.ReadLine());
        var thunderousFistDamage = int.Parse(Console.ReadLine());

        var peshoHealth = 100;
        var goshoHealth = 100;
        var roundNumber = 1;
        var canContinue = true;
        
        while (canContinue)
        {
            if (roundNumber % 2 != 0)
            {
                CalculateDamageAndHealth(roundHouseKickDamage, ref goshoHealth, roundNumber, ref canContinue, "Pesho", "Roundhouse kick", "Gosho");
            }
            else
            {
                CalculateDamageAndHealth(thunderousFistDamage, ref peshoHealth, roundNumber, ref canContinue, "Gosho", "Thunderous fist", "Pesho");
            }

            if (roundNumber % 3 == 0)
            {
                goshoHealth += 10;
                peshoHealth += 10;
            }
            
            roundNumber++;
        }
    }

    public static void CalculateDamageAndHealth(int skillDamage, ref int currentOpponentHealth, int roundNumber, ref bool canContinue, string name, string skill, string opponent)
    {
        var currentPlayerName = name;
        var currentPlayerSkill = skill;
        var currentOpponentName = opponent;

        currentOpponentHealth -= skillDamage;

        if (currentOpponentHealth <= 0)
        {
            Console.WriteLine($"{currentPlayerName} won in {roundNumber}th round.");
            canContinue = false;
        }
        else
        {
            Console.WriteLine($"{currentPlayerName} used {currentPlayerSkill} and reduced {currentOpponentName} to {currentOpponentHealth} health.");
        }
    }
}