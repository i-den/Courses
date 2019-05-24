using System;
using System.Collections.Generic;
using System.Linq;
using System.Text.RegularExpressions;

public class Program
{
    public static void Main()
    {
        var emailsCount = int.Parse(Console.ReadLine());

        var emails = new Dictionary<string, HashSet<string>>();
        var validEmailPattern = @"\b(?<user>[a-zA-Z]{5,})@(?<domain>[a-z]{3,}\.(com|bg|org))\b";

        for (int i = 0; i < emailsCount; i++)
        {
            var currInput = Console.ReadLine();

            if (Regex.IsMatch(currInput, validEmailPattern))
            {
                var match = Regex.Match(currInput, validEmailPattern);
                var user = match.Groups["user"].Value;
                var domain = match.Groups["domain"].Value;

                if (!emails.ContainsKey(domain))
                {
                    emails[domain] = new HashSet<string>();
                }

                emails[domain].Add(user);
            }
        }

        foreach (var item in emails
            .OrderByDescending(m => m.Value.Count()))
        {
            var currDomain = item.Key;
            var currEmails = item.Value;

            Console.WriteLine($"{currDomain}:");

            foreach (var currEmail in currEmails)
            {
                Console.WriteLine($"### {currEmail}");
            }
        }
    }
}