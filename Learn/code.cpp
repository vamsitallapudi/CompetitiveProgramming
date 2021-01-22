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

int main()
{
	c_p_c();
    // int n;
    // cin>>n;
    // int x = (n-1)/3; // multiples_of_3
    // int y = (n-1)/5; // multiples_of_5
    // int z = (n-1)/15; // multiples_of_15

    // int sum_for_3 = (x * (2*3 + (x-1)*3))/2;  //we wrote like this due to precedence
    // int sum_for_5 = (y * (2*5 + (y-1)*5))/2;  //we wrote like this due to precedence
    // int sum_for_15 = (z * (2*15 + (z-1)*15))/2;  //we wrote like this due to precedence
    // int ans = (sum_for_3 + sum_for_5 - sum_for_15);
    int n;
    cout<<sizeof(n)<<endl;
	return 0;
}