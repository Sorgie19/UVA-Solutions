#include <iostream>
using namespace std;
int main()
{
    int n;
    while(cin >> n)
    {
        int a = 0;
        int b = 1;
        
        while(b < n)
        {
            a++;
            b+=6*a;
        }
        
        int y = 0;
        int x = a;
        
        while(b != n)
        {
            while(b != n && y + a != 0)
            {
				b--;
                y--;
            }
            
            while(b != n && x != 0)
            {
				b--;
                x--;
            }
			
            while(b !=n && y != 0)
            {
				b--;
                x--;
                y++;
            }
            while(b !=n && y != a)
            {
				b--;
                y++;
            }
            while(b !=n && x != 0)
            {
				b--;
                x++;
            }
            while(b != n && x != a)
            {
				b--;
                x++;
                y--;
            }
        }
        cout<<x<<' '<<y<<endl;
    }
}