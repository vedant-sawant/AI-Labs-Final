
import java.util.*;

public class uniformed_search2 {
    public static class edge {
        int source;
        int destination;

        public edge(int s, int d) {
            this.source = s;
            this.destination = d;
        }

    }

    public static void DFS(ArrayList<edge> graph[], int V) {
        Scanner sc = new Scanner(System.in);
        System.out.println("---Please enter Starting vertex----");
        int start = sc.nextInt();
        Boolean visited[] = new Boolean[V];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }
        Stack<Integer> s = new Stack();
        s.push(start);
        while (!s.isEmpty()) {
            int vertex = s.pop();
            if (visited[vertex] == false) {
                System.out.print(vertex + " ");
                visited[vertex] = true;
                for (int i = graph[vertex].size() - 1; i >= 0; i--) {
                    edge e = graph[vertex].get(i);
                    if (visited[e.destination] == false) {
                        s.push(e.destination);
                    }
                }
            }
        }

    }

    public static void BFS(ArrayList<edge> graph[], int V) {
        Scanner sc = new Scanner(System.in);
        System.out.println("---Please enter Starting vertex---");
        int start = sc.nextInt();
        Boolean visited[] = new Boolean[V];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        while (!q.isEmpty()) {
            int vertex = q.remove();
            if (visited[vertex] == false) {
                System.out.print(vertex + " ");
                visited[vertex] = true;
                for (int i = 0; i < graph[vertex].size(); i++) {
                    edge e = graph[vertex].get(i);
                    if (visited[e.destination] == false) {
                        q.add(e.destination);
                    }
                }
            }
        }
    }

    public static void creategraph(ArrayList<edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<edge>();
        }
        graph[0].add(new edge(0, 2));
        graph[0].add(new edge(0, 6));

        graph[1].add(new edge(1, 4));
        graph[1].add(new edge(1, 5));
        graph[1].add(new edge(1, 6));

        graph[2].add(new edge(2, 0));
        graph[2].add(new edge(2, 4));

        graph[3].add(new edge(3, 4));
        graph[3].add(new edge(3, 5));

        graph[4].add(new edge(4, 1));
        graph[4].add(new edge(4, 2));
        graph[4].add(new edge(4, 3));

        graph[5].add(new edge(5, 1));
        graph[5].add(new edge(5, 3));
        graph[5].add(new edge(5, 7));

        graph[6].add(new edge(6, 0));
        graph[6].add(new edge(6, 1));

        graph[7].add(new edge(7, 5));

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int V = 8;
        ArrayList<edge> graph[] = new ArrayList[V];
        creategraph(graph);
        System.out.println("BFS Traversal : ");
        BFS(graph, V);
        System.out.println("\nDFS Traversal : ");
        DFS(graph, V);

    }
}