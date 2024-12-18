package CNLabPrograms;
import java.util.Arrays;
public class DistanceVectorRouting {
    static int INF = 9999;
    public static void distance(int[][] graph){
        int n = graph.length;
        int dist[][] = new int[n][n];
        for(int i =0;i<n; i++){
            dist[i] = Arrays.copyOf(graph[i],n);
        }
        for(int k=0; k<n; k++){
            for(int i=0; i<n; i++){
                for(int j=0; j<n;j++){
                    if(dist[i][k] + dist[k][j] < dist[i][j]){
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        for(int i=0; i<n; i++){
            System.out.println("Router "+i+" distance vector: "+Arrays.toString(dist[i]));
        }
    }
        public static void main(String args[]){
            int graph[][] = {{0, 2, 3, 1},
                             {2, 0, 3, 2},
                             {3, 3, 0, 1},
                             {1, 2, 1, 0}};
            distance(graph);
        }
    }

