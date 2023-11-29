package com.tanu;

import java.util.*;

class graphNode {
    int value;
    List<graphNode> connect;

    graphNode(int value) {
        this.value = value;
        connect = new ArrayList<>();
    }
}

public class BFS_DFS {
    public static void bfs(graphNode startNode) {
        Queue<graphNode> queue = new LinkedList<>();
        Set<graphNode> visited = new HashSet<>();

        queue.add(startNode);
        visited.add(startNode);
        while (!queue.isEmpty()) {
            graphNode current = queue.poll();
            System.out.print(current.value + " ");

            for (graphNode neighbor : current.connect) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                }
            }
        }
    }

    public static void dfs(graphNode start) {
        Stack<graphNode> stack = new Stack<>();
        Set<graphNode> visited = new HashSet<>();

        stack.push(start);

        while (!stack.isEmpty()) {
            graphNode current = stack.pop();
            if (!visited.contains(current)) {
                System.out.print(current.value + " ");
                visited.add(current);

                for (graphNode neighbour_node : current.connect) {
                    if (!visited.contains(neighbour_node)) {
                        stack.push(neighbour_node);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);

        graphNode node40 = new graphNode(40);
        graphNode node10 = new graphNode(10);
        graphNode node20 = new graphNode(20);
        graphNode node30 = new graphNode(30);
        graphNode node60 = new graphNode(60);
        graphNode node50 = new graphNode(50);
        graphNode node70 = new graphNode(70);
        graphNode node80 = new graphNode(80);
        graphNode node35 = new graphNode(35);

        node40.connect.add(node10);
        node40.connect.add(node20);
        node10.connect.add(node30);
        node20.connect.add(node10);
        node20.connect.add(node30);
        node20.connect.add(node60);
        node20.connect.add(node50);
        node30.connect.add(node60);
        node60.connect.add(node80);
        node50.connect.add(node70);
        node70.connect.add(node80);
        node70.connect.add(node35);
        node80.connect.add(node35);

        System.out.println("Enter your choice: 1.BFS(Breadth First Search) 2.DFS(Depth First Search):");
        int n =sc.nextInt();

        graphNode start = node40;

        switch (n) {
            case 1:
                System.out.print("BFS traversal of the graph: ");
                bfs(start);
                break;
            case 2:
                System.out.print("DFS traversal of the graph: ");
                dfs(start);
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
    }
}