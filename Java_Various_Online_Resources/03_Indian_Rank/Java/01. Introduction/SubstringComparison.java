package com.denchevgod;

public class SubstringComparison {

    public static String getSmallestAndLargest(String string, int k) {
        java.util.SortedSet<String> strs = new java.util.TreeSet<>();
        for (int i = 0; i <= string.length() - k; i++) {
            strs.add(string.substring(i, i + k));
        }
        return strs.first() + "\n" + strs.last();
    }
}
