using System;
using System.Collections.Generic;
using System.Linq;
using System.Text.RegularExpressions;

class Program
{
    public static void Main()
    {
        var events = new List<Event>();

        while (true)
        {
            var input = Console.ReadLine();

            if (input == "Time for Code")
            {
                break;
            }

            if (!Regex.IsMatch(input, @"(\d+)\s(\#[^\s]*)"))
            {
                continue;
            }

            var idNumber = int.Parse(Regex.Match(input, @"^\d+").Value);

            var name = Regex.Match(input, @"(?<=\#)[^\s]*").Value;

            var participants = Regex.Matches(input, @"(?<=\s@)[a-zA-Z0-9\'\-]*")
                .Cast<Match>()
                .Select(m => m.Value)
                .ToList();

            var currEvent = new Event
            {
                Name = name,
                IdNumber = idNumber,
                Participants = participants
            };

            if (events.Any(e => e.IdNumber == idNumber))
            {
                if (events.First(e => e.IdNumber == idNumber).Name == name)
                {
                    currEvent = events.First(e => e.IdNumber == idNumber);

                    currEvent.Participants.AddRange(participants);
                }
                else
                {
                    continue;
                }
            }
            else
            {
                events.Add(currEvent);
            }
        }

        foreach (var currEvent in events
            .OrderByDescending(e => e.Participants.Count)
            .ThenBy(e => e.Name))
        {
            currEvent.Print();
        }
    }
} 

internal class Event
{
    public string Name { get; set; }

    public int IdNumber { get; set; }

    public List<string> Participants { get; set; }

    public void Print()
    {
        Console.WriteLine($"{this.Name} - {this.Participants.Distinct().Count()}");

        foreach (var participant in Participants
            .Distinct()
            .OrderBy(p => p))
        {
            Console.WriteLine($"@{participant}");
        }
    }
}