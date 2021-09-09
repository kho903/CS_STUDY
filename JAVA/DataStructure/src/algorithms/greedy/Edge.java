package algorithms.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class Edge implements Comparable<Edge> {
    public Integer distance;
    public String vertex;

    public Edge(Integer distance, String vertex) {
        this.distance = distance;
        this.vertex = vertex;
    }


    @Override
    public int compareTo(Edge e) {
        return this.distance - e.distance;
    }

    public static void main(String[] args) {
        Edge edge1 = new Edge(10, "A");
        Edge edge2 = new Edge(12, "A");
        Edge edge3 = new Edge(13, "A");
        Edge[] edges = new Edge[]{edge1, edge2, edge3};
//        Arrays.sort(edges);

        Arrays.sort(edges, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.distance - o2.distance;
            }
        });

        for (int i = 0; i< edges.length; i++) {
            System.out.println(edges[i].distance);
        }

    }
}
