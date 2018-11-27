#include <stdio.h>
#include <math.h>

int main() 
{
    double a;
    while(scanf("%lf", &a) == 1) 
	{
		double Pi = acos(-1);
        double x;
		double y;
		double z;
        z = a * a - a * a * Pi / 4;
        z = z - (a * a * Pi / 4 - a * a *Pi / 6 - (a * a * Pi / 6 - a * a * sqrt(3.0) / 4));
        y = a * a - a * a * Pi / 4 - 2 * z;
        x = a * a - 4 * y - 4 * z;
        printf("%.3lf %.3lf %.3lf\n", x, 4 * y ,4 * z);
    }
    return 0;
}