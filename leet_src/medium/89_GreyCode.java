class Solution {

    public List<Integer> grayCode(int n) {
        //镜像法Time limit
        List<Integer> res = new ArrayList<>();
        /*res.add(0);
        res.add(1);
        iteration(res, n - 1, 2);
        return res;
        */
        for(int i = 0; i < 1<<n; i ++) {
            res.add(i ^ i>>1);
        }
        return res;
    }

    /*private void iteration(List<Integer> res, int n, int increase) {
        if(n == 0) {
            return;
        }
        int len = res.size();
        for(int i = len - 1; i >= 0; i --) {
            res.add(res.get(i) + increase);
        }
        iteration(res, n - 1, increase * 2);
    }*/
}
