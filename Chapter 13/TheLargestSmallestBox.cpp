#include <cmath>
#include <cstdio>
using namespace std;

int main()
{
	double length;
	double width;
	double min;
	double max;
	while(scanf("%lf %lf",&length,&width)==2)
	{
		if(width < length)
			min = (width / 2.0);
		else
			min = (length / 2.0);
		max = (length + width - sqrt(length * length + width * width - length * width))/6.0;
		printf("%.3f 0.000 %.3f\n",max + 1e-6, min + 1e-6);
	}
	return 0;
}
