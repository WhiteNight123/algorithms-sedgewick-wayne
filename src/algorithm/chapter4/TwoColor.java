package algorithm.chapter4;

/**
 * 深度优先搜索检查二分图(双色问题)
 */
public class TwoColor {

    private boolean[] visited;
    private boolean[] color;
    private boolean isTwoColorable = true;

    public TwoColor(GraphInterface graph) {
        visited = new boolean[graph.vertices()];
        color = new boolean[graph.vertices()];

        for (int source = 0; source < graph.vertices(); source++) {
            if (!visited[source]) {
                dfs(graph, source);
            }
        }
    }

    private void dfs(GraphInterface graph, int vertex) {
        visited[vertex] = true;

        if (graph.adjacent(vertex) != null) {
            for (int neighbor : graph.adjacent(vertex)) {
                if (!visited[neighbor]) {
                    color[neighbor] = !color[vertex];
                    dfs(graph, neighbor);
                } else if (color[neighbor] == color[vertex]) {
                    isTwoColorable = false;
                }
            }
        }

    }

    public boolean isBipartite() {
        return isTwoColorable;
    }
}
