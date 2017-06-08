using System;
using System.Collections.Generic;
using System.Linq;

public class Program
{
    public static void Main()
    {
        var participants = GetParticipantsAndSongs();
        var validSongs = GetParticipantsAndSongs();

        var participantAwardsList = new Dictionary<string, HashSet<string>>();

        while (true)
        {
            var stagePerformances = Console.ReadLine().Split(',');

            if (stagePerformances[0] == "dawn")
            {
                break;
            }

            var currentParticipant = stagePerformances[0];
            var currentSong = stagePerformances[1].Trim();
            var currentAward = stagePerformances[2].Trim();

            if (participants.Contains(currentParticipant) && validSongs.Contains(currentSong))
            {
                if (!participantAwardsList.ContainsKey(currentParticipant))
                {
                    participantAwardsList[currentParticipant] = new HashSet<string>();
                }

                participantAwardsList[currentParticipant].Add(currentAward);
            }
        }

        if (!participantAwardsList.Any())
        {
            Console.WriteLine("No awards");
            return;
        }

        foreach (var participantAwardsInfoPair in participantAwardsList.OrderByDescending(a => a.Value.Count))
        {
            var currentParticipant = participantAwardsInfoPair.Key;
            var currentParticipantAwardsInfo = participantAwardsInfoPair.Value;

            Console.WriteLine($"{currentParticipant}: {currentParticipantAwardsInfo.Count} awards");
            
            foreach (var currentParticipantAward in currentParticipantAwardsInfo.OrderBy(a => a))
            {
                Console.WriteLine($"--{currentParticipantAward}");
            }
        }
    }

    public static List<string> GetParticipantsAndSongs()
    {
        return Console.ReadLine()
            .Split(',')
            .Select(p => p.Trim())
            .Distinct()
            .ToList();
    }
}