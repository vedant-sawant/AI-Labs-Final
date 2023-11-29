#include <bits/stdc++.h>
using namespace std;
const int ROWS = 8;
const int COLS = 8;
const int EMPTY = 0;
const int BLOCKED = 1;
const int dx[] = {-1, 1, 0, 0};
const int dy[] = {0, 0, -1, 1};
struct Cell {
    int row, col;
    double f;
    Cell(int r, int c, double f) : row(r), col(c), f(f) {}
};
double heuristic(int row, int col, int endRow, int endCol) {
    return sqrt(pow(row - endRow, 2) + pow(col - endCol, 2));
}
bool bestFirstSearch(vector<vector<int>>& maze, int startRow, int startCol, int endRow, int endCol, vector<Cell>& path) {
    priority_queue<Cell, vector<Cell>, function<bool(Cell, Cell)>> pq( [](Cell a, Cell b) { return a.f > b.f; });
    vector<vector<bool>> visited(ROWS, vector<bool>(COLS, false));
    Cell startCell(startRow, startCol, heuristic(startRow, startCol, endRow, endCol));
    pq.push(startCell);
    vector<vector<Cell>> parent(ROWS, vector<Cell>(COLS, Cell(-1, -1, 0)));
    while (!pq.empty()) {
        Cell current = pq.top();
        pq.pop();

        int row = current.row;
    
        int col = current.col;

        if (row == endRow && col == endCol) {
            path.push_back(current);
            while (parent[row][col].row != -1 && parent[row][col].col != -1) {
                path.push_back(parent[row][col]);
                int newRow = parent[row][col].row;
                int newCol = parent[row][col].col;
                row = newRow;
                col = newCol;
            }

            return true;
        }
        visited[row][col] = true;

        for (int i = 0; i < 4; ++i) {
            int newRow = row + dx[i];
            int newCol = col + dy[i];

            if (newRow >= 0 && newRow < ROWS && newCol >= 0 && newCol < COLS && maze[newRow][newCol] == 0 && !visited[newRow][newCol]) {
                Cell next(newRow, newCol, heuristic(newRow, newCol, endRow, endCol));
                pq.push(next);
                visited[newRow][newCol] = true;
                parent[newRow][newCol] = current;
            }
        }
    }

    return false;
}

int main() {
    vector<vector<int>> maze = {
        {0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 1, 1, 1},
        {0, 0, 0, 0, 1, 0, 0, 0},
        {0, 1, 1, 1, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 1, 1, 1},
        {0, 1, 1, 1, 1, 1, 1, 1},
        {0, 0, 0, 0, 0, 1, 1, 1},
        {0, 1, 1, 1, 0, 0, 0, 0}
    };

    int startRow = 0;
    int startCol = 0;
    int endRow = 7;
    int endCol = 7;

    vector<Cell> path;
    if (bestFirstSearch(maze, startRow, startCol, endRow, endCol, path)) {
        cout << "Path found!" << endl;
        for (int i = path.size() - 1; i >= 0; --i) {
            cout << "(" << path[i].row << ", " << path[i].col << ") ";
        }
        cout << endl;
    } else {
        cout << "No path found." << endl;
    }
    return 0;
}
