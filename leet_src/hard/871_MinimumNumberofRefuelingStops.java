class Solution {
    //每经过一个加油站，将其中的油存起来，当油箱里的油不够时，再取出最多的油使用
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        if (startFuel >= target) {
            return 0;
        }
        PriorityQueue<Station> queue = new PriorityQueue<>();
        List<Station> list = new ArrayList<>();
        for (int[] station: stations) {
            list.add(new Station(station[0], station[1]));
        }
        int minStep = 0;
        for (int i = 0; i < list.size(); i ++) {
            while (startFuel < list.get(i).start) {
                if (queue.isEmpty()) {
                    return -1;
                }
                startFuel += queue.poll().gas;
                minStep ++;
            }
            queue.add(list.get(i));
        }

        while (startFuel < target) {
            if (queue.isEmpty()) {
                return -1;
            }
            startFuel += queue.poll().gas;
            minStep ++;
        }

        return (startFuel >= target) ? minStep : -1;
    }

    private class Station implements Comparable<Station> {
        int start;
        int gas;
        public Station(int start, int gas) {
            this.start = start;
            this.gas = gas;
        }

        public int compareTo(Station s) {
            return s.gas - gas;
        }
    }
}
