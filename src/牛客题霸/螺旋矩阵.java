package 牛客题霸;

import java.util.ArrayList;

/**
 * Created by xieli on 2021/3/13.
 */
public class 螺旋矩阵 {

    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        if (matrix.length == 0) {
            return res;
        }

        int up = 0, down = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;

        while (true) {
            for (int col = left; col <= right; col++) {
                res.add(matrix[up][col]);
            }
            if (++up > down) {
                break;
            }

            for (int row = up; row <= down; row++) {
                res.add(matrix[row][right]);
            }
            if (--right < left) {
                break;
            }

            for (int col = right; col >= left; col--) {
                res.add(matrix[down][col]);
            }
            if (--down < up) {
                break;
            }

            for (int row = down; row >= up; row--) {
                res.add(matrix[row][left]);
            }
            if (++left > right) {
                break;
            }
        }

        return res;
    }

}
