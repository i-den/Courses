namespace Problems
{
    using System;
    using System.Collections.Generic;
    using System.Linq;
    using System.Text;
    using System.Text.RegularExpressions;

    public class ProblemD
    {
        public static void Main()
        {
            var pokemons = new List<Pokemon>();

            while (true)
            {
                var input = Console.ReadLine().Split();


                if (input.First() == "wubbalubbadubdub")
                {
                    break;
                }

                if (input.Length == 1)
                {
                    var currPokemon = pokemons.FirstOrDefault(p => p.Name == input.First());

                    if (currPokemon != null)
                    {
                        currPokemon.PrintEvo();
                    }
                }
                else
                {
                    var name = input[0];
                    var evolutionName = input[2];
                    var evolutionIndex = int.Parse(input[4]);

                    var currPokemon = pokemons.FirstOrDefault(p => p.Name == name);

                    if (currPokemon != null)
                    {
                        if (!currPokemon.EvolutionType.ContainsKey(evolutionName))
                        {
                            currPokemon.EvolutionType[evolutionName] = new List<int>();
                        }

                        currPokemon.EvolutionType[evolutionName].Add(evolutionIndex);

                        var currString = evolutionName + " <-> " + evolutionIndex;
                        currPokemon.MyStrings.Add(currString);
                    }
                    else
                    {
                        currPokemon = new Pokemon
                        {
                            Name = name,
                            EvolutionType = new Dictionary<string, List<int>>
                            {
                                { evolutionName, new List<int>() }
                            },
                            MyStrings = new List<string>()
                        };

                        currPokemon.EvolutionType[evolutionName].Add(evolutionIndex);

                        var currString = evolutionName + " <-> " + evolutionIndex;
                        currPokemon.MyStrings.Add(currString);

                        pokemons.Add(currPokemon);
                    }
                }
            }

            foreach (var currPokemon in pokemons)
            {
                currPokemon.PrintFinal();
            }
        }
    }

    class Pokemon
    {
        public string Name { get; set; }

        public Dictionary<string, List<int>> EvolutionType { get; set; }

        public List<string> MyStrings { get; set; }

        public void PrintEvo()
        {
            Console.WriteLine($"# {this.Name}");

            foreach (var str in MyStrings)
            {
                Console.WriteLine(str);
            }
        }

        public void PrintFinal()
        {
            Console.WriteLine($"# {this.Name}");

            foreach (var currEvo in this.EvolutionType
                .OrderByDescending(p => p.Value.Max())
                .ThenBy(p => p.Value.Sum()))
            {
                var currEvoType = currEvo.Key;
                var currEvoIndexes = currEvo.Value;

                foreach (var currIndex in currEvoIndexes.OrderByDescending(p => p))
                {
                    Console.WriteLine($"{currEvoType} <-> {currIndex}");
                }
            }
        }
    }
}