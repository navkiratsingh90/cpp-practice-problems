class Solution {
public:
    int solve(vector<int>& nums, int idx,int prev,vector<vector<int>>& dp ){
        if (idx == nums.size()-1){
            if (nums[idx]%prev == 0) return 1;
            return 0;
        }
        if (dp[idx][prev] != -1) return dp[idx][prev];
        int ans = 0;
        if (nums[idx]%prev == 0) ans++;
        int take = ans + solve(nums,idx + 1,nums[idx],dp);
        int notTake = solve(nums,idx + 1, prev, dp);
        return dp[idx][prev] = max(take,notTake);
    }
    vector<int> largestDivisibleSubset(vector<int>& nums) {
            int n = nums.size();

         vector<int> dp(n, 1), parent(n, -1);
          int lastIdx = 0;
         int maxLen = 1;

       for (int i=0;i<nums.size();i++){
            for (int j=0;j<i;j++){
                if (nums[i]%nums[j] == 0 && dp[i] < dp[j] + 1){
                    dp[i] = dp[j] + 1;
                    parent[i] = j;
                }
            }
            if (dp[i] > maxLen){
                maxLen = dp[i];
                lastIdx = i;
            }
       }
        vector<int> ans;
        while (lastIdx != -1){
            ans.push_back(nums[lastIdx]);
            lastIdx = parent[lastIdx];
        }
        reverse(ans.begin(), ans.end());

        return ans;
    }
};
