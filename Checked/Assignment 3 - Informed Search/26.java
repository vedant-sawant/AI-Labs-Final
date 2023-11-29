import java.util.*;

class Node {
    String name;
    int heuristic;
    int cost;

    public Node(String name, int heuristic, int cost) {
        this.name = name;
        this.heuristic = heuristic;
        this.cost = cost;
    }
}

public class AStar {
    public static Map<String, List<Node>> graph = new HashMap<>();

    public static void addEdge(String from, String to, int cost) {
        graph.computeIfAbsent(from, k -> new ArrayList<>()).add(new Node(to, 0, cost));
        graph.computeIfAbsent(to, k -> new ArrayList<>()).add(new Node(from, 0, cost));
    }

    public static List<String> aStar(String start, String goal) {
        Map<String, String> cameFrom = new HashMap<>();
        Map<String, Integer> gScore = new HashMap<>();
        Map<String, Integer> fScore = new HashMap<>();

        PriorityQueue<Node> openSet = new PriorityQueue<>(Comparator.comparingInt(node -> fScore.getOrDefault(node.name, Integer.MAX_VALUE)));
        openSet.add(new Node(start, 0, 0));

        gScore.put(start, 0);
        fScore.put(start, gScore.get(start) + heuristicEstimate(start, goal));

        while (!openSet.isEmpty()) {
            Node current = openSet.poll();

            if (current.name.equals(goal)) {
                return reconstructPath(cameFrom, current.name);
            }

            for (Node neighbor : graph.get(current.name)) {
                int tentativeGScore = gScore.get(current.name) + neighbor.cost;

                if (tentativeGScore < gScore.getOrDefault(neighbor.name, Integer.MAX_VALUE)) {
                    cameFrom.put(neighbor.name, current.name);
                    gScore.put(neighbor.name, tentativeGScore);
                    fScore.put(neighbor.name, gScore.get(neighbor.name) + heuristicEstimate(neighbor.name, goal));
                    openSet.add(new Node(neighbor.name, fScore.get(neighbor.name), gScore.get(neighbor.name)));
                }
            }
        }

        return null; // No path found
    }

    public static int heuristicEstimate(String from, String to) {
        // Hardcoded heuristic values
        Map<String, Integer> heuristicValues = new HashMap<>();
        heuristicValues.put("A", 10);
        heuristicValues.put("B", 8);
        heuristicValues.put("C", 6);
        heuristicValues.put("D", 7);
        heuristicValues.put("E", 5);
        heuristicValues.put("F", 3);
        heuristicValues.put("G", 9);
        heuristicValues.put("H", 4);
        heuristicValues.put("I", 3);
        heuristicValues.put("J", 5);
        heuristicValues.put("K", 7);
        heuristicValues.put("L", 4);

        return heuristicValues.getOrDefault(from, 0);
    }

    public static List<String> reconstructPath(Map<String, String> cameFrom, String current) {
        List<String> path = new ArrayList<>();
        while (current != null) {
            path.add(current);
            current = cameFrom.get(current);
        }
        Collections.reverse(path);
        return path;
    }

    public static void main(String[] args) {
        addEdge("A", "B", 4);
        addEdge("A", "C", 8);
        addEdge("B", "D", 5);
        addEdge("B", "E", 10);
        addEdge("C", "F", 12);
        addEdge("D", "G", 7);
        addEdge("E", "H", 5);
        addEdge("F", "I", 3);
        addEdge("G", "J", 4);
        addEdge("H", "K", 8);
        addEdge("I", "L", 7);
        addEdge("B", "C", 3);
        addEdge("D", "E", 2);
        addEdge("G", "H", 4);
        addEdge("I", "J", 2);

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the start node: ");
        String startNode = scanner.nextLine();

        System.out.print("Enter the goal node: ");
        String goalNode = scanner.nextLine();

        List<String> shortestPath = aStar(startNode, goalNode);
        if (shortestPath != null) {
            System.out.println("Shortest Path from " + startNode + " to " + goalNode + ": " + shortestPath);
        } else {
            System.out.println("No path found from " + startNode + " to " + goalNode);
        }

        scanner.close();
    }
}
