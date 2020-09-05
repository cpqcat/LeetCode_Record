import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        res.add(new ArrayList<Integer>());
        for (int i = 0; i < nums.length; i++) {
            int size = res.size();
            for (int j = 0; j < size; j++) {
                List<Integer> newSubres = new ArrayList<Integer>(res.get(j));
                newSubres.add(nums[i]);
                res.add(newSubres);
            }
        }
        return res;
    }
    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        helper(nums, 0, res, new ArrayList<>());
        return res;
    }
    void helper(int[] nums, int index, List<List<Integer>> res, List<Integer> subres) {
        if (index == nums.length) {
            res.add(new ArrayList<Integer>(subres));
            return;
        }
        //dont choose
        helper(nums, index + 1, res, subres);
        //choose
        subres.add(nums[index]);
        helper(nums, index + 1, res, subres);
        subres.remove(subres.size() - 1);
    }
} 