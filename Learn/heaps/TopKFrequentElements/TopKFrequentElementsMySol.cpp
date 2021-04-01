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
private:
    static bool cmp(pair<int, int> &a, pair<int, int> &b)
    {
        return a.second < b.second;
    }

public:
    vector<int> topKFrequent(vector<int> &nums, int k)
    {
        map<int, int> a;

        for (auto i : nums)
        {
            if (a.find(i) == a.end())
            {
                a[i] = 1;
            }
            else
            {
                a[i]++;
            }
        }
        vector<pair<int, int>> vect;
        for (auto &i : a)
        {
            vect.push_back(i);
        }

        sort(vect.begin(), vect.end(), cmp);
        vector<int> sol;
        for (int i = 0; i < k; i++)
        {
            pair<int, int> val1 = vect[i];
            sol.push_back(val1.first);
        }
        return sol;
    }
};

void solve()
{
    Solution *s = new Solution();
    vector<int> nums{4, 1, -1, 2, -1, 2, 3};
    vector<int> sol = s->topKFrequent(nums, 2);
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