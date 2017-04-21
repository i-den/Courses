using System;

namespace _06.Bonus_Score
{
    class Program
    {
        static void Main()
        {

            var pts = double.Parse(Console.ReadLine());
            var bonuspts = 0.0;
            if (pts <= 100)
                bonuspts += 5;

            if (pts > 100 && pts <= 1000)
                bonuspts += pts * 0.2;

            if (pts > 1000)
                bonuspts += pts * 0.1;

            if (pts % 2 == 0)
                bonuspts += 1;

            if (pts % 10 == 5)
                bonuspts += 2;

            Console.WriteLine("Bonus score: " + bonuspts);
            Console.WriteLine("Total score: " + (bonuspts + pts));
        }
    }
}
