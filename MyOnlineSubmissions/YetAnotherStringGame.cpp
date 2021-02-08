#include<iostream>
using namespace std;

void   c_p_c()
{
    ios_base::sync_with_stdio(0); cin.tie(0); cout.tie(0);
#ifndef ONLINE_JUDGE
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
#endif
}
void solve() {
    int n;
    cin >> n;
    for(int i= 0; i< n; i++) {
        string m;
        cin >> m;
        char* my_char = &m[0];
        int count =0;
        for(char* j = my_char; *j != '\0'; j++) {
            count +=1;
            int value = int(*j);
            if(count%2 == 0)  {
                // Bob's move
                if (value == int('z')) value = int('y');
                else value = int('z');
                cout<<char(value);
            }
            else {
                if (value <= int('a')) value = int('b');
                else value = int('a');
                cout << char(value);
            }
        }
        cout<< endl;
    }
}
int main()
{
    c_p_c();
    solve();
    return 0;
}