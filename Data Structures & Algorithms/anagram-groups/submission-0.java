class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] keyArr = new int[26];
            for (char c : str.toCharArray()){
                keyArr[c - 'a'] += 1;
            }
            StringBuilder sb = new StringBuilder();
            for (int ele : keyArr){
                sb.append(ele).append("#");
            }

            String key = sb.toString();
            map.computeIfAbsent(key, k -> new ArrayList<String>()).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
