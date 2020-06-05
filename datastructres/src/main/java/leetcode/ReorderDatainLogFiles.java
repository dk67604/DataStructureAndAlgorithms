package main.java.leetcode;

import java.util.*;

public class ReorderDatainLogFiles {
    public String[] reorderLogFiles(String[] logs) {
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int o1SpaceIndex = o1.indexOf(' ');
                int o2SpaceIndex = o2.indexOf(' ');

                // lastly compare the number logs
                char o1FirstCharacter = o1.charAt(o1SpaceIndex+1);
                char o2FirstCharacter = o2.charAt(o2SpaceIndex+1);
                if(o1FirstCharacter <= '9'){
                    if(o2FirstCharacter <= '9') return 0;
                    else return 1;
                }
                if(o2FirstCharacter <='9') return  -1;
                // Compare the log content
                int compValue = o1.substring(o1SpaceIndex+1).compareTo(o2.substring(o2SpaceIndex+1));
                // If content are equal compare  first alphanumeric log id
                if (compValue ==0 ) return o1.substring(0,o1SpaceIndex).compareTo(o2.substring(0,o2SpaceIndex));
                return compValue;
            }
        };
        Arrays.sort(logs,comparator);
        return logs;

    }
    public List<String> reorderLines(int logFileSize, List<String> logLines)
    {
        Collections.sort(logLines, (log1, log2) -> {
            String[] split1 = log1.split(" ", 2);
            String[] split2 = log2.split(" ", 2);
            boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(split2[1].charAt(0));
            if (!isDigit1 && !isDigit2) {
                int cmp = split1[1].compareTo(split2[1]);
                if (cmp != 0) return cmp;
                return split1[0].compareTo(split2[0]);
            }
            return isDigit1 ? (isDigit2 ? 0 : 1) : -1;
        });
        return logLines;
    }



    public static void main(String[] args) {
        String[] logs = new String[]{"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo","a2 act car"};
        List<String> logsfile = new ArrayList<String>(Arrays.asList(logs));
        ReorderDatainLogFiles reorderDatainLogFiles = new ReorderDatainLogFiles();
        List<String> ans=reorderDatainLogFiles.reorderLines(0,logsfile);
        for(String t:ans){
            System.out.println(t);
        }
    }
}
