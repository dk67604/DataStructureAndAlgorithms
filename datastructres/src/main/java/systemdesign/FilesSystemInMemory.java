package main.java.systemdesign;

import java.util.*;

public class FilesSystemInMemory {
    class File{
        boolean isFile = false;
        Map<String,File> files = new HashMap<>();
        String content = "";
    }

    File root;
    public FilesSystemInMemory(){
        root  = new File();
    }

    public List< String > ls(String path) {
        File tempPointer = root;
        List<String> files = new ArrayList<>();
        if(!path.equals("/")){
            String[] d = path.split("/");
            for (int i =1;i<d.length;i++){
                tempPointer = tempPointer.files.get(d[i]);
            }
            if(tempPointer.isFile){
                files.add(d[d.length-1]);
                return files;
            }
        }
        List<String> res_files = new ArrayList<>(tempPointer.files.keySet());
        Collections.sort(res_files);
        return res_files;
    }
    public void mkdir(String path) {
        File temp = root;
        String [] d = path.split("/");
        for (int i =1;i<d.length;i++){
            if(!temp.files.containsKey(d[i]))
                temp.files.put(d[i],new File());
            temp = temp.files.get(d[i]);
        }

    }

    public void addContentToFile(String filePath, String content) {
        File temp = root;
        String[] d = filePath.split("/");
        for (int i =1;i<d.length-1;i++){
            temp = temp.files.get(d[i]);
        }
        if(!temp.files.containsKey(d[d.length-1]))
            temp.files.put(d[d.length-1],new File());
        temp = temp.files.get(d[d.length-1]);
        temp.isFile =true;
        temp.content+=content;
    }


    public String readContentFromFile(String filePath) {
        File temp = root;
        String[] d = filePath.split("/");
        for (int i =1;i<d.length-1;i++){
            temp = temp.files.get(d[i]);
        }
        return temp.files.get(d[d.length-1]).content;
    }

    }
