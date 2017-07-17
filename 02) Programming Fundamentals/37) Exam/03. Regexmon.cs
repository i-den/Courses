namespace Problems
{
    using System;
    using System.Collections.Generic;
    using System.Linq;
    using System.Text;
    using System.Text.RegularExpressions;

    public class ProblemC
    {
        public static void Main()
        {
            var input = Console.ReadLine();
            var didi = @"[^a-zA-Z\-]*";
            var bojo = @"([a-zA-Z]+)-([a-zA-Z]+)";
            var currSwitch = 2;
            var lastMatch = true;

            while (input.Length != 0)
            {
                var currPattern = currSwitch % 2 == 0 ? didi : bojo;

                var matches = Regex.Matches(input, currPattern)
                    .Cast<Match>()
                    .Where(m => m.Value != string.Empty)
                    .ToArray();

                if (!matches.Any())
                {
                    return;
                }

                var currMatch = matches.First().Value;
                Console.WriteLine(currMatch);
                var currIndex = input.IndexOf(currMatch);
                var lastIndex = currIndex + currMatch.Length;
                input = input.Remove(0, lastIndex);
                currSwitch++;
            }
        }
    }
}