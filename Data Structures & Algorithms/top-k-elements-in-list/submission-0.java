class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer>[] bucket = new List[nums.length + 1];
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int key : map.keySet()) {
            int freq = map.get(key);
            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(key);
        }
        List<Integer> res = new ArrayList<>();
        for (int i = nums.length; i >=0 ; i--) {
            if (bucket[i] != null){
                for (int ele : bucket[i]) {
                    res.add(ele);
                    if (res.size() == k) break;
                }
                if (res.size() == k) break;
            }
        }
        return res.stream().mapToInt(i -> i).toArray();
    }
}
