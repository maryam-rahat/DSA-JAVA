class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        for (int num : nums) {
            stack.push(num);
            while (stack.size() >= 2) {
                int a = stack.pop();
                int b = stack.pop();
                int gcd = gcd(a, b);
                if (gcd > 1) {
                    int lcm = (int)((long)a * b / gcd);
                    stack.push(lcm);
                } else {
                    stack.push(b);
                    stack.push(a);
                    break;
                }
            }
        }
        return new ArrayList<>(stack);
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}