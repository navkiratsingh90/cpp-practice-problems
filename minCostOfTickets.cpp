class Solution {
public:
    int solve(vector<int>& days, vector<int>& cost, int idx, int totalDays,vector<vector<int>>& dp){
        if (idx == days.size()) {
            // if (totalDays < days[idx]) return 2;
            return 0;
        }
        if (dp[idx][totalDays] != -1) return dp[idx][totalDays];
        int c1,c2,c3 = INT_MAX;
        if (totalDays < days[idx]){
            c1 = cost[0] + solve(days,cost,idx + 1, days[idx] + 1 - 1,dp);
             c2 = cost[1] + solve(days,cost,idx + 1, days[idx] + 7 - 1,dp);
              c3 = cost[2] + solve(days,cost,idx + 1, days[idx] + 30 - 1,dp);
        }
        else {
             return dp[idx][totalDays]  = solve(days,cost,idx + 1, totalDays,dp);
        }
        return dp[idx][totalDays] = min(c1,min(c2,c3));
    }
    int mincostTickets(vector<int>& days, vector<int>& costs) {
          vector<vector<int>> dp(days.size(), vector<int>(days.size()*31, -1));
        return solve(days,costs,0,0,dp);
    }
};
