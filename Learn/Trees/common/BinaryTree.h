#ifndef BinaryTree_H
#define BinaryTree_H

#include <iostream>
using namespace std;

struct TreeNode
{
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
    TreeNode(int x, TreeNode *left) : val(x), left(left), right(nullptr) {}
};

TreeNode * initBinaryTree()
{

    /* Forming the following Binary Tree:
                    1
                  /   \
                 2     3
               /   \
              4     5
    */

    struct TreeNode *a = new TreeNode(4);
    struct TreeNode *b = new TreeNode(5);
    struct TreeNode *c = new TreeNode(2, a, b);
    struct TreeNode *d = new TreeNode(3);
    return new TreeNode(1, c, d);
}

TreeNode * initBST()
{

    /* Forming the following Binary Search Tree:
                    5
                  /   \
                 2     6
               /   \    \
              1     4    7
                   /
                  3  
    */              

    struct TreeNode *a = new TreeNode(3);
    struct TreeNode *b = new TreeNode(4, a);
    struct TreeNode *e = new TreeNode(1);
    struct TreeNode *c = new TreeNode(2, e, b);
    struct TreeNode *d = new TreeNode(7);
    struct TreeNode *f = new TreeNode(6);
    f->right = d;
    return new TreeNode(5, c, f);
}

void printTree(TreeNode *x)
{
    if (x)
    {
        cout << x->val << endl;
    }
    if (x->left)
    {
        printTree(x->left);
    }
    if (x->right)
    {
        printTree(x->right);
    }
}

#endif