package kata.stub;

enum EnumPerson {

    ENUM_WILL("will");

    private String name;

    public String getName() {
        return name;
    }

    EnumPerson(String name) {
        this.name = name;
    }

    public String getEnum(String key) {
        for (EnumPerson person : EnumPerson.values()) {
            if (key.equals(person.getName())) {
                return person.getName() + "123";
            }
        }
        return "empty";
    }
}
