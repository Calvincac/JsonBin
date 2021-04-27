package asserters;

import data.BinTestData;
import pojo.Bin;
import pojo.Metadata;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class BinAsserters {

    public void assertBin(Bin bin, String sampleName, String flag) {
        assertThat("Bin sample name does not match", bin.getRecord().getSample(), equalTo(sampleName));
        assertMetadata(bin.getMetadata(), flag);
    }

    private void assertMetadata(Metadata metadata, String metadataFlag) {
        if(metadataFlag.equals("create")) {
            assertThat(metadata.getCreatedAt(), notNullValue());
        }

        if(metadataFlag.equals("update")) {
            assertThat("Bin Metadata parent id is null", metadata.getParentId(), notNullValue());
        } else {
            assertThat("Bin Metadata Id is null", metadata.getId(), notNullValue());
        }
        assertThat("Private value is null",metadata.getPrivates(), notNullValue());
    }

    public void assertDeleteMetadata(Bin actual, Bin deletedBin) {
        assertThat("Bin metadata Id does not match", deletedBin.getMetadata().getId(), equalTo(actual.getMetadata().getId()));
        assertThat("VersionsDeleted is null", deletedBin.getMetadata().getVersionsDeleted(), notNullValue());
        assertThat("Bin deleted message does not match", deletedBin.getMessage(), equalTo(BinTestData.BIN_DELETED_MESSAGE.toString()));
    }
}
