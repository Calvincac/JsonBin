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

public class UpdateBinTests extends BaseTest {

    private Sample sample = new Sample();
    private Sample updatedSample = new Sample();
    private Bin createdBin;
    private BinAsserters binAsserters = new BinAsserters();

    @BeforeMethod
    public void beforeMethod() {
        sample.setSample(faker.funnyName().name());
        updatedSample.setSample(faker.ancient().god());
        createdBin = binClient.postBinSuccessfully(sample);
    }


    @Test
    public void canUpdateABin() {
        Bin updatedBin = binClient.updateABin(updatedSample, createdBin.getMetadata().getId());
        binAsserters.assertBin(updatedBin, updatedSample.getSample(), "update");
    }

    @Test
    public void cannotUpdateABinByWrongId() {
        Response response = binClient.updateABinError(updatedSample, faker.idNumber().invalid(), 422);
        assertThat(getJsonPath(response, "message"), equalTo(BinTestData.INVALID_RECORD_ID_ERROR.toString()));
    }

    @Test
    public void cannotUpdateABinWithoutId() {
        binClient.updateABinError(updatedSample, "", 404);
    }

    @Test
    public void cannotUpdateABinWithNullId() {
        Response response = binClient.updateABinError(updatedSample, null, 422);
        assertThat(getJsonPath(response, "message"), equalTo(BinTestData.INVALID_RECORD_ID_ERROR.toString()));
    }
}
