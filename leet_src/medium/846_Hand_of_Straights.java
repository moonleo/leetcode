class Solution {
    public boolean isNStraightHand(int[] hand, int W) {
        if(hand.length % W != 0) {
            return false;
        }

        Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
        for(int i: hand) {
            if(map.get(i) == null) {
                map.put(i, 1);
            } else {
                map.put(i, map.get(i) + 1);
            }
        }

        while (!map.isEmpty()) {
            int start = new ArrayList<Integer>(map.keySet()).get(0);
            int tmp = W;
            while (tmp > 0) {
                if(map.get(start) == null) {
                    return false;
                }
                if(map.get(start) == 1) {
                    map.remove(start);
                } else {
                    map.put(start, map.get(start) - 1);
                }
                tmp --;
                start ++;
            }
        }

        return true;

    }
}
