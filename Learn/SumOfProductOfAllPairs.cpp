#include<iostream>
using namespace std;

int main() {
    int n;
    cin >>n;
    long long int sum = 0, sqsum = 0;

    for (int i=0; i<n;i++) {
        int x;
        cin >> x;
        sum += x;
        sqsum += x*x;  
    }
    cout<< ((sum*sum) - sqsum)/2 <<endl;
}