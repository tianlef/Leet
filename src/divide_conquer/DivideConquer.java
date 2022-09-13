package divide_conquer;

/**
 * 分治算法LeetCode
 * 1. Pow(x,n)
 */
public class DivideConquer {

    public static double myPow(double x, int n) {


        if (n == 1) {
            return x;
        }
        if (n == 0) {
            return 1;
        }
        if (n == -1) {
            return 1/x;
        }

        int resultOfDivision = n / 2;
        int reminder = n % 2;
        double halfResult = myPow(x, resultOfDivision);
        if (reminder == 1) {
            return halfResult * halfResult * x;
        }
        else if (reminder == -1) {
            return halfResult * halfResult * 1/x;
        }
        else {
            return halfResult * halfResult;
        }

    }

    public static void main(String[] args) {
        System.out.println(myPow(2,-2147483648));
    }
}
