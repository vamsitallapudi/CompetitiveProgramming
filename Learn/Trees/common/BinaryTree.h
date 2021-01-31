#ifndef BinaryTree_H
#define BinaryTree_H

#include<iostream>
using namespace std;

struct TreeNode {
    int val;
    TreeNode* left;
    TreeNode* right;
    TreeNode() : val(0),left(nullptr), right(nullptr) { }
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode* left, TreeNode* right) : val(x), left(left), right(right){}
};

TreeNode* formBinaryTree() {
    struct TreeNode* a = new TreeNode(4);
    struct TreeNode* b = new TreeNode(5);
    struct TreeNode* c = new TreeNode(2, a, b);
    struct TreeNode* d = new TreeNode(3);
    return new TreeNode(1,c,d);
}

void printTree(TreeNode* x) {
    if (x) {
        cout<< x->val<<endl;
    }
    if (x->left) {
        printTree(x->left);
    }
    if (x-> right) {
        printTree(x->right);
    }
}

#endif