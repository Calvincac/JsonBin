package resources;

import client.BinClient;
import com.github.javafaker.Faker;
import data.DataBuilder;

public class BaseTest {
    public DataBuilder dataBuilder = new DataBuilder();
    public Faker faker = new Faker();
    public BinClient binClient = new BinClient();
}
