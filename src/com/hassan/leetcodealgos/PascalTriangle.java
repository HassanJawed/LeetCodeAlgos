package com.hassan.leetcodealgos;

import java.util.List;
import java.util.ArrayList;
/**
 * Created by Trikster on 7/26/2015.
 */
public class PascalTriangle {

	public static void main (String[] args) {
		System.out.println( new PascalTriangle().generate( 2 ) );
		System.out.println( new PascalTriangle().generate( 3 ) );
	}

	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> temp = new ArrayList<Integer>();
		List<Integer> last = new ArrayList<Integer>();
		if(numRows<1) {
			result.add( temp );
			return result;
		}
		if(numRows==1) {
			temp.add(1);
			result.add( temp );
		}
		else if (numRows>=2) {
			for(int i = 0; i < numRows; i++) {
				for(int j = 0;j<=i;j++) {
					temp.add(1);
				}
				result.add( last = new ArrayList<Integer>( temp ));
				temp.clear();
			}
		}
		int j;
		for(int i = 3; i <= numRows; i++){
			temp.add(1);
			for(j = 1; j <= (Math.ceil(i/2) -1 );j++){
				temp.add(last.get(j) + last.get(j-1));
			}
			for(int k = j-1;k>=0;k--){
				temp.add(temp.get(k));
			}
			result.add(last=new ArrayList<Integer>( temp ));
			temp.clear();
		}
		return result;
	}
}
