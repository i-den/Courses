using System;

public class Program
{
    public static void Main()
    {
        var numberOfChars = int.Parse(Console.ReadLine());
        var resultMessage = string.Empty;

        for (int i = 0; i < numberOfChars; i++)
        {
            var currentMessageNumber = Console.ReadLine();

            var currentMessage = GetCurrentMessage(currentMessageNumber);

            resultMessage += currentMessage;
        }

        Console.WriteLine(resultMessage);
    }

    public static char GetCurrentMessage(string currentMessageNumber)
    {
        var mainDigit = int.Parse(currentMessageNumber[0].ToString());
        var numberOfDigits = currentMessageNumber.Length;

        if (currentMessageNumber == "0")
        {
            return ' ';
        }

        var offset = (mainDigit - 2) * 3;

        if (mainDigit == 8 || mainDigit == 9)
        {
            offset++;
        }

        var letterIndex = offset + numberOfDigits - 1;

        return (char)(letterIndex + 97);
    }
}