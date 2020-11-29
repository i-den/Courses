public class P58_Length_of_Last_Word {

    public int lengthOfLastWord(String s) {
        String[] arr = s.split("\\s+");
        if(arr.length == 0) {
            return 0;
        }
        return arr[arr.length - 1].length();
    }
}
