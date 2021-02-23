#include<bits/stdc++.h>
#include <ext/pb_ds/assoc_container.hpp>
#include "../common/BinaryTree.h"
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

bool isValidBST(TreeNode* root) {
    if(!root) return false;
    stack<TreeNode *> t_stack;
    TreeNode *prev = NULL;
    while(root || !t_stack.empty()) {
        if(root) {
            t_stack.push(root);
            root = root -> left;
        } else {
            root = t_stack.top();
            t_stack.pop();
            //main logic - root value always greater than previous value (left < root <right)
            if (prev && root->val <=prev->val) return false;
            prev = root;
            root = root->right;
        }
    }
    return true;
}

void solve() {
    if(isValidBST(initBST())) cout<<"true"; else cout<<"false";
}
int main()
{
    c_p_c();
    solve();
    return 0;
}