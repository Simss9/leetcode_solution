class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int size = nums1.length + nums2.length;
        int[] merged = new int[size];
        int k = 0;
        for(int i = 0;i < nums1.length ; i++){
            merged[k++] = nums1[i];
        }
        for(int i =0;i< nums2.length ; i++){
            merged[k++] = nums2[i];
        }
        Arrays.sort(merged);
        if(size % 2 !=0){
            return merged[size / 2];
        }else{
            return(merged[size / 2 -1 ] + merged[size / 2] ) /2.0;
        }

    }
}