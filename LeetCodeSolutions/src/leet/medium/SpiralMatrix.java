package leet.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 根据矩阵打印螺旋矩阵
 *
 */
public class SpiralMatrix {
	
	//分别定义右、下、左、上四个方向
	int[][] direction = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	public List<Integer> spiralOrder(int[][] matrix) {
		//依次访问的路径
		List<Integer> list = new ArrayList<Integer>();
		if (0 == matrix.length) {
			return list;
		}
		//定义矩阵大小的数组记录位置是否已被访问
		int[][] visited = new int[matrix.length][matrix[0].length];
		//方向
		int direct = 0;
		//当前访问位置
		int x = 0, y = 0;
		//下一步移动的方向
		int stepX = direction[direct][0], stepY = direction[direct][1];
		visited[0][0] = 1;
		list.add(matrix[x][y]);
		while (true) {
			if (x + stepX >= matrix.length || x + stepX < 0
					|| y + stepY >= matrix[0].length || y + stepY < 0
					|| visited[x + stepX][y + stepY] != 0) {
				direct = (direct + 1) % 4;
				stepX = direction[direct][0];
				stepY = direction[direct][1];
			}
			x = x + stepX;
			y = y + stepY;
			if (x >= matrix.length || x < 0 || y >= matrix[0].length || y < 0
					|| visited[x][y] != 0)
				break;
			list.add(matrix[x][y]);
			visited[x][y] = 1;
		}
		return list;
	}
}
