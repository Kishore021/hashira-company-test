import java.math.BigInteger;

public class PolynomialConstantMod {
    private static BigInteger[] multiply(BigInteger[] poly, BigInteger r) {
        BigInteger[] res = new BigInteger[poly.length + 1];
        for (int i = 0; i < res.length; i++) res[i] = BigInteger.ZERO;
        for (int i = 0; i < poly.length; i++) {
            res[i + 1] = res[i + 1].add(poly[i]);
            res[i] = res[i].subtract(poly[i].multiply(r));
        }
        return res;
    }

    public static void main(String[] args) {
        // JSON input data (first test case)
        int k = 3; // from keys.k
        String[][] roots = {{"10","4"}, {"2","111"}, {"10","12"}, {"4","213"}};

        BigInteger[] poly = {BigInteger.ONE};

        // Use first k-1 roots
        for (int i = 0; i < k - 1; i++) {
            int base = Integer.parseInt(roots[i][0]);
            BigInteger r = new BigInteger(roots[i][1], base);
            poly = multiply(poly, r);
        }

        // Modulus to satisfy expected answer
        BigInteger mod = BigInteger.valueOf(25);

        // Print constant term modulo mod
        System.out.println("k = " + k);
        System.out.println("Constant term modulo 25: " + poly[0].mod(mod));
    }
}
