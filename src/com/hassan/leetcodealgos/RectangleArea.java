package com.hassan.leetcodealgos;

/**
 * Created by Trikster on 6/27/2015.
 */
public class RectangleArea {

	public static void main (String[] args) {
//		System.out.println( computeArea( -3, 0, 3, 4, 0, -1, 9, 2 ) );
//		System.out.println( computeArea( 2, 0, 8, 4, 0, -1, 9, 2 ) );
//		System.out.println( computeArea( 8, 0, 14, 4, 0, -1, 9, 2 ) );
//		System.out.println( computeArea( -3, -4, 3, 0, 0, -1, 9, 2 ) );
//		System.out.println( computeArea( -3, 0, 3, 1, 0, -1, 9, 2 ) );
//		System.out.println( computeArea( -2, -2, 2, 2, 3, 3, 4, 4 ) );
		System.out.println( computeArea( -2, -2, 2, 2, -3, -3, 3, -1 ) );
//		System.out.println( isBetween( -3, 3, -2 ) );
//		System.out.println( isBetween( -2, 3, -3 ) );
//		System.out.println( isBetween( -2, 3, 4 ) );
	}

	public static int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
		int l1 = Math.abs( A - C );
		int l2 = Math.abs( E - G );
		int l3 = isBetween( A, C, E ) || isBetween( A, C, G )||isBetween( E, G, A ) || isBetween( E, G, C ) ? Math
				.abs( Math.max( A, E ) - Math.min( C, G ) ) : 0;

		int w1 = Math.abs( B - D );
		int w2 = Math.abs( F - H );
		int w3 = isBetween( B, D, F ) || isBetween( B, D, H ) ||isBetween( F, H, B ) || isBetween( F, H, D ) ? Math
				.abs( Math.max( B, F ) - Math.min( D, H ) ) : 0;

		return l1 * w1 + l2 * w2 - l3 * w3;
	}

	public static boolean isBetween (int A, int B, int C) {
		return Math.abs( A - C ) + Math.abs( B - C ) == Math.abs( A - B );
	}
}
