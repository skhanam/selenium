package uk.co.ratedpeople;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.TagNode;
import org.htmlcleaner.XPather;
import org.htmlcleaner.XPatherException;

public class ThreeDHelper {

	/**
	 * 
	 * @param url Authentication URL
	 * @param md MD value for 3D authentication
	 * @param pareq Encrypted blob called PaReq in 3D authentication
	 * @return Map containing 3D response parameters as keys: MD, MDX, and PaRes
	 * @throws IOException
	 * @throws XPatherException
	 */
	public LinkedHashMap<String, String> doSuccessfulThreeDAuthentication(String url, String md, String pareq) throws IOException, XPatherException{
		final String htmlForm = postAuthenticationRequest(url, md, pareq);
		final String htmlResponse = postAuthenticationData(url, htmlForm, "password");
		final LinkedHashMap<String, String> threeDResponse = extractAuthnResponseData(htmlResponse);
		return threeDResponse;
	}
	
	
	/**
	 * Performs HTTP post to given URL along with the 3D authentication parameters
	 * @param url Authentication URL
	 * @param md MD value for 3D authentication
	 * @param pareq Encrypted blob called PaReq in 3D authentication
	 * @return String representation of returned HTML
	 * @throws IOException
	 */
	public String postAuthenticationRequest(String url, String md, String pareq) throws IOException{
		
		/*
		String data = URLEncoder.encode("MD", "UTF-8") + "=" + URLEncoder.encode(md, "UTF-8");
		    data += "&" + URLEncoder.encode("PaReq", "UTF-8") + "=" + URLEncoder.encode(pareq, "UTF-8");
		 */
		
		final LinkedHashMap<String, String> postParams = new LinkedHashMap<String, String>();
		postParams.put("MD", md);
		postParams.put("PaReq", pareq);
		postParams.put("TermUrl", "http://www.ratedtrades.com/myaction");
		String data = createPostData(postParams);
		
		return postData(url, data);
	}
	
	/**
	 * 
	 * @param url URL from where authentication form was loaded
	 * @param htmlForm  html form as text
	 * @param password Value that should be entered in the form to authenticate
	 * @return html text returned on submission of given form
	 * @throws XPatherException
	 * @throws IOException 
	 */
	public String postAuthenticationData(String url, String htmlForm, String password) throws XPatherException, IOException {
		final HtmlCleaner cleaner = new HtmlCleaner();
		final TagNode node = cleaner.clean(htmlForm);
		System.out.println(htmlForm);
		final XPather actionXPather = new XPather("//form[@action]");
		final Object[] actionNodes = actionXPather.evaluateAgainstNode(node);
		final TagNode actionNode = (TagNode)actionNodes[0];
		final String action = actionNode.getAttributeByName("action");
		System.out.println("action="+action);
		
		final XPather inputXPather = new XPather("//input");		
		final Object[] inputNodes = inputXPather.evaluateAgainstNode(node);
		final LinkedHashMap<String, String> postParams = new LinkedHashMap<String, String>();
		for(Object object : inputNodes ){
			final TagNode inputNode = (TagNode) object;			
			final String name = inputNode.getAttributeByName("name");
			final String value = inputNode.getAttributeByName("value");
			System.out.println("name="+name+" value="+value);
			if(name!=null){ // name is null for submit button
				if(name.equals("password")){
					postParams.put(name, password);
				} else {
					postParams.put(name, value);
				}
			} 
		}
		String dataToPost = createPostData(postParams);
		String baseUrl = extractBaseUrl(url);
		String postUrl = baseUrl + action;
		String htmlResponse = postData(postUrl,dataToPost);
		System.out.println(htmlResponse);
		return htmlResponse;
	}
	
	public LinkedHashMap<String, String> extractAuthnResponseData(String htmlResponse) throws XPatherException{
		final HtmlCleaner cleaner = new HtmlCleaner();
		final TagNode node = cleaner.clean(htmlResponse);
		
		final XPather inputXPather = new XPather("//input");		
		final Object[] inputNodes = inputXPather.evaluateAgainstNode(node);
		final LinkedHashMap<String, String> responseParams = new LinkedHashMap<String, String>();
		for(Object object : inputNodes ){
			final TagNode inputNode = (TagNode) object;			
			final String name = inputNode.getAttributeByName("name");
			final String value = inputNode.getAttributeByName("value");
			System.out.println("name="+name+" value="+value);			
			if(name!=null){
				// name is null for submit button 
				responseParams.put(name, value);
			}			 
		}		
		return responseParams;
	}
	
	/**
	 * 
	 * @param map Ordered map of name value pairs that need to be posted
	 * @return UTF-8 encoded data that can be sent as part of post
	 * @throws UnsupportedEncodingException
	 */
	public String createPostData(final LinkedHashMap<String,String> map) throws UnsupportedEncodingException{
		final StringBuilder sBuilder = new StringBuilder();
		final Iterator<Entry<String, String>> entrySet = map.entrySet().iterator();
		while(entrySet.hasNext()){
			final Entry<String, String> entry = entrySet.next();
			sBuilder.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
			sBuilder.append("=");
			sBuilder.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
			if(entrySet.hasNext()){
				sBuilder.append("&");
			}
		}
		return sBuilder.toString();
	}
	
	private String postData(String url, String data) throws IOException{
		URL postUrl = new URL(url);
		URLConnection conn = postUrl.openConnection();
	    conn.setDoOutput(true);
	    OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
	    wr.write(data);
	    wr.flush();
	    
	    // Get the response
	    StringBuilder sbuilder = new StringBuilder();
	    BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	    String line;
	    while ((line = rd.readLine()) != null) {
	        sbuilder.append(line);
	    }
	    wr.close();
	    rd.close();
	    return sbuilder.toString();
	}
	
	/**
	 * 
	 * @param url URL such as http://host.com/abc
	 * @return base If successful, URL such as http://host.com or https://a.host.com
	 * 	            Otherwise null
	 * @throws MalformedURLException 
	 */
	public String extractBaseUrl(String url) throws MalformedURLException{
		URL aURL = new URL(url);
		String baseURL = aURL.getProtocol()+"://"+aURL.getHost();
		if(aURL.getPort()!=-1){
			baseURL = baseURL+":"+aURL.getPort();
		}
		return baseURL;
	}
}
