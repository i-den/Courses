using System;

public class Program
{
    public static void Main()
    {
        var totalGuests = int.Parse(Console.ReadLine());
        var typeOfReservation = Console.ReadLine();
        var hall = string.Empty;
        var bookingPrice = 0D;

        if (totalGuests > 120 || totalGuests < 0)
        {
            Console.WriteLine("We do not have an appropriate hall.");
            return;
        }

        SelectAppropriateHall(totalGuests, out hall, out bookingPrice);
        bookingPrice = GetTotalBookingPrice(typeOfReservation, bookingPrice);

        var pricePerPerson = bookingPrice / totalGuests;

        Console.WriteLine($"We can offer you the {hall}");
        Console.WriteLine($"The price per person is {pricePerPerson:F2}$");
    }

    public static void SelectAppropriateHall(int totalGuests, out string hall, out double bookingPrice)
    {
        if (totalGuests > 0 && totalGuests <= 50)
        {
            hall = "Small Hall";
            bookingPrice = 2500;
        }
        else if (totalGuests > 50 && totalGuests <= 100)
        {
            hall = "Terrace";
            bookingPrice = 5000;
        }
        else
        {
            hall = "Great Hall";
            bookingPrice = 7500;
        }
    }

    public static double GetTotalBookingPrice(string typeOfReservation, double bookingPrice)
    {
        switch (typeOfReservation)
        {
            case "Normal":
                bookingPrice = (bookingPrice + 500) * 0.95; break;

            case "Gold":
                bookingPrice = (bookingPrice + 750) * 0.9; break;
            case "Platinum":
                bookingPrice = (bookingPrice + 1000) * 0.85; break;
        }

        return bookingPrice;
    }
}
