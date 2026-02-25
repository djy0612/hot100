package main.java.mid;

import java.util.ArrayList;
import java.util.List;

public class permute {
    public static void main(String[] args) {

    }
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        backTracking(nums);
        return ans;
    }

    private void backTracking(int[] nums) {
        if (path.size() == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!path.contains(nums[i])) {
                path.add(nums[i]);
                backTracking(nums);
                path.remove(path.size() - 1);
            }
        }
    }
}
