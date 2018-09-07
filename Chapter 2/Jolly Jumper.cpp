#include <iostream>
#include <algorithm>
#include <cmath>
using namespace std;

bool isJolly(int num[], int totalNums) //Boolean that determines if Jolly or not. Takes array and total amount of numbers to check
{
    int num2[3010]; //Array to hold abs value
    
    for(int i = 0; i < totalNums - 1; i++) //Get the abs value
    {
        num2[i] = abs(num[i+1] - num[i]);   
    }
    sort(num2, num2 + totalNums - 1); //Sort the array numerically
    
    for(int i = 0; i < totalNums - 1; i++) //itterate through sorted array and check if there are values from 1 to n-1
    {
        if(num2[i] != 1 + i)
            return false;
    }    
    return true; //Is a jolly jumper
}

int main()
{
    int totalNums; //Total amount of numbers to check for jolly jumpers       
    while(cin >> totalNums) //While there are more inputs
    {   
        int num[3010]; //Array to hold 3000
        for(int i = 0; i < totalNums; i++) //Get user inputs
        {
            cin >> num[i];   
        }
        if(isJolly(num, totalNums)) //If jolly, print Jolly
            cout << "Jolly" << endl;
        else
            cout << "Not jolly" << endl; //Else print not jolly        
    }
    return 0;
}