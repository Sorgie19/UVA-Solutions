#include <cstdio>
using namespace std;

bool Locate(int a, int b, int row, int col, char grid[51][51], char word[51])
{
    int x;
    for (x = 1; a - x >= 0 && word[x] == grid[a - x][b];)
    {
        x++;
        if (word[x] == '\0') return 1;
    }
    for (x = 1; a + x < row && word[x] == grid[a + x][b];)
    {
        x++;
        if (word[x] == '\0') return 1;
    }
    for (x = 1; b - x >= 0 && word[x] == grid[a][b - x];)
    {
        x++;
        if (word[x] == '\0') return 1;
    }
    for (x = 1; b + x < col && word[x] == grid[a][b + x];)
    {
        x++;
        if (word[x] == '\0') return 1;
    }
    for (x = 1; a - x >= 0 && b - x >= 0 && word[x] == grid[a - x][b - x];)
    {
        x++;
        if (word[x] == '\0') return 1;
    }
    for (x = 1; a + x < row && b - x >= 0 && word[x] == grid[a + x][b - x];)
    {
        x++;
        if (word[x] == '\0') return 1;
    }
    for (x = 1; a - x >= 0 && b + x < col && word[x] == grid[a - x][b + x];)
    {
        x++;
        if (word[x] == '\0') return 1;
    }
    for (x = 1; a + x < row && b + x < col && word[x] == grid[a + x][b + x];)
    {
        x++;
        if (word[x] == '\0') return 1;
    }
    return 0;
}

void casing(char word[])
{
    for (int i = 0; word[i]; i++)
    {
        if (word[i] >= 'A' && word[i] <= 'Z')
        {
            word[i] += 32;
        }
    }
}

int main()
{
    int testCase;
    int row;
    int col;
    int k;
    char grid[51][51];
    char word[51];
    
    scanf("%d", &testCase);
    while (testCase--)
    {
        scanf("%d%d", &row, &col);
        for (int i = 0; i < row; i++)
        {
            scanf("%s", grid[i]);
            casing(grid[i]);
        }

        scanf("%d", &k);
        while (k--)
        {
            scanf("%s", word);
            casing(word);
            int a;
            int b;
            int ok = 0;
            for (a = 0; !ok && a < row; a++)
                for (b = 0; !ok && b < col; b++)
                {
                    if (grid[a][b] == word[0] && Locate(a, b, row, col, grid, word))
                    {
                        printf("%d %d\n", a + 1, b + 1);
                        ok = 1;
                    }
                }
        }
        if (testCase)
        {
            printf("\n");
        }
    }
    return 0;
}