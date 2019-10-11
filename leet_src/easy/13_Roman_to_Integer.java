class Solution {
    static Map<Character, Integer> numberMap = new HashMap<>();
    static Map<Character, List<Character>> specMap = new HashMap<>();

    static {
        numberMap.put('I', 1);
        numberMap.put('V', 5);
        numberMap.put('X', 10);
        numberMap.put('L', 50);
        numberMap.put('C', 100);
        numberMap.put('D', 500);
        numberMap.put('M', 1000);

        List<Character> list = new ArrayList<>();
        list.add('V');
        list.add('X');
        specMap.put('I', list);
        list = new ArrayList<>();
        list.add('L');
        list.add('C');
        specMap.put('X', list);
        list = new ArrayList<>();
        list.add('D');
        list.add('M');
        specMap.put('C', list);
    }

    public int romanToInt(String s) {
        int result = 0;
        char[] arr = s.toCharArray();
        int pre = 0;
        int post = pre + 1;
        while (post < arr.length) {
            if (specMap.get(arr[pre]) != null && specMap.get(arr[pre]).contains(arr[post])) {
                result += (numberMap.get(arr[post]) - numberMap.get(arr[pre]));
                pre = post + 1;
                post = pre + 1;
            } else {
                result += numberMap.get(arr[pre]);
                pre ++;
                post ++;
            }
        }
        if (pre < arr.length) {
            result += numberMap.get(arr[pre]);
        }
        return result;
    }
}
