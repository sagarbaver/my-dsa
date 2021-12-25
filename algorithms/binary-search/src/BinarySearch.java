public class BinarySearch {

  public static void main(String[] args) {
    int[] nums = {-1, 0, 3, 5, 9, 12};
    System.out.println(search(nums, 2));
  }

  public static int search(int[] nums, int target) {
    int pivot = -1, left = 0, right = nums.length - 1;

    while (left <= right) {
      pivot = left + (right - left) / 2;

      if (nums[pivot] == target) {
        return pivot;
      }

      if (target < nums[pivot]) {
        right = pivot - 1;
      } else {
        left = pivot + 1;
      }
    }

    return -1;
  }

}
