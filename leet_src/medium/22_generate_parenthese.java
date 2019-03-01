class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        func(res, "", 0, 0, n);
        return res;
    }

    private void func(List<String> res, String now, int left, int right, int num) {
        if(now.length() == num * 2) {
            res.add(now);
            return;
        }
        if(left < num) {
            func(res, now + "(", left + 1, right, num);
        }
        if(right < left) {
            func(res, now + ")", left, right + 1, num);
        }
    }
}
