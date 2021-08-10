//Time Complexity : O(max(m,n)), m -> Length of order, n -> Length of String 
// Space Complexity : O(n), n -> Length of String
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem1;

public class CustomSortString {
	public String customSortString(String order, String str) {
		if (str == null || str.length() == 0) {
			return str;
		}

		int[] cnt = new int[26];
		for (char ch : str.toCharArray()) {
			cnt[ch - 'a']++;
		}

		StringBuilder ans = new StringBuilder();

		for (char ch : order.toCharArray()) {
			for (int i = 0; i < cnt[ch - 'a']; i++) {
				ans.append(ch);
			}
			cnt[ch - 'a'] = 0;
		}

		for (char ch = 'a'; ch <= 'z'; ch++) {
			for (int i = 0; i < cnt[ch - 'a']; i++) {
				ans.append(ch);
			}
		}

		return ans.toString();
	}

	public static void main(String[] args) {
		CustomSortString obj = new CustomSortString();
		String order = "cba";
		String str = "abcd";
		System.out.println("Custom Sorted String: " + obj.customSortString(order, str));
	}

}