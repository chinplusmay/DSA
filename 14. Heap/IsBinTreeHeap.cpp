#include <bits/stdc++.h>
using namespace std;


class Node {
   public:
    int data;
    Node *left;
    Node *right;

    Node(int val) {
        data = val;
        left = right = NULL;
    }
};


class Solution {
  public:
int CountNodes(Node* root){
    if(root == NULL) return 0;

    int ans = 1 + CountNodes(root->left) + CountNodes(root->right);
    return ans;
}

  
bool isCBT(Node* root, int i, int cnt){
    if(root == NULL) return true;
    if(i >= cnt) return false;
    else{
        bool left = isCBT(root->left, 2*i+1, cnt);
        bool right = isCBT(root->right, 2*i+2, cnt);
        return (left && right);
    }
}


bool isMaxOrder(Node* head){ // max heap
    if(head == NULL) return true;
    if(head->left == NULL && head->right == NULL){ //leaf node
        return true;
    }
    
    if(head->right == NULL && head->left != NULL){ // when only left exist
        return (head->data > head->left->data);
    }
    
    if(head->left == NULL) return false;  // if right exist but not left invalid
    else{
        bool left = isMaxOrder(head->left);
        bool right = isMaxOrder(head->right);
        
         // for currend node and next left and right nodes
        return ((head->data > head->left->data) &&(head->data > head->right->data) && left && right);
        
    }
}
  
  
  
  
  
bool isHeap(Node* root) {
    int i = 0;
    int NodeCnt = CountNodes(root);
    return (isCBT(root, i, NodeCnt) && isMaxOrder(root));
}
};