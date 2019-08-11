class Solution {
    public String complexNumberMultiply(String a, String b) {
        String[] arr1 = a.split("\\+");
        String[] arr2 = b.split("\\+");
        return multiply(arr1[0], arr1[1], arr2[0], arr2[1]);
    }

    private String multiply(String a1, String a2, String b1, String b2) {
        String m1 = multiply(a1, b1);
        String m2 = multiply(a1, b2);
        String m3 = multiply(a2, b1);
        String m4 = multiply(a2, b2);

        int numSum = Integer.parseInt(m1) + Integer.parseInt(m4);
        int iSum = Integer.parseInt(m2.substring(0, m2.length() - 1))
            + Integer.parseInt(m3.substring(0, m3.length() - 1));

        return numSum + "+" + iSum + "i";
    }

    private String multiply(String a, String b) {
        boolean isNegative = false;
        int iNum = 0;
        String tmpA = a, tmpB = b;

        int index = a.indexOf("i");
        if (index != -1) {
            tmpA = tmpA.substring(0, index);
            iNum ++;
        }

        if (tmpA.indexOf("-") != -1) {
            isNegative = !isNegative;
            tmpA = tmpA.substring(1);
        }

        index = b.indexOf("i");
        if (index != -1) {
            tmpB = tmpB.substring(0, index);
            iNum ++;
        }

        if (tmpB.indexOf("-") != -1) {
            isNegative = !isNegative;
            tmpB = tmpB.substring(1);
        }

        if (iNum == 2) {
            isNegative = !isNegative;
            iNum = 0;
        }

        return (isNegative ? "-": "") +
            Integer.parseInt(tmpA) * Integer.parseInt(tmpB) +
            (iNum == 0 ? "" : "i");
    }
}
