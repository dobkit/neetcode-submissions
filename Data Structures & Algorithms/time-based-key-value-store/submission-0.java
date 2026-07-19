class TimeMap {

    private static class Pair {
        int timestamp;
        String value;

        Pair(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }

    private final Map<String, List<Pair>> timeMap;

    public TimeMap() {
        timeMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        timeMap.computeIfAbsent(key, k -> new ArrayList<>())
               .add(new Pair(timestamp, value));
    }

    public String get(String key, int timestamp) {
        List<Pair> values = timeMap.get(key);
        if (values == null) return "";

        int n = values.size();

        if (values.get(0).timestamp > timestamp) {
            return "";
        }

        int left = 0;
        int right = n - 1;

        // Find the last timestamp <= query timestamp
        while (left < right) {
            int mid = left + (right - left + 1) / 2;

            if (values.get(mid).timestamp <= timestamp) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        return values.get(left).value;
    }
}