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

vector<vector<int>> levelOrder(TreeNode* root) {
    vector<vector<int>> result;
    if (!root) return result;
    vector<int> curr_queue;
    queue<TreeNode*> q;

    q.push(root);
    q.push(NULL);

    while(!q.empty()) {
        TreeNode* node = q.front();
        q.pop();
        if(node == NULL) {
            // reached end position of curr level
            result.push_back(curr_queue);
            curr_queue.resize(0);
            if(q.size()>0) {
                q.push(NULL);
            }
        } else {
            curr_queue.push_back(node->val);
            if(node->left) q.push(node->left);
            if(node->right) q.push(node->right);
        }
    }
    return result;
}

void solve() {
    vector<vector<int>> lvlOrder = levelOrder(formBinaryTree());
    for (int i = 0; i< lvlOrder.size();i++) {
        vector<int> level = lvlOrder[i];
        for (int j= 0;j< level.size();j++) {
            cout<<level[j];
        }
    }
}
int main()
{
    c_p_c();
    solve();
    return 0;
}