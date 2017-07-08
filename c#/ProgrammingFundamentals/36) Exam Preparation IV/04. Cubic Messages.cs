using System;
using System.Collections.Generic;
using System.Linq;
using System.Text.RegularExpressions;

public class Program
{
    public static void Main()
    {
        var pattern = @"^(?<leftPart>\d+)(?<message>[a-zA-Z]+)(?<rightPart>[^a-zA-Z]*)$";

        var messageRegex = new Regex(pattern);

        while (true)
        {
            var line = Console.ReadLine();

            if (line == "Over!")
            {
                break;
            }

            var messageMatch = messageRegex.Match(line);

            if (!messageMatch.Success)
            {
                continue;
            }

            var leftPart = messageMatch.Groups["leftPart"].Value;
            var rightPart = messageMatch.Groups["rightPart"].Value;
            var message = messageMatch.Groups["message"].Value;

            var messageLength = int.Parse(Console.ReadLine());

            if (messageLength != message.Length)
            {
                continue;
            }

            var verificationCode = new string((leftPart + rightPart)
                .Where(char.IsDigit)
                .Select(a => int.Parse(a.ToString()))
                .Select(i => i >= 0 && i < message.Length ? message[i] : ' ')
                .ToArray());

            Console.WriteLine($"{message} == {verificationCode}");
        }
    }
}