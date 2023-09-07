package algo.code.src.bitopt.bit;

import java.util.HashMap;
import java.util.HashSet;

public class BitKM {
    public static void main(String[] args) {
        //        int[] arr2 = {2, 2 ,2 ,6 ,6 ,6,3};
        //        int i = getKNumber(arr2, 1, 3);
        //        System.out.println(i);
        int maxKinds = 100;
        int k = 7;
        int m = 8;
        int range = 200;
        //        for (int j = 0; j < 1000; j++) {
        //            int[] randomArr = getRandomArr(maxKinds, range, k, m);
        //            int mapValue = myHashMapTest(randomArr, k, m);
        //            int kNumber = getKNumber(randomArr, k, m);
        //            if(mapValue != kNumber){
        //                System.out.println(mapValue);
        //                System.out.println(kNumber);
        //                System.out.println("出错了 " );
        //            }
        //        }
        //        System.out.println(" no problem");

        for (int j = 0; j < 1000; j++) {
            int[] randomArr = getRandomArrForIfHasK(maxKinds, range, k, m);
            int mapValue = myHashMapTest(randomArr, k, m);
            int kNumber = getKNumberIfHas(randomArr, k, m);
            if (mapValue != kNumber) {
                System.out.println(mapValue);
                System.out.println(kNumber);
                System.out.println("出错了 ");
            }
        }
        System.out.println(" no problem");
    }

    // arr种 找出出现k次的数
    public static int getKNumber(int arr[], int k, int m) {
        int[] arrRes = new int[32];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < 32; j++) {
                // 1010101
                //                if(((arr[i] >> j) & 1) == 1){
                //                    arrRes[j] ++;
                //                }
                arrRes[j] += (arr[i] >> j) & 1;
            }
        }
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if (arrRes[i] % m == k) {
                res |= (1 << i);
            }
        }
        return res;
    }

    // arr种 如果有出现k次的数 返回 否则 返回 -1
    public static int getKNumberIfHas(int arr[], int k, int m) {
        int[] arrRes = new int[32];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < 32; j++) {
                // 1010101
                //                if(((arr[i] >> j) & 1) == 1){
                //                    arrRes[j] ++;
                //                }
                arrRes[j] += (arr[i] >> j) & 1;
            }
        }
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if (arrRes[i] % m != 0) {
                if (arrRes[i] % m == k) {
                    res |= (1 << i);
                } else {
                    return -1;
                }
            }
        }
        if (res == 0) {
            int count = 0;
            for (int num : arr) {
                if (num == 0) {
                    count++;
                }
            }
            if (count != k) {
                return -1;
            }
        }
        return res;
    }

    public static int myHashMapTest(int[] arr, int k, int m) {
        // HashMap< 数字，出现的次数 >
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            Integer orDefault = hashMap.getOrDefault(arr[i], 0);
            hashMap.put(arr[i], ++orDefault);
        }
        for (int num : hashMap.keySet()) {
            if (hashMap.get(num) == k) {
                return num;
            }
        }

        return -1;
    }

    public static int[] getRandomArr(int maxKinds, int range, int k, int m) {
        // 出现了K次的数
        int kNum = getRangeNumber(range);
        int kinds = (int) (Math.random() * maxKinds) + 2;
        int[] arrRes = new int[k + m * (kinds - 1)];
        HashSet<Integer> hashSet = new HashSet<>();
        int index = 0;
        for (int i = 0; i < k; i++) {
            arrRes[index++] = kNum;
        }
        hashSet.add(kNum);
        kinds--;
        while (kinds > 0) {
            int num;
            do {
                num = getRangeNumber(range);
            } while (hashSet.contains(num));
            hashSet.add(num);
            kinds--;
            for (int i = 0; i < m; i++) {
                arrRes[index++] = num;
            }
        }
        for (int i = 0; i < arrRes.length; i++) {
            int change = (int) (Math.random() * arrRes.length);
            int temp = arrRes[i];
            arrRes[i] = arrRes[change];
            arrRes[change] = temp;
        }
        return arrRes;
    }

    public static int[] getRandomArrForIfHasK(int maxKinds, int range, int k, int m) {
        // 出现了K次的数
        int kNum = getRangeNumber(range);
        int kTimes = Math.random() < 0.5 ? k : (int) ((Math.random() * (m - 1)) + 1);
        int kinds = (int) (Math.random() * maxKinds) + 2;
        int[] arrRes = new int[kTimes + m * (kinds - 1)];
        HashSet<Integer> hashSet = new HashSet<>();
        int index = 0;
        for (int i = 0; i < kTimes; i++) {
            arrRes[index++] = kNum;
        }
        hashSet.add(kNum);
        kinds--;
        while (kinds > 0) {
            int num;
            do {
                num = getRangeNumber(range);
            } while (hashSet.contains(num));
            hashSet.add(num);
            kinds--;
            for (int i = 0; i < m; i++) {
                arrRes[index++] = num;
            }
        }
        for (int i = 0; i < arrRes.length; i++) {
            int change = (int) (Math.random() * arrRes.length);
            int temp = arrRes[i];
            arrRes[i] = arrRes[change];
            arrRes[change] = temp;
        }
        return arrRes;
    }

    // [-range, +range]
    public static int getRangeNumber(int range) {
        return (int) (Math.random() * (range + 1) - (int) (Math.random() * (range + 1)));
    }
}
