package studio6;

import edu.princeton.cs.introcs.StdDraw;

public class RecursiveMethods {

	/**
	 * Computes the geometric sum for the first n terms in the series
	 * 
	 * @param n the number of terms to include in the sum
	 * @return the sum of the first n terms of the geometric series (1/2 + 1/4 + 1/8
	 *         ...)
	 */
	public static double geometricSum(int n) {
		
		double sum = 0.0;
		
		if(n == 0)
		{
			return sum;		
		}
		else
		{
			sum += Math.pow(0.5, n);
			return sum + geometricSum(n-1);
		}
		
	}

	/**
	 * This method uses recursion to compute the greatest common divisor
	 * for the two input values
	 * 
	 * @param p first operand
	 * @param q second operand
	 * @return greatest common divisor of p and q
	 */
	public static int gcd(int p, int q) {
		
			// FIXME compute the gcd of p and q using recursion
			
			if(q == 0)
			{
				return p;
			}
			else 
			{
				int temp = q;
				q = p % q;
				p = temp;
				
				return gcd(p, q);
			}
		
			
		
	}

	

	/**
	 * This method uses recursion to create a reverse of the given array
	 * 
	 * @param array the array to create a reverse of, not to be mutated
	 * @return an array with the same data as the input but it reverse order
	 */
	public static int[] toReversed(int[] array) {
		
			int[] reversed = new int[array.length];
			
			
			if(array.length == 0) {
				return reversed;
			}
			else
			{
				int startIndex = 0;
				
				reversed = helper(startIndex, reversed, array);	
				return reversed;
			}
			
		
	}
	
	public static int[] helper(int startIndex, int[] reversed, int[] array)
	{

		if(startIndex > array.length-1)
		{
			return reversed;
		}
		else
		{
			reversed[startIndex] = array[(array.length-1)-startIndex];
			startIndex++;
			return helper(startIndex, reversed, array);
		}

		
		
	}

	/**
	 * @param xCenter                       x-coordinate of the center of the circle
	 *                                      at the current depth
	 * @param yCenter                       y-coordinate of the center of the circle
	 *                                      at the current depth
	 * @param radius                        radius of the circle at the current
	 *                                      depth
	 * @param radiusMinimumDrawingThreshold radius above which drawing should occur
	 */
	public static void circlesUponCircles(double xCenter, double yCenter, double radius,
			double radiusMinimumDrawingThreshold) {
		
		if(radius < radiusMinimumDrawingThreshold)
		{
			StdDraw.circle(0,0,0);
		}
		else
		{
			StdDraw.circle(xCenter, yCenter, radius);
			
			circlesUponCircles(xCenter + radius, yCenter, radius/3, radiusMinimumDrawingThreshold);
			circlesUponCircles(xCenter - radius, yCenter, radius/3, radiusMinimumDrawingThreshold);
			circlesUponCircles(xCenter, yCenter + radius, radius/3, radiusMinimumDrawingThreshold);
			circlesUponCircles(xCenter, yCenter - radius, radius/3, radiusMinimumDrawingThreshold);
			
			
		}
		
		// FIXME
	}

}
