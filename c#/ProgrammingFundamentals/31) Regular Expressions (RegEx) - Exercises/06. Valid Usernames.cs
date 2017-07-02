using System;
using System.Linq;
using System.Text.RegularExpressions;

class Program
{
    static void Main()
    {
        var validUsernamesPattern = @"\b[a-zA-Z][a-zA-Z0-9_]{2,25}\b";
        var longestFirst = string.Empty;
        var longestSecond = string.Empty;
        var longestLength = int.MinValue;

        var inputUsernames = Console.ReadLine()
            .Split(new[] { ' ', '/', '\\', '(', ')' })
            .Where(t => Regex.IsMatch(t, validUsernamesPattern))
            .ToArray();

        for (int i = 0; i < inputUsernames.Length - 1; i++)
        {
            var firstUser = inputUsernames[i];
            var secondUser = inputUsernames[i + 1];
            var usernameLength = firstUser.Length + secondUser.Length;

            if (longestLength < usernameLength)
            {
                longestFirst = firstUser;
                longestSecond = secondUser;
                longestLength = usernameLength;
            }
        }

        Console.WriteLine(longestFirst);
        Console.WriteLine(longestSecond);
    }
}