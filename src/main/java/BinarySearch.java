/**
 * @author suwenguang
 * email suveng@163.com
 * since 2019/4/13
 * description:二分查找demo写发放【重要】
 **/
public class BinarySearch {
    /**
     * 查找数组中的数字
     *
     * @param nums   数组
     * @param target 数字
     *
     * @return -1：没找到；
     */
    public int binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;

        //相邻退出，start=3&&end=4 时就退出
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;

            if (target == nums[mid]) {
                end = mid;
            } else if (target < nums[mid]) {
                end = mid;
            } else if (target > nums[mid]) {
                start = mid;
            }
        }

        //双重校验，查看start和end
        if (target == nums[start]) {
            return nums[start];
        }
        if (target == nums[end]) {
            return nums[end];
        }
        return -1;
    }
}
