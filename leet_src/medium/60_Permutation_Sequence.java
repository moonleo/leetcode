class Solution {
    public String getPermutation(int n, int k) {
        //康托展开
        if (n == 1) {
            return "1";
        }
        List<Integer> list = new ArrayList<>();
        int[] factorial = new int[n + 1];
        int i = 1;
        factorial[0] = 1;
        while (i <= n) {
            list.add(i);
            factorial[i] = factorial[i-1] * i;
            i ++;
        }

        StringBuilder sb = new StringBuilder();
        int c;
        k --;
        while (n > 0) {
            c = k / factorial[--n];
            sb.append(list.get(c));
            list.remove(list.get(c));
            k -= factorial[n]*c;
        }
        if (!list.isEmpty()) {
            sb.append(list.get(0));
        }
        return sb.toString();
    }


}
