public class Satisfaction {

	/**
	* @param customers stored the number of customers in store in ith minute
	* @param grumpy stored 1:0 of customer satisfaction
	* @param X means the total number of minutes of continuing satisfaction
	*
	*
	* 1 <= X <= customers.length == grumpy.length <= 20000
	* 0 <= customers[i] <= 1000
	* 0 <= grumpy[i] <= 1, 0 (1 = satisfied, 0 = unsatisfied)
	* 
	* Return the total number of satisfied customers
	*/	

	public static int maxSatisfaction(int[] customers, int[] grumpy, int X) {
		int max = 0;
		int n = customers.length;
		int [] dp = new int[n+1];
	    int [] dp2 = new int[n+1];

	    // System.out.println("\nTable");
		for(int i = 0; i < n; i++) {
			dp[i+1] = dp[i] + customers[i];
			dp2[i+1] = dp2[i] + grumpy[i] * customers[i];
	        // System.out.println((i+1) + " " + dp[i+1] + " " + dp2[i+1]);
		}
		// System.out.println();

		for(int i = 0; (i+X) <= n; i++) {
	        int grumpySum = (dp2[n] - (dp2[i+X]-dp2[i]));
			int customerSum = dp[i+X] - dp[i];
			// System.out.println(i + " " + sum + " " + grumpySum);
	      	max = Math.max(customerSum+grumpySum, max);
		}
		// System.out.println();

		return max;
	}

	public static int solution(int[] customers, int[] grumpy, int X) {
		int max = 0;
	  // System.out.println("\nTable");
		for(int i = 0; i < customers.length; i++) {
			int sum = 0;
			for(int j = 0; j < customers.length; j++) {
				if(j >= i && j < i + X)
				sum += customers[j];
	            else
	              sum += customers[j] * grumpy[j];
	          // System.out.println(j + " " + sum);
			} 
	      // System.out.println();
	      max = Math.max(sum, max);
		}
	  return max;
	}

	public static void main(String args[]) { 
		System.out.println("Hello, world!"); 
		int [] customers = {1, 4, 3, 1, 1, 2, 1};
	    int [] grumpy =    {0, 0, 1, 0, 0, 0 ,0};
	    int X = 1;
		int first = solution(customers, grumpy, X);
		int second = maxSatisfaction(customers, grumpy, X);
		System.out.println(first);
		System.out.println(second);
	} 

}