import java.math.BigInteger;
import java.util.Scanner;

public class mainClass {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        BigInteger[] res = getSeriesSum(n);
        System.out.println(res[0].toString() + "/" + res[1].toString());
    }

    private static BigInteger[] getSeriesSum(int n){
        BigInteger[] result = new BigInteger[2];
        result[0] = new BigInteger("1");
        result[1] = new BigInteger("1");
        if(n == 0 || n == 1){
            return result;
        }
        else{
            for(int i = 2; i <= n; ++i){
                result[0] = result[0].multiply(new BigInteger(Integer.toString(i))).add(result[1]);
                result[1] = result[1].multiply(new BigInteger(Integer.toString(i)));
                result = simplify(result);
            }
            return result;
        }
    }

    public static BigInteger gcm(BigInteger a, BigInteger b) {
        return b.compareTo(new BigInteger("0")) == 0 ? a : gcm(b, a.remainder(b));
    }

    public static BigInteger[] simplify(BigInteger[] arr) {
        if(arr.length != 2) return new BigInteger[2];
        BigInteger gcm = gcm(arr[0], arr[1]);
        arr[0] = arr[0].divide(gcm);
        arr[1] = arr[1].divide(gcm);
        return arr;
    }
}
