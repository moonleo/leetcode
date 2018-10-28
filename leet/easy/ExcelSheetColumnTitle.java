package leet.easy;

/**
 * No.168 Excel Sheet Column Title
 * Given a positive integer, return its corresponding column title as appear 
 * in an Excel sheet.
 */
public class ExcelSheetColumnTitle {

	public static void main(String[] args) {

	}
	
	public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        if(n < 0) {
            return sb.toString();
        }
        int temp = 0;
        while(n != 0) {
            temp = n % 26;
            if(temp == 0) {
                temp = 26;
                n --;
            }
            sb.append((char)('A' + temp - 1));
            n = n / 26;
        }
        return sb.reverse().toString();
    }

}
