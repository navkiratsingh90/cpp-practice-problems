class Solution {
public:
    int maximalSquare(vector<vector<char>>& nums) {
        vector<vector<int>> dp(nums.size(), vector<int>(nums[0].size(), -1));
        for (int i=0;i<nums.size();i++){
            dp[i][0] = nums[i][0] == '1' ? 1 : 0;
        }
        for (int i=0;i<nums[0].size();i++){
            dp[0][i] = nums[0][i] == '1' ? 1 : 0;
        }
        for (int i=1;i<nums.size();i++){
            for (int j=1;j<nums[i].size();j++){
                if (nums[i][j] == '1'){
                    dp[i][j] = min(dp[i-1][j], min(dp[i-1][j-1],dp[i][j-1])) + 1;
                }
                else dp[i][j] = 0;
            }
        }
        int ans = 0;
          for (int i=0;i<nums.size();i++){
            for (int j=0;j<nums[i].size();j++){
                ans = max(ans,dp[i][j]);
            }
            // cout<<endl;
        }
        return ans*ans;
    }
};
