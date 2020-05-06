package main.java.leetcode;

public class StringInterleave {
	
	
	 public boolean isInterleave_dfs(String s1, String s2, String s3) {
	        char[] c1 = s1.toCharArray(), c2 = s2.toCharArray(), c3 = s3.toCharArray();
	        int m = s1.length(), n = s2.length();
	        if(m + n != s3.length()) return false;
	        return dfs(c1, c2, c3, 0, 0, 0, new boolean[m + 1][n + 1]);
	    }

	    public boolean dfs(char[] c1, char[] c2, char[] c3, int i, int j, int k, boolean[][] invalid) {
	        if(invalid[i][j]) return false;
	        if(k == c3.length) return true;
	        boolean valid =
	                i < c1.length && c1[i] == c3[k] && dfs(c1, c2, c3, i + 1, j, k + 1, invalid) ||
	                        j < c2.length && c2[j] == c3[k] && dfs(c1, c2, c3, i, j + 1, k + 1, invalid);
	        if(!valid) invalid[i][j] = true;
	        return valid;
	    }
	
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s3.length()!=(s1.length()+s2.length())) return false;
        
        boolean[][] T=new boolean[s1.length()+1][s2.length()+1];
        
        for(int i=0;i<=s1.length();i++){
            for(int j=0;j<=s2.length();j++){
                int l=i+j-1;
                if(i==0 && j==0)
                    T[i][j]=true;
                else if(i==0){
                    if(s3.charAt(l)==s2.charAt(j-1))
                        T[i][j]=T[i][j-1];
                }
                else if(j==0){
                    if(s3.charAt(l)==s1.charAt(i-1))
                        T[i][j]=T[i-1][j];
                }
                else {
                    T[i][j]=(s3.charAt(l)==s1.charAt(i-1)?T[i-1][j]:false) || (s3.charAt(l)==s2.charAt(j-1)?T[i][j-1]:false);
                }
            }
        }
        return T[s1.length()][s2.length()];
    }
    
    public static void main(String[] args) {
		String s2="aab";
		String s1="axy";
		String s3="aaxaby";
		StringInterleave stringInterleave=new StringInterleave();
		stringInterleave.isInterleave(s1, s2, s3);
	}
}
