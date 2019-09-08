using System;
using System.Globalization;
using System.Linq;

class Program
{
    static void Main()
    {
        var startDate = DateTime.ParseExact(Console.ReadLine(), "dd-MM-yyyy", CultureInfo.InvariantCulture);
        var endDate = DateTime.ParseExact(Console.ReadLine(), "dd-MM-yyyy", CultureInfo.InvariantCulture);
        var workingDays = 0L;
        var offDays = new[]
        {
            "01-01",
            "03-03",
            "01-05",
            "06-05",
            "24-05",
            "06-09",
            "22-09",
            "01-11",
            "24-12",
            "25-12",
            "26-12"
        }
        .Select(x => DateTime.ParseExact(x, "dd-MM", CultureInfo.InvariantCulture))
        .ToArray();

        for (DateTime currDate = startDate; currDate <= endDate; currDate = currDate.AddDays(1))
        {
            var dayIsSatOrSun = 
                currDate.DayOfWeek == DayOfWeek.Saturday || currDate.DayOfWeek == DayOfWeek.Sunday;
            var isHoliday = offDays.Any(d => d.Day == currDate.Day && d.Month == currDate.Month);
            var isWorkingDay = !(dayIsSatOrSun || isHoliday);

            if (isWorkingDay)
            {
                workingDays++;
            }
        }
        Console.WriteLine(workingDays);
    }
}