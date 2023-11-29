#include <iostream>
using namespace std;

char square[10] = {'o','1','2','3','4','5','6','7','8','9'};

int win();
void board();
int minimax(bool isMaximizing);
int findBestMove();

int main()
{
    int player = 1, choice;
    char mark;

    do
    {
        board();
        player = (player % 2) ? 1 : 2;

        if (player == 1)
        {
            cout << "Player 1, enter a number:  ";
            cin >> choice;
            mark = 'X';
        }
        else
        {
            // AI's turn
            choice = findBestMove();
            mark = 'O';
        }

        if (choice >= 1 && choice <= 9 && square[choice] == '0' + choice)
            square[choice] = mark;
        else
        {
            cout << "Invalid move! Try again.\n";
            player--;
        }

        int result = win();
        if (result == 1)
        {
            board();
            cout << "============================================\n";
            if (player == 1)
                cout << "Congrats! Player 1 (X) wins!\n";
            else
                cout << "AI (O) wins!\n";
            break;
        }
        else if (result == 0)
        {
            board();
            cout << "============================================\n";
            cout << "It's a draw!\n";
            break;
        }
        player++;
    } while (1);

    cin.ignore();
    cin.get();
    return 0;
}

int win()
{
     if (square[1] == square[2] && square[2] == square[3])

        return 1;
    else if (square[4] == square[5] && square[5] == square[6])

        return 1;
    else if (square[7] == square[8] && square[8] == square[9])

        return 1;
    else if (square[1] == square[4] && square[4] == square[7])

        return 1;
    else if (square[2] == square[5] && square[5] == square[8])

        return 1;
    else if (square[3] == square[6] && square[6] == square[9])

        return 1;
    else if (square[1] == square[5] && square[5] == square[9])

        return 1;
    else if (square[3] == square[5] && square[5] == square[7])

        return 1;
    else if (square[1] != '1' && square[2] != '2' && square[3] != '3'
                    && square[4] != '4' && square[5] != '5' && square[6] != '6'
                  && square[7] != '7' && square[8] != '8' && square[9] != '9')

        return 0;
    else
        return -1;
}

void board()
{
    system("cls");
     cout << "============================================";
    cout << "\n\n\tTic Tac Toe\n\n";
     cout << "============================================\n\n";

    cout << "X - Sign for Player 1\n0 - Sign for Player 2(AI)" << endl << endl;
    cout << endl;

    cout << "     |     |     " << endl;
    cout << "  " << square[1] << "  |  " << square[2] << "  |  " << square[3] << endl;

    cout << "_____|_____|_____" << endl;
    cout << "     |     |     " << endl;

    cout << "  " << square[4] << "  |  " << square[5] << "  |  " << square[6] << endl;

    cout << "_____|_____|_____" << endl;
    cout << "     |     |     " << endl;

    cout << "  " << square[7] << "  |  " << square[8] << "  |  " << square[9] << endl;

    cout << "     |     |     " << endl << endl;
}

int minimax(bool isMaximizing)
{
    int result = win();

    if (result != -1)
    {
        if (result == 0)
            return 0;
        else if (result == 1)
            return (isMaximizing) ? -1 : 1;
    }

    if (isMaximizing)
    {
        int bestScore = -10;
        for (int i = 1; i <= 9; i++)
        {
            if (square[i] == '0' + i)
            {
                square[i] = 'O';
                int score = minimax(false);
                square[i] = '0' + i;
                bestScore = max(bestScore, score);
            }
        }
        return bestScore;
    }
    else
    {
        int bestScore = 10;
        for (int i = 1; i <= 9; i++)
        {
            if (square[i] == '0' + i)
            {
                square[i] = 'X';
                int score = minimax(true);
                square[i] = '0' + i;
                bestScore = min(bestScore, score);
            }
        }
        return bestScore;
    }
}

int findBestMove()
{
    int bestMove = -1;
    int bestScore = INT_MIN;
    for (int i = 1; i <= 9; i++)
    {
        if (square[i] == '0' + i)
        {
            square[i] = 'O';
            int score = minimax(false);
            square[i] = '0' + i;
            if (score > bestScore)
            {
                bestScore = score;
                bestMove = i;
            }
        }
    }
    return bestMove;
}
