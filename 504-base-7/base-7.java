class Solution {
    public String convertToBase7(int num) {
        if(num==0) return "0";
        
        boolean isNeg = num < 0;
        num = Math.abs(num);
        String res = base7(num, "");
        if(isNeg){
            return "-" + res;
        }
        return res;
    }
    private String base7(int num, String res){
        if(num == 0) return new StringBuilder(res).reverse().toString();

        int rem = num % 7;
        num = num / 7;
        res += rem;
        return base7(num, res);
    }
}