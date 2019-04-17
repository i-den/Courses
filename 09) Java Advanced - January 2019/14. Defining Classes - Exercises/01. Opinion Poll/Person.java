class Person {
    private int age;
    private String name;

    Person(int age, String name) {
        this.setAge(age);
        this.setName(name);
    }

    String getInfo() {
        return String.format("%s - %d", getName(), getAge());
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}