package leet.easy;

/**
 * No.190 Reverse Bits
 * Reverse bits of a given 32 bits unsigned integer. For example, given input 43261596 
 * (represented in binary as 00000010100101000001111010011100), return 964176192 
 * (represented in binary as 00111001011110000010100101000000).
 */
public class ReverseBits {

	public static void main(String[] args) {
		System.out.println(new ReverseBits().reverseBits(43261596));
	}
	
	// you need treat n as an unsigned value
	public int reverseBits(int n) {
        StringBuilder sb = new StringBuilder();
        while(n!=0) {
            if((n & 1) == 1)
                sb.append(1);
            else
                sb.append(0);
            n = n >>> 1;
        }
        int length = sb.length();
        while(length < 32) {
        	sb.append("0");
        	length ++;
        }
        String hexString = sb.toString();
        return (int)Long.parseLong(hexString, 2);
    }

}
