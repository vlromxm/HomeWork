package ua.romanenko.module.models;

public class Customer {
    private int id;
    private String email;
    private int age;

    public Customer(int id, String email, int age) {
        this.id = id;
        this.email = email;
        this.age = age;
    }

    public Customer() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "\n" + "Customer " +
                "id=" + id +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }

}
