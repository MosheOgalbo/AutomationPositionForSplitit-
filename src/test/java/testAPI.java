

import static io.restassured.RestAssured.given;

public class testAPI {

    public static void PostApi(String email ) {
        given().contentType("application/x-www-form-urlencoded; charset")
                .formParam("Amount", "100.00")
                .formParam("Currency", "GBP")
                .formParam("Order ID", "Name1")
                .formParam("Installment Options", "All Default Options")
                .formParam("Number of Installments","6")
                .formParam("Card number", "4111-1111-1111-1111")
                .formParam("Expiration Date", "02/24")
                .formParam( "Email",email+"@gmail.com")

                .when()
                .post(TextRepository.url+"In-store",TextRepository.encodedToken)
                .then()

                .statusCode(200);
    }

}
