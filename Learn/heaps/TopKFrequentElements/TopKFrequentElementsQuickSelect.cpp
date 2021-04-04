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
    vector<int> unique;
    map<int, int> freq_map;

public:
    // Lomuto partition scheme

    /*
        To do the partial sort of the given unique array such that the given
        pivot_index value is set to its correct position along with the less freq
        elements than the value in pivot_index are towards left of this position &
        greater value is towards right of this position.

        Returns the new position of pivot_index's value after 
        frequencies based swapping is done.
     */
    int partition(int left, int right, int pivot_index)
    {
        int pivot_freq = freq_map[unique[pivot_index]];

        // 1. move pivot value to the end
        swap(unique[pivot_index], unique[right]);

        // 2. set a pointer at begin of array
        int store_index = left;

        // 3. Iterate and swap less freq elements to left
        for (int i = left; i <= right; i++)
        {
            if (freq_map[unique[i]] < pivot_freq)
            {
                swap(unique[store_index], unique[i]);
                store_index++;
            }
        }
        // 4. Moving pivot to final place
        swap(unique[right], unique[store_index]);
        return store_index;
    }

    /*
     Sort a list within left..right till kth less frequent element

    */
    void quickSelect(int left, int right, int k_smallest)
    {
        // recursion breaking base case -> list contains only 1 element
        if (left == right)
            return;
        // generating a random pivot between left and right values
        int pivot_index = left + rand() % (right - left + 1);

        // finding the given generated pivot's position in a partially sorted list
        pivot_index = partition(left, right, pivot_index);

        // check if the pivot is in its final sorted position
        if (k_smallest == pivot_index)
        {
            return;
        }
        else if (k_smallest < pivot_index)
        {
            // moving left
            quickSelect(left, pivot_index - 1, k_smallest);
        }
        else
        {
            // moving right
            quickSelect(pivot_index + 1, right, k_smallest);
        }
    }

    // solution using quick select
    vector<int> topKFrequent(vector<int> &nums, int k)
    {
        // building hashmap
        for (int n : nums)
        {
            freq_map[n]++;
        }
        // getting array of unique elements
        int n = freq_map.size();
        for (pair<int, int> val : freq_map)
        {
            unique.push_back(val.first);
        }
        // kth top frequent element is (n-k)th less frequent
        // Do a partial sort: from less frequent to the most frequent, till
        // (n - k)th less frequent element takes its place (n - k) in a sorted array.
        // All element on the left are less frequent.
        // All the elements on the right are more frequent.
        quickSelect(0, n - 1, n - k);

        // return top k frequent elements
        vector<int> k_freq(k);
        copy(unique.begin() + (n - k), unique.end(), k_freq.begin());
        return k_freq;
    }
};

void solve()
{
    Solution *s = new Solution();
    vector<int> nums{4, 1, -1, 2, -1, 2, 3};
    vector<int> sol = s->topKFrequent(nums, 2);
    for (auto &i : sol)
    {
        cout << i << " ";
    }
}

int main()
{
    c_p_c();
    solve();
    return 0;
}