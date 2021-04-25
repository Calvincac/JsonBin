package tests;

import asserters.BinAsserters;
import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pojo.Bin;
import pojo.Sample;
import resources.BaseTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static resources.Utils.getJsonPath;

public class DeleteBinTests extends BaseTest {
    private Sample sample = new Sample();
    private Bin createdBin, retrievedBin;
    private BinAsserters binAsserters = new BinAsserters();


    @BeforeMethod
    public void beforeMethod() {
        sample.setSample(faker.funnyName().name());
        createdBin = binClient.postBinSuccessfully(sample);
        retrievedBin = binClient.getBinById(createdBin.getMetadata().getId());
    }

    @Test
    public void canDeleteABinById() {
        Bin deletedBin = binClient.deleteBinById(retrievedBin.getMetadata().getId());
        binAsserters.assertDeleteMetadata(retrievedBin, deletedBin);
    }

    @Test
    public void cannotDeleteABinByWrongId() {
        Response response = binClient.deleteBinByIdError(faker.idNumber().invalid(), 422);
        assertThat(getJsonPath(response, "message"), equalTo("Invalid Record ID"));
    }

    @Test
    public void cannotDeleteBinWithoutId() {
        binClient.deleteBinByIdError("", 404);
    }

    @Test
    public void cannotDeleteBinWithNullId() {
        Response response = binClient.deleteBinByIdError(null, 422);
        assertThat(getJsonPath(response, "message"), equalTo("Invalid Record ID"));
    }
}
