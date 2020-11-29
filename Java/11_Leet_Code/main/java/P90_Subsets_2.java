import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P90_Subsets_2 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> sets = new HashSet<>();
        sets.add(new ArrayList<>());

        for(int num : nums) {
            sets = expand(sets, num);
        }

        return new ArrayList<>(sets);
    }

    private Set<List<Integer>> expand(Set<List<Integer>> sets, int num) {
        Set<List<Integer>> toReturn = new HashSet<>();
        for(List<Integer> l : sets) {
            List<Integer> l2 = new ArrayList<>(l);
            l2.add(num);
            toReturn.add(l);
            toReturn.add(l2);
        }
        return toReturn;
    }
}
