package RecursionPatternWise.GetAStrongHold;

public class CountGoodNumbers {
    public int countGoodNumbers(long n) {
        long evenPositions = (n + 1)/2;
        long oddPositions = n/2;
        final long MOD = 1000000007;

        return (int)((pow(5, evenPositions, MOD) * pow(4, oddPositions, MOD)) % MOD);
    }

    private long pow(int choices, long position, long MOD) {
        if (position == 0) return 1;

        long half = pow(choices, position / 2, MOD);
        if (position % 2 == 0) {
            return (half * half) % MOD;
        } else {
            return (half * half * choices) % MOD;
        }
    }
}