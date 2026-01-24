class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if(!wordSet.contains(endWord)) return 0;
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();

        beginSet.add(beginWord);
        endSet.add(endWord);

        int level = 1;

        while(!beginSet.isEmpty() && !endSet.isEmpty()){
            if(beginSet.size()>endSet.size()){
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }

            Set<String> nextSet = new HashSet<>();

            for(String word: beginSet){
                char arr[] = word.toCharArray();

                for(int i = 0; i < arr.length; i++){
                    char original = arr[i];

                    for(char ch = 'a'; ch <= 'z'; ch++){
                        if(ch == original) continue;
                        arr[i] = ch;
                        String newWord = new String(arr);

                        if(endSet.contains(newWord)) return level + 1;

                        if(wordSet.contains(newWord)){
                            nextSet.add(newWord);
                            wordSet.remove(newWord);
                        }
                    }
                    arr[i] = original;
                }
            }
            beginSet = nextSet;
            level++;
        }
        return 0;
    }
}