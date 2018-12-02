class Solution {

    private int tmp;
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        tmp = num;
        int thousandNum = tmp / 1000;
        while(thousandNum > 0) {
            sb.append("M");
            thousandNum --;
        }

        sb.append(transStr(1000, "C", "D", "M"));
        sb.append(transStr( 100, "X", "L", "C"));
        sb.append(transStr(  10, "I", "V", "X"));
        return sb.toString();
    }

    private String transStr(int binary, String leftOne, String rightFive, String rightTen) {
        StringBuilder sb = new StringBuilder();
        tmp = tmp % binary;
        int num = tmp / (binary/10);
        if(num >= 5) {
            if(num == 9) {
                sb.append(leftOne).append(rightTen);
            } else {
                sb.append(rightFive);
                num -= 5;
                while(num > 0) {
                    sb.append(leftOne);
                    num --;
                }
            }
        } else {
            if(num == 4) {
                sb.append(leftOne).append(rightFive);
            } else {
                while(num > 0) {
                    sb.append(leftOne);
                    num --;
                }
            }
        }

        return sb.toString();
    }
}
