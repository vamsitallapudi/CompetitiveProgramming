#include<bits/stdc++.h>
#include <ext/pb_ds/assoc_container.hpp>
#include "common/BinaryTree.h"
using namespace __gnu_pbds;
using namespace std;

#define ff              first
#define ss              second
#define ll             long long
#define pb              push_back
#define mp              make_pair
#define pii             pair<int,int>
#define vi              vector<int>
#define mii             map<int,int>
#define pqb             priority_queue<int>
#define pqs             priority_queue<int,vi,greater<int> >
#define setbits(x)      __builtin_popcountll(x)
#define zrobits(x)      __builtin_ctzll(x)
#define mod             1000000007
#define inf             1e18
#define ps(x,y)         fixed<<setprecision(y)<<x
#define mk(arr,n,type)  type *arr=new type[n];
#define w(x)            int x; cin>>x; while(x--)
mt19937                 rng(chrono::steady_clock::now().time_since_epoch().count());

typedef tree<int, null_type, less<int>, rb_tree_tag, tree_order_statistics_node_update> pbds;

void   c_p_c()
{
    ios_base::sync_with_stdio(0); cin.tie(0); cout.tie(0);
#ifndef ONLINE_JUDGE
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
#endif
}

vector<int> postorderTraversal(TreeNode* root) {
    vector<int> data;
    if(!root) return data;
    stack<TreeNode*> tree_stack;
    while (root || !tree_stack.empty())
    {
        while(root) {
            tree_stack.push(root);
            if(root->left)
                root = root->left;
            else
                root = root->right;
        }
        // processing data after reaching leaf node
        TreeNode* node = tree_stack.top();
        tree_stack.pop();
        data.push_back(node->val);
        // checking if current top node is root or not, then traversing to right
        if(!tree_stack.empty() && tree_stack.top()->left == node) { 
            root = tree_stack.top()->right;
        }
    }
    return data;
}

void solve() {
    TreeNode* node = initBinaryTree();
    vector<int> values = postorderTraversal(node);
    for(int i=0;i<values.size();i++)
    {   
        cout<<values[i];

    }
}
int main()
{
    c_p_c();
    solve();
    return 0;
}