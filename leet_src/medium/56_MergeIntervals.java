/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals == null || intervals.size() <= 1) {
            return intervals;
        }
        List<Interval> result = new ArrayList<Interval>();
        //按照start进行排序
        sort(intervals);
        Interval s = intervals.get(0);
        result.add(s);
        int len = 0;
        for(int i = 1; i < intervals.size(); i ++) {
            int start = intervals.get(i).start;
            Interval temp = result.get(len);
            if(start >= temp.start && start <= temp.end) {
                temp.end = max(temp.end, intervals.get(i).end);
            } else {
                result.add(intervals.get(i));
                len ++;
            }
        }
        return result;
    }

    private int max(int a, int b) {
        return a > b ? a : b;
    }

    private void sort(List<Interval> intervals) {
        int size = intervals.size();
        for(int i = 0; i < size; i ++) {
            for(int j = i + 1; j < size; j ++) {
                if(intervals.get(i).start > intervals.get(j).start) {
                    swap(intervals.get(i), intervals.get(j));
                }
            }
        }
    }

    private void swap(Interval a, Interval b) {
        Interval temp = new Interval(a.start, a.end);
        a.start = b.start;
        a.end = b.end;
        b.start = temp.start;
        b.end = temp.end;
    }
}
