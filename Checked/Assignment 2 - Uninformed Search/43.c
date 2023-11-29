#include <stdio.h>
#include <stdbool.h>

#define MAX 10

typedef struct {
    int data[MAX];
    int front;
    int rear;
} Queue;

void initQueue(Queue* q) {
    q->front = -1;
    q->rear = -1;
}

bool isEmpty(Queue* q) {
    return q->rear == -1;
}

void enqueue(Queue* q, int value) {
    if (q->rear == MAX - 1) {
        printf("Queue is full.\n");
    } else {
        if (q->front == -1) {
            q->front = 0;
        }
        q->rear++;
        q->data[q->rear] = value;
    }
}

int dequeue(Queue* q) {
    int item;
    if (isEmpty(q)) {
        printf("Queue is empty.\n");
        item = -1;
    } else {
        item = q->data[q->front];
        q->front++;
        if (q->front > q->rear) {
            q->front = q->rear = -1;
        }
    }
    return item;
}

void BFS(int adjMatrix[MAX][MAX], int vertices, int startVertex) {
    bool visited[MAX];
    for (int i = 0; i < vertices; i++) {
        visited[i] = false;
    }

    Queue q;
    initQueue(&q);

    visited[startVertex] = true;
    enqueue(&q, startVertex);

    printf("Breadth-First Search starting from vertex: %d\n", startVertex);

    while (!isEmpty(&q)) {
        int currentVertex = dequeue(&q);
        printf("%d ", currentVertex);

        for (int i = 0; i < vertices; i++) {
            if (adjMatrix[currentVertex][i] == 1 && !visited[i]) {
                visited[i] = true;
                enqueue(&q, i);
            }
        }
    }
    printf("\n");
}

void DFS(int adjMatrix[MAX][MAX], bool visited2[MAX], int vertices, int currentVertex) {
    visited2[currentVertex] = true;
    printf("%d ", currentVertex);

    for (int i = 0; i < vertices; i++) {
        if (adjMatrix[currentVertex][i] == 1 && !visited2[i]) {
            DFS(adjMatrix, visited2, vertices, i);
        }
    }
}

int main() {
    int vertices;
    printf("Enter the number of vertices: ");
    scanf("%d", &vertices);
    
    bool visited[MAX];
    bool visited2[MAX];
    
    for (int i = 0; i < vertices; i++) {
        visited[i] = false;
    }

    int adjMatrix[MAX][MAX];
    printf("Enter the adjacency matrix:\n");
    for (int i = 0; i < vertices; i++) {
        for (int j = 0; j < vertices; j++) {
            scanf("%d", &adjMatrix[i][j]);
        }
    }

    int startVertex;
    printf("Enter the starting vertex: ");
    scanf("%d", &startVertex);

    BFS(adjMatrix, vertices, startVertex);
    printf("Depth-First Search starting from vertex %d:\n", startVertex);
    DFS(adjMatrix, visited2, vertices, startVertex);

    return 0;
}
