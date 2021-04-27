package client;

import io.restassured.response.Response;
import pojo.Bin;
import resources.BinResources;

import static io.restassured.RestAssured.given;

public class BinClient extends BaseClient {

    public Bin postBinSuccessfully(Object bin) {
        return  given()
                .spec(utils.requestSpecification())
                .body(bin)
                .when()
                .log()
                .all()
                .post(BinResources.CRUD_RESOURCE.getResource())
                .then()
                .log()
                .all()
                .statusCode(200)
                .extract()
                .as(Bin.class);
    }

    public Response postBinError(Object bin, int status) {
        return  given()
                .spec(utils.requestSpecification())
                .body(bin)
                .when()
                .log()
                .all()
                .post(BinResources.CRUD_RESOURCE.getResource())
                .then()
                .log()
                .all()
                .statusCode(status)
                .extract()
                .response();
    }

    public Bin getBinById(String binId) {
        return  given()
                .spec(utils.requestSpecification())
                .when()
                .log()
                .all()
                .get(BinResources.CRUD_RESOURCE.getResource() + binId)
                .then()
                .log()
                .all()
                .statusCode(200)
                .extract()
                .as(Bin.class);
    }

    public Response getBinByIdError(String binId, int status) {
        return  given()
                .spec(utils.requestSpecification())
                .when()
                .log()
                .all()
                .get(BinResources.CRUD_RESOURCE.getResource() + binId)
                .then()
                .log()
                .all()
                .statusCode(status)
                .extract()
                .response();
    }

    public Bin deleteBinById(String binId) {
        return  given()
                .spec(utils.requestSpecification())
                .when()
                .log()
                .all()
                .delete(BinResources.CRUD_RESOURCE.getResource() + binId)
                .then()
                .log()
                .all()
                .statusCode(200)
                .extract()
                .as(Bin.class);
    }

    public Response deleteBinByIdError(String binId, int status) {
        return  given()
                .spec(utils.requestSpecification())
                .when()
                .log()
                .all()
                .delete(BinResources.CRUD_RESOURCE.getResource() + binId)
                .then()
                .log()
                .all()
                .statusCode(status)
                .extract()
                .response();
    }

    public Bin updateABin(Object bin, String binId) {
        return  given()
                .spec(utils.requestSpecification())
                .body(bin)
                .when()
                .log()
                .all()
                .put(BinResources.CRUD_RESOURCE.getResource() + binId)
                .then()
                .log()
                .all()
                .statusCode(200)
                .extract()
                .as(Bin.class);
    }

    public Response updateABinError(Object bin, String binId, int status) {
        return  given()
                .spec(utils.requestSpecification())
                .body(bin)
                .when()
                .log()
                .all()
                .put(BinResources.CRUD_RESOURCE.getResource() + binId)
                .then()
                .log()
                .all()
                .statusCode(status)
                .extract()
                .response();
    }
}
