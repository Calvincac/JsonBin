package resources;

import client.BinClient;
import com.github.javafaker.Faker;

public class BaseTest {
    public Faker faker = new Faker();
    public BinClient binClient = new BinClient();
}
