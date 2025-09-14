class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> wordSet = new HashSet<>();
        Map<String, String> capMap = new HashMap<>();
        Map<String, String> vowelMap = new HashMap<>();

        for (String word : wordlist) {
            wordSet.add(word);

            String lower = word.toLowerCase();
            capMap.putIfAbsent(lower, word);

            String devowel = devowel(lower);
            vowelMap.putIfAbsent(devowel, word);
        }

        String[] res = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];

            if (wordSet.contains(query)) {
                
                res[i] = query;
            } else {
                String lower = query.toLowerCase();
                if (capMap.containsKey(lower)) {
                    
                    res[i] = capMap.get(lower);
                } else {
                    String devowel = devowel(lower);
                    if (vowelMap.containsKey(devowel)) {

                        res[i] = vowelMap.get(devowel);
                    } else {
                    
                        res[i] = "";
                    }
                }
            }
        }
        return res;
    }
    private String devowel(String word) {
        StringBuilder sb = new StringBuilder();
        for (char c : word.toCharArray()) {
            if ("aeiou".indexOf(c) >= 0) {
                sb.append('*');
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}