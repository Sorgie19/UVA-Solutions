#include <cstdio>
#include <iostream>

double distance(double x1, double y1, double x2, double y2) //Returns distance
{
    return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
}

int main()
{
    int n; //Number
    while (scanf("%d", &n) == 1) //Get number input
    {
        bool findHole = false; //Boolean to determine if gopher has a hole
        double gopherX; //Gopher x coord
        double gopherY; //Gopher y coord
        double dogX; //Dog x coord
        double dogY; //Dog y coord
        scanf("%lf%lf%lf%lf", &gopherX, &gopherY, &dogX, &dogY);//Gets all coords for gopher and dog
        
        while (n--)
        {
            double holeX; //Gopher hole x coord
            double holeY; //Gopher hole y coord
            scanf("%lf%lf", &holeX, &holeY); //gets gopher hole coords
            if (!findHole) //If find hole is false
            {
                if (4.0 * distance(gopherX, gopherY, holeX, holeY) <= distance(dogX, dogY, holeX, holeY)) 
                {
                    printf("The gopher can escape through the hole at (%.3lf,%.3lf).\n", holeX, holeY);
					findHole = true;
                }
            }
        }
        if (!findHole) //If the gopher cannot escape
        {
            std::cout << "The gopher cannot escape.\n";
        }
    }
    return 0;
}
