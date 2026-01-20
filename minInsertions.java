class Solution {
    public static int solve(String s, String t,int[][] dp,int i, int j){
        if (i < 0 || j < 0){
            return 0;
        }
        if (dp[i][j] != -1) return dp[i][j];
        if (s.charAt(i) == t.charAt(j)){
            return dp[i][j] = 1 + solve(s,t,dp,i-1,j-1);
        }
        int first = solve(s,t,dp,i-1,j);
        int second = solve(s,t,dp,i,j-1);
        return dp[i][j] = Math.max(first,second);
    }
    public int minInsertions(String s) {
       String t = new StringBuilder(s).reverse().toString();
       int[][] dp = new int[s.length()][t.length()]  ;
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        int lcs = solve(s,t,dp,s.length()-1,t.length()-1);
        return s.length() - lcs;
    }
}
