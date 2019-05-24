using System;

public class Program
{
    public static void Main()
    {
        var picturesTaken = int.Parse(Console.ReadLine());
        var filterTime = int.Parse(Console.ReadLine());
        var filterFactor = int.Parse(Console.ReadLine());
        var uploadTime = int.Parse(Console.ReadLine());

        var filteredPictures = Math.Ceiling(picturesTaken * (filterFactor / 100D));

        var timeToFilter = picturesTaken * (long)filterTime;
        var timeToUpload = filteredPictures * (long)uploadTime;

        var totalTimeInSeconds = timeToFilter + timeToUpload;

        Console.WriteLine(
            TimeSpan.FromSeconds(totalTimeInSeconds)
            .ToString(@"d\:hh\:mm\:ss"));
    }
}