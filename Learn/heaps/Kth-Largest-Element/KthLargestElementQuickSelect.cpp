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
    vector<int> vect;

public:
    int partition(int left, int right, int pivot_index)
    {
        swap(vect[pivot_index], vect[right]);
        int my_index = left;
        for (int i = left; i < right; i++)
        {
            if (vect[i] < vect[right])
            {
                swap(vect[my_index], vect[i]);
                my_index++;
            }
        }
        swap(vect[right], vect[my_index]);
        return my_index;
    }
    void quickSelect(int left, int right, int k_smallest)
    {
        if (left == right)
            return;

        int n = vect.size();
        int pivot_index = left + rand() % (right - left + 1);
        pivot_index = partition(left, right, pivot_index);

        if (pivot_index == k_smallest)
        {
            // we got our element
            return;
        }
        else if (k_smallest < pivot_index)
        {
            quickSelect(left, pivot_index - 1, k_smallest);
        }
        else
        {
            quickSelect(pivot_index + 1, right, k_smallest);
        }
    }
    int findKthLargest(vector<int> &nums, int k)
    {
        vect = nums;
        int n = vect.size();
        // since kth largest = (n-k)th smallest
        quickSelect(0, n - 1, n - k);
        return vect[n - k];
    }
};

void solve()
{
    Solution *x = new Solution();
    vector<int> vect{3, 2, 3, 1, 2, 4, 5, 5, 6};
    cout << x->findKthLargest(vect, 4);
}
int main()
{
    c_p_c();
    solve();
    return 0;
}