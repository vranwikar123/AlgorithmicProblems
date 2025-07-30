package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class FloodFill
{
    public static void main(String[] args) {

    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor)
    {
        int[][] directions = {
                {1, 0}, {-1, 0}, {0, 1}, {0, -1}
        };

        if (image[sr][sc] == newColor) {
            return image;
        }

        int oldColor = image[sr][sc];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sr, sc});

        image[sr][sc] = newColor;

        while (!q.isEmpty()) {
            int[] front = q.poll();
            int x = front[0], y = front[1];

            for (int[] direction : directions) {
                int nx = x + direction[0];
                int ny = y + direction[1];

                if (nx >= 0 && nx < image.length &&
                        ny >= 0 && ny < image[0].length &&
                        image[nx][ny] == oldColor) {

                    // Change the color and enqueue
                    image[nx][ny] = newColor;
                    q.offer(new int[]{nx, ny});
                }
            }
        }

        return image;
    }
}
