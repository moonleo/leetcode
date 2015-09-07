package leet.easy;

/**
 * No.278 First Bad Version
 *  You are a product manager and currently leading a team to 
 *  develop a new product. Unfortunately, the latest version of 
 *  your product fails the quality check. Since each version is 
 *  developed based on the previous version, all the versions 
 *  after a bad version are also bad. Suppose you have n versions 
 *  [1, 2, ..., n] and you want to find out the first bad one, 
 *  which causes all the following ones to be bad. You are given 
 *  an API bool isBadVersion(version) which will return whether 
 *  version is bad. Implement a function to find the first bad 
 *  version. You should minimize the number of calls to the API. 
 */
public class FirstBadVersion extends VersionControl{
	/* The isBadVersion API is defined in the parent class VersionControl.
    boolean isBadVersion(int version); */
	public static void main(String[] args) {
		System.out.println(new FirstBadVersion().firstBadVersion(2126753390));
	}
	
	public int firstBadVersion(int n) {
        return firstBadVersion(1, n);
    }
    
    private int firstBadVersion(long start, long end) {
        if(start >= end)
            return (int)start;
        long mid = (start + end) >> 1;
        if(isBadVersion((int)mid)) {
            if(mid>=start+1) {
                if(!isBadVersion((int)mid-1)) {
                    return (int)mid;
                } else {
                    return firstBadVersion(start, mid-1);
                }
            }else {
                return (int)mid;
            }
        } else {
            return firstBadVersion(mid+1, end);
        }
    }
}

class VersionControl {
	boolean isBadVersion(int version) {
		if(version >= 1702766719)
			return true;
		return false;
	}
}
