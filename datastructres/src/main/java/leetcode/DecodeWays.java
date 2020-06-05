package main.java.leetcode;

public class DecodeWays {
	 public int numDecodings(String s) {
	        int k=s.length();
	        int[] memo=new int[k+1];
	        return helper(s,k,memo);
	    }
	    public int helper(String s,int k){
	        if(k==0)
	            return 1;
	        int j=s.length()-k;
	        if(s.charAt(j)=='0')return 0;
	        int result=helper(s,k-1);
	        if(k>=2 && Integer.parseInt(s.substring(j,j+2))<=26)
	            result+=helper(s,k-2);
	        return result;
	    }
	    
	    // Dynamic Programming to solve for case "1111111", in this the running time is O(2^n) . 
	    // Using DP the running time is reduced to O(n)

	    public int helper(String s,int k, int[] memo){
	         if(k==0)
	            return 1;
	        int j=s.length()-k;
	        if(s.charAt(j)=='0')return 0;
	        if(memo[k]!=0) return memo[k];
	        int result=helper(s,k-1,memo);
	        if(k>=2 && Integer.parseInt(s.substring(j,j+2))<=26)
	            result+=helper(s,k-2,memo);
	        memo[k]=result;
	        return result;
	    }


	    public int decodeWaysUSingDP(String s){
	 		int[] dp = new int[s.length()+1];
	 		dp[0] =1; //An empty string can decoded in 1 way
			dp[1] = s.charAt(0) == '0'?0:1;//Given mapping starts from 1 .. 26
			for (int i =2;i<=s.length();i++){
				int oneDigit = Integer.parseInt(s.substring(i-1,i));
				int twoDigit = Integer.parseInt(s.substring(i-2,i));
				if(oneDigit>=1){
					dp[i]+=dp[i-1];
				}
				if(twoDigit>=10 && twoDigit<=26){
					dp[i]+=dp[i-2];
				}

			}
			return dp[s.length()];

		}
}
