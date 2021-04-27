package tests;

import asserters.BinAsserters;
import data.BinTestData;
import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pojo.Bin;
import pojo.Sample;
import resources.BaseTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static resources.Utils.getJsonPath;

public class ReadBinTests extends BaseTest {
    private Sample sample = new Sample();
    private BinAsserters binAsserters = new BinAsserters();
    private Bin createdBin;


    @BeforeMethod
    public void beforeMethod() {
        sample.setSample(faker.funnyName().name());
        createdBin = binClient.postBinSuccessfully(sample);
    }

    @Test
    public void canReadABinById() {
        Bin retrievedBin = binClient.getBinById(createdBin.getMetadata().getId());
        binAsserters.assertBin(retrievedBin, createdBin.getRecord().getSample(), "read");
    }

    @Test
    public void cannotRetrieveBinByWrongId() {
        Response response = binClient.getBinByIdError(faker.idNumber().invalid(), 422);
        assertThat(getJsonPath(response, "message"), equalTo(BinTestData.INVALID_RECORD_ID_ERROR.toString()));
    }

    @Test
    public void cannotRetrieveBinByNullId() {
        Response response = binClient.getBinByIdError(null, 422);
        assertThat(getJsonPath(response, "message"), equalTo(BinTestData.INVALID_RECORD_ID_ERROR.toString()));
    }

    @Test
    public void cannotRetrieveBinNoId() {
        Response response = binClient.getBinByIdError("", 404);
        assertThat(getJsonPath(response, "message"), equalTo(BinTestData.ROUTE_NOT_FOUND_ERROR.toString()));
    }

}
