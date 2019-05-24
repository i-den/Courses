using System;

class Program
{
    public static void Main()
    {
        var text = Console.ReadLine();
        var sum = 0;

        for (int i = 0; i < text.Length; i++)
        {
            var currletter = text[i];
            switch (currletter)
            {
                case 'a':
                    sum += 1;
                    break;
                case 'e':
                    sum += 2;
                    break;
                case 'i':
                    sum += 3;
                    break;
                case 'o':
                    sum += 4;
                    break;
                case 'u':
                    sum += 5;
                    break;
            }
        }

        Console.WriteLine(sum);
    }
}