package data;

public enum BinTestData {
    BLANK_BIN_ERROR("Bin cannot be blank"),
    ROUTE_NOT_FOUND_ERROR("Route not found!"),
    BIN_DELETED_MESSAGE("Bin deleted successfully"),
    INVALID_RECORD_ID_ERROR("Invalid Record ID");

    private String value;
    BinTestData(String value){
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
