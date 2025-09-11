class Solution {
    public String sortVowels(String s) {
        String vowels = "aeiouAEIOU";
        ArrayList<Character> resList = new ArrayList<>();
        ArrayList<Integer> index = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            if (vowels.indexOf(s.charAt(i)) != -1) {
                resList.add(s.charAt(i));
                index.add(i);
            }
        }

        Collections.sort(resList);

        StringBuilder result = new StringBuilder(s);

        for (int i = 0; i < index.size(); i++) {
            result.setCharAt(index.get(i), resList.get(i));
        }

        return result.toString();
    }
}