package main.java.systemdesign;

import java.util.*;

public class WebCrawler {

    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        String hostname = getHostName(startUrl);
        queue.offer(startUrl);
        visited.add(startUrl);
        while (!queue.isEmpty()){
            String currentUrl = queue.poll();
            for (String url: htmlParser.getUrls(currentUrl)){
                if(url.contains(hostname) && !visited.contains(url)){
                    queue.offer(url);
                    visited.add(url);
                }
            }
        }
        return new ArrayList<>(visited);
    }

    private String getHostName(String url){
        String[] ss = url.split("/");
        return ss[2];
    }
}
