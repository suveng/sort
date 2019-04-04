import java.util.ArrayList;
import java.util.List;

/**
 * @author suwenguang
 * email suveng@163.com
 * since 2019/4/1
 * description:
 **/
public class SubSet {
    public static void main(String[] args) {
        System.out.println(subsets(new int[]{0, 1, 2}));
    }
    private static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return results;
        }
        List<Integer> subset = new ArrayList<>();
        dfsHelper(nums, 0, results, subset);

        return results;
    }

    private static void dfsHelper(int[] nums, int startIndex, List<List<Integer>> results, List<Integer> subset) {
        // deep copy and add to results
        System.out.println(subset);
        results.add(new ArrayList<>(subset));

        for (int i = startIndex; i < nums.length; i++) {
            subset.add(nums[i]);
            dfsHelper(nums, i + 1, results, subset);
            subset.remove(subset.size() - 1);
        }
    }

}
