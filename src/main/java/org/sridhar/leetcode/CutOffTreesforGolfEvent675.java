package org.sridhar.leetcode;


import java.util.*;

// https://leetcode.com/problems/cut-off-trees-for-golf-event/
public class CutOffTreesforGolfEvent675 {

    int[][] dirs = new int[][]{{0,1},{-1,0},{0,-1},{1,0}};

    public int cutOffTree(List<List<Integer>> forest) {

        PriorityQueue<Node> q = new PriorityQueue<>(Comparator.comparingInt(a -> a.height));
        for (int i=0; i < forest.size();i++){
            List<Integer> row = forest.get(i);
            for(int j=0; j < row.size(); j++){
                q.add(new Node(i,j,row.get(j)));
            }
        }

        Node start = new Node(0,0,0);
        int steps = 0;
        while (!q.isEmpty()){
            Node dest = q.poll();
            if (dest.height <=0)
                continue;
            int distance = findMinimumDistance(forest, start, dest);
            if (distance < 0)
                return -1;
            steps += distance;
            start = dest;
        }

        return steps;
    }

    int findMinimumDistance(List<List<Integer>> forest, Node start, Node dest){
        int m = forest.size();
        int n = forest.get(0).size();
        int distance = 0;
        boolean[][] visited = new boolean[m][n];
        Queue<Node> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i< size; i++){
                Node node = queue.poll();
                visited[node.x][node.y] = true;
                if(node.equals(dest))
                    return distance;

                for (int[] d : dirs){
                    int x = node.x + d[0];
                    int y = node.y + d[1];

                    if(x <0 || y<0 || x >=m || y >=n || visited[x][y] || forest.get(x).get(y)==0)
                        continue;
                    queue.add(new Node(x,y,0));
                    visited[x][y] = true;
                }
            }
            distance++;
        }

        return -1;
    }

    class Node{
        int x;
        int y;
        int height;

        public Node(int x, int y, int height) {
            this.x = x;
            this.y = y;
            this.height = height;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return x == node.x &&
                    y == node.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
    public static void main(String[] args) {
        CutOffTreesforGolfEvent675 p = new CutOffTreesforGolfEvent675();

        //[[1,2,3],[0,0,4],[7,6,5]]

        ArrayList<List<Integer>> a = new ArrayList<>();
        a.add(Arrays.asList(1,2,3));
        a.add(Arrays.asList(0,0,4));
        a.add(Arrays.asList(7,6,5));

        System.out.println(p.cutOffTree(a));

    }
}
