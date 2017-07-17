namespace Problems
{
    using System;
    using System.Collections.Generic;
    using System.Linq;
    using System.Text;
    using System.Text.RegularExpressions;
    
    public class ProblemB
    {
        public static void Main()
        {
            var inputArr = Console.ReadLine().Split().Select(long.Parse).ToList();
            var summedValue = 0L;

            while (inputArr.Count != 0)
            {
                var currIndex = int.Parse(Console.ReadLine());
                var removedElement = 0L;

                if (currIndex > inputArr.Count - 1)
                {
                    removedElement = inputArr.Last();
                    summedValue += removedElement;
                    inputArr[inputArr.Count - 1] = inputArr.First();
                }
                else if (currIndex < 0)
                {
                    removedElement = inputArr.First();
                    summedValue += removedElement;
                    inputArr[0] = inputArr[inputArr.Count - 1];
                }
                else
                {
                    removedElement = inputArr[currIndex];
                    summedValue += removedElement;
                    inputArr.RemoveAt(currIndex);
                }

                for (int i = 0; i < inputArr.Count; i++)
                {
                    if (inputArr[i] <= removedElement)
                    {
                        inputArr[i] += removedElement;
                    }
                    else if (inputArr[i] > removedElement)
                    {
                        inputArr[i] -= removedElement;
                    }
                }
            }

            Console.WriteLine(summedValue);
        }
    }
}