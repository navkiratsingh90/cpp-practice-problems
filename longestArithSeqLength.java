class Solution {
    // public static int solve(int[] nums, int[][][] dp, int idx, int last, int diff){
    //     if (idx == nums.length-1){
    //         if (last != -1 && (nums[idx] - nums[last]) == diff) return 1;
    //         return 0;
    //     }
    //     if (dp[idx][last+1][diff + 500] != -501) return dp[idx][last+1][diff + 500];
    //     int take = 0;
    //     // int k = nums[idx] - nums[last+1];
    //     if (last == -1){
    //         take = 1 + solve(nums,dp,idx+1,idx,diff);
    //     //    else take  = 1 + solve(nums,dp,idx+1,idx,)
    //     }
    //     else {
    //         int k = nums[idx] - nums[last];
    //        if (diff == -1 || k == diff) take = 1 + solve(nums,dp,idx+1,idx,k);
    //     }
    //     int notTake = solve(nums,dp,idx+1,last,diff);
    //     // System.out.println(diff + " " + idx);
    //     return dp[idx][last+1][diff + 500] = Math.max(take,notTake);
        
    // }
    public int longestArithSeqLength(int[] nums) {
     HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
     int ans = 0;
      for (int i=0;i<nums.length;i++){
         map.put(i,  new HashMap<>());
        for (int j=0;j<i;j++){
            int diff = nums[i] - nums[j];
            // if (map.containsKey(nums[j])){
                int len = map.get(j).getOrDefault(diff,0) + 1;
                map.get(i).put(diff,len);
               ans = Math.max(ans,len);
            // }
        }
      }
        return ans+1;
    }
}
