package stepDefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;

import config.Request;
import config.World;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import utils.ConfigProvider;
import utils.TestUtils;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;

/** StepDefsIntegration class is the implementation class for all the step defs present in the feature file
 * @author Avinash
 */
public class StepDefsIntegration {
	private static final Logger LOGGER = LogManager.getLogger(StepDefsIntegration.class);
	private static ThreadLocal<Scenario> localScenario = new InheritableThreadLocal<Scenario>();
	private Request request;
	private World world = null;

	public static void putScenario(Scenario scenario) {
		localScenario.set(scenario);
	}

	public static Scenario getScenario() {
		return localScenario.get();
	}

	@Before
	public void setUp(Scenario scenario) {
		LOGGER.info("Before : StepDef");
		putScenario(scenario);
		request = new Request();
		world = new World();
	}

	@Given("^a user searches for bikes on the CityBikes network$")
	public void aCallTo() throws IOException {
		world.setEndpointURL(ConfigProvider.getProperty("baseURL"));
		world.setHeaderList(TestUtils.buildHttpHeaders());
		world.setHttpMethod(Method.GET);
		world.setRequestContent(null);
	}

	@When("^the user enters a particular city$")
	public void theRequestIsMade() {
		if (world.getHttpMethod() == Method.GET || world.getHttpMethod() == Method.DELETE) {
			world.setRequestContent("");
		}
		request.processHttpRequest(world.getHttpMethod(), new Headers(world.getHeaderList()), world.getRequestContent(),
				world.getEndpointURL());

	}

	@Then("the status code is {int}")
	public void validateTheResponseCode(int responseCode) {
		assertThat(request.getResponseStatusCode(), CoreMatchers.is(responseCode));
	}

	@Then("City: {string} has latitude: {float}, longitude: {float} and country: {string}")
	public void validateTheResponse(String city, float latitude, float longitude, String country) {
		if (request.getResponse() != null) {
			List<Map<?, ?>> locations = (request.getResponse().jsonPath().param("cityProperty", city)
					.get("networks.findAll{ networks -> networks.location.city == cityProperty }.location"));
			if (locations != null && locations.size() == 1) {
				Map<?, ?> location = locations.get(0);
				if (location != null && location.get("longitude") != null && location.get("latitude") != null
						&& location.get("country") != null) {
					assertThat(location.get("country"), is(country));
					assertEquals(location.get("longitude"), longitude);
					assertEquals(location.get("latitude"), latitude);
					return;
				}
			}
		}
		Assert.fail();
	}

}
