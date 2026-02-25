class Solution {
    public int[] sortByBits(int[] arr) {
          // Convert int[] to Integer[] for custom sorting
        Integer[] temp = new Integer[arr.length];
        for(int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
        }
        
        // Sort using custom comparator
        Arrays.sort(temp, (a, b) -> {
            int countA = Integer.bitCount(a);
            int countB = Integer.bitCount(b);
            
            if(countA == countB) {
                return a - b;   // ascending order if bit count same
            }
            
            return countA - countB;  // sort by bit count
        });
        
        // Convert back to int[]
        for(int i = 0; i < arr.length; i++) {
            arr[i] = temp[i];
        }
        
        return arr;
    
    }
}