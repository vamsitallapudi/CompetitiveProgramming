#include<bits/stdc++.h>
#include <ext/pb_ds/assoc_container.hpp>
using namespace __gnu_pbds;
using namespace std;
#include "common/BinaryTree.h"

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
#define pit             pair<int, TreeNode*>

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
bool hasPathSum(TreeNode* root, int targetSum) {
    if(!root) return false;
    vector<pit> tree_queue;
    tree_queue.push_back(pit(targetSum, root));
    while(!tree_queue.empty()) {
        pit my_pair = tree_queue.back();
        tree_queue.pop_back();
        TreeNode* my_node = get<1>(my_pair);
        int remainingSum = get<0>(my_pair) - my_node->val;
        if(!my_node->left && !my_node->right && remainingSum == 0) return true;
        if(my_node->left) tree_queue.push_back(pit(remainingSum, my_node->left));
        if(my_node->right) tree_queue.push_back(pit(remainingSum, my_node->right));
    }
    return false;
}

void solve() {
    if (hasPathSum(initBinaryTree(), 7)) cout<<"true"; else cout<<"false";
}
int main()
{
    c_p_c();
    solve();
    return 0;
}