class RandomizedCollection {
    List<Integer> list;
    Map<Integer, Set<Integer>> map;
    Random random;

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        list = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.get(val) == null) {
            map.put(val, new HashSet<>());
        }
        list.add(val);
        map.get(val).add(list.size() - 1);
        return map.get(val).size() == 1;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        Set<Integer> tmpIndexs = map.get(val);
        if (tmpIndexs != null && tmpIndexs.size() != 0) {
            int removeIndex = tmpIndexs.iterator().next();
            int lastElement = list.get(list.size() - 1);
            list.set(removeIndex, lastElement);
            map.get(lastElement).add(removeIndex);
            map.get(lastElement).remove(list.size() - 1);
            if (val != lastElement) {
                map.get(val).remove(removeIndex);
            }
            list.remove(list.size() - 1);
            return true;
        }
        return false;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
