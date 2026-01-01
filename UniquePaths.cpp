class Solution {
public:
    int row = -1;
    int col = -1;
    int solve(int n, int m, vector<vector<int>>& dp, vector<vector<int>>& grid){
        if (grid[n][m] == 1) return 0;
        if (n == row-1 && m == col -1){
            return 1;
        }
        if (dp[n][m] != -1) return dp[n][m];
        int total = 0;
        if (m + 1 <= col - 1){
            total += solve(n,m+1,dp,grid);
        }
        if (n + 1 <= row - 1){
            total += solve(n+1,m,dp,grid);
        }
        return dp[n][m] = total;
    }
    int uniquePathsWithObstacles(vector<vector<int>>& nums) {
        row = nums.size();
        col = nums[0].size();
        vector<vector<int>> dp(row, vector<int>(col, -1));
        return solve(0,0,dp,nums);
    }
};
