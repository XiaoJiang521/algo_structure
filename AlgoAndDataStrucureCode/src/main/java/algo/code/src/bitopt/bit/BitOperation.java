package algo.code.src.bitopt.bit;

public class BitOperation {
    public static void main(String[] args) {
        exchangeTwoNumber(-1, 2);
    }

    /** 交换值 */
    public static void exchangeTwoNumber(int num1, int num2) {

        num1 = num1 ^ num2;
        num2 = num1 ^ num2;
        num1 = num2 ^ num1;

        System.out.println(num1 + "  ***   " + num2);
    }
}
