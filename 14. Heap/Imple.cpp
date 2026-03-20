#include <bits/stdc++.h>
using namespace std;

class heap{ // max
    public:
        
        int arr[100];
        int size;
        
        heap(){
            arr[0] = -1;
            size = 0;
        }
        
        void insert(int val){
            size++;
            int index = size;
            arr[index] = val;
            
            while(index > 1){   
                int parent = index/2;
                if(arr[index] > arr[parent]){
                    swap(arr[index], arr[parent]);
                    index = parent;
                }
                else{
                    return;
                }
            }
        }

        void deleteRoot(){ // deleteRoot
            if(size == 0) return;
            arr[1] = arr[size]; //swap root node with last node
            size--;

            int i = 1;
            while(i*2 < size){ // children exist or not(if single children it will be at left of i=1)
                int largest = i;
                int leftindex = 2*i;
                int rightindex = 2*i+1;

                if(leftindex <= size && arr[leftindex] > arr[largest]){
                    largest = leftindex;
                }
                if(rightindex <= size && arr[rightindex] > arr[largest]){
                    largest = rightindex;
                }
                if(largest != i){
                    swap(arr[largest], arr[i]);
                    i = largest;
                }
                return;
            }
        }
        
        void print(){
            for(int i = 1; i<=size; i++){
                cout<<arr[i]<<" ";
            }
        }
};

int main() {
	heap h1;
	h1.insert(53);
	h1.insert(52);
	h1.insert(51);
	h1.insert(54);
	h1.insert(50);
    h1.deleteRoot();
	h1.print();

}
