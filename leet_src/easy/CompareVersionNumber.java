package leet.easy;

/**
 * No.165 Compare Version Numbers
 * Compare two version numbers version1 and version2. 
 * If version1 > version2 return 1, if version1 < version2 
 * return -1, otherwise return 0.
 *
 */
public class CompareVersionNumber {
	/**
	 * 比较两个版本号字符串
	 * @param version1 版本号字符串
	 * @param version2 版本号字符串
	 * @return version1 > version2 return 1, version1 < version2 return -1, otherwise 0
	 */
	public int compareVersion(String version1, String version2) {
        String[] array1 = parseVersionString(version1);
        String[] array2 = parseVersionString(version2);
        int i = 0, j = 0;
        int result;
        while(i < array1.length && j < array2.length) {
            result = compareString(array1[i], array2[j]);
            if(0 == result) {
                i ++; j++;
            } else if(result > 0)
                return 1;
            else 
                return -1;
        }
        if(i < array1.length) {
        	for(int index = i; index < array1.length; index ++) {
        		if(!checkZero(array1[index]))
        			return 1;
        	}
            return 0;
        }
        else if(j < array2.length) {
        	for(int index = j; index < array2.length; index ++) {
        		if(!checkZero(array2[index]))
        			return -1;
        	}
        	return 0;
        }
        else 
            return 0;
    }
    
	/**
	 * 将版本号字符串按“.”解析成列表形式
	 * @param version 版本号字符串
	 * @return 字符串列表
	 */
    private String[] parseVersionString(String version) {
        if(version.contains(".")) {
            return version.split("\\.");
        }
        return new String[]{version};
    }
    
    /**
     * 比较两个数字字符串的大小
     * @param str1 数字字符串
     * @param str2 数字字符串
     * @return str1 > str2 return 1, str1 < str2 return -1, otherwise return 0
     */
    private int compareString(String str1, String str2) {
        int i = 0, j = 0;
        char[] array1 = str1.toCharArray();
        char[] array2 = str2.toCharArray();
        while(i < array1.length && array1[i] == '0') {
            i ++;
        }
        while(j < array2.length && array2[j] == '0') {
            j ++;
        }
        if(array1.length - i > array2.length - j) {
            return 1;
        } 
        if(array2.length - j > array1.length - i){
            return -1;
        }
        while(i < array1.length && j < array2.length) {
            if(array1[i] == array2[j]) {
                i ++;
                j ++;
            } else if(array1[i] > array2[j]) {
                return 1; 
            } else {
                return -1;
            }
        }
        return 0;
    }
    
    /**
     * 检查某个字符串是否为全“0”
     * @param str 字符串
     * @return 若是全0返回true,否则返回false
     */
    private boolean checkZero(String str) {
		char[] array = str.toCharArray();
		for(char c: array) {
			if(c != '0') {
				return false;
			}
		}
		return true;
	}
}
