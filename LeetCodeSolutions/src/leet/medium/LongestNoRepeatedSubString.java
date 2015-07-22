package leet.medium;

/**
 * No.3 最长不重复子串
 * 
 */
public class LongestNoRepeatedSubString {

    public int lengthOfLongestSubstring(String s) {
        if(null == s || s.trim().equals(""))
            return 0;
        int length = s.length();
        if(1 == length)
            return 1;
        int[] dp = new int[length];
        char[] array = s.toCharArray();
        int[] visited = new int[256];
        int last_start = 0;
        dp[0] = 1;
        visited[array[0]] = 1;
        for(int i=1; i<array.length; i++) {
//System.out.println("char:"+array[i]);
            if(visited[array[i]] != 0) {
                if(visited[array[i]] < last_start + 1) {
                    dp[i] = dp[i-1] + 1;
                } else if(visited[array[i]] > last_start + 1) {
                    dp[i] = i - visited[array[i]] + 1;
                    last_start = visited[array[i]] - 1;
                } else {
                    dp[i] = dp[i-1];
                    last_start = visited[array[i]] - 1;
                }
            } else {
                dp[i] = dp[i-1] + 1;
            }
            visited[array[i]] = i + 1;

        }
        int max = 0;
//System.out.println("dp:");
        for(int i=0; i < length; i++) {
//System.out.println(dp[i]);
            if(dp[i]>max) {
                max = dp[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new LongestNoRepeatedSubString().lengthOfLongestSubstring("tmmzuxt"));
        System.out.println(new LongestNoRepeatedSubString().lengthOfLongestSubstring("pwwkew"));
        System.out.println(new LongestNoRepeatedSubString().lengthOfLongestSubstring("vqblqcb"));
        System.out.println(new LongestNoRepeatedSubString().lengthOfLongestSubstring("gsqygebs"));
        System.out.println(new LongestNoRepeatedSubString().lengthOfLongestSubstring("eee"));
    }
}