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
    deque<long> dq;
    vector<long> nums;
    long maxIndex = 0;

    void clean_deque(long i, long k)
    {
        // remove elements out of current window ((i-k+1) till i)
        if (!dq.empty() && dq.front() == i - k)
        {
            dq.pop_front();
        }

        // remove all the elements less than the curr element
        while (!dq.empty() && nums[i] > nums[dq.back()])
        {
            dq.pop_back();
        }
    }

    vector<long> maxSlidingWindow(vector<long> &nums, long k)
    {
        long n = nums.size();
        if (n * k == 0)
            return vector<long>{0};
        if (k == 1)
            return nums;

        this->nums = nums;
        for (long i = 0; i < k; i++)
        {
            clean_deque(i, k);
            dq.push_back(i);
            if (nums[i] > nums[maxIndex])
                maxIndex = i;
        }
        vector<long> ans;
        ans.push_back(nums[maxIndex]);

        for (long i = k; i < n; i++)
        {
            clean_deque(i, k);
            dq.push_back(i);
            ans.push_back(nums[dq.front()]);
        }
        return ans;
    }
};
void solve()
{
    Solution *s = new Solution();
    vector<long> nums{1, 3, 1, 2, 0, 5};
    vector<long> sol = s->maxSlidingWindow(nums, 3);
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