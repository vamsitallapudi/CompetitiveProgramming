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
bool checkSymm(TreeNode* root1, TreeNode* root2) {
    if(!root1 && !root2) return true;
    queue<TreeNode*> queue;
    queue.push(root1);
    queue.push(root2);
    while(!queue.empty()) {
        TreeNode* x = queue.front();
        queue.pop(); // we have to pop manually in cpp after every read
        TreeNode* y = queue.front();
        queue.pop();
        if(!x && !y) continue; // remember, we are continuing here
        if(!x || !y) return false;
        if(x->val != y->val) return false;
        // pushing the values alternatively
        queue.push(x->left);
        queue.push(y->right);
        queue.push(x->right);
        queue.push(y->left);
    }
    return true;
}

bool isSymmetric(TreeNode* root) {
    if(!root) return true;
    return checkSymm(root->left, root->right);
}
void solve() {
    
}
int main()
{
    c_p_c();
    solve();
    return 0;
}