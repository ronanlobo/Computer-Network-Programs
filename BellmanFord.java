package CNLabPrograms;
import java.util.Scanner;

public class BellmanFord {
    public static void bellmanFord(int[][] graph, int v, int e, int src) {
        int[] dist = new int[v];
        for (int i = 0; i < v; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[src] = 0;

        for (int i = 1; i < v; i++) {
            for (int j = 0; j < e; j++) {
                int u = graph[j][0];
                int vIndex = graph[j][1];
                int w = graph[j][2];
                if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[vIndex]) {
                    dist[vIndex] = dist[u] + w;
                }
            }
        }

        for (int j = 0; j < e; j++) {
            int u = graph[j][0];
            int vIndex = graph[j][1];
            int weight = graph[j][2];
            if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[vIndex]) {
                System.out.println("GRAPH HAS NEGATIVE WEIGHT CYCLE");
                return;
            }
        }
        
        printSolution(dist, v);
    }

    public static void printSolution(int[] dist, int V) {
        System.out.println("Vertex Distance from Source:");
        for (int i = 0; i < V; i++) {
            System.out.println(i + " \t " + dist[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of vertices: ");
        int v = sc.nextInt();
        System.out.print("Enter the number of edges: ");
        int e = sc.nextInt();
        int[][] graph = new int[e][3];

        System.out.println("Enter the edges with source, destination, and weight:");
        for (int i = 0; i < e; i++) {
            System.out.print("EDGE " + (i + 1) + " (source destination weight): ");
            graph[i][0] = sc.nextInt();
            graph[i][1] = sc.nextInt();
            graph[i][2] = sc.nextInt();
        }

        System.out.print("Enter the source vertex: ");
        int src = sc.nextInt();
        bellmanFord(graph, v, e, src);
        sc.close();
    }
}