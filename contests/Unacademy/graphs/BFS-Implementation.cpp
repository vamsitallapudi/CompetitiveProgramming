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
void bfs(int root, vector<vi> &adj, int n)
{
    // BFS
    vi parent(n + 1);
    parent[1] = 0;
    queue<int> q;
    q.push(1);
    while (!q.empty())
    {
        int curr = q.front();
        cout << curr << ' ';
        q.pop();
        for (int nb : adj[curr])
        {
            if (nb != parent[curr])
            {
                q.push(nb);
                parent[nb] = curr;
            }
        }
    }
}
void solve()
{
    int n;
    cin >> n;

    vector<vi> adj(n + 1);
    for (int i = 0; i < n - 1; ++i)
    {
        int u, v;
        cin >> u >> v;
        adj[u].pb(v);
        adj[v].pb(u);
    }

    // for (int i = 1; i <= n; ++i)
    // {
    //     for (int nb : adj[i])
    //         cout << nb << ' ';

    //     cout << '\n';
    // }

    bfs(1, adj, n);
}
int main()
{
    c_p_c();
    solve();
    return 0;
}