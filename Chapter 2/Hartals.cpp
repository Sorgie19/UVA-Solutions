#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main()
{
    vector<int> h;
    int testCases;
    cin >> testCases;
    for (int testCase = 0; testCase < testCases; testCase++)
    {
        int days;
        int parties;
        cin >> days; //Get days
        cin >> parties; //Get amount of parties
        int hartal[parties]; //Array to hold hartal numbers
        for (int i = 0; i < parties; i++)
        {
            cin >> hartal[i]; //Get hartal numbers
        }

        for (int i = 0; i < parties; i++)
        {
            for (int j = 1; j < days + 1; j++)
            {
                if ((j % hartal[i] == 0) && (j % 7 != 0) && (j % 7 != 6))
                {
                    if (find(h.begin(), h.end(), j) == h.end())
                    {
                        h.push_back(j);
                    }
                    else if (h.empty())
                    {
                        h.push_back(j);
                    }
                }
            }
        }
        cout << h.size() << endl;
        h.clear();
    }
}