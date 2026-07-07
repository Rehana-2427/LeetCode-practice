class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
       int size = m+n;
        int[] arr = new int[size];
	     int f1=0;int f2=0;
	     int i=0;
	     while(f1<m && f2<n){
	         if(nums1[f1] <= nums2[f2]){
	             arr[i]=nums1[f1];
	             f1++;
	             i++;
	         }
	         else if(nums2[f2] < nums1[f1]){
	             arr[i] = nums2[f2];
	             f2++;
	             i++;
	         }
	     }
	     while(f1<m){
	         arr[i]=nums1[f1];
	         f1++;
	         i++;
	     }
	     while(f2<n){
	     arr[i] = nums2[f2];
	     f2++;
	     i++;
	     }
         for(int j=0;j<size;j++){
            nums1[j]=arr[j];
         }
	     System.out.println(Arrays.toString(nums1));
        
    }
}