package algo.code.src.bitopt.bit;

public class BinaryClass {

    public static void main(String[] args) {
        //        print(1);
        //        print( -1);
        int a = 10;
        //        print(a);
        //        print(a << 1);
        //        print(a >> 1);
        int b = -10;
        //        print(b >>> 1);
        //        print(b);
        //        System.out.println(b >>> 1);
        //        System.out.println(b >> 1);
        //        System.out.println("############");
        print(a);
        print(b);
        print(a ^ b);
        //        print(a);
        //        print(b);
        ////        print( a | b);
        ////        print( a & b);
        //        print( a ^ b);

        //        int h = 5;
        //        System.out.println(-h);
        //        System.out.println( ~h + 1);

        //        int arr[] = new int []{5,10,6,50,15};
        //        int arrGetSort[] = new int []{5,10,6,50,15};
        //        Arrays.sort(arr);
        //        printArr(arr);
        //        printArr(getSort(arrGetSort));
        //        int[] arr1 = getArr(100, 5);
        //        int[] arr2 = copyArr(arr1);
        //        Arrays.sort(arr1);
        //        getSort(arr2);
        //        judge(arr1,arr2);

        //        int random = (int) (Math.random() * 100 + 1);
        //
        //        for (int i = 0; i < random; i++) {
        //
        //            int[] arr1 = getArr(1000, 20);
        //            int[] arr2 = copyArr(arr1);
        //            Arrays.sort(arr1);
        //            getSort(arr2);
        //            boolean judge = judge(arr1, arr2);
        //            if (!judge){
        //                System.out.println("系统异常");
        //            }
        //        }
        //
        //        System.out.println(" 没问题 ");
    }

    public static void print(int number) {
        for (int i = 31; i >= 0; i--) {
            System.out.print((number & (1 << i)) == 0 ? "0" : "1");
        }
        System.out.println();
    }

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "  ");
        }
        System.out.println();
    }

    public static int[] getSort(int[] arr) {
        // select sort
        if (arr == null || arr.length == 0) {
            return null;
        }
        for (int i = 0; i < arr.length; i++) {
            int minValue = i;
            for (int j = i + 1; j < arr.length; j++) {
                minValue = arr[minValue] < arr[j] ? minValue : j;
            }
            swap(arr, i, minValue);
        }
        return arr;
    }

    public static void swap(int arr[], int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    /**
     * @param len 闯入数组长度
     * @param numMax 数组内数字最大值
     * @return 目标数组
     */
    public static int[] getArr(int len, int numMax) {
        int arr[] = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = (int) (Math.random() * numMax + 1);
        }
        return arr;
    }

    public static int[] copyArr(int arr[]) {
        int arrRes[] = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            arrRes[i] = arr[i];
        }

        return arrRes;
    }

    /*
          比较器
    */
    public static boolean judge(int arr1[], int arr2[]) {
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                System.out.println(
                        "返回的值不对 : 第" + i + "位置的数字 arr1=" + arr1[i] + " * arr2=" + arr2[i]);
                System.out.println(arr1.length);
                return false;
            }
        }
        return true;
    }
}
