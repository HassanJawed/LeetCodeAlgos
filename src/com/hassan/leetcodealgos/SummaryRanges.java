package com.hassan.leetcodealgos;

import java.util.*;

/**
 * Created by Trikster on 6/27/2015.
 */
public class SummaryRanges {

	public static void main (String[] args) {
		int[] ints = {-1, 1, 2, 3, 5, 6, 8, 10, 11, 12};
		System.out.println( summaryRanges( ints ) );
	}

	public static List<String> summaryRanges(int[] nums) {
		if (nums.length <= 0) {
			return new ArrayList<String>();
		}
		List<String> result = new ArrayList<String>();
		int lastNum = nums[0], start = 0;

		for (int i = 1; i < nums.length; i++) {
			if ((nums[i] - lastNum) == 1) {
				lastNum = nums[i];
			} else {
				result.add( nums[start] == nums[i - 1] ? nums[i - 1] + "" : nums[start] + "->" + nums[i - 1] );
				lastNum = nums[i];
				start = i;
			}
		}
		result.add( nums[start] == nums[nums.length - 1] ? nums[nums.length - 1] + "" :
				nums[start] + "->" + nums[nums.length - 1] );
		return result;
	}
}
