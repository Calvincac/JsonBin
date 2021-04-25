package resources;

public enum BinResources {
    CRUD_RESOURCE("/b/");

    private String resource;

    BinResources(String resource) {
        this.resource = resource;
    }

    public String getResource() {
        return resource;
    }
}
