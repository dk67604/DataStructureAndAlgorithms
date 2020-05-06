package main.java.leetcode;

import java.util.*;
public class PossibleSubstring {
  public int findPairCount(String s){
	  Map<Long,Integer> map=new HashMap<>();
	  int ans=0;
	  for(int i=0;i<s.length();i++) {
		  for(int j=1;j<=s.length()-i;j++) {
			 
			  long key=getKey(s.substring(i, i+j));
			  if(map.containsKey(key)) {
				  ans+=map.get(key);
				  map.put(key, map.get(key)+1);
			  }
			  else {
				  map.put(key, 1);
			  }
		  }
	  }
	 
	 return ans;
	  
  }
  
  public long getKey(String i) {
	  long key=1;
	  for(int m=0;m<i.length();m++) {
		  key=((i.charAt(m))*key)%100000007;
	  }
	  return key;
  }
  public List<String> getSubstring(String s) {
	  List<String> subString=new ArrayList<>();
	  for(int i=0;i<s.length();i++) {
		  for(int j=1;j<=s.length()-i;j++) {
			  //System.out.println(s.substring(i, i+j));
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
  
  public static String getScore(List<String> subString,String prefix,String suffix,String word) {
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
	  
	  int startEnd=word.indexOf(higSuffix);
	  String part1="";
	  String part2="";
	  String part3="";
	  if(higPre.length()>=0) {
		  part1=word.substring(0, higPre.length());
	  }
	  if(higPre.length()>0&&startEnd>higPre.length()) {
		  part2=word.substring(higPre.length(), startEnd);
	  }
	  if(startEnd>0&&startEnd<=word.length()) {
		  part3=word.substring(startEnd, higSuffix.length()+startEnd);;
	  }
	  
	 String result= part1+part2+part3;

			 
	  return result;
  }

  public void printSubstring(String s) {
	  for(int i=0;i<s.length();i++) {
		  for(int j=1;j<=s.length()-i;j++) {
			  System.out.println(s.substring(i, i+j));
		  }
	  }
  }
  
  public boolean isAnagram(String s, String t) {
      int[] alphabet=new int[26];
      for(int i=0;i<s.length();i++)alphabet[s.charAt(i)-'a']++;
      for(int j=0;j<t.length();j++)alphabet[t.charAt(j)-'a']--;
      for(int k=0;k<alphabet.length;k++){
          if(alphabet[k]!=0){
              return false;
          }
      }
      return true;
  }
  
  public static void main(String[] args) {
	PossibleSubstring possibleSubstring=new PossibleSubstring();
	//String test="dichcagakdajjhhdhegiifiiggjebejejciaabbifkcbdeigajhgfcfdgekfajbcdifikafkgjjjfefkdbeicgiccgkjheeiefje";
	//System.out.println(test.length());
	//System.out.println(possibleSubstring.findPairCount(test));
	List<String> subString=possibleSubstring.getSubstring("engine");
	System.out.println(getScore(subString,"hen","ginkgo","engine"));
	
	
}
}
