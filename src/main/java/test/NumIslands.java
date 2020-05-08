package test;

/**
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。
 *
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 * 输出: 1
 *
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 * 输出: 3
 * 解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
 *
 */
public class NumIslands {
    public static void main(String[] agrs){
        /**
         *  1 1 1 1 0
         *  1 1 0 1 0
         *  1 1 0 0 0
         *  0 0 0 0 0
         */
        int[][] grid = {{1,1,1,1,0},{1,1,0,1,0},{1,1,0,0,0},{0,0,0,0,0}};

        System.out.println("num islands ="+numisLands(grid));

    }
    private static int[][] offset = {{-1,0},{1,0},{0,-1},{0,1}};

    /**
     * 方法一：深度优先搜索
     * 我们可以将二维网格看成一个无向图，竖直或水平相邻的 11 之间有边相连。
     *
     * 为了求出岛屿的数量，我们可以扫描整个二维网格。如果一个位置为 11，则以其为起始节点开始进行深度优先搜索。在深度优先搜索的过程中，每个搜索到的 11 都会被重新标记为 00。
     *
     * 最终岛屿的数量就是我们进行深度优先搜索的次数。
     *
     * dfs 深度优先
     * @param grid
     * @param h
     * @param w
     */
    private static void dfs(int[][] grid,int h,int w){
        int oh  = grid.length;
        int ow = grid[0].length;
        if(h < 0 || w < 0 || h >= oh || w >= ow || grid[h][w] == 0){
            return;
        }
        System.out.println("find value="+grid[h][w] + " h ="+h +" w = "+w);
        grid[h][w] = 0;
        dfs(grid,h + offset[0][0],w+offset[0][1]);
        dfs(grid,h + offset[1][0],w+offset[1][1]);
        dfs(grid,h + offset[2][0],w+offset[2][1]);
        dfs(grid,h + offset[3][0],w+offset[3][1]);

    }
    private static int numisLands(int[][] grid){
        if(grid == null || grid.length == 0){
            return 0;
        }
        int h = grid.length;
        int w = grid[0].length;
        int num_isLands = 0;
        System.out.println(" h ="+ h + "/ w = "+w);

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                System.out.println("i = "+i + " j = "+ j + " value ="+grid[i][j]);
                if(grid[i][j] == 1){
                    ++num_isLands;
                    dfs(grid,i,j);
                }

            }

        }

        return num_isLands;
    }
}
