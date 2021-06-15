



// Flood Fill


/**
 * An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.

You are also given three integers sr, sc, and newColor. You should perform a flood fill on the image starting from the pixel image[sr][sc].

To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color), and so on. Replace the color of all of the aforementioned pixels with newColor.

Return the modified image after performing the flood fill.

 

Example 1:


Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, newColor = 2
Output: [[2,2,2],[2,2,0],[2,0,1]]
Explanation: From the center of the image with position (sr, sc) = (1, 1) (i.e., the red pixel), all pixels connected by a path of the same color as the starting pixel (i.e., the blue pixels) are colored with the new color.
Note the bottom corner is not colored 2, because it is not 4-directionally connected to the starting pixel.
Example 2:

Input: image = [[0,0,0],[0,0,0]], sr = 0, sc = 0, newColor = 2
Output: [[2,2,2],[2,2,2]]
 

Constraints:

m == image.length
n == image[i].length
1 <= m, n <= 50
0 <= image[i][j], newColor < 216
0 <= sr < m
0 <= sc < n
 */

class Solution {
    public int[][] floodFill(int[][] land, int sr, int sc, int newColor) {
        int hgt = land.length;
        int len = land[0].length;
        int color = land[sr][sc];
        if(color==newColor) return land;
        Queue<int[]> q = new LinkedList();
        q.add( new int[]{sr,sc});
        land[sr][sc]=newColor;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                int[] part = q.poll();
                if(part[0]-1>=0 && land[part[0]-1][part[1]]==color){
                    q.add(new int[]{part[0]-1, part[1]});
                    land[part[0]-1][part[1]]=newColor;
                }
                if(part[0]+1<hgt && land[part[0]+1][part[1]]==color){
                    q.add(new int[]{part[0]+1, part[1]});
                    land[part[0]+1][part[1]]=newColor;
                }
                if(part[1]-1>=0 && land[part[0]][part[1]-1]==color){
                    q.add(new int[]{part[0], part[1]-1});
                    land[part[0]][part[1]-1]=newColor;
                }
                if(part[1]+1<len && land[part[0]][part[1]+1]==color){
                    q.add(new int[]{part[0], part[1]+1});
                    land[part[0]][part[1]+1]=newColor;
                }
            }
        }
        return land;
    }
}