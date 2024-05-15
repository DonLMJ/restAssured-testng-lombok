package com.example.tests;


import static com.example.tests.BookingDataBuilder.getBookingData;
import static com.example.tests.BookingDataBuilder.getPartialBookingData;
import static com.example.tests.TokenBuilder.getToken;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test; // Import JUnit Test annotation



public class RestfulBookerE2ETests extends BaseSetup {

    private BookingData newBooking;
    private Tokencreds newCredenetials;
    private int bookingId;
    private String token;

    @BeforeEach
    public void testSetup() {
        newBooking = getBookingData();
        newCredenetials = getToken();
        bookingId = given().body(newBooking)
                .when()
                .post("/booking")
                .then()
                .extract()
                .path("bookingid");
        token = given().body(newCredenetials)
                .when().post("/auth") .then ()
                .statusCode(200)
                .and()
                .assertThat()
                .body("token", Matchers.not (nullValue ()))
                .extract()
                .path("token");
    }

    @Test
    @Description("Example test for retrieving a booking - Get request")
    @Severity(SeverityLevel.CRITICAL)
    @Story("End to End tests using rest-assured")
    @Step("Get a the newly created booking")
    public void getBookingTest() {

        given().get("/booking/" + bookingId)
                .then()
                .statusCode(200)
                .and()
                .assertThat()
                .body("firstname", equalTo(newBooking.getFirstname()), "lastname", equalTo(newBooking.getLastname()),
                        "totalprice", equalTo(newBooking.getTotalprice()), "depositpaid",
                        equalTo(newBooking.isDepositpaid()), "bookingdates.checkin", equalTo(newBooking.getBookingdates()
                                .getCheckin()), "bookingdates.checkout", equalTo(newBooking.getBookingdates()
                                .getCheckout()), "additionalneeds", equalTo(newBooking.getAdditionalneeds()));

    }

    @Test
    @Description("Example test for updating a booking - Put request")
    @Severity(SeverityLevel.NORMAL)
    @Story("End to End tests using rest-assured")
    @Step("Update the booking")
    public void updateBookingTest() {
        BookingData updatedBooking = getBookingData();
        given().body(updatedBooking)
                .when()
                .header("Cookie", "token=" + token)
                .put("/booking/" + bookingId)
                .then()
                .statusCode(200)
                .and()
                .assertThat()
                .body("firstname", equalTo(updatedBooking.getFirstname()), "lastname",
                        equalTo(updatedBooking.getLastname()), "totalprice", equalTo(updatedBooking.getTotalprice()),
                        "depositpaid", equalTo(updatedBooking.isDepositpaid()), "bookingdates.checkin", equalTo(
                                updatedBooking.getBookingdates()
                                        .getCheckin()), "bookingdates.checkout", equalTo(updatedBooking.getBookingdates()
                                .getCheckout()), "additionalneeds", equalTo(updatedBooking.getAdditionalneeds()));
    }

    @Test
    @Description("Example test for updating a booking partially- Patch request")
    @Severity(SeverityLevel.NORMAL)
    @Story("End to End tests using rest-assured")
    @Step("Update the booking partially")
    public void updatePartialBookingTest() {
        PartialBookingData partialUpdateBooking = getPartialBookingData();
        given().body(partialUpdateBooking)
                .when()
                .header("Cookie", "token=" + token)
                .patch("/booking/" + bookingId)
                .then()
                .statusCode(200)
                .and()
                .assertThat()
                .body("firstname", equalTo(partialUpdateBooking.getFirstname()), "totalprice",
                        equalTo(partialUpdateBooking.getTotalprice()));

    }

    @Test
    @Description("Example test for deleting a booking - Delete request")
    @Severity(SeverityLevel.NORMAL)
    @Story("End to End tests using rest-assured")
    @Step("Delete the booking")
    public void deleteBookingTest() {
        given().header("Cookie", "token=" + token)
                .when()
                .delete("/booking/" + bookingId)
                .then()
                .statusCode(201);
        given().get("/booking/" + bookingId)
                .then()
                .statusCode(404);
    }

}
