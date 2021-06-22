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
    vector<vector<int>> kClosest(vector<vector<int>> &points, int k)
    {
        int l = 0, r = points.size() - 1;

        while (true)
        {
            int p = partition(points, l, r);
            if (p == k - 1)
            {
                break;
            }
            if (p < k - 1)
            {
                l = p + 1;
            }
            else
            {
                r = p - 1;
            }
        }
        return vector<vector<int>>(points.begin(), points.begin() + k);
    }

private:
    bool farther(vector<int> &i, vector<int> &j)
    {
        return i[0] * i[0] + i[1] * i[1] > j[0] * j[0] + j[1] * j[1];
    }

    bool closer(vector<int> &i, vector<int> &j)
    {
        return i[0] * i[0] + i[1] * i[1] < j[0] * j[0] + j[1] * j[1];
    }
    int partition(vector<vector<int>> &points, int left, int right)
    {
        int pivot = left, l = left + 1, r = right;

        while (l <= r)
        {
            if (farther(points[l], points[pivot]) && closer(points[r], points[pivot]))
            {
                swap(points[l++], points[r--]);
            }
            if (!farther(points[l], points[pivot]))
            {
                l++;
            }
            if (!closer(points[r], points[pivot]))
            {
                r--;
            }
        }
        swap(points[pivot], points[r]); //swapped the points till r is reached. Till that r the elements are < pivot
        return r;                       // now that we swapped pivot, we are returning the position of pivot.
    }
};

void solve()
{
    vector<vector<int>> points{{1, 3}, {-2, 2}};
    Solution().kClosest(points, 1);
}
int main()
{
    c_p_c();
    solve();
    return 0;
}