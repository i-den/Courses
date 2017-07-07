using System;

class Program
{
    public static void Main()
    {
        double amount = double.Parse(Console.ReadLine());
        string from = Console.ReadLine();
        string to = Console.ReadLine();

        var BGN = 1.0;
        var USD = 1.79549;
        var EUR = 1.95583;
        var GBP = 2.53405;

        if (from == "BGN")
        {
            if (to == "USD")
                Console.WriteLine(Math.Round((amount * (BGN / USD)), 2) + " " + to);

            if (to == "EUR")
                Console.WriteLine(Math.Round((amount * (BGN / EUR)), 2) + " " + to);

            if (to == "GBP")
                Console.WriteLine(Math.Round((amount * (BGN / GBP)), 2) + " " + to);
        }

        if (from == "USD")
        {
            if (to == "BGN")
                Console.WriteLine(Math.Round((amount * (USD / BGN)), 2) + " " + to);

            if (to == "EUR")
                Console.WriteLine(Math.Round((amount * (USD / EUR)), 2) + " " + to);

            if (to == "GBP")
                Console.WriteLine(Math.Round((amount * (USD / GBP)), 2) + " " + to);

        }

        if (from == "EUR")
        {
            if (to == "USD")

                Console.WriteLine(Math.Round((amount * (EUR / USD)), 2) + " " + to);

            if (to == "BGN")
                Console.WriteLine(Math.Round((amount * (EUR / BGN)), 2) + " " + to);

            if (to == "GBP")
                Console.WriteLine(Math.Round((amount * (EUR / GBP)), 2) + " " + to);
        }
        if (from == "GBP")
        {
            if (to == "USD")
                Console.WriteLine(Math.Round((amount * (GBP / USD)), 2) + " " + to);

            if (to == "EUR")
                Console.WriteLine(Math.Round((amount * (GBP / EUR)), 2) + " " + to);

            if (to == "BGN")
                Console.WriteLine(Math.Round((amount * (GBP / BGN)), 2) + " " + to);

        }
    }
}