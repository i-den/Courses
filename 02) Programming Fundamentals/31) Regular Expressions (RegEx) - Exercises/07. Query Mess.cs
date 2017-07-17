using System;
using System.Collections.Generic;
using System.Text.RegularExpressions;

class Program
{
    static void Main()
    {
        var nullRegex = @"((%20|\+)+)";

        while (true)
        {
            var input = Console.ReadLine();

            if (input == "END")
            {
                break;
            }

            var queries = new Dictionary<string, List<string>>();
            var pairsPattern = @"([^&=?]*)=([^&=]*)";
            var matches = Regex.Matches(input, pairsPattern);

            for (int i = 0; i < matches.Count; i++)
            {
                var currType = matches[i].Groups[1].Value;
                currType = Regex.Replace(currType, nullRegex, w => " ").Trim();

                var currValue = matches[i].Groups[2].Value;
                currValue = Regex.Replace(currValue, nullRegex, w => " ").Trim();

                if (!queries.ContainsKey(currType))
                {
                    queries[currType] = new List<string>();
                }

                queries[currType].Add(currValue);
            }

            foreach (var pair in queries)
            {
                var currType = pair.Key;
                var currValue = string.Join(", ", pair.Value);

                Console.Write($"{currType}=[{currValue}]");
            }
            
            Console.WriteLine();
        }
    }
}