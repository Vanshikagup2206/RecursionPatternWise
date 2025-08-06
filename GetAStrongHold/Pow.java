package RecursionPatternWise.GetAStrongHold;

// class Solution {
//     public double myPow(double x, int n) {
//         if (n == 0) return 1.0;
//         long exp = n;
//         boolean negative = false;
//         if (exp < 0) {
//             negative = true;
//             exp = -exp;
//         }

//         double result = 1.0;
//         while (exp > 0) {
//             if ((exp & 1) == 1) {
//                 result *= x;
//             }
//             x *= x;
//             exp >>= 1;
//         }

//         return negative ? 1.0 / result : result;
//     }
// }

public class Pow {
    public double myPow(double x, int n) {
        if (n == 0) return 1.0;
        long exp = n;
        boolean negative = false;
        if (exp < 0) {
            negative = true;
            exp = -exp; 
        }
        double result = powHelper(x, exp);
        return negative ? 1.0 / result : result;
    }

    private double powHelper(double x, long exp) {
        if (exp == 0) return 1.0;
        double half = powHelper(x, exp / 2);
        if (exp % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }
}