class Solution {
    public boolean hasAlternatingBits(int n) {
        while(n>0){
            int lastbit = n % 2;
            n = n / 2;
            int nextbit = n % 2;
            if(lastbit==nextbit){
                return false;
            }
            
               
            

        }
        return true;
    }
}