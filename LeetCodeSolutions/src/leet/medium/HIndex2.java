package leet.medium;

/**
 * No.275 H-Index II
 * Follow up for H-Index: What if the citations array is sorted 
 * in ascending order? Could you optimize your algorithm? 
 */
public class HIndex2 {
	public int hIndex(int[] citations) {
		for(int i=0; i<citations.length; i++) {
			if(citations.length - i <= citations[i]) {
				return citations.length - i;
			}
		}
		return 0;
    }
}
