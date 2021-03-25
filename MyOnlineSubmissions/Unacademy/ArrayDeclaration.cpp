#include<bits/stdc++.h>
#include <ext/pb_ds/assoc_container.hpp>
using namespace __gnu_pbds;
using namespace std;

#define ff              first
#define ss              second
#define ll             long long
#define pb              push_back
#define mp              make_pair
#define pii             pair<int,int>
#define vi              vector<int>
#define mii             map<int,int>
#define pqb             priority_queue<int>
#define pqs             priority_queue<int,vi,greater<int> >
#define setbits(x)      __builtin_popcountll(x)
#define zrobits(x)      __builtin_ctzll(x)
#define mod             1000000007
#define inf             1e18
#define ps(x,y)         fixed<<setprecision(y)<<x
#define mk(arr,n,type)  type *arr=new type[n];
#define w(x)            int x; cin>>x; while(x--)
mt19937                 rng(chrono::steady_clock::now().time_since_epoch().count());

typedef tree<int, null_type, less<int>, rb_tree_tag, tree_order_statistics_node_update> pbds;

void   c_p_c()
{
    ios_base::sync_with_stdio(0); cin.tie(0); cout.tie(0);
#ifndef ONLINE_JUDGE
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
#endif
}

class vec {
    int *a;
    int size;
    int capacity;

public:
    vec(int x) {
        a = new int[x];
        capacity= x;
        size =0;
    }
    void resize() {
        int *temp = new int[capacity *2];
        capacity *=2;
        for(int i = 0; i< size;i++) {
            temp[i] = a[i];
        }
        delete a;
        a = temp;
    }

    void push_back(int val) {
        if(size+1 > capacity) {
            resize();
        }
        a[size++] = val;
    }

    int get(int index) {
        if(index >=0 && size > index) {
            return a[index];
        } else {
            cout<<"Array out of bounds";
            return -1;
        }
    }
    int get_size() {
        return size;
    }

    void print() {
        cout<<"size of array is " <<size<< ", capacity is " <<capacity<<endl;
        for(int i = 0; i<size;i++) {
            cout<< a[i];
        }
    }


};

void solve() {
    vec v(1);
    v.push_back(10);
    v.push_back(20);

}
int main()
{
    c_p_c();
    solve();
    return 0;
}