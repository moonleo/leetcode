class Solution {
    public String largestNumber(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        boolean allZero = true;
        for(int i: nums) {
            if(i != 0) {
                allZero = false;
            }
            list.add(i);
        }
        if(allZero) {
            return "0";
        }
        Collections.sort(list, new IntergerComparator());
        StringBuilder sb = new StringBuilder();
        for(Integer s: list) {
            sb.append(s);
        }
        return sb.toString();
    }

    class IntergerComparator implements Comparator<Integer> {
        public int compare(Integer o1, Integer o2) {
            char[] arr1 = ("" + o1 + o2).toCharArray();
            char[] arr2 = ("" + o2 + o1).toCharArray();
            int len1 = arr1.length;
            int len2 = arr2.length;
            int i = 0, j = 0;
            while(i < len1 && j < len2) {
                if(arr1[i] - '0' > arr2[j] - '0') {
                    return -1;
                } else if(arr1[i] - '0' < arr2[j] - '0') {
                    return 1;
                }
                i ++;
                j ++;
            }
            return 0;

        }
    }
}
