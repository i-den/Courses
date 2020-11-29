public class P41_First_Missing_Positive {

    public int firstMissingPositive(int[] arr) {
        int maxPossibleMissingNumInArr = arr.length;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > maxPossibleMissingNumInArr || arr[i] <= 0) {
                arr[i] = maxPossibleMissingNumInArr + 1;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            int idx = Math.abs(arr[i]);
            if (idx > maxPossibleMissingNumInArr) {
                continue;
            }

            idx--;
            if (arr[idx] > 0) {
                arr[idx] = ( (-1) * arr[idx] );
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0) {
                return i + 1;
            }
        }

        return maxPossibleMissingNumInArr + 1;
    }
}
