class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int i = 0;
        int j = 0;
        int maxi = Integer.MIN_VALUE;
        int mini = Integer.MAX_VALUE;
        int ans = 0;
        while (i < nums.length && j < nums.length){
            maxi = Math.max(maxi,Math.max(nums[i],nums[j]));
            mini = Math.min(mini,Math.min(nums[i],nums[j]));
            int diff = Math.abs(maxi - mini);
            
            if (diff > limit){
                if (maxi == nums[i]){
                    while (j < nums.length && mini != nums[j] ){
                        j++;
                    }
                    mini = Integer.MAX_VALUE;
                }
                else{
                    while (j < nums.length && maxi != nums[j]){
                        j++;
                    }
                    maxi = Integer.MIN_VALUE;
                }
                j++;
            }
            else {
                ans = Math.max(ans, Math.abs(i - j) + 1);
                i++;
            }
        }
        return ans;
    }
}
