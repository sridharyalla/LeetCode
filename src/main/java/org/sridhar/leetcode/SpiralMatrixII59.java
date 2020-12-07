package org.sridhar.leetcode;

public class SpiralMatrixII59 {

    public int[][] generateMatrix(int n) {

        int dir[][] = new int[][] {{0,1},{1,0},{0,-1},{-1,0}}; // 4 directions
        int[][] arr = new int[n][n];
        int i=0,j=0,d=0,curr=1;

        while (curr <= n*n){
            arr[i][j] = curr++;
            // Boundary validation
            if(i+dir[d][0]<0 || j+dir[d][1]< 0 || i+dir[d][0]==n || j+dir[d][1]==n || arr[i+dir[d][0]][j+dir[d][1]] != 0)
                d = (d+1) %4; // change direction
            i = i + dir[d][0];
            j = j + dir[d][1];
        }
        return arr;
    }
}
