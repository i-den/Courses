using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _01.Repairing_The_Tiles
{
    class Program
    {
        static void Main(string[] args)
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
}
