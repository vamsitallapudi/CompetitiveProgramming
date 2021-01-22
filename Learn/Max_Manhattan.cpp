#include<iostream>
using namespace std;

int main() {
    // variables -> buckets
    int n; //initialized a bucket. took input from user and stored in the bucket.
    cin>>n;
    int answer = 1 + 2*(n * (n+1));
    cout<<answer<<endl;
    return 0;
}