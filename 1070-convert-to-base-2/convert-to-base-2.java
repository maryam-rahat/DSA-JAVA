class Solution {
    public String baseNeg2(int n) {
        if(n==0) return "0";
        return division(n, "");
    }
    private String division(int n, String res){
        
        if(n==0) return new StringBuilder(res).reverse().toString();

        int rem = n%-2;
        n = n/-2;

        if(rem<0){
            rem+=2;
            n += 1;
        }
        res+= rem;
        return division(n, res);
    }
}