public class power {
    public double myPow(double x, int n) {
        long N = n;
        return n > 0 ? myPowL(x, N) : myPowL(1/x, -N);
    }
    double myPowL(double x, long N) {
        if (N == 1) return x;
        if (N == 0) return 1;
        double subres;
        subres = myPowL(x, N/2);
        return N%2 == 0 ? subres * subres : subres * subres * x;
    }

}
