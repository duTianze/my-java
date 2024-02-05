package com.dutianze.others;

/**
 * @author dutianze
 * @date 2024/2/2
 */
public class SpiralMatrix {

    public static void main(String[] args) {
        int size = 32;
        char[][] matrix = generateSpiralMatrix(size);

        // 从左上到右下的对角线上的字符
        StringBuilder diagonalString = new StringBuilder();
        for (int i = 0; i < size; i++) {
            diagonalString.append(matrix[i][i]);
        }

        System.out.println("从左上到右下的对角线上的字符: " + diagonalString.toString());
    }

    // 生成螺旋状的32x32棋盘
    private static char[][] generateSpiralMatrix(int n) {
        //当前位置
        int i = 0, j = 0;
        //循环次数
        int loop = n == 1 ? 1 : n - 1;
        //当前填充的数据
        int count = 1;
        //标识方向
        int direction = 1;
        //存放结果
        char[][] result = new char[n][n];

        int A = 'A';

        while (count <= n * n) {
            //从左往右
            if (direction == 1) {
                for (int k = 0; k < loop; ++k) {
                    //设置值后向右移动，同时count自增1
                    result[i][j++] = (char) (A + ((count - 1) % 26));
                    count++;
                }
                //改变方向，使下次进入从上往下的循环
                direction = 2;
                //结束该次循环
                continue;
            }
            //从上往下
            if (direction == 2) {
                for (int k = 0; k < loop; k++) {
                    result[i++][j] = (char) (A + ((count - 1) % 26));
                    count++;
                }
                direction = 3;
                continue;
            }
            //从右往左
            if (direction == 3) {
                for (int k = 0; k < loop; k++) {
                    result[i][j--] = (char) (A + ((count - 1) % 26));
                    count++;
                }
                direction = 4;
                continue;
            }
            //从下往上
            if (direction == 4) {
                for (int k = 0; k < loop; k++) {
                    result[i--][j] = (char) (A + ((count - 1) % 26));
                    count++;
                }
                //方向回到  左----》右
                direction = 1;
                //当前层结束，调整loop
                loop = loop == 3 || loop == 2 ? loop / 2 : loop - 2;
                //i,j指向下一层首个元素
                i++;
                j++;
                continue;
            }

        }
        return result;

    }
}
