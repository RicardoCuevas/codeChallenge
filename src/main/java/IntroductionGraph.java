import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class IntroductionGraph {
    public static void main(String[] args) {
        int [][]  adjancecyList = {
                {1,3},
                {0},
                {3,8},
                {0,2,4,5},
                {3,6},
                {3},
                {4,7},
                {6},
                {2}
        };
        // Matriz de adyacencia
        int[][] adjacencyMatrix = {
                {0, 1, 0, 1, 0, 0, 0, 0, 0}, //0
                {1, 0, 0, 0, 0, 0, 0, 0, 0},//1
                {0, 0, 0, 1, 0, 0, 0, 0, 1},//2
                {1, 0, 1, 0, 1, 1, 0, 0, 0},//3
                {0, 0, 0, 1, 0, 0, 1, 0, 0},//4
                {0, 0, 0, 1, 0, 0, 0, 0, 0},//5
                {0, 0, 0, 0, 1, 0, 0, 1, 0},//6
                {0, 0, 0, 0, 0, 0, 1, 0, 0},//7
                {0, 0, 1, 0, 0, 0, 0, 0, 0}//8
        };

        traversalBFS(adjancecyList).forEach(System.out::print);
        System.out.println();
        traversalBFS1(adjacencyMatrix).forEach(System.out::print);
        System.out.println();
        System.out.println("DFS solution");
        traversalDFS(0, adjacencyMatrix, new ArrayList<>(), new boolean[adjacencyMatrix.length]).forEach(System.out::print);
    }

    private static List<Integer> traversalBFS1(int[][] graph) {
        boolean[] seen = new boolean[graph.length];
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> values = new ArrayList<>();

        queue.add(0); //Start queue with 0

        while(!queue.isEmpty()){
            int vertex = queue.poll();
            values.add(vertex);
            seen[vertex] = true;

            //Review all conections
            for(int v=0; v<graph[vertex].length; v++){
                if(graph[vertex][v]>0 && !seen[v]){
                    queue.add(v);
                }
            }
        }
        return values;
    }

    public static List<Integer> traversalBFS(int[][] graph){

        Queue<Integer> queue = new LinkedList<>();
        List<Integer> values = new ArrayList<>();
        boolean[] seen = new boolean[graph.length];

        queue.add(0);
        while (!queue.isEmpty()){
            int vertex = queue.poll();
            values.add(vertex);
            seen[vertex] = true;

            for (int connection : graph[vertex]){
                if(!seen[connection]){
                    queue.add(connection);
                }
            }
        }
        return values;
    }

    public static List<Integer> traversalDFS(int vertex, int[][] graph, List<Integer> values, boolean[] seen){
        values.add(vertex);
        seen[vertex] = true;
        int[] connections = graph[vertex];
        for (int i=0; i< connections.length; i++){
            if(connections[i] >0 && !seen[i]){
                traversalDFS(i, graph, values, seen);
            }
        }
        return values;
    }
}
