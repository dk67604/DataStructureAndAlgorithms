package main.java.topcodingquestion.sortingandsearching;

import java.util.Arrays;
import java.util.Comparator;

public class ReorderLogFiles {
    public String[] reorderLogFiles(String[] logs) {
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int o1SpaceIndex = o1.indexOf(' ');
                int o2SpaceIndex = o2.indexOf(' ');

                int o1FirstCharacter = o1.charAt(o1SpaceIndex + 1);
                int o2FirstCharacter = o2.charAt(o2SpaceIndex + 1);
                if (o1FirstCharacter <= '9') {
                    if (o2FirstCharacter <= '9') return 0;
                    return 1;
                }
                if (o2FirstCharacter <= '9') return -1;
                //Compare the log content
                int compValue = o1.substring(o1SpaceIndex + 1).compareTo(o2.substring(o2SpaceIndex + 1));
                if (compValue == 0) return o1.substring(0, o1SpaceIndex).compareTo(o2.substring(0, o2SpaceIndex));
                return compValue;
            }
        };
        Arrays.sort(logs, comparator);
        return logs;
    }
}
