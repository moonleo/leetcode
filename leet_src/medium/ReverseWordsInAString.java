package leet.medium;

/**
 * No.151 Reverse Words in a String 
 * Given an input string, reverse the string word by word. 
 * For example, Given s = "the sky is blue", 
 * return "blue is sky the".
 *
 */
public class ReverseWordsInAString {
	public static void main(String[] args) {
		ReverseWordsInAString r = new ReverseWordsInAString();
		System.out.println(r.reverseWords(" a  b"));
		System.out.println(r.reverseWords("1   "));
		System.out.println(r.reverseWords("   "));
	}
	
	public String reverseWords(String s) {
        if(null == s || 0 == s.length()) {
            return s;
        }
        //字符串转数组
        char[] array = s.toCharArray();
        //不考虑字符串开头的空格
        int i=0;
        while(i< array.length && array[i] == ' ') {
            i ++;
        }
        //若字符串全为空格，返回空字符串
        if(i>=array.length) {
            return "";
        }
        //不考虑字符串结尾的空格
        int end = array.length - 1;
        while(end > i && array[end] == ' ') {
        	end --;
        }
        //字符串反转
        reverse(array, i, end);
        int j = i+1;
        StringBuilder sb = new StringBuilder();//记录结果
        while(j <= end) {
        	//碰到空格，反转之前的单词
            if(array[j] == ' ') {
                reverse(array, i, j-1);
                sb.append(array, i, j-i);
                //只要一个空格
                while(j < array.length && array[j] == ' ') {
                    j ++;
                }
                if(j < array.length) {
                	sb.append(" ");
                }
                i = j;
                j = i + 1;
            } else {
                j ++;
            }
        }
        //添加最后一个单词
        if(i < j) {
        	reverse(array, i, j-1);
        	sb.append(array, i, j-i);
        }
        return sb.toString();
    }
    
	/**
	 * 将数组中起始位置到终止位置的元素交换
	 * @param array 数组
	 * @param start 起始位置
	 * @param end 终止位置
	 */
    private void reverse(char[] array, int start, int end) {
        int i=start, j=end;
        char c;
        while(i < j) {
            c = array[i];
            array[i] = array[j];
            array[j] = c;
            i ++;
            j --;
        }
    }
}
