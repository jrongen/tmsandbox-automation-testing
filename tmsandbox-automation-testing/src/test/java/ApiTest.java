package java;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;

public class ApiTest {
    @Test
    public void getNumberOfCarBrands() {
        given()
                .when()
                .get("https://api.trademe.co.nz/v1/Categories/UsedCars.json")
                .then()
                .statusCode(200)
                .assertThat()
                .body("Subcategories.size()", is(81));
    }
}
