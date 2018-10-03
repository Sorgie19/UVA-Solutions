#include<bits/stdc++.h>
using namespace std;
int main()
{
    int testCase; //Enter in amount of test cases
    cin >> testCase; //Number of test cases
    while(testCase > 0) //While test cases is above zero
    {
        vector<int> v; //Declaring vector
        int numOfResidents //number of residents
        cin>>numOfResidents; //Get user input of number of residents
        int streets[numOfResidents]; //Array of streets
        
        for(int i=0; i < numOfResidents; i++) //Get user input for streets
        {
            cin>>streets[i];
        }
        sort(streets, streets + numOfResidents); //Sort array streets
        int sum = 0; //Variable that holds sum of distance
        for(int i = 0; i < numOfResidents; i++)
        {
            for(int k = 0; k < numOfResidents; k++)
            { 
                sum += abs(streets[i] - streets[k]); //Itterators through and calculates each sum possibilty 
            }
        
            v.push_back(sum); //Adds the value sum to the vector
            sum=0; //resets the value of sum
        }
        
        int minimum =* min_element(v.begin(),v.end()); //Gets the minimum value of sum from vector

        cout << minimum << endl; //Print out Vito's house choice
        v.clear(); //Clear vector
        testCase--; //Decrement testCase
    }
    
    return 0; //Exit
}