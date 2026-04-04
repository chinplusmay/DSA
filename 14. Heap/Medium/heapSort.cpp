#include <bits/stdc++.h>
using namespace std;
//1 based indexing

void heapify(int arr[], int n, int i){
    int largest = i;
    int left = i*2;
    int right = i*2+1;

    if(left <= n && arr[largest] < arr[left]){
        largest = left;
    }
    if(right <= n && arr[largest] < arr[right]){
        largest = right;
    }

    if(largest != i){
        swap(arr[largest], arr[i]);
        heapify(arr, n, largest);
    }
}

void heapSort(int arr[], int n){
    
    //step 1: given tree -> max heap
    for(int i = n/2; i>=1; i--){
        heapify(arr, n, i);
    }

    //step 2: swap(a[1], a[n]), reduce size, heapify
    int size = n;
    while(size > 1){
        swap(arr[1], arr[size]);
        size--;
        heapify(arr, size, 1);
    }

}


int main(){

int arr[] = {-1,   45, 60, 70, 55, 50};
int n = 5;

heapSort(arr, n);


for(int i = 1; i <= n; i++){ 
    cout << arr[i] << " ";
}
}
