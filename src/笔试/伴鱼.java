package 笔试;

/**
 * Created by xieli on 2021/3/30.
 */
public class 伴鱼 {

    /**
     * 80%
     * @param arr
     * @return
     */
    public boolean validMountainArray(int[] arr) {
        if (arr == null || arr.length < 3)
            return false;

        for (int k = 1; k < arr.length - 1; k++) {

            for (int i = k - 1; i >= 0; i--) {
                if (arr[k] <= arr[i]) {
                    return false;
                }
            }

            for (int j = k + 1; j < arr.length; j++) {
                if (arr[k] <= arr[j]) {
                    return false;
                }
            }

        }

        return true;
    }

    public int NumberOfTriplets (int[] arr) {
        return 0;
    }

}
