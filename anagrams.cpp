class Solution {
public:
    vector<int> findAnagrams(string s, string p) {
        vector<int> ans;
        set<pair<char,int>> mp;
        int windowSize = p.size();
        for (int i=0;i<s.size();i++){
            mp.insert({s[i],i});
            if (mp.size() > windowSize){
                int idxRemoved = INT_MAX;
               char chRemoved = '\0';
                for (auto& [ch,val] : mp){
                    if (idxRemoved > val){
                        idxRemoved = val;
                        chRemoved = ch;
                    }
                }
                mp.erase({chRemoved,idxRemoved});
            }
            if (mp.size() < windowSize) continue;
            string newStr = "";
            int idx = INT_MAX;
            for (auto& [ch,val] : mp){
                    idx = min(idx,val);
                    newStr += ch;
            }
            if (newStr == p) ans.push_back(idx);

        }
        return ans;
    }
};
