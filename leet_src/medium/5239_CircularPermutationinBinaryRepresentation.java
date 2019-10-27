
/**循环码排列
给你两个整数 n 和 start。你的任务是返回任意 (0,1,2,,...,2^n-1) 的排列 p，并且满足：

p[0] = start
p[i] 和 p[i+1] 的二进制表示形式只有一位不同
p[0] 和 p[2^n -1] 的二进制表示形式也只有一位不同

例1:
输入：n = 2, start = 3
输出：[3,2,0,1]
解释：这个排列的二进制表示是 (11,10,00,01)
     所有的相邻元素都有一位是不同的，另一个有效的排列是 [3,1,0,2]

例2:
输入：n = 3, start = 2
输出：[2,6,7,5,4,0,1,3]
解释：这个排列的二进制表示是 (010,110,111,101,100,000,001,011)

*/

class Solution {
    public List<Integer> circularPermutation(int n, int start) {
        List<Integer> permutation = grayCode((int)Math.pow(2, n));
        int index = permutation.indexOf(start);
        if (index == 0) {
            return permutation;
        }
        int i = index;
        int len = permutation.size();
        List<Integer> res = new ArrayList<>();
        while (i != index - 1) {
            res.add(permutation.get(i));
            i = (i + 1) % len;
        }
        res.add(permutation.get(i));
        return res;
    }

    public List<Integer> grayCode(int n) {
        if (n == 2) {
            List<Integer> list = new ArrayList<>();
            list.add(0);
            list.add(1);
            return list;
        }
        List<Integer> res = new ArrayList<>();
        List<Integer> last = grayCode(n >> 1);
        for (int i : last) {
            res.add(i);
        }
        for (int i = last.size() - 1; i >= 0; i --) {
            res.add(last.get(i) | (n >> 1));
        }
        return res;
    }
}
