package algorithm.chapter4;

import chapter1.section3.Stack;

/**
 * 使用深度优先搜索查找图中的路径
 */
public class DepthFirstPaths {

    private boolean[] visited;
    private int[] edgeTo;
    private final int source;

    public DepthFirstPaths(GraphInterface graph, int source) {
        visited = new boolean[graph.vertices()];
        edgeTo = new int[graph.vertices()];
        this.source = source;
        dfs(graph, source);
    }

    private void dfs(GraphInterface graph, int vertex) {
        visited[vertex] = true;

        for (int neighbor : graph.adjacent(vertex)) {
            if (!visited[neighbor]) {
                edgeTo[neighbor] = vertex;
                dfs(graph, neighbor);
            }
        }
    }

    public boolean hasPathTo(int vertex) {
        return visited[vertex];
    }

    public Iterable<Integer> pathTo(int vertex) {
        if (!hasPathTo(vertex)) {
            return null;
        }

        Stack<Integer> path = new Stack<>();

        for (int currentVertex = vertex; currentVertex != source; currentVertex = edgeTo[currentVertex]) {
            path.push(currentVertex);
        }

        path.push(source);
        return path;
    }
}
