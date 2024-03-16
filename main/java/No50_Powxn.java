import java.util.HashMap;
import java.util.Map;

/**
 * @author vneli
 * @since 1.0
 */
public class No50_Powxn {
    public static void main(String[] args) {
        Solution501 solution = new Solution501();
        System.out.println(solution.myPow(2, 10));
        System.out.println(solution.myPow(2, -2));
    }
}

class Solution501 {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        boolean multiply = n > 0;
        boolean more = n == Integer.MIN_VALUE;
        if (more) {
            n = Integer.MAX_VALUE;
        }
        else if (n < 0) {
            n = -n;
        }
        double sum = x;
        int power = 2;
        Map<Integer, Double> record = new HashMap<>();
        while (power <= n && power > 0) {
            sum *= sum;
            record.put(power, sum);
            power <<= 1;
        }
        power >>>= 1;
        n -= power;
        record.put(1, x);
        if (n > 0) {
            while (power > 0) {
                while (n >= power) {
                    sum *= record.get(power);
                    n -= power;
                }
                if (n == 0) {
                    break;
                }
                power >>= 1;
            }
        }
        if (more) {
            sum *= x;
        }
        return multiply ? sum : 1 / sum;
    }
}


class Solution502 {
    public double myPow(double x, int n) {
        long nl = n;
        return nl >= 0 ? quickMul(x, nl) : 1.0 / quickMul(x, -nl);
    }

    public double quickMul(double x, long n) {
        if (n == 0) {
            return 1.0;
        }
        double y = quickMul(x, n >> 1);
        return (n & 0x1) == 0 ? y * y : y * y * x;
    }
}