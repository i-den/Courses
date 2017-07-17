using System;
using System.Collections.Generic;
using System.Linq;
using System.Text.RegularExpressions;

class Program
{
    static void Main()
    {
        var validSingers = GetInput();
        var validSongs = GetInput();

        var singers = new List<Singer>();

        while (true)
        {
            var input = GetInput();

            if (input.First() == "dawn")
            {
                break;
            }

            var name = input[0];
            var song = input[1];
            var award = input[2];

            if (!(validSingers.Contains(name) && validSongs.Contains(song)))
            {
                continue;
            }

            var currSinger = new Singer
            {
                Name = name,
                Songs = new List<string>
                {
                    song
                },
                Awards = new HashSet<string>
                {
                    award
                },
            };

            if (!singers.Any(singer => singer.Name == currSinger.Name))
            {
                singers.Add(currSinger);
            }
            else
            {
                currSinger = singers.First(singer => singer.Name == name);
                currSinger.Songs.Add(song);
                currSinger.Awards.Add(award);
            }
        }

        if (!singers.Any())
        {
            Console.WriteLine("No awards");
            return;
        }

        foreach (var currSinger in singers
            .OrderByDescending(singer => singer.AwardsCount)
            .ThenBy(singer => singer.Name))
        {
            currSinger.PrintStats();
            currSinger.PrintAwards();
        }
    }

    public static string[] GetInput()
    {
        return Regex.Split(Console.ReadLine(), @"\,\s")
            .ToArray();
    }
}

internal class Singer
{
    public string Name { get; set; }

    public List<string> Songs { get; set; }

    public HashSet<string> Awards { get; set; }

    public int AwardsCount => this.Awards.Count();

    public void PrintStats()
    {
        Console.WriteLine($"{this.Name}: {this.AwardsCount} awards");
    }

    public void PrintAwards()
    {
        foreach (var currAward in Awards
            .OrderBy(award => award))
        {
            Console.WriteLine($"--{currAward}");
        }
    }
}