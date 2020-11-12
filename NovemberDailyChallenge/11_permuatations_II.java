Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.

 

Example 1:

Input: nums = [1,1,2]
Output:
[[1,1,2],
 [1,2,1],
 [2,1,1]]
Example 2:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 

Constraints:

1 <= nums.length <= 8
-10 <= nums[i] <= 10


class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        Arrays.sort(nums);
        boolean [] used = new boolean [nums.length];
        backtrack(result, current, 0, nums, used);
        return result;
    }
    public void backtrack(List<List<Integer>> result, List<Integer> current, int start, int [] nums, boolean [] used) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i=start; i<nums.length; i++) {
            if (used[i] || i > start && nums[i] == nums[i-1] && !used[i-1])
                continue;
            used[i] = true;
            current.add(nums[i]);
            backtrack(result, current, 0, nums, used);
            used[i] = false;
            current.remove(current.size() - 1);
        }
    }
}
