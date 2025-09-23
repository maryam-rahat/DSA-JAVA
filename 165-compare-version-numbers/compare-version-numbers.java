class Solution {
    public int compareVersion(String version1, String version2) {
        String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");

        int i = 0;
        while (i < arr1.length || i < arr2.length) {
            int num1 = (i < arr1.length) ? Integer.parseInt(arr1[i]) : 0;
            int num2 = (i < arr2.length) ? Integer.parseInt(arr2[i]) : 0;

            if (num1 < num2) return -1;
            else if (num1 > num2) return 1;

            i++;
        }

        return 0;
    }
}
