package config;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

/**
 * Request class is used for building up a HTTP request.
 * @author Avinash
 */
public class Request {

	private Response response;
	private int responseCode;
	private ResponseBody<?> responseBody;
	private Headers responseHeaders;

	private Method httpMethod;
	private Headers headers;
	private Object requestBody;
	private String relativeRequestURL;

	/**
	 * processHttpRequest method is used to perform a http request
	 * @param httpMethod
	 * @param headers
	 * @param requestBody
	 * @param relativeRequestURL
	 */
	public void processHttpRequest(Method httpMethod, Headers headers, Object requestBody, String relativeRequestURL) {
		this.httpMethod = httpMethod;
		this.headers = headers;
		this.requestBody = requestBody;
		this.relativeRequestURL = relativeRequestURL;
		response = RestAssured.given().log().all().headers(headers).body(requestBody).when()
				.request(httpMethod, relativeRequestURL).then().extract().response();
		responseCode = response.getStatusCode();
		responseHeaders = response.getHeaders();
	}

	public Response getResponse() {
		return response;
	}

	public int getResponseStatusCode() {
		return responseCode;
	}

	public String getResponseBody() {
		return responseBody.asString();
	}

	public int getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}

	public Headers getResponseHeaders() {
		return responseHeaders;
	}

	public void setResponseHeaders(Headers responseHeaders) {
		this.responseHeaders = responseHeaders;
	}

	public Method getHttpMethod() {
		return httpMethod;
	}

	public void setHttpMethod(Method httpMethod) {
		this.httpMethod = httpMethod;
	}

	public Headers getHeaders() {
		return headers;
	}

	public void setHeaders(Headers headers) {
		this.headers = headers;
	}

	public Object getRequestBody() {
		return requestBody;
	}

	public void setRequestBody(Object requestBody) {
		this.requestBody = requestBody;
	}

	public String getRelativeRequestURL() {
		return relativeRequestURL;
	}

	public void setRelativeRequestURL(String relativeRequestURL) {
		this.relativeRequestURL = relativeRequestURL;
	}

	public void setResponse(Response response) {
		this.response = response;
	}

	public void setResponseBody(ResponseBody<?> responseBody) {
		this.responseBody = responseBody;
	}
	
	
}
