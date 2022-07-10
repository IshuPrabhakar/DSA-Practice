class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        // step 1: merge the input array
        // step 2: find two mid point if length is even
        // step 3: return the median
        
        int[] res = merge(nums1,nums2);
        int l = res.length;
        
        if(l % 2 == 0){
            // if length is even then there will be two medians
            int a = l/2 - 1, b = l/2;
            double r = res[a] + res[b];

            return r/2;
        }
        
        int a = l/2 ;
        double r = res[a] /1;
        
        return r;
    }
    
    public int[] merge(int[] nums1, int[] nums2){
        // total length of both the arrays
        int size = nums1.length + nums2.length;
        
        // resultant array
        int[] res = new int[size];
            
        int i = 0, j = 0, k = 0;
        while(i < nums1.length && j < nums2.length){
            
            if(nums1[i] < nums2[j]){
                res[k] = nums1[i];
                i++;
            }
            else{
                res[k] = nums2[j];
                j++;
            }
            k++;
        }
        
        
        while(i < nums1.length){
            res[k++] = nums1[i++];
        }
        
        while(j < nums2.length){
            res[k++] = nums2[j++];
        }
        
        return res;
    }
}
