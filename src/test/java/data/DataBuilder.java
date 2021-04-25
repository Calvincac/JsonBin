package data;

import com.github.javafaker.Faker;
import pojo.Bin;
import pojo.Record;


public class DataBuilder {
    private Faker faker = new Faker();

    public Bin getBinAllFields() {
        Record record = new Record();
        record.setSample(faker.funnyName().name());
        Bin bin = new Bin();
        bin.setRecord(record);
        return bin;
    }

}
