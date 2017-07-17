using System;
using System.Collections.Generic;
using System.Linq;

public class Program
{
    public static void Main()
    {
        var drags = new Dictionary<string, Dictionary<string, int[]>>();
        var n = int.Parse(Console.ReadLine());

        for (int i = 0; i < n; i++)
        {
            var currInput = Console.ReadLine().Split();
            var type = currInput[0];
            var name = currInput[1];
            var dmg = currInput[2] == "null" ? 45 : int.Parse(currInput[2]);
            var hp = currInput[3]  == "null" ? 250 : int.Parse(currInput[3]);
            var arm = currInput[4]  == "null" ? 10 : int.Parse(currInput[4]);

            if (!drags.ContainsKey(type))
            {
                drags[type] = new Dictionary<string, int[]>();
            }

            if (!drags[type].ContainsKey(name))
            {
                drags[type][name] = new int[3];
            }

            drags[type][name][0] = dmg;
            drags[type][name][1] = hp;
            drags[type][name][2] = arm;
        }

        foreach (var kvp in drags)
        {
            var currDragType = kvp.Key;
            var avgDmg = kvp.Value.Values.Average(x => x[0]);
            var avgHp = kvp.Value.Values.Average(x => x[1]);
            var avgArm = kvp.Value.Values.Average(x => x[2]);

            Console.WriteLine($"{currDragType}::({avgDmg:F2}/{avgHp:F2}/{avgArm:F2})");

            foreach (var item in kvp.Value.OrderBy(x => x.Key))
            {
                var currDragName = item.Key;
                var dmg = item.Value[0];
                var hp = item.Value[1];
                var arm = item.Value[2];
                Console.WriteLine($"-{currDragName} -> damage: {dmg}, health: {hp}, armor: {arm}");
            }
        }
    }
}