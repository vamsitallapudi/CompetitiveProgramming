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

class MaxHeap {
    private:
        int _size{};
        vector<int> vect = {-1};

        int p(int i) { return i>>1;} //right shifting by 1 equivalent to i/2 = parent
        int l(int i) { return i<<1;} //left shifting by 1 equivalent to i*2 = left child
        int r (int i) {return (i<<1) + 1;} // for right child (left shift + 1) = right child

    public:
        bool isEmpty() const {return _size == 0;};
        int getMax() const{return vect[1];};
        int extractMax();
        void insertItem(int val);
        void shiftUp(int i);
        void shiftDown(int i);

};

void MaxHeap::shiftUp(int i) {
    if(i > _size) return;
    if(i==1) return;
    if(vect[i] > vect[p(i)]) {
        swap(vect[p(i)], vect[i]);
    }
    shiftUp(p(i));
}
void MaxHeap::shiftDown(int i) {
    if(i > _size) return;
    int swapId = i;
    if(l(i) <= _size && vect[i] < vect[l(i)]) {
        swapId = l(i);
    }
    if(r(i)<= _size && vect[swapId] < vect[r(i)]){
        swapId = r(i);
    }
    if(swapId != i)  {
        swap(vect[i], vect[swapId]);
        shiftDown(swapId);
    }
    return;
}

void MaxHeap::insertItem(int val) {
    if(_size + 1 >= vect.size()) {
        vect.push_back(0);
    }
    vect[++_size] = val;
    shiftUp(_size);
    return;
}

int MaxHeap::extractMax() {
    int maxNum = vect[1];
    swap(vect[1], vect[_size--]);
    shiftDown(1);
    return maxNum;
}

void solve() {
    MaxHeap* priorityQueue = new MaxHeap();
    if(priorityQueue ->isEmpty()) {
        cout<< "Yes It is empty"<<endl;
    } else {
        cout << "error creating priority queue"<<endl;
    }
    priorityQueue->insertItem(10);
    priorityQueue->insertItem(120);
    priorityQueue->insertItem(34);
    priorityQueue->insertItem(41);
    priorityQueue->insertItem(39);
    priorityQueue->insertItem(5);
    cout << priorityQueue->getMax() << endl;
    priorityQueue->extractMax();
    cout << priorityQueue->getMax()<<endl;
    priorityQueue->extractMax();
    cout << priorityQueue->getMax()<<endl;
    priorityQueue->extractMax();
    cout << priorityQueue->getMax()<<endl;
    priorityQueue->extractMax();
    cout << priorityQueue->getMax()<<endl;
    priorityQueue->extractMax();
    cout << priorityQueue->getMax()<<endl;
}
int main()
{
    c_p_c();
    solve();
    return 0;
}