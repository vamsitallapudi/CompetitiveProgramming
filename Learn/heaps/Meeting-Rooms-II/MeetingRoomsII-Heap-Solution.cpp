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
    struct Comparator
    {
        bool operator()(vector<int> &a, vector<int> &b)
        {
            return a[1] > b[1];
        }
    };

    struct Comparing
    {
        bool operator()(vector<int> a, vector<int> b)
        {
            return a[0] < b[0];
        }
    } myObject;

public:
    int minMeetingRooms(vector<vector<int>> &intervals)
    {
        if (intervals.empty())
            return 0;

        sort(intervals.begin(), intervals.end(), myObject);

        priority_queue<vector<int>, vector<vector<int>>, Comparator> minHeap;
        for (auto &x : intervals)
        {
            if (minHeap.empty())
            {
                minHeap.push(x);
            }
            else
            {
                if (x[0] >= minHeap.top()[1])
                {
                    vector<int> new_vect = {minHeap.top()[0], x[1]};
                    minHeap.pop();
                    minHeap.push(new_vect);
                }
                else
                {
                    minHeap.push(x);
                }
            }
        }
        return minHeap.size();
    }
};

void solve()
{
    vector<vector<int>> i;
    // [26,29],[19,26],[19,28],[4,19],[4,25]]
    vector<int> j{26, 29};
    vector<int> k{19, 26};
    vector<int> l{19, 28};
    vector<int> m{4, 19};
    vector<int> n{4, 25};
    i.push_back(j);
    i.push_back(k);
    i.push_back(l);
    i.push_back(m);
    i.push_back(n);
    Solution *x = new Solution();
    cout << x->minMeetingRooms(i);
}
int main()
{
    c_p_c();
    solve();
    return 0;
}