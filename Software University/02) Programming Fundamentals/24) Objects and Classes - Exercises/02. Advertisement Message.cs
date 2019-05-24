using System;

class Program
{
    static void Main()
    {
        var phrases = new[]
        {
            "Excellent product.",
            "Such a great product.",
            "I always use that product.",
            "Best product of its category.",
            "Exceptional product.",
            "I can’t live without this product."
        };

        var events = new[]
        {
           "Now I feel good.",
                "I have succeeded with this product.",
                "Makes miracles. I am happy of the results!",
                "I cannot believe but now I feel awesome.",
                "Try it yourself, I am very satisfied.",
                "I feel great!"
        };

        var authors = new[]
        {
            "Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva"
        };

        var cities = new[] { "Burgas", "Sofia", "Plovdiv", "Varna", "Ruse" };

        var msgCount = int.Parse(Console.ReadLine());
        var rnd = new Random();

        for (int i = 0; i < msgCount; i++)
        {
            var rndPhrase = rnd.Next(0, phrases.Length);
            var rndEvent = rnd.Next(0, events.Length);
            var rndAuth = rnd.Next(0, authors.Length);
            var rndCity = rnd.Next(0, cities.Length);

            Console.WriteLine($"{phrases[rndPhrase]} {events[rndEvent]} {authors[rndAuth]} – {cities[rndCity]}.");
        }
    }
}