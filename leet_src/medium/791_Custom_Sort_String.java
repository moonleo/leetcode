class Solution {
    public String customSortString(String S, String T) {
        if(S == null || S.length() == 0
           || T == null || T.length() == 0) {
            return T;
        }
        //count every char in T
        int[] count = new int[26];
        char[] arrT = T.toCharArray();
        for(int i = 0; i < arrT.length; i ++) {
            count[arrT[i] - 'a'] ++;
        }

        StringBuilder sb = new StringBuilder();
        char[] arrS = S.toCharArray();
        char tmp;
        int c;
        // for every char in S, append the same char in T, then they have been sorted
        for(int i = 0; i < arrS.length; i ++) {
            tmp = arrS[i];
            c = count[tmp - 'a'];
            for(int j = c; j > 0; j --) {
                sb.append(arrS[i]);
                count[tmp - 'a'] --;
            }
        }

        // append the other char in T
        for(int i = 0; i < 26; i ++) {
            c = count[i];
            for(int j = c; j > 0; j --) {
                sb.append((char)('a' + i));
                count[i] --;
            }
        }

        return sb.toString();
    }

}
