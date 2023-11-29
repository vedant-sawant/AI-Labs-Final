package com.tanu;

import java.util.*;

public class AStar {

    public static class Node {
        private String name;
        private double hScores;
        private List<Edge> neighbors;
        private double fScore;

        public Node(String name, double hScores) {
            this.name = name;
            this.hScores = hScores;
            this.neighbors = new ArrayList<>();
        }

        public void addNeighbor(Node neighbor, double cost) {
            neighbors.add(new Edge(neighbor, cost));
        }

        public String getName() {
            return name;
        }

        public double getHScores() {
            return hScores;
        }

        public void setFScore(double fScore) {
            this.fScore = fScore;
        }

        public double getFScore() {
            return fScore;
        }

        public List<Edge> getNeighbors() {
            return neighbors;
        }
    }

    public static class Edge {
        private Node target;
        private double cost;

        public Edge(Node target, double cost) {
            this.target = target;
            this.cost = cost;
        }

        public Node getTarget() {
            return target;
        }

        public double getCost() {
            return cost;
        }
    }

    public static List<Node> aStar(Node start, Node goal) {
        PriorityQueue<Node> openSet = new PriorityQueue<>(Comparator.comparingDouble(node -> node.getFScore()));
        Set<Node> closedSet = new HashSet<>();
        Map<Node, Node> cameFrom = new HashMap<>();
        Map<Node, Double> gScore = new HashMap<>();

        gScore.put(start, 0.0);
        start.setFScore(gScore.get(start) + start.getHScores());
        openSet.add(start);

        while (!openSet.isEmpty()) {
            Node current = openSet.poll();

            if (current.equals(goal)) {
                return reconstructPath(cameFrom, current, start);
            }

            closedSet.add(current);

            for (Edge edge : current.getNeighbors()) {
                Node neighbor = edge.getTarget();

                if (closedSet.contains(neighbor)) {
                    continue;
                }

                double tentativeGScore = gScore.get(current) + edge.getCost();

               if (!openSet.contains(neighbor) || tentativeGScore < gScore.get(neighbor)) {
                    cameFrom.put(neighbor, current);
                    gScore.put(neighbor, tentativeGScore);
                    neighbor.setFScore(gScore.get(neighbor) + neighbor.getHScores());

                    if (!openSet.contains(neighbor)) {
                        openSet.add(neighbor);
                    } else {
                        openSet.remove(neighbor);
                        openSet.add(neighbor);
                    }
                }
            }
        }

        return null;
    }

    public static List<Node> reconstructPath(Map<Node, Node> cameFrom, Node current, Node goal) {
        List<Node> path = new ArrayList<>();
        boolean reachedGoal = false;

        while (current != null) {
            path.add(current);
            if (current.equals(goal)) {
                reachedGoal = true;
                break;
            }
            current = cameFrom.get(current);
        }

        if (reachedGoal) {
            Collections.reverse(path);
            return path;
        } else {
            return null;
        }
    }



    public static void main(String[] args) {
        Node a = new Node("A", 10);
        Node b = new Node("B", 8);
        Node f = new Node("F", 6);
        Node d = new Node("D", 7);
        Node c = new Node("C", 5);
        Node g = new Node("G", 5);
        Node e = new Node("E", 3);
        Node i = new Node("I", 1);
        Node h = new Node("H", 3);
        Node j = new Node("J", 0);

        a.addNeighbor(b,6);
        a.addNeighbor(f, 3);

        b.addNeighbor(c, 3);
        b.addNeighbor(d, 2);

        f.addNeighbor(g, 1);
        f.addNeighbor(h, 7);

        d.addNeighbor(c, 1);
        d.addNeighbor(e, 8);
        c.addNeighbor(e, 5);

        g.addNeighbor(i, 3);
        h.addNeighbor(i, 2);

        i.addNeighbor(e,5);
        i.addNeighbor(j, 3);
        e.addNeighbor(j, 5);

        List<Node> path = aStar(a, j);
        if (path != null) {
            System.out.println("Shortest path from A to J:");
            for (int k = 0; k < path.size(); k++) {
                System.out.print(path.get(k).getName());
                if (k < path.size() - 1) {
                    System.out.print(" -> ");
                }
            }
            System.out.println();
        } else {
            System.out.println("No path found from A to J");
        }
    }
}



