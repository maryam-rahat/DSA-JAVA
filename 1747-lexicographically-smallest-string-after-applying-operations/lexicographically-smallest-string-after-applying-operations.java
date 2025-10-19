class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        Deque<String> queue = new ArrayDeque<>();
        queue.offer(s);
        Set<String> visited = new HashSet<>();
        visited.add(s);
      
        String smallestString = s;
        int length = s.length();
        while (!queue.isEmpty()) {
            String currentString = queue.poll();
          
            if (smallestString.compareTo(currentString) > 0) {
                smallestString = currentString;
            }
          
            char[] charArray = currentString.toCharArray();
            for (int i = 1; i < length; i += 2) {
                charArray[i] = (char) (((charArray[i] - '0' + a) % 10) + '0');
            }
            String additionResult = String.valueOf(charArray);
          
            String rotationResult = currentString.substring(length - b) + 
                                   currentString.substring(0, length - b);
          
            for (String transformedString : List.of(additionResult, rotationResult)) {
                if (visited.add(transformedString)) {
                    queue.offer(transformedString);
                }
            }
        }
      
        return smallestString;
    }
}