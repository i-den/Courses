public class P88_Merge_Sorted_Array {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int arrPtr = nums1.length - 1;
        m--;
        n--;

        while(m >= 0 && n >= 0) {
            int left = nums1[m];
            int right = nums2[n];

            if(left <= right) {
                nums1[arrPtr--] = right;
                n--;
            } else if(left > right) {
                nums1[arrPtr--] = left;
                nums1[m] = right;
                m--;
            }
        }

        while (n >= 0) {
            nums1[arrPtr--] = nums2[n--];
        }
    }
}
