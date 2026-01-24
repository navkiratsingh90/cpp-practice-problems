class Solution {
    public static int solve(int[] nums, int[][] dp, int idx, int lastRobbed){
        if (idx <= 0){
            if (idx == 0 && lastRobbed != 1) return nums[0];
            return 0;
        }
        if (dp[idx][lastRobbed] != -1) return dp[idx][lastRobbed];
        int take = -1;
        int notTake = -1;
        if (idx == nums.length-1){
             take = nums[idx] + solve(nums,dp,idx-2, 1);
             notTake = solve(nums, dp, idx-1,0);
        }
        else{
             take = nums[idx] + solve(nums,dp,idx-2,lastRobbed);
             notTake = solve(nums, dp, idx-1, lastRobbed);
        }
        return dp[idx][lastRobbed] = Math.max(take,notTake);
    }
    public int rob(int[] nums) {
          int[][] dp = new int[nums.length][2];
         for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solve(nums,dp,nums.length-1,0);
    }
}
