using System;
using System.Globalization;

public class Program
{
    public static void Main()
    {
        var photoNumber = int.Parse(Console.ReadLine());
        var photoDay = int.Parse(Console.ReadLine());
        var photoMonth = int.Parse(Console.ReadLine());
        var photoYear = int.Parse(Console.ReadLine());
        var photoHour = int.Parse(Console.ReadLine());
        var photoMinutes = int.Parse(Console.ReadLine());
        var photoSize = long.Parse(Console.ReadLine());
        var photoWidth = int.Parse(Console.ReadLine());
        var photoHeight = int.Parse(Console.ReadLine());

        var name = $"DSC_{photoNumber:D4}.jpg";
        var dateTaken = DateTime.ParseExact($"{photoDay:D2}/{photoMonth:D2}/{photoYear} {photoHour:D2}:{photoMinutes:D2}", "dd/MM/yyyy HH:mm", CultureInfo.InvariantCulture).ToString("dd/MM/yyyy HH:mm");
        var photoHumanSize = GetReadableFileSize(photoSize);
        var photoScape = photoWidth / (double)photoHeight;
        var photoScapey = string.Empty;

        if (photoScape > 1)
        {
            photoScapey = "landscape";
        }
        else if (photoScape == 1)
        {
            photoScapey = "square";
        }
        else
        {
            photoScapey = "portrait";
        }

        Console.WriteLine($"Name: {name}");
        Console.WriteLine($"Date Taken: {dateTaken}");
        Console.WriteLine($"Size: {photoHumanSize}");
        Console.WriteLine($"Resolution: {photoWidth}x{photoHeight} ({photoScapey})");
    }

    private static string GetReadableFileSize(long photoSize)
    {
        var humanReadableFormatSize = string.Empty;
        var formatExtensions = new string[] { "B", "KB", "MB", "GB", "TB", "PB" };
        var indexer = 0;
        var currNumber = (double)photoSize;
        
        while (true)
        {
            if (currNumber > 1000)
            {
                currNumber /= 1000;
                indexer++;
            }
            else
            {
                humanReadableFormatSize = formatExtensions[indexer];
                break;
            }
        }

        return(currNumber + humanReadableFormatSize);
    }
}