using System;

public class Program
{
    public static void Main()
    {
        var typeOfDay = Console.ReadLine();
        var clientAge = int.Parse(Console.ReadLine());
        var ticketPrice = 0;

        if (clientAge < 0 || clientAge > 122)
        {
            Console.WriteLine("Error!");
            return;
        }

        switch (typeOfDay)
        {
            case "Weekday":
                ticketPrice = GetTicketPrice(clientAge, 12, 18, 12); break;

            case "Weekend":
                ticketPrice = GetTicketPrice(clientAge, 15, 20, 15); break;

            case "Holiday":
                ticketPrice = GetTicketPrice(clientAge, 5, 12, 10); break;
        }

        Console.WriteLine($"{ticketPrice}$");
    }

    public static int GetTicketPrice(int clientAge, int youngAge, int midAge, int oldAge)
    {
        var ticketPrice = 0;

        if (clientAge >= 0 && clientAge <= 18)
        {
            ticketPrice = youngAge;
        }
        else if (clientAge > 18 && clientAge <= 64)
        {
            ticketPrice = midAge;
        }
        else 
        {
            ticketPrice = oldAge;
        }

        return ticketPrice;
    }
}