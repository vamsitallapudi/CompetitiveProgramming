#include <bits/stdc++.h>
#include <ext/pb_ds/assoc_container.hpp>
using namespace __gnu_pbds;
using namespace std;

#define ff first
#define ss second
#define ll long long
#define pb push_back
#define mp make_pair
#define pii pair<int, int>
#define vi vector<int>
#define mii map<int, int>
#define pqb priority_queue<int>
#define pqs priority_queue<int, vi, greater<int>>
#define setbits(x) __builtin_popcountll(x)
#define zrobits(x) __builtin_ctzll(x)
#define mod 1000000007
#define inf 1e18
#define ps(x, y) fixed << setprecision(y) << x
#define mk(arr, n, type) type *arr = new type[n];
#define w(x)  \
    int x;    \
    cin >> x; \
    while (x--)
mt19937 rng(chrono::steady_clock::now().time_since_epoch().count());

typedef tree<int, null_type, less<int>, rb_tree_tag, tree_order_statistics_node_update> pbds;

void c_p_c()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);
#ifndef ONLINE_JUDGE
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
#endif
}
class KthLargest
{
private:
    priority_queue<int, vector<int>, greater<int>> minHeap;
    int required;

public:
    KthLargest(int k, vector<int> &nums)
    {
        required = k;
        for (auto it : nums)
        {
            minHeap.push(it);
            if (minHeap.size() > required)
            {
                minHeap.pop();
            }
        }
    }

    int add(int val)
    {
        minHeap.push(val);
        if (minHeap.size() > required)
        {
            minHeap.pop();
        }
        return minHeap.top();
    }
};
void solve()
{
    vector<int> nums = {4, 5, 8, 2};
    KthLargest *largest = new KthLargest(3, nums);
    cout << largest->add(3);
    cout << largest->add(5);
    cout << largest->add(10);
    cout << largest->add(9);
    cout << largest->add(4);
}
int main()
{
    c_p_c();
    solve();
    return 0;
}