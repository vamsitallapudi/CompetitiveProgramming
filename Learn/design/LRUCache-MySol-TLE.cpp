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

class LRUCache
{
    struct Node
    {
        int value = -1;
    };
    int capacity;
    map<int, Node> lruMap;
    deque<int> accessQueue;

public:
    LRUCache(int capacity)
    {
        this->capacity = capacity;
    }

    int get(int key)
    {
        if (lruMap[key].value == -1)
            return -1;
        cleanUp(key);
        return lruMap[key].value;
    }

    void put(int key, int value)
    {
        this->lruMap[key].value = value;
        cleanUp(key);
    }

    void cleanUp(int key)
    {
        for (int i = 0; i < accessQueue.size(); i++)
        {
            if (accessQueue[i] == key)
            {
                accessQueue.erase(accessQueue.begin() + i);
            }
        }
        accessQueue.push_back(key);
        if (accessQueue.size() > capacity)
        {
            int x = accessQueue.front();
            lruMap.erase(x);
            accessQueue.pop_front();
        }
    }
};

void solve()
{
    // ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
    // [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
    LRUCache *cache = new LRUCache(2);
    cache->put(1, 1);
    cache->put(2, 2);
    cout << cache->get(1);
    cache->put(3, 3);
    cout << cache->get(2);
    cache->put(4, 4);
    cout << cache->get(1);
    cout << cache->get(3);
    cout << cache->get(4);
}
int main()
{
    c_p_c();
    solve();
    return 0;
}