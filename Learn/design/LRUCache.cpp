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

private:
    int capacity;
    unordered_map<int, int> lruMap;
    deque<int> accessQueue; // using to refresh keys

public:
    LRUCache(int capacity)
    {
        accessQueue = deque<int>(capacity, -1);
        this->capacity = capacity;
    }

    int get(int key)
    {
        if (lruMap.find(key) != lruMap.end())
        {
            refresh(key);
            return lruMap[key];
        }
        return -1;
    }

    void put(int key, int value)
    {
        if (lruMap.find(key) != lruMap.end())
        {
            refresh(key);
        }
        else
        {
            accessQueue.push_back(key);
            manageCapacity();
        }
        lruMap[key] = value;
    }

    void refresh(int key)
    {
        // to check if the key exists and
        // to refresh the key by setting it to back of deque and
        // to remove the existing key from its current place
        for (auto it = accessQueue.begin(); it != accessQueue.end(); it++)
        {
            if (*it == key)
            {
                accessQueue.erase(it);
                accessQueue.push_back(key);
                break;
            }
        }
    }
    void manageCapacity()
    {
        // to check if accessqueue exceeds its capacity and to remove it from lrumap
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