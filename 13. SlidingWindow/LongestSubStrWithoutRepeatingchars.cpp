#include<bits/stdc++.h>
using namespace std;

int lengthOfLongestSubstring1(string s){ // O(N^2)
    int maxLen = 0;
    for(int i = 0; i<s.size(); i++){
        vector<int> hash(256, 0);
        for(int j = i; j<s.size(); j++){
            if(hash[s[j]] == 1) break;

            int len = j-i+1;
            maxLen = max(len, maxLen);
            hash[s[j]] = 1;
        }
    }return maxLen;
}

// 2Ptrs
int lengthOfLongestSubstring2(string s){ // O(N)
    int maxLen = 0;
    vector<int> hash(256, -1);
    int r = 0, l = 0;
    while(r < s.size()){
        if(hash[s[r]] != -1){
            l = max(hash[s[r]]+1, l);
        }

        int len = r-l+1;
        maxLen = max(maxLen, len);

        hash[s[r]] = r;
        r++;
    }
    return maxLen;
    
}


int main(){
    string s = "abcabcbb"; // abc == 3
    cout << lengthOfLongestSubstring2(s);
}
