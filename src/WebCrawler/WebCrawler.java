package WebCrawler;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebCrawler {

	private Queue<String> queue;
	private List<String> discoverWebsites;
	
	public WebCrawler() {
		this.queue = new LinkedList<String>();
		this.discoverWebsites = new ArrayList<String>();
	}
	
	/**
	 * Open an initial website and look at the code 
	 * for looking the next URL and so on.
	 * 
	 * @param root is an URL i.e. http://www.google.com
	 * 
	 * */
	public void discoverWeb(String root) {
		queue.add(root);
		discoverWebsites.add(root);
		while(!queue.isEmpty()) {
			String vertex = queue.remove();
			String rawHtml = readURL(vertex);
			String regExp = "https://(\\w+\\.)*(\\w+)";
			Pattern pattern = Pattern.compile(regExp);
			Matcher matcher = pattern.matcher(rawHtml);
			while(matcher.find()) {
				String actualURL = matcher.group();
				if(!discoverWebsites.contains(actualURL)) {
					discoverWebsites.add(actualURL);
					System.out.println("Website has been found: "+actualURL);
					queue.add(actualURL);
				}
			}
		}
	}
	
	/**
	 * Read the HTML website and convert to String
	 * 
	 * @param route is the first URL inside a website   
	 * 
	 * */
	private String readURL(String route) {
		String rawHtml = "";
		try {
			URL url = new URL(route);
			BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
			String inputLine = "";
			while((inputLine = br.readLine()) != null) {
				rawHtml += inputLine;
			}
			br.close();
		} catch (Exception e) {
			System.out.println("Problem reading: "+route);
		}
		return rawHtml;
	} 
	
}
