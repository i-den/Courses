public class P392_Is_Subsequence {

    public boolean isSubsequence(String subseq, String strToWalk) {
        int stringPtr = 0;
        char[] stringChars = subseq.toCharArray();
        for(char c : strToWalk.toCharArray()) {
            if(stringPtr >= stringChars.length)
                break;
            if(stringChars[stringPtr] == c)
                stringPtr++;
            if(stringPtr == stringChars.length)
                return true;
        }
        return stringPtr == stringChars.length;
    }
}
