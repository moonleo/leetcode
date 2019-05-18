class Solution {
    public List<Integer> partitionLabels(String S) {
        int len = S.length();
        char[] arr = S.toCharArray();
        int[] flag = new int[26];
        //record every char's lastest index in S
        for(int i = 0; i < len; i ++) {
            flag[arr[i] - 'a'] = i;
        }
        //result List
        List<Integer> result = new ArrayList<Integer>();
        int i = 0, j;
        int lastIndex = -1;
        while(i < len) {
            //arr[i]'s last index in S
            lastIndex = flag[arr[i] - 'a'];
            j = i;
            while(j < lastIndex) {
                if(flag[arr[j] - 'a'] > lastIndex) {
                    //update index of some chat in [i, lastIndex]'s last index is bigger than i's
                    lastIndex = flag[arr[j] - 'a'];
                    continue;
                }
                j ++;
            }
            if(j == lastIndex) {
                result.add(j - i + 1);
                i = lastIndex + 1;
            }
        }
        return result;
    }
}
