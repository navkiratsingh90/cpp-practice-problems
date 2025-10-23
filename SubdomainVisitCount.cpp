class Solution {
public:
    void checkDomain(string domain, string num, unordered_map<string, string>& mp) {
        if (mp.count(domain)) {
            int count = stoi(mp[domain]);  
            count += stoi(num);            
            mp[domain] = to_string(count); 
        } 
        else {
            mp[domain] = num;
        }
    }

    vector<string> subdomainVisits(vector<string>& dom) {
        unordered_map<string,string> mp;
        string res = "";
        for (int i=0;i<dom.size();i++){
            int j = 0;
            string num = "";
            while (dom[i][j] != ' '){
                num+=dom[i][j];
                j++;
            }
            cout<<num<<endl;
            j++;
            string domain = "";
            while (j<dom[i].size()){
                domain+=dom[i][j];
                j++;
            }
            checkDomain(domain,num,mp);
            string domain2 = "";
            int idx = domain.find('.');
            domain2 += domain.substr(idx+1);
            checkDomain(domain2,num,mp);
             string domain3 = "";
            int idx1 = domain2.find('.');
            if (idx1 == -1) continue;
            domain3 += domain2.substr(idx1+1);
            checkDomain(domain3,num,mp);
        }
        vector<string> ans;
        for (auto& [key,val] : mp){
            string temp = "";
            temp += val +" "+key;
            ans.push_back(temp);
        }
        return ans;
    }
};
