class Solution {
public:
    void solve(vector<int>& arr, int& maxChunks, int idx,  vector<vector<int>>& temp){
       if (idx == arr.size()) {
            vector<int> flat;
            for (auto &row : temp) {
                for (auto &x : row) {
                    flat.push_back(x);
                }
            }
            bool isSorted = is_sorted(flat.begin(), flat.end());
            if (!isSorted) return;
            maxChunks = max(maxChunks, (int)temp.size());
            return;
        }

        vector<int> ans;
        for (int i=idx;i<arr.size();i++){
            ans.push_back(arr[i]);
            sort(ans.begin(),ans.end());
            temp.push_back(ans);
            solve(arr,maxChunks,i+1,temp);
            temp.pop_back();
        }
    }
    int maxChunksToSorted(vector<int>& arr) {
        int maxChunks = 1;
        vector<vector<int>> temp;
        solve(arr,maxChunks,0, temp);
        return maxChunks;
    }
};
