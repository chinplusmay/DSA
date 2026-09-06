#include <bits/stdc++.h>
using namespace std;

class WatchHistoryManager {
public:

    struct UserHistory {
        // Stores all watch events in order
        list<int> history;

        // Stores unique movies for quick common-movie checking
        unordered_set<int> movies;
    };

    // user_id -> UserHistory
    unordered_map<int, UserHistory> mp;


    // WATCH user_id movie_id
    void watch(int user_id, int movie_id) {

        // Add movie to history
        mp[user_id].history.push_back(movie_id);

        // Add movie to set
        mp[user_id].movies.insert(movie_id);
    }


    // HISTORY user_id K
    void getHistory(int user_id, int k) {

        // User doesn't exist
        if(mp.find(user_id) == mp.end()) {
            cout << "EMPTY\n";
            return;
        }

        auto &lst = mp[user_id].history;

        if(lst.empty()) {
            cout << "EMPTY\n";
            return;
        }

        int count = 0;

        // Start from most recently watched movie
        for(auto it = lst.rbegin();
            it != lst.rend() && count < k;
            it++) {

            cout << *it;

            count++;

            if(count < k && next(it) != lst.rend()) {
                cout << " ";
            }
        }

        cout << "\n";
    }


    // COMMON user1 user2
    bool common(int user1, int user2) {

        // If either user doesn't exist
        if(mp.find(user1) == mp.end() ||
           mp.find(user2) == mp.end()) {

            return false;
        }

        auto &set1 = mp[user1].movies;
        auto &set2 = mp[user2].movies;

        // Always iterate over smaller set
        if(set1.size() > set2.size()) {
            return common(user2, user1);
        }

        for(int movie : set1) {

            if(set2.find(movie) != set2.end()) {
                return true;
            }
        }

        return false;
    }
};


int main() {

    WatchHistoryManager obj;

    int n;
    cin >> n;

    while(n--) {

        string operation;
        cin >> operation;

        if(operation == "WATCH") {

            int user_id, movie_id;
            cin >> user_id >> movie_id;

            obj.watch(user_id, movie_id);
        }

        else if(operation == "HISTORY") {

            int user_id, k;
            cin >> user_id >> k;

            obj.getHistory(user_id, k);
        }

        else if(operation == "COMMON") {

            int user1, user2;
            cin >> user1 >> user2;

            if(obj.common(user1, user2)) {
                cout << "YES\n";
            }
            else {
                cout << "NO\n";
            }
        }
    }

    return 0;
}
