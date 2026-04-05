class Solution {
    public boolean judgeCircle(String moves) {
      int k = 0;
      int j = 0;
      int size = moves.length();
      for(int i = 0 ; i <size;i++){
        if(moves.charAt(i)== 'U'){
            k = k -1;
        }
        if(moves.charAt(i)== 'D'){
          k = k + 1;
      }
        if(moves.charAt(i)== 'L'){
           j = j - 1;

    }
        if(moves.charAt(i)== 'R'){
             j = j + 1;

    }
 }
 if (k == 0 && j == 0){
    return true;
 }
   return false;
}
}