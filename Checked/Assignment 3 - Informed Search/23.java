import java.util.PriorityQueue;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.Collections;

public class ASTAR{


    public static void main(String[] args){

        Node n1 = new Node("A",14);
        Node n2 = new Node("B",12);
        Node n3 = new Node("C",11);
        Node n4 = new Node("D",6);
        Node n5 = new Node("E",4);
        Node n6 = new Node("F",11);
        Node n7 = new Node("Z",0);
        

        n1.adjacencies = new Edge[]{
                new Edge(n2,4),
                new Edge(n3,3),
        };

        n2.adjacencies = new Edge[]{
                new Edge(n1,4),
                new Edge(n5,12),
                new Edge(n6,5)
        };



        n3.adjacencies = new Edge[]{
                new Edge(n1,3),
                new Edge(n4,7),
                new Edge(n6,11),
                new Edge(n5,10)
        };


        n4.adjacencies = new Edge[]{
                new Edge(n3,7),
                new Edge(n5,2),
        };


        
        n5.adjacencies = new Edge[]{
                new Edge(n2,12),
                new Edge(n7,5)
        };

        
        n6.adjacencies = new Edge[]{
                new Edge(n2,5),
                new Edge(n7,16),
        };

        
        n7.adjacencies = new Edge[]{
            new Edge(n5,5),    
            new Edge(n6,16),
        };

      

        AstarSearch(n1,n7);

        List<Node> path = printPath(n7);

        System.out.println("Path: " + path);


    }

    public static List<Node> printPath(Node goal){
        List<Node> path = new ArrayList<Node>();

        for(Node node = goal; node!=null; node = node.parent){
            path.add(node);
        }

        Collections.reverse(path);

        return path;
    }

    public static void AstarSearch(Node source, Node goal){

        Set<Node> explored = new HashSet<Node>();

        PriorityQueue<Node> queue = new PriorityQueue<Node>(20,
                new Comparator<Node>(){
                    @Override
                    public int compare(Node i, Node j){
                        if(i.f_scores > j.f_scores){
                            return 1;
                        }

                        else if (i.f_scores < j.f_scores){
                            return -1;
                        }

                        else{
                            return 0;
                        }
                    }

                }
        );

        //cost from start
        source.g_scores = 0;

        queue.add(source);
        
        

        boolean found = false;

        while((!queue.isEmpty())&&(!found)){

            //the node in having the lowest f_score value
            Node current = queue.poll();

            explored.add(current);

            //goal found
            if(current.value.equals(goal.value)){
                found = true;
            }

            //check every child of current node
            for(Edge e : current.adjacencies){
                Node child = e.target;
                double cost = e.cost;
                double temp_g_scores = current.g_scores + cost;
                double temp_f_scores = temp_g_scores + child.h_scores;

                if((explored.contains(child)) && (temp_f_scores >= child.f_scores)){
                    continue;
                }

                else if((!queue.contains(child)) ||
                        (temp_f_scores < child.f_scores)){

                    child.parent = current;
                    child.g_scores = temp_g_scores;
                    child.f_scores = temp_f_scores;

                    queue.add(child);

                }

            }

        }

    }

}

class Node{

    public final String value;
    public double g_scores;
    public final double h_scores;
    public double f_scores = 0;
    public Edge[] adjacencies;
    public Node parent;

    public Node(String val, double hVal){
        value = val;
        h_scores = hVal;
    }

    public String toString(){
        return value;
    }

}

class Edge{
    public final double cost;
    public final Node target;

    public Edge(Node targetNode, double costVal){
        target = targetNode;
        cost = costVal;
    }
}



