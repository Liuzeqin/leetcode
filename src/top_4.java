import java.util.Map;

public class top_4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        int totallen = len1 + len2;
        if (totallen % 2 == 1) {
            int midIndex = totallen / 2 + 1;
            double median = getKthElement(nums1, nums2, midIndex);
            return median;
        }else{
            int midIndex = totallen / 2;
            double median = (getKthElement(nums1, nums2, midIndex) + getKthElement(nums1, nums2, midIndex + 1)) / 2;
            return median;
        }
    }

    //利用二分查找的思想，每轮在每个数组中查找对应的第k/2个元素，对两个数进行比较，然后较小那个数所在数组
    //中剔除k/2个元素，更新该数组其实位置以及k=k/2进行下一轮查找
    public int getKthElement(int[] num1, int[] num2, int k){
        int len1 = num1.length, len2 = num2.length;
        int index1 = 0, index2 = 0;
        while (true) {
            if (index1 == len1) {
                return num2[index2 + k - 1];
            }
            if (index2 == len2) {
                return num1[index1 + k - 1];
            }
            if (k == 1) {
                return Math.min(num1[index1], num2[index2]);
            }
            int half = k / 2;
            int newIndex1 = Math.min(index1 + half, len1) - 1;
            int newIndex2 = Math.min(index2 + half, len2) - 1;
            int pivot1 = num1[newIndex1], pivot2 = num2[newIndex2];
            if (pivot1 <= pivot2) {
                k -= (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            }else {
                k -= (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }
        }
    }
}
