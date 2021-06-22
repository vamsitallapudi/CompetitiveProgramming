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
class BSTIterator {
    stack<TreeNode*> bst_stack;
    TreeNode* root, prev;
public:
    BSTIterator(TreeNode* rt) {
        root = rt;
    }
    int next() {
        while(root || !bst_stack.empty()) {
            if(root) {
                bst_stack.push(root);
                root = root->left;
            } else {
                TreeNode* x = bst_stack.top();
                bst_stack.pop();
                root = x->right;
                return x->val;
            }
        }
        return 0;
    }
    
    bool hasNext() {
        return(root || !bst_stack.empty());
    }
};



void solve() {
    BSTIterator* bst = new BSTIterator(initBST());
    if (bst->hasNext()) cout<<"True"<<endl; else cout<<"False"<<endl;
    cout << bst->next()<<endl;
    if (bst->hasNext()) cout<<"True"<<endl; else cout<<"False"<<endl;
    cout << bst->next()<<endl;
    if (bst->hasNext()) cout<<"True"<<endl; else cout<<"False"<<endl;
    cout << bst->next()<<endl;
    while(bst->hasNext()) {
        cout << bst->next()<<endl;
    }
    delete bst;
}
int main()
{
    c_p_c();
    solve();
    return 0;
}