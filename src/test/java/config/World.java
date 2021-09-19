package config;

import java.util.ArrayList;
import java.util.List;


import io.restassured.http.Header;
import io.restassured.http.Method;

/**
 * World class is the class which is used to extract the elements from the request and response.
 * @author Avinash
 */

public class World {

	private List<Header> headerList = new ArrayList<Header>();
	private String endpointURL;
	private String requestContent;
	private Method httpMethod;

	public World() {

	}

	public World(List<Header> headerList, String endpointURL, String requestContent, Method httpMethod) {
		super();
		this.headerList = headerList;
		this.endpointURL = endpointURL;
		this.requestContent = requestContent;
		this.httpMethod = httpMethod;
	}

	public List<Header> getHeaderList() {
		return headerList;
	}

	public void setHeaderList(List<Header> headerList) {
		this.headerList = headerList;
	}

	public String getEndpointURL() {
		return endpointURL;
	}

	public void setEndpointURL(String endpointURL) {
		this.endpointURL = endpointURL;
	}

	public String getRequestContent() {
		return requestContent;
	}

	public void setRequestContent(String requestContent) {
		this.requestContent = requestContent;
	}

	public Method getHttpMethod() {
		return httpMethod;
	}

	public void setHttpMethod(Method httpMethod) {
		this.httpMethod = httpMethod;
	}

	
}
