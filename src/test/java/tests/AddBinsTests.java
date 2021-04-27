package tests;

import asserters.BinAsserters;
import data.BinTestData;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojo.Bin;
import pojo.Sample;
import resources.BaseTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static resources.Utils.getJsonPath;

public class AddBinsTests extends BaseTest {

    private Sample sample = new Sample();
    private BinAsserters binAsserters = new BinAsserters();

    @Test
    public void canCreateABinWithValidValue() {
        sample.setSample(faker.funnyName().name());
        Bin createdBin = binClient.postBinSuccessfully(sample);
        binAsserters.assertBin(createdBin, sample.getSample(), "create");
    }

    @Test
    public void canCreateABinWithNullValue() {
        sample.setSample(null);
        Bin createdBin = binClient.postBinSuccessfully(sample);
        binAsserters.assertBin(createdBin, sample.getSample(), "create");
    }

    @Test
    public void canCreateABinWithEmptyValue() {
        sample.setSample("");
        Bin createdBin = binClient.postBinSuccessfully(sample);
        binAsserters.assertBin(createdBin, sample.getSample(), "create");
    }

    @Test
    public void canCreateABinWith1000Characters() {
        sample.setSample(faker.lorem().characters(1000));
        Bin createdBin = binClient.postBinSuccessfully(sample);
        binAsserters.assertBin(createdBin, sample.getSample(), "create");
    }

    @Test
    public void cannotCreateBinWithBlankBody() {
        Response response = binClient.postBinError("",400);
        assertThat(getJsonPath(response, "message"), equalTo(BinTestData.BLANK_BIN_ERROR.toString()));
    }
}
