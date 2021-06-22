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
    // A doubly linked list node which consists of prev and next values
    struct DLNode
    {
        int key;
        int value;
        DLNode *prev;
        DLNode *next;
    };

    DLNode *head;
    DLNode *tail;
    int capacity;
    unordered_map<int, DLNode *> cache;

    // adding the new node always after the head
    void addNode(DLNode *node)
    {
        node->prev = head;
        node->next = head->next;
        node->next->prev = node;
        head->next->prev = node;
        head->next = node;
    }

    // removing the node from DLL
    void removeNode(DLNode *node)
    {
        if (node->prev)
            node->prev->next = node->next;
        if (node->next)
            node->next->prev = node->prev;
    }
    // move the node from any position to dummy head's next
    void moveToHead(DLNode *node)
    {
        removeNode(node);
        addNode(node);
    }
    // pop the original tail. its the node previous to the dummy tail
    DLNode *popTail()
    {
        DLNode *originalTail = tail->prev;
        removeNode(originalTail);
        return originalTail;
    }

public:
    LRUCache(int capacity)
    {
        this->capacity = capacity;
        head = new DLNode(); //dummy head
        tail = new DLNode(); // dummy tail
        head->prev = nullptr;
        head->next = tail;
        tail->prev = head;
        tail->next = nullptr;
    }

    int get(int key)
    {
        // if key is present, renew the DLL and return the value
        if (cache.find(key) != cache.end())
        {
            moveToHead(cache[key]);
            return cache[key]->value;
        }
        return -1;
    }

    void put(int key, int value)
    {
        if (cache.find(key) != cache.end())
        {
            // key found, update the value
            cache[key]->value = value;
            moveToHead(cache[key]);
        }
        else
        {
            // node not found
            // add the new key to cache and update head of DLL

            DLNode *newNode = new DLNode();
            newNode->key = key;
            newNode->value = value;
            moveToHead(newNode);
            cache[key] = newNode; //placing new node inside cache

            if (cache.size() > capacity)
            {
                DLNode *tailNode = popTail();
                cache.erase(tailNode->key);
            }
        }
    }
};

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache* obj = new LRUCache(capacity);
 * int param_1 = obj->get(key);
 * obj->put(key,value);
 */

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