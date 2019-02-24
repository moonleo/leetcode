class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas == null || cost == null || gas.length < 1
          || cost.length < 1) {
            return 0;
        }
        int len = gas.length;
        int[] sub = new int[len];
        for (int i = 0; i < len; i ++) {
            sub[i] = gas[i] - cost[i];
        }
        int sum = 0;
        int j = -1;
        for (int i = 0; i < len; i ++) {
            if (sub[i] >= 0) {
                sum = sub[i];
                for (j = (i + 1) % len; j != i; j = (j + 1) % len) {
                    sum += sub[j];
                    if (sum < 0) {
                        break;
                    }
                }
                if (j == i) {
                    return j;
                }
            }
        }
        return -1;
    }
}
