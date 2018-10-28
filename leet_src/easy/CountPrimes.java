package leet.easy;

/**
 * No.204 Count Primes
 * Count the number of prime numbers less than a non-negative number, n.
 */
public class CountPrimes {

	public static void main(String[] args) {
		System.out.println(new CountPrimes().countPrimes(0));
		System.out.println(new CountPrimes().countPrimes(2));
		System.out.println(new CountPrimes().countPrimes(120));
	}
	
	public int countPrimes(int n) {
        if(n <= 2) {
            return 0;
        }
        //数组记录所有的素数，-1表示非素数，0表示素数
        int[] primes = new int[n];
        primes[0] = -1; primes[1] = -1;
        for(int i=2; i*i<n; i++) {
            if(primes[i] == -1) {
                continue;
            }
            //从i*i开始检测
            for(int j=i*i; j<n; j+=i) {
                if(primes[j] == -1)
                    continue;
                else {
                    primes[j] = -1;
                }
            }
        }
        int count = 0;
        for(int i=2; i<n; i++) {
            if(primes[i] == 0) {
                count ++;
            }
        }
        return count;
    }

}
