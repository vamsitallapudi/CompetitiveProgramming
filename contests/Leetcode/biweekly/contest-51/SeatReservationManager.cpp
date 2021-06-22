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

class SeatManager
{
public:
    vector<int> values;
    SeatManager(int n)
    {
        for (int i = 0; i < n; i++)
        {
            values.push_back(i);
        }
    }

    int reserve()
    {
        int ans;
        for (int i = 0; i < values.size(); i++)
        {
            if (values[i] != -1)
            {
                ans = values[i];
                values[i] = -1;
            }
        }
        return ans;
    }

    void unreserve(int seatNumber)
    {
        if (find(values.begin(), values.end(), seatNumber) == values.end())
        {
            // element found
            values[seatNumber--] = seatNumber;
        }
    }
};

void solve()
{
}
int main()
{
    c_p_c();
    solve();
    return 0;
}