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
    vector<int> unique;
    map<int, int> freq_map;

public:
    // Lomuto Partition Algorithm
    int partition(int left, int right, int pivot_index)
    {
        int pivot_freq = freq_map[unique[right]];
        // move the value from pivot index to end
        swap(unique[pivot_index], unique[right]);

        int sortedIndex = left;

        for (size_t i = left; i < right; i++)
        {
            if (freq_map[unique[i]] < freq_map[unique[right]])
            {
                swap(unique[i], unique[sortedIndex]);
                sortedIndex++;
            }
        }

        swap(unique[sortedIndex], unique[right]);
        return sortedIndex;
    }

    void quickSelect(int left, int right, int smallest)
    {
        if (left == right)
        {
            return;
        }
        int pivot_index = left + rand() % (right - left + 1);
        int pivot_index_loc = partition(left, right, pivot_index);

        if (smallest == pivot_index_loc)
        {
            return;
        }
        else if (pivot_index_loc < smallest)
        {
            quickSelect(pivot_index_loc + 1, right, smallest);
        }
        else
        {
            quickSelect(left, pivot_index_loc - 1, smallest);
        }
    }

    vector<int> topKFrequent(vector<int> &nums, int k)
    {
        for (int i : nums)
        {
            freq_map[i]++;
        }
        for (pair<int, int> i : freq_map)
        {
            unique.push_back(i.first);
        }

        int n = freq_map.size();
        quickSelect(0, n - 1, n - k);
        vector<int> ans(k);
        copy(unique.begin() + (n - k), unique.end(), ans.begin());
        return ans;
    }
};

void solve()
{
    Solution *s = new Solution();
    vector<int> a = {1, 1, 2, 2, 3, 4};
    vector<int> ans = s->topKFrequent(a, 2);
    for (int i : ans)
    {
        cout << i << endl;
    }
}
int main()
{
    c_p_c();
    solve();
    return 0;
}