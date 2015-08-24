package leet.easy;

/**
 * No.6 ZigZag Conversion
 * The string "PAYPALISHIRING" is written in a zigzag 
 * pattern on a given number of rows like this:
 * P   A   H   N 
 * A P L S I I G 
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR". 
 */
public class ZigZagConversion {
	public String convert(String s, int numRows) {
		if(null == s ||s.length() <= 1 || 1 == numRows || numRows >= s.length())
			return s;
		char[] array = s.toCharArray();
		StringBuilder sb = new StringBuilder();
		int index, temp;
		//打印每一行
		for(int i=0; i<numRows; i++) {
			index = i;
			sb.append(array[index]);
			while(index < array.length) {
				//第一行和最后一行下标等差2*(row-1)
				if(0 == i || (numRows - 1) == i) {
					index += 2 *(numRows - 1);
					if(index < array.length)
						sb.append(array[index]);
				} 
				//其余各行奇数列与前一偶数列相差2*(row - 行下标 - 1)，偶数列间相差2*(row-1)
				else {
					//奇数列
					temp = index + 2 *(numRows - i - 1);
					if(temp < array.length) {
						sb.append(array[temp]);
					} 
					//偶数列
					index = index + 2 *(numRows - 1);
					if(index < array.length) {
						sb.append(array[index]);
					}
				}
			}
		}
		return sb.toString();
    }
	
	public static void main(String[] args) {
		System.out.println(new ZigZagConversion().convert("PAYPALISHIRING", 3).equals("PAHNAPLSIIGYIR"));
		System.out.println(new ZigZagConversion().convert("AB", 3));
	}
}
