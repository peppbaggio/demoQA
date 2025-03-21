package guru.qa.data;

public enum Genders {
    MALE("Male"), FEMALE("Female"), OTHER("Other");

    public final String description;

    Genders(String description) {
        this.description = description;
    }
}
