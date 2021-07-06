package main.java.topcodingquestion.backtracking;

import java.util.*;

class PairQuotient {
    String node;
    double quotient;

    public PairQuotient(String node, double quotient) {
        this.node = node;
        this.quotient = quotient;
    }
}

public class EvaluateDivision {
    public static void main(String[] args) {
        List<List<String>> equations = new ArrayList<>();
        equations.add(Arrays.asList("a", "b"));
        equations.add(Arrays.asList("b", "c"));
        double[] values = {2.0, 3.0};
        List<List<String>> queries = new ArrayList<>();
        queries.add(Arrays.asList("a", "c"));
        queries.add(Arrays.asList("b", "a"));
        EvaluateDivision evaluateDivision = new EvaluateDivision();
        System.out.println(Arrays.toString(evaluateDivision.calcEquation(equations, values, queries)));
    }

    public double[] calcEquation(List<List<String>> equations, double[] values,
                                 List<List<String>> queries) {
        HashMap<String, HashMap<String, Double>> graph = new HashMap<>();
        // Step 1). build the graph from the equations

        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            String dividend = equation.get(0), divisor = equation.get(1);
            double quotient = values[i];
            if (!graph.containsKey(dividend)) {
                graph.put(dividend, new HashMap<String, Double>());
            }
            if (!graph.containsKey(divisor)) {
                graph.put(divisor, new HashMap<String, Double>());
            }
            graph.get(dividend).put(divisor, quotient);
            graph.get(divisor).put(dividend, 1 / quotient);
        }
        double[] results = new double[queries.size()];
        // Step 2). Evaluate each query via bactracking (DFS)
        // by verifying if there exists a path from dividend to divisor
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String dividend = query.get(0), divisor = query.get(1);
            if (!graph.containsKey(dividend) || !graph.containsKey(divisor))
                results[i] = -1.0;
            else if (dividend == divisor)
                results[i] = 1.0;
            else {
                Set<String> visited = new HashSet<>();
                //results[i] = dfs(graph,dividend,divisor,1,visited);
                Queue<PairQuotient> queue = new LinkedList<>();
                queue.add(new PairQuotient(dividend, 1.0));
                results[i] = bfs(graph, divisor, visited, queue);
            }
        }
        return results;
    }

    private double dfs(HashMap<String, HashMap<String, Double>> graph, String currentNode,
                       String targetNode, double accumulatedProduct, Set<String> visited) {

        visited.add(currentNode);
        double ret = -1.0;
        Map<String, Double> neighbors = graph.get(currentNode);
        if (neighbors.containsKey(targetNode))
            ret = accumulatedProduct * neighbors.get(targetNode);
        else {
            for (Map.Entry<String, Double> entry : neighbors.entrySet()) {
                String nextNode = entry.getKey();
                if (visited.contains(nextNode))
                    continue;
                ret = dfs(graph, nextNode, targetNode, accumulatedProduct * entry.getValue(), visited);
                if (ret != -1.0)
                    break;
            }
        }
        //backtrack
        visited.remove(currentNode);
        return ret;
    }

    private double bfs(Map<String, HashMap<String, Double>> graph,
                       String targetNode, Set<String> visited,
                       Queue<PairQuotient> queue) {

        while (!queue.isEmpty()) {
            PairQuotient pairQuotient = queue.poll();
            double curr_product = pairQuotient.quotient;
            if (pairQuotient.node == targetNode) {
                return curr_product;
            }
            visited.add(pairQuotient.node);
            for (Map.Entry<String, Double> pair : graph.get(pairQuotient.node).entrySet()) {
                if (!visited.contains(pair.getKey())) {
                    queue.add(new PairQuotient(pair.getKey(), curr_product * pair.getValue()));
                }
            }
        }
        return -1.0;
    }
}
