package alexander.sergeev.leetcode.tasks;

// 165. Compare Version Numbers
public class a165 {

    /*
    Given two version strings, version1 and version2, compare them.
    A version string consists of revisions separated by dots '.'.
    The value of the revision is its integer conversion ignoring leading zeros.
    To compare version strings, compare their revision values in left-to-right order.
    If one of the version strings has fewer revisions, treat the missing revision values as 0.
     */

    public static void main(String[] args) {

        String a = "1.2";
        String b = "1.10";

        System.out.println(compareVersion(a, b)); // -1
    }

    public static int compareVersion(String version1, String version2) {
        String[] nums1 = version1.split("\\.");
        String[] nums2 = version2.split("\\.");
        int n1 = nums1.length, n2 = nums2.length;
        int i1, i2;
        for (int i = 0; i < Math.max(n1, n2); ++i) {
            i1 = i < n1 ? Integer.parseInt(nums1[i]) : 0;
            i2 = i < n2 ? Integer.parseInt(nums2[i]) : 0;
            if (i1 != i2) {
                return i1 > i2 ? 1 : -1;
            }
        }
        return 0;
    }
}
