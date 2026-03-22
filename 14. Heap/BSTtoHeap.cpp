#include <bits/stdc++.h>
using namespace std;

struct Node {
    int data;
    Node *left, *right;
};



/*

BST -> max heap

bst: L<R, max order: N>L, N>R
==> L<R<N = LRN (postorder)
Steps:
1. make a array containing inorder trav of given bst
2. postorder travrse the tree and insert ele from array in LRN way

for bst -> min heap : travse preorderly ans insert ele from inorderArray

*/

class Solution {
  public:
  
  void InorderedTrav(Node* root, vector<int> &arr){
      if(root == NULL) return;
      // LNR
      InorderedTrav(root->left, arr);
      arr.push_back(root->data);
      InorderedTrav(root->right, arr);
    }
  
    void fillPostOrder(Node* root, vector<int> &arr, int &i){
        if(root == NULL) return;
        // LRN
        fillPostOrder(root->left, arr, i);
        fillPostOrder(root->right, arr, i);
        root->data = arr[i++];
    }
  
  
  
    void convertToMaxHeapUtil(Node* root) {
        
        if(root == NULL) return;
        vector<int> InOrdarr;
        int index = 0;

        InorderedTrav(root, InOrdarr);
        
        fillPostOrder(root, InOrdarr, index);
        
    }
};
