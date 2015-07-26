package leet.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * No.49 回文构词法
 * (包含相同字符串)
 *
 */
public class Anagrams {
	
	public static void main(String[] args) {
		System.out.println(new Anagrams().anagrams(new String[]{"abc", "acb"}).size());
	}
	
	public List<String> anagrams(String[] strs) {
		//最后的结果记录
        List<String> result = new ArrayList<String>();
        if(strs.length <= 1)
            return result;
        //记录排序后的字符串是否已经被访问过
        Map<String, Integer> visited = new HashMap<String, Integer>();
        String s;
        Integer temp;
        for(int i=0; i<strs.length; i++) {
            s = sortString(strs[i]);
            temp = visited.get(s);
            if(temp == null) {
                visited.put(s, i);
            } else {
                if(temp == -1) {
                    result.add(strs[i]);
                } else {
                    result.add(strs[temp]);
                    result.add(strs[i]);
                    visited.put(s, -1);
                }
            }
        }
        return result;
    }
    
    /**
     * 返回字符排列后的字符串
     * @param str 源字符串
     * @return 排列后的字符串
     */
    public String sortString(String str) {
        char[] array = str.toCharArray();
        Arrays.sort(array);
        return new String(array);
    }

}
