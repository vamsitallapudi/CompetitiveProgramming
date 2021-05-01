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

class Solution
{
public:
    vector<int> topKFrequent(vector<int> &nums, int k)
    {
        vector<int> sol(k);
        map<int, int> freq;
        for (auto n : nums)
        {
            freq[n]++;
        }
        auto comp = [&freq](int a, int b) {
            return freq[a] > freq[b];
        };
        priority_queue<int, vector<int>, decltype(comp)> minHeap(comp);
        for (auto i : freq)
        {
            minHeap.push(i.first);
            if (minHeap.size() > k)
            {
                minHeap.pop();
            }
        }
        for (int i = k - 1; i >= 0; i--)
        {
            sol[i] = minHeap.top();
            minHeap.pop();
        }
        return sol;
    }
};

void solve()
{
    Solution *x = new Solution();
    vector<int> y = {1, 1, 1, 2, 3, 3, 4};
    vector<int> ans = x->topKFrequent(y, 2);
    for (auto i : ans)
    {
        cout << i << "\n";
    }
}
int main()
{
    c_p_c();
    solve();
    return 0;
}