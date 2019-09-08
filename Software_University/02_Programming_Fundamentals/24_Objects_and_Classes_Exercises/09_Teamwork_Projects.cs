using System;
using System.Collections.Generic;
using System.Linq;

namespace Teams
{
    class Program
    {
        static void Main()
        {
            var teamsCount = int.Parse(Console.ReadLine());
            var teams = new List<Team>();

            for (int i = 0; i < teamsCount; i++)
            {
                var input = Console.ReadLine().Split('-');
                var founder = input[0];
                var teamName = input[1];

                if (teams.Any(t => t.TeamName == teamName))
                {
                    Console.WriteLine($"Team {teamName} was already created!");
                    continue;
                }

                if (teams.Any(t => t.Founder == founder))
                {
                    Console.WriteLine($"{founder} cannot create another team!");
                    continue;
                }

                var currNewTeam = new Team
                {
                    Founder = founder,
                    TeamName = teamName,
                    Members = new List<string>()
                };

                teams.Add(currNewTeam);
                Console.WriteLine($"Team {teamName} has been created by {founder}!");
            }

            while (true)
            {
                var input = Console.ReadLine();

                if (input == "end of assignment")
                {
                    break;
                }

                var currName = input.Split('-').First();
                var currTeamToJoin = input.Split('>').Skip(1).First();

                if (!teams.Any(t => t.TeamName == currTeamToJoin))
                {
                    Console.WriteLine($"Team {currTeamToJoin} does not exist!");
                    continue;
                }

                if (teams.Any(c => c.Members.Contains(currName)) || teams.Any(f => f.Founder == currName))
                {
                    Console.WriteLine($"Member {currName} cannot join team {currTeamToJoin}");
                    continue;
                }

                var currTeamToAdd = teams.First(t => t.TeamName == currTeamToJoin);
                currTeamToAdd.Members.Add(currName);
            }

            foreach (var team in teams.Where(t => t.Members.Any()).OrderBy(t => t.TeamName))
            {
                Console.WriteLine($"{team.TeamName}");
                team.printFounder();
                team.PrintMembers();
            }

            if (teams.Any(t => t.Members.Count == 0))
            {
                Console.WriteLine("Teams to disband:");

                foreach (var team in teams.Where(t => t.Members.Count == 0))
                {
                    Console.WriteLine($"{team.TeamName}");
                }
            }
        }
    }

    class Team
    {
        public string Founder { get; set; }

        public string TeamName { get; set; }

        public List<string> Members { get; set; }

        public void printFounder()
        {
            Console.WriteLine($"- {Founder}");
        }

        public void PrintMembers()
        {
            foreach (var member in Members)
            {
                Console.WriteLine($"-- {member}");
            }
        }
    }
}