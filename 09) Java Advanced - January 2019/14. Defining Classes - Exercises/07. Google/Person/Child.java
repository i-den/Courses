package Person;

public class Child {

    private String name;

    private String birthday;

    public Child(String name, String birthday) {
        setName(name);
        setBirthday(birthday);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}
