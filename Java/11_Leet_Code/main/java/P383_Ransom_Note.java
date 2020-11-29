public class P383_Ransom_Note {

    public boolean canConstruct(String ransomNote, String magazine) {
        char[] left = ransomNote.toCharArray();
        char[] right = magazine.toCharArray();
        int[] chars = new int[256];

        for(char c : left) {
            chars[c] = chars[c] + 1;
        }

        for(char c : right) {
            chars[c] = chars[c] - 1;
        }

        for(char c : left) {
            if(chars[c] > 0)
                return false;
        }

        return true;
    }
}
