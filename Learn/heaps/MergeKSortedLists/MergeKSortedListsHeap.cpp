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

struct ListNode
{
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};

class Solution
{
private:
    pqs heap;

public:
    ListNode *mergeKLists(vector<ListNode *> &lists)
    {
        for (ListNode *i : lists)
        {
            while (i)
            {
                heap.push(i->val);
                i = i->next;
            }
        }

        ListNode *result = new ListNode();
        ListNode *temp = result;
        while (heap.size() > 0)
        {
            temp->next = new ListNode(heap.top());
            temp = temp->next;
            heap.pop();
        }
        return result->next;
    }
};

void solve()
{
    ListNode *a = new ListNode(5);
    ListNode *b = new ListNode(4, a);
    ListNode *c = new ListNode(1, b);

    ListNode *d = new ListNode(4);
    ListNode *e = new ListNode(3, d);
    ListNode *f = new ListNode(1, e);

    ListNode *g = new ListNode(6);
    ListNode *h = new ListNode(2, g);

    vector<ListNode *> vect;
    vect.push_back(c);
    vect.push_back(f);
    vect.push_back(h);

    Solution *sol = new Solution();
    ListNode *x = sol->mergeKLists(vect);
    while (x)
    {
        cout << x->val << endl;
        x = x->next;
    }
}
int main()
{
    c_p_c();
    solve();
    return 0;
}