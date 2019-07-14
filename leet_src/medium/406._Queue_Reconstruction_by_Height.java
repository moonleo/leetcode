class Solution {
    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0 ) {
            return people;
        }
        int len = people.length;
        List<Person> list = new ArrayList<Person>();
        for (int i = 0; i < len; i ++) {
            list.add(new Person(people[i][0], people[i][1]));
        }
        // sort the person List
        Collections.sort(list);
        // result list
        List<Person> result = new ArrayList<Person>();
        result.add(list.get(0));
        int tmpCount;
        boolean flag;
        for (int j = 1; j < list.size(); j ++) {
            Person p = list.get(j);
            tmpCount = 0;
            flag = false;
            for (int i = 0; i < result.size(); i ++) {
                if (p.count == tmpCount) {
                    result.add(i, p);
                    flag = true;
                    break;
                } else {
                    tmpCount ++;
                }
            }
            if (!flag) {
                result.add(p);
            }
        }
        int[][] res = new int[len][2];
        for (int i = 0; i < result.size(); i ++) {
            res[i][0] = result.get(i).height;
            res[i][1] = result.get(i).count;
        }
        return res;
    }

    class Person implements Comparable<Person>{
        int height;
        int count;

        public Person(int height, int count) {
            this.height = height;
            this.count = count;
        }

        public int compareTo(Person b) {
            // sort the Person, more height is first, less count is first
            return this.height == b.height ? (this.count - b.count) : (b.height - this.height);
        }
    }
}
