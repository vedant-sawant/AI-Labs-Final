import java.util.PriorityQueue;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.Collections;

class Node {
    public final String value;
    public double g_scores;
    public final double h_scores;
    public double f_scores = 0;
    public Edge[] adjacencies; 
    public Node parent;

    public Node(String val, double hVal) {
        value = val;
        h_scores = hVal;
    }

    public String toString() {
        return value;
    }
}

class Edge {
    public final double cost;
    public final Node target;

    public Edge(Node targetNode, double costVal) {
        target = targetNode;
        cost = costVal;
    }
}

public class AStarRomaniaMap {
    public static void main(String[] args) {
        Node n1 = new Node("Arad", 366);
        Node n2 = new Node("Zerind", 374);
        Node n3 = new Node("Oradea", 380);
        Node n4 = new Node("Sibiu", 253);
        Node n5 = new Node("Fagaras", 178);
        Node n6 = new Node("Rimnicu Vilcea", 193);
        Node n7 = new Node("Pitesti", 98);
        Node n8 = new Node("Timisoara", 329);
        Node n9 = new Node("Lugoj", 244);
        Node n10 = new Node("Mehadia", 241);
        Node n11 = new Node("Drobeta", 242);
        Node n12 = new Node("Craiova", 160);
        Node n13 = new Node("Bucharest", 0);
        Node n14 = new Node("Giurgiu", 77);
        // Arad
        n1.adjacencies = new Edge[] {
                new Edge(n2, 75),
                new Edge(n4, 140),
                new Edge(n8, 118)
        };
        // Zerind
        n2.adjacencies = new Edge[] {
                new Edge(n1, 75),
                new Edge(n3, 71)
        };
        // Oradea
        n3.adjacencies = new Edge[] {
                new Edge(n2, 71),
                new Edge(n4, 151)
        };
        // Sibiu
        n4.adjacencies = new Edge[] {
                new Edge(n1, 140),
                new Edge(n5, 99),
                new Edge(n3, 151),
                new Edge(n6, 80),
        };
        // Fagaras
        n5.adjacencies = new Edge[] {
                new Edge(n4, 99),
                new Edge(n13, 211)
        };
        // Rimnicu Vilcea
        n6.adjacencies = new Edge[] {
                new Edge(n4, 80),
                new Edge(n7, 97),
                new Edge(n12, 146)
        };
        // Pitesti
        n7.adjacencies = new Edge[] {
                new Edge(n6, 97),
                new Edge(n13, 101),
                new Edge(n12, 138)
        };
        // Timisoara
        n8.adjacencies = new Edge[] {
                new Edge(n1, 118),
                new Edge(n9, 111)
        };
        // Lugoj
        n9.adjacencies = new Edge[] {
                new Edge(n8, 111),
                new Edge(n10, 70)
        };
        // Mehadia
        n10.adjacencies = new Edge[] {
                new Edge(n9, 70),
                new Edge(n11, 75)
        };
        // Drobeta
        n11.adjacencies = new Edge[] {
                new Edge(n10, 75),
                new Edge(n12, 120)
        };
        // Craiova
        n12.adjacencies = new Edge[] {
                new Edge(n11, 120),
                new Edge(n6, 146),
                new Edge(n7, 138)
        };
        // Bucharest
        n13.adjacencies = new Edge[] {
                new Edge(n7, 101),
                new Edge(n14, 90),
                new Edge(n5, 211)
        };
        // Giurgiu
        n14.adjacencies = new Edge[] {
                new Edge(n13, 90)
        };

        AstarSearch(n1, n13);

        List<Node> path = Path(n13);
        System.out.println("Path: " + path);

    }
    public static List<Node> AstarSearch(Node source, Node goal) {
        PriorityQueue<Node> openSet = new PriorityQueue<>(Comparator.comparingDouble(node -> node.f_scores));
        Set<Node> visited = new HashSet<>();
    
        source.g_scores = 0;
        source.f_scores = source.h_scores;
        openSet.add(source);
        
    
        while (!openSet.isEmpty()) {
            Node current = openSet.poll();
            if (current == goal) {
                return Path(current);
            }
            visited.add(current);
            for (Edge edge : current.adjacencies) {
                Node neighbor = edge.target;
                if (visited.contains(neighbor)) {
                    continue;
                }
    
                double temp_g = current.g_scores + edge.cost;

                if (!openSet.contains(neighbor)) {
                    neighbor.parent = current;
                    neighbor.g_scores = temp_g;
                    neighbor.f_scores = neighbor.g_scores + neighbor.h_scores;
                    
                    openSet.add(neighbor);
                }
            }
        }
        return Collections.emptyList();
    }
    
    public static List<Node> Path(Node target) {
        List<Node> path = new ArrayList<>();
        Node current = target;
        
        while (current != null) {
            path.add(current);
            current = current.parent;
        }
        Collections.reverse(path);
        return path;
    }
}