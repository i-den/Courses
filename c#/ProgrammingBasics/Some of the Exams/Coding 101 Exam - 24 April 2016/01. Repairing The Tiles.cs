using System;

class Program
{
    public static void Main()
    {

        int PlayGroundSide = int.Parse(Console.ReadLine());
        double TileWidth = double.Parse(Console.ReadLine());
        double TileHeight = double.Parse(Console.ReadLine());

        int BenchWidth = int.Parse(Console.ReadLine());
        int BenchHeight = int.Parse(Console.ReadLine());

        double TileSetTme = 0.2;

        int BenchSize = BenchWidth * BenchHeight;

        double TileSize = TileWidth * TileHeight;

        int PlayGroundSize = PlayGroundSide * PlayGroundSide;

        double TilesNumber = (double)(PlayGroundSize - BenchSize) / TileSize;

        double TilesTotalTime = TilesNumber * TileSetTme;

        Console.WriteLine(TilesNumber);
        Console.WriteLine(TilesTotalTime);
    }
}