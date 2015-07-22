package leet.medium;

/**
 * No.5 最长回文子串
 *
 */
public class LongestPalindromeSubstring {
	public String longestPalindrome(String s) {
		char[] array = s.toCharArray();
		if (array.length <= 1)
			return s;
		// 每个字符中间插入‘#’使字符串变为奇数长度
		int[] value = new int[array.length * 2 + 1];
		char[] newArray = new char[array.length * 2 + 1];
		for (int i = 0; i < newArray.length; i++) {
			if (i % 2 == 0) {
				newArray[i] = '#';
			} else {
				newArray[i] = array[i / 2];
			}
		}
		value[0] = 1;
		// 记录上个最长回文的最后索引，以及中间位置索引
		int mx = 0, id = 0;
		int i = 1;
		while (i < newArray.length) {
			if (mx > i) {
				value[i] = min(value[2 * id - i], mx - i);
			} else {
				value[i] = 1;
			}
			while (i - value[i] >= 0 && i + value[i] < newArray.length
					&& newArray[i - value[i]] == newArray[i + value[i]]) {
				value[i]++;
			}
			if (mx < value[i] + i) {
				mx = value[i] + i;
				id = i;
			}
			i++;
		}

		int maxId = 0;
		for (int j = 1; j < value.length; j++) {
			if (value[j] > value[maxId]) {
				maxId = j;
			}
		}
		return new String(newArray).substring(maxId - value[maxId] + 1,
				maxId + value[maxId]).replace("#", "");
	}

	int min(int a, int b) {
		return a > b ? b : a;
	}
	
	public static void main(String[] args) {
		System.out
				.println(new LongestPalindromeSubstring()
						.longestPalindrome("civilwartestingwhetherthatnaptionoranynart"
								+ "ionsoconceivedandsodedicatedcanlongendureWeareqmetona"
								+ "greatbattlefiemldoftzhatwarWehavecometodedicpateaportionof"
								+ "thatfieldasafinalrestingplaceforthosewhoheregavetheirlivest"
								+ "hatthatnationmightliveItisaltogetherfangandproperthatweshoulddo"
								+ "thisButinalargersensewecannotdedicatewecannotconsecratewecannothal"
								+ "lowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecra"
								+ "teditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotl"
								+ "enorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItis"
								+ "forusthelivingrathertobededicatedheretotheulnfinishedworkwhichthey"
								+ "whofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededic"
								+ "atedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetak"
								+ "eincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureof"
								+ "devotionthatweherehighlyresolvethatthesedeadshallnothavediedinvai"
								+ "nthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernm"
								+ "entofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth"));
		System.out.println(new LongestPalindromeSubstring().longestPalindrome("aaaa"));
	}
	
}
