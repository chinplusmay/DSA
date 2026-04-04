#include <bits/stdc++.h>
using namespace std;

//return the max val that can be stored in a knapsack with given capacity

class node{
    public:
    int val;
    int wt;
};

class compare{
    public:
    bool operator()(node a, node b){
        double r1 =(double) a.val / a.wt;
        double r2 =(double) b.val / b.wt;
        return r1 > r2; //desc
    }
};


// sort the array based on val per wieght, val / wt in desc order
double fractionalKnapsack(vector<int>& val, vector<int>& wt, int cap){
    int n = wt.size();
    vector<node> itemList;
    for(int i = 0; i<n; i++){
        itemList.push_back({val[i], wt[i]});
    }
    sort(itemList.begin(), itemList.end(), compare());

    double mxval = 0.0;
    for(int i = 0; i<n; i++){
        if(cap >= itemList[i].wt){
            cap -= itemList[i].wt;
            mxval += itemList[i].val;
        }
        else{// fract part
            mxval += ((double)cap * itemList[i].val) / itemList[i].wt;
            break;
        }
    }
    return mxval;

}   


int main(){
    vector<int> val = {60, 100, 120};
    vector<int> wt = {10, 20, 30};
    int capacity = 50; //60+100+(2/3)(120)

    cout<<fractionalKnapsack(val, wt, capacity);
}