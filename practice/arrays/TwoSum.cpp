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
    unordered_map<int, int> myMap;
    vector<int> sol;

public:
    vector<int> twoSum(vector<int> &nums, int target)
    {
        for (size_t i = 0; i < nums.size(); i++)
        {
            int numToFind = target - nums[i];
            // case -1 number was found
            if (myMap.find(numToFind) != myMap.end())
            {
                sol.push_back(myMap[numToFind]);
                sol.push_back(i);
            }
            else
            {
                // case -2  number was not found
                //  simply add this number to map
                myMap[nums[i]] = i;
            }
        }
        return sol;
    }
};

void solve()
{
    Solution *x = new Solution();
    vector<int> y{2, 7, 11, 15};
    vector<int> ans = x->twoSum(y, 9);
    for (auto i : ans)
    {
        cout << i;
        cout << '\n';
    }
}
int main()
{
    c_p_c();
    solve();
    return 0;
}