#include <bits/stdc++.h>
using namespace std;

void heapify(int arr[], int n, int i){ // i is the node we have to place to correct place to make heap
    int largest = i;
    int left = i*2;
    int right = i*2+1;

    if(left <= n && arr[largest] < arr[left]){
        largest = left;
    }
    if(right <= n && arr[largest] < arr[right]){
        largest = right;
    }
    // was ith node really wrongly placed?
    if(largest != i){
        swap(arr[largest], arr[i]);
        heapify(arr, n, largest);
    }

}
int main(){

    int arr[] = {-1,   50, 55, 53, 52, 54};
    int n = 5;

    //Build heap
    for(int i = n/2; i >= 1; i--){  //iterate pn non lead nodes= n/2 -> 1
        heapify(arr, n, i);
    }

    for(int i = 1; i <= n; i++){ 
        cout << arr[i] << " ";
    }
}
