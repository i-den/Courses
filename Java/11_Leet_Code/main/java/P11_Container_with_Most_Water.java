public class P11_Container_with_Most_Water {

    public int maxArea(int[] height) {
        int maxWater = 0;

        int leftPtr = 0;
        int rightPtr = height.length - 1;

        while(leftPtr < rightPtr) {
            int leftHeight = height[leftPtr];
            int rightHeight = height[rightPtr];
            int maxPossibleHeight = Integer.min(leftHeight, rightHeight);
            int distanceBetweenHeights = rightPtr - leftPtr;
            int areaBetweenHeights = maxPossibleHeight * distanceBetweenHeights;

            maxWater = Integer.max(maxWater, areaBetweenHeights);

            if(leftHeight == rightHeight) {
                leftPtr++;
                rightPtr--;
            } else if (leftHeight > rightHeight) {
                rightPtr--;
            } else {
                leftPtr++;
            }
        }

        return maxWater;
    }
}
