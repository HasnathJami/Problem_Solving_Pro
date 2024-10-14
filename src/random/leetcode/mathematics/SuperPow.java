package random.leetcode.mathematics;

//note same as "POW(x,n)" with mod
// Result: ERROR (UNSOLVED)
class SuperPow {
    public int superPow(int a, int[] b) {
        int result = 1;
        int B = 0;
        int resBase = (int) Math.pow(10, b.length - 1);
        int mod = 1337;

        // Construct B from the array b
        for (int i = 0; i < b.length; i++) {
            B += (resBase * b[i]); // Construct the number B without modulus
            resBase /= 10;          // Decrease the positional value
        }

        // Remove unnecessary negative checks, since B should be non-negative
        // Compute result using modular exponentiation
        //or just, a = a % mod; // Reduce a modulo 1337
        while (B > 0) {
            if (B % 2 == 1) {
                result = (result * (a % mod)) % mod; // Multiply result by a
            }
            a = ((a % mod) * (a % mod)) % mod; // Square a
            B /= 2;            // Divide B by 2
        }

        return result; // Return the result modulo 1337
    }
}

