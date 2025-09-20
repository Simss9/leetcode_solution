class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int n = heights.length;
        int maxArea = 0;

        for(int i = 0; i <= n; i++){
            int currentHeight = (i==n) ? 0 : heights[i];
            while(!stack.isEmpty() && currentHeight < heights[stack.peek()]){
                int topIndex = stack.pop();
                int height = heights[topIndex];
                int width;
                if(stack.isEmpty()){
                    width = i;
                }
                else{
                    width = i - stack.peek() - 1;
                }
                int area = height * width;
                maxArea = Math.max(maxArea , area);
            }
            stack.push(i);

        }
        return maxArea;
    }

}