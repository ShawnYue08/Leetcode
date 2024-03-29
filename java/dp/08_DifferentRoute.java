//不同路径I：没有障碍物的情况
public class DifferentRouteI {
    public int uniquePaths(int m, int n) {
        //f[i][j]代表从起点到(i,j)位置的路径个数 
        //到达(i,j)位置：1、从上面下来;2、从左侧过来
        //f[i][j] = f[i-1][j] + f[i][j-1]
        int[][] f = new int[m][n];
        f[0][0] = 1; //因为没有障碍物的存在，f[0][0]可以直接赋值为1，有一条路径，如果有障碍物存在时，需要先检查是否需要跳过。
        
        //枚举二维数组
        for(int i = 0; i < m; i++) 
            for(int j = 0; j < n; j++) {
                if(i > 0)
                    f[i][j] += f[i-1][j];
                
                if(j > 0)
                    f[i][j] += f[i][j-1];
            }
        return f[m-1][n-1];
    }
}
//不同路径II：存在障碍物的情况
public class 08_DifferentRouteII {
    public int uniquePathsWithObstacles(int[][] array) {
        //1、f[i][j]数组代表从起点到当前(i,j)位置有多少种路径，初始化二位数组默认值为0，f[i][j] = f[i-1][j](上面) + f[i][j-1](左侧)
        int n = array.length;
        int m = array[0].length;
        int[][] f = new int[n][m];
        
        //枚举二维数组
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                //2、如果有障碍物，那么就跳过本次循环（执行j++），则此路不通，f[i][j]还是0，并且影响了后面的f[i][j++]
                if(array[i][j] == 1) continue;
                if(i == 0 && j == 0) f[i][j] = 1; //先检查array[0][0] != 1 
                if(i > 0) {
                    //3、从上面
                    f[i][j] += f[i-1][j];
                }
                if(j > 0) {
                    //4、从左侧
                    f[i][j] += f[i][j-1];
                }
            }
        }
        return f[n-1][m-1];
    }
}

