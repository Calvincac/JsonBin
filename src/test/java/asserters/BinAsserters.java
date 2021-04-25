package asserters;

import pojo.Bin;
import pojo.Metadata;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class BinAsserters {

    public void assertBin(Bin bin, String sampleName) {
        assertThat(bin.getRecord().getSample(), equalTo(sampleName));
        assertMetadata(bin.getMetadata());
    }

    private void assertMetadata(Metadata metadata) {
        if(metadata.getCreatedAt() != null) {
            assertThat(metadata.getCreatedAt(), notNullValue());
        }
        assertThat(metadata.getPrivates(), notNullValue());
        assertThat(metadata.getId(), notNullValue());
    }

    public void assertDeleteMetadata(Bin actual, Bin deletedBin) {
        assertThat(deletedBin.getMetadata().getId(), equalTo(actual.getMetadata().getId()));
        assertThat(deletedBin.getMetadata().getVersionsDeleted(), notNullValue());
        assertThat(deletedBin.getMessage(), equalTo("Bin deleted successfully"));
    }
}
