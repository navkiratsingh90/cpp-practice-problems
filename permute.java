class Solution {
    public static void solve(int[] nums,List<List<Integer>> ans, List<Integer> part, List<Integer> res){
        if (part.size() == 0){
            ans.add(new ArrayList<>(res));
        }   
        for (int i=0;i<part.size();i++){
            res.add(part.get(i));
            List<Integer> a = new ArrayList<>();
            for (int j=0;j<part.size();j++){
                if (j != i) a.add(part.get(j));
            }
            solve(nums,ans,a,res);
            res.remove(res.size() - 1);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> part = new ArrayList<>();
          List<Integer> res = new ArrayList<>();
          for (int i = 0; i < nums.length; i++) {
            part.add(nums[i]);
        }

          solve(nums,ans,part,res);
          return ans;
    }
}
