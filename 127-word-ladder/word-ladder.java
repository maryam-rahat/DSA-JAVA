class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        Queue<String> q = new LinkedList<>();

        for (String word : wordList) {
            set.add(word);
        }
        if (!set.contains(endWord))
            return 0;
        q.offer(beginWord);
        int level = 1;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int s = 0; s < size; s++) {
                String currentWord = q.poll();
                if (currentWord.equals(endWord))
                    return level;
                char[] arr = currentWord.toCharArray();

                for (int i = 0; i < arr.length; i++) {
                    char original = arr[i];

                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        if (ch == original)
                            continue;

                        arr[i] = ch;
                        String newWord = new String(arr);

                        if (set.contains(newWord)) {
                            q.offer(newWord);
                            set.remove(newWord);

                        }
                    }
                    arr[i] = original;
                }
            }
            level++;
        }
        return 0;
    }
}