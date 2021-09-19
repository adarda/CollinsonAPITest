package utils;

import java.util.ArrayList;
import java.util.List;



import io.restassured.http.Header;

/**
 * @author Avinash
 *
 */
public class TestUtils {

	private static final String APPLICATION_JSON = "application/json";
	
	public static List<Header> buildHttpHeaders(){
		List<Header> headers = new ArrayList<Header>();
		headers.add(new Header("Content-Type", APPLICATION_JSON));
		return headers;	
	}
}
