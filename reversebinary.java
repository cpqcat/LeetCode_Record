public class reversebinary {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0, power = 31;
        while (power >= 0) {
            res += (n & 1) << power;
            n = n >> 1;
            power = power - 1;
        }
        return res;
    }
}