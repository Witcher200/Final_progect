package Stage3.Requests_with_other_peoples_posts;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class Search_for_someone_else_publicationTest extends AbstractPageTest{

	  @BeforeEach
	  void setUp() {
			System.out.println(" ");
			System.out.println("Start running tests");
			RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
	  }

	  @Test
	  @Order(1)
	  void Search_someone_publicationTest() {
			given()
				.log()
				.all()
				.queryParam("owner", "notMe")
				.queryParam("sorted", "createdAt")
				.queryParam("order", "ASC")
				.queryParam("page", 12)
				.expect()
				.when()
				.post(PostsURL()+"someone_publication")
				.then()
				.statusCode(404);
	  }

	  @Test
	  @Order(2)
	  void Search_someone_publication2Test() {
			given()
				.log()
				.all()
				.queryParam("owner", "notMe")
				.queryParam("sorted", "createdAt")
				.queryParam("order", "DESC")
				.queryParam("page", 25)
				.expect()
				.when()
				.post(PostsURL()+"someone_publication")
				.then()
				.statusCode(404);
	  }

	  @Test
	  @Order(3)
	  void Search_someone_publication3Test() {
			given()
				.log()
				.all()
				.queryParam("owner", "notMe")
				.queryParam("sorted", "createdAt")
				.queryParam("order", "ALL")
				.queryParam("page", 18)
				.expect()
				.when()
				.post(PostsURL()+"someone_publication")
				.then()
				.statusCode(404);
	  }
}