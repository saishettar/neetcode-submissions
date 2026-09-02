class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        HashMap<String, List<String>> map = new HashMap<>();

        for(String word : strs)
        {
            char [] cword = word.toCharArray();
            Arrays.sort(cword);
            String alpha = new String(cword);

            map.putIfAbsent(alpha, new ArrayList<>());
            map.get(alpha).add(word);

        }

        return new ArrayList<>(map.values());
    }
}
