package worksheet1;

public class Recursion {

    /** Print numbers n, n-1, ... 0
     * n a non-negative integer
     */

    static void printNums(int n) {
	if (n == 0) {
	    System.out.print(0);
	    return;
	}
	else {
	    System.out.print(n);
	    printNums(n-1);
	    return;
	}

    }
    /** Print numbers 0, 1, ..., n-1, n
     * n non-negative integer
     */
    
    static void printNumsUp(int n) {
	if (n == 0) {
	    System.out.print(0);
	    return;
	}
	else {
	    printNumsUp(n-1);
	    System.out.print(n);
	    return;
	}
    }

    /** Factorial of a non-negative integer
     */

    static int factorial(int n) {
	if (n == 0)
	    return 1;
	else 
	    return n * factorial(n-1);
    }

    /** Print n *'s on a line.
     * n must be a non-negative integer.
     */
    
    static void stars(int n) {
	if (n == 0)
	    return;
	else {
	    System.out.print('*');
	    stars(n-1);
	    return;
	}
    }

    /** Print a triangle of stars of width and height n (non-negative integer)
     */

    static void triangle(int n) {
	if (n == 0)
	    return;
	else {
	    stars(n);
	    System.out.println();
	    triangle(n-1);
	    return;
	}
    }

    /* Compute m to the power of n, both non-negative integers
     */

    static int power(int m, int n) {
	if (n == 0)
	    return 1;
	else {
	    int y = power(m, n-1);
	    return y*m;
	}
    }

    /** Computer m to the power of n faster in O(log n) time
     */

    static int fastPower(int m, int n) {
	/* Exercise */
	return 0; // dummy result
    }

    /** Binomial coefficient "m choose n", both non-negative integers
     */

    static int choose(int m, int n) {
	if (n == 0)
	    return 1;
	else if (m == 0)
	    return 0;
	else {
	    int x = choose(m-1, n-1);
	    int y = choose(m-1, n);
	    return x + y;
	}
    }
}
