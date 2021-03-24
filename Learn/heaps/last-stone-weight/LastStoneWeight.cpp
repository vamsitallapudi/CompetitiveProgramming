#include<bits/stdc++.h>
#include <ext/pb_ds/assoc_container.hpp>
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
int removeLargest(vector<int>& stones) {
    int indexOfLargest = distance(stones.begin(), max_element(stones.begin(), stones.end()));
    // extracting largest value of vectors
    int largestVal = stones.at(indexOfLargest);
    // swapping last element with large element
    swap(stones[indexOfLargest], stones[stones.size()-1]);
    stones.pop_back();
    return largestVal;
}

int lastStoneWeight(vector<int>& stones) {
    while(stones.size() >1) {
        int stone1 = removeLargest(stones);
        int stone2 = removeLargest(stones);
        if(stone1 != stone2) {
            stones.push_back(stone1-stone2);
        }
    }
    if(stones.size()>0) {
        return stones[0];
    } else {
        return 0;
    }
}
void solve() {
    vector<int> x;
    x.pb(2);
    x.pb(7);
    x.pb(4);
    x.pb(1);
    x.pb(8);
    x.pb(1);
    cout<< lastStoneWeight(x);
}
int main()
{
    c_p_c();
    solve();
    return 0;
}