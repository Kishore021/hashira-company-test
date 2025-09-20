import java.math.BigInteger;

public class PolynomialExactConstant {
    // Multiply polynomial by (x - r) with sign tracking
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
        // Second test case JSON data
        int k = 7; // from keys.k
        String[][] roots = {
            {"6","13444211440455345511"},
            {"15","aed7015a346d635"},
            {"15","6aeeb69631c227c"},
            {"16","e1b5e05623d881f"},
            {"8","316034514573652620673"},
            {"3","2122212201122002221120200210011020220200"},
            {"3","20120221122211000100210021102001201112121"},
            {"6","20220554335330240002224253"},
            {"12","45153788322a1255483"},
            {"7","1101613130313526312514143"}
        };

        // Start polynomial as 1
        BigInteger[] poly = {BigInteger.ONE};

        // Multiply using first k-1 roots
        for (int i = 0; i < k - 1; i++) {
            int base = Integer.parseInt(roots[i][0]);
            BigInteger r = new BigInteger(roots[i][1], base);
            poly = multiply(poly, r);
        }

        // Print results
        System.out.println("k = " + k);
        System.out.println("Exact constant term: " + poly[0]);
    }
}
