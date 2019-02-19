//1 + 3 + 5 + ... + (2n - 1) = n * n
class Solution {
    public boolean isPerfectSquare(int num) {
        int i = 1;
        int tmp = num;
        while(tmp > 0) {
            tmp -= i;
            i += 2;
        }
        return tmp == 0;
    }
}
