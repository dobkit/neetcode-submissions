class Solution {

    public String encode(List<String> strs) {
        StringBuilder encodedStr = new StringBuilder();
        for (String str : strs) {
            encodedStr.append(str.length()).append('#').append(str);
        }
        return encodedStr.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int j = str.indexOf('#', i);
            int subLength = Integer.parseInt(str.substring(i, j));
            res.add(str.substring(j+1, j+1+subLength));

            i = j + 1 + subLength;
        }
        return res;
    }
}
