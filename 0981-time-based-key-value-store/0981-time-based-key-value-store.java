class TimeMap {
    Map<String, List<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>());
        List<Pair> pairs = map.get(key);
        pairs.add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";

        List<Pair> pairs = map.get(key);
        int left = 0;
        int right = pairs.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (pairs.get(mid).timestamp > timestamp) {
                right = mid - 1;
            } else if (pairs.get(mid).timestamp < timestamp) {
                left = mid + 1;
            } else {
                return pairs.get(mid).value;
            }
        }

        if (right < 0) return "";

        return pairs.get(right).value;
    }

    private class Pair {
        int timestamp;
        String value;

        public Pair(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */