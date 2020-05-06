package main.java.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ApproximateMatching {

	  public static List<String> getSubstring(String s) {
		  List<String> subString=new ArrayList<>();
		  for(int i=0;i<s.length();i++) {
			  for(int j=1;j<=s.length()-i;j++) {
				  subString.add(s.substring(i, i+j));
			  }
		  }
		  return subString;
	  }
	public static int getSubstringScore(String sub,String word) {
		  if(word.contains(sub))
			  return sub.length();
		  return 0;
	  }
	  
	  public static HashMap<String, Integer> sortByValue(Map<String, Integer> hm) 
	  { 
	      // Create a list from elements of HashMap 
	      List<Map.Entry<String, Integer> > list = 
	             new LinkedList<Map.Entry<String, Integer> >(hm.entrySet()); 

	      // Sort the list 
	      Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() { 
	          public int compare(Map.Entry<String, Integer> o1,  
	                             Map.Entry<String, Integer> o2) 
	          { 
	              return (o2.getValue()).compareTo(o1.getValue()); 
	          } 
	      }); 
	        
	      // put data from sorted list to hashmap  
	      HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>(); 
	      for (Map.Entry<String, Integer> aa : list) { 
	          temp.put(aa.getKey(), aa.getValue()); 
	      } 
	      return temp; 
	  }
	  
	  public static String getScore(String text,String prefix,String suffix) {
		  List<String> subString=getSubstring(text);
		  Map<String,Integer> mapPrefix=new TreeMap<>();
		  Map<String,Integer> mapSuffix=new TreeMap<>();
		  for(String token:subString) {
			 int prefixScore=getSubstringScore(token, prefix);
			 int suffixScore=getSubstringScore(token, suffix);
			 mapPrefix.put(token, prefixScore);
			 mapSuffix.put(token, suffixScore);
		  }
		  Map<String,Integer> sorteMapPrefix=sortByValue(mapPrefix);
		  Map<String,Integer> sorteMapSuffix=sortByValue(mapSuffix);
		  Map.Entry<String,Integer> preFix=sorteMapPrefix.entrySet().iterator().next();
		  Map.Entry<String,Integer> sufFix=sorteMapSuffix.entrySet().iterator().next();
		  String higPre=(preFix.getKey());
		  String higSuffix=(sufFix.getKey());
		  if(preFix.getValue()==sufFix.getValue()) {
			  if(higPre.compareTo(higSuffix)<0)return higPre;
			  else return higSuffix;
		  }
		  
		  int startEnd=text.indexOf(higSuffix);
		  String part1="";
		  String part2="";
		  String part3="";
		  if(higPre.length()>=0) {
			  part1=text.substring(0, higPre.length());
		  }
		  if(higPre.length()>0&&startEnd>higPre.length()) {
			  part2=text.substring(higPre.length(), startEnd);
		  }
		  if(startEnd>0&&startEnd<=text.length()) {
			  part3=text.substring(startEnd, higSuffix.length()+startEnd);;
		  }
		  
		 String result= part1+part2+part3;

				 
		  return result;
	  }
	  
	  public static String calculateScore(String text,String prefix,String suffix) {
		  List<String> subString=new ArrayList<>();
		  for(int i=0;i<text.length();i++) {
			  for(int j=1;j<=text.length()-i;j++) {
				  subString.add(text.substring(i, i+j));
			  }
		  }
		  int maxPrefixScore=Integer.MIN_VALUE;
		  int maxSuffixScore=Integer.MIN_VALUE;
		  String prefixToken="";
		  String suffixToken="";
		  int currenMaxPrescore=0;
		  int currenMaxSufscore=0;
		  for(String token:subString) {
			 int prefixScore=getSubstringScore(token, prefix);
			 int suffixScore=getSubstringScore(token, suffix);
			 maxPrefixScore=Math.max(prefixScore, maxPrefixScore);
			 if(maxPrefixScore>currenMaxPrescore) {
				 prefixToken=token;
			 }
			 maxSuffixScore=Math.max(maxSuffixScore, suffixScore);
			 if(maxSuffixScore>currenMaxSufscore) {
				 suffixToken=token;
			 }
			 
			 currenMaxPrescore=maxPrefixScore;
			 currenMaxSufscore=maxSuffixScore;

		  }

		  if(prefixToken.length()==suffixToken.length()) {
			  if(prefixToken.compareTo(suffixToken)<0)return prefixToken;
			  else return suffixToken;
		  }
		  
		  int startEnd=text.indexOf(suffixToken);
		  String part1="";
		  String part2="";
		  String part3="";
		  if(prefixToken.length()>=0) {
			  part1=text.substring(0, prefixToken.length());
		  }
		  if(prefixToken.length()>0&&startEnd>prefixToken.length()) {
			  part2=text.substring(prefixToken.length(), startEnd);
		  }
		  if(startEnd>0&&startEnd<=text.length()) {
			  part3=text.substring(startEnd, suffixToken.length()+startEnd);;
		  }
		  
		 String result= part1+part2+part3;

				 
		  return result;
	  }
	  
	
	  public static void main(String[] args) {
		  //Test Case 1:
		  String text="nothing";
		  String prefix="bruno";
		  String suffix="ingenious";
		  System.out.println(calculateScore(text, prefix, suffix));
		  
		  //Test Case 2:
		   text="ab";
		   prefix="b";
		   suffix="a";
		  System.out.println(calculateScore(text, prefix, suffix));
	}
}
