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
bool comp(int i, int j)
{
    return (i < j);
}
class Solution
{
public:
    priority_queue<int> maxHeap;
    vector<int> res;
    vector<int> maxSlidingWindow(vector<int> &nums, int k)
    {
        for (int i = 0, j = i + k; i < nums.size() - k, j < nums.size() + 1; i++, j++)
        {
            res.push_back(*max_element(nums.begin() + i, nums.begin() + j));
        }
        return res;
    }
};
void solve()
{
    Solution *s = new Solution();
    vector<int> nums{1, 3, -1, -3, 5, 3, 6, 7};
    vector<int> sol = s->maxSlidingWindow(nums, 3);
    for (auto &i : sol)
    {
        cout << i;
    }
}
int main()
{
    c_p_c();
    solve();
    return 0;
}