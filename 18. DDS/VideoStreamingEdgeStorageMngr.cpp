#include<bits/stdc++.h>;
using namespace std;

class VideoStreamingManager{
    public:

    list<int> dll;
    unordered_map<int, list<int> :: iterator> mp;

    void markRecentlyUsed(int chunkId, int c){
        dll.erase(mp[chunkId]);
        dll.push_front(chunkId);
        mp[chunkId] = dll.begin();
        return;
    }

    void fetch(int chunkId, int c){
        // if chunkId already exist in dll
        if(mp.find(chunkId) != mp.end()){
            markRecentlyUsed(chunkId, c);
            return;
        }

        //if chunkId doesnt exist add chunkId
        // if size is full 
        else{
            if(dll.size() == c){
                int deletedChunk = dll.back();
                dll.pop_back();
                mp.erase(deletedChunk);

                dll.push_front(chunkId);
                mp[chunkId] = dll.begin();
                return;
            }

            else{ // is chunk is not full
                
                dll.push_front(chunkId);
                mp[chunkId] = dll.begin();
                return;
            }
        }        
    }


    void status(){
        if(dll.size() == 0){
            cout<<"EMPTY"<<"\n";
            return;
        }

        for(auto it = dll.begin(); it != dll.end(); ++it)
        {
            if(it != dll.begin()){
                cout<<" ";
            }

            cout<<*it;
        }

        cout<<"\n";

        return;
    }
};

int main(){
    VideoStreamingManager obj;
    int cap, n;
    cin>>cap>>n;

    while(n--){
        string op;
        cin>>op;
        if(op == "FETCH"){
            int chunkId;
            cin>>chunkId;
            obj.fetch(chunkId, cap);
        }

        else if(op == "STATUS"){
            obj.status();
        }

    }

    return 0;
}
