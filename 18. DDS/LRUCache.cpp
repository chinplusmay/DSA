class LRUCache {
public:
    int n;
    //dll
    list<int> dll;
    //map: key, <Address, value>
    map<int, pair<list<int> ::iterator, int>> mp;
    LRUCache(int capacity) {
        n = capacity;
    }

    void makeRecentlyUsed(int key){
        dll.erase(mp[key].first);

        dll.push_front(key);

        mp[key].first = dll.begin();
    }
    
    int get(int key) {
        if(mp.find(key) == mp.end()) return -1; //not found

        makeRecentlyUsed(key);

        return mp[key].second;
    }
    
    void put(int key, int value) {
        
        //if pair already existing in map
        if(mp.find(key) != mp.end()){
            mp[key].second = value;
            makeRecentlyUsed(key);
        }
        else{ //not present in map
            dll.push_front(key);
            mp[key] = {dll.begin(), value};

            n--; //decrease capacity
        }

        if(n < 0){
            int deletedkey = dll.back();
            mp.erase(deletedkey);
            dll.pop_back();

            n++;
        }


        
    }
};

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache* obj = new LRUCache(capacity);
 * int param_1 = obj->get(key);
 * obj->put(key,value);
 */