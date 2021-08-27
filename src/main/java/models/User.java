package models;

public class User {
    private int id;
    private int document;
    private String name;
    private String surname;
    private String email;
    private String password;
    private String rol;
    private String status;

    public User() {
    }

    public User(int id) {
        this.id = id;
    }

    public User(int document, String name, String surname, String email, String password, String rol, String status) {
        this.document = document;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.rol = rol;
        this.status = status;
    }

    public User(int id, int document, String name, String surname, String email, String password, String rol, String status) {
        this.id = id;
        this.document = document;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.rol = rol;
        this.status = status;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDocument() {
        return document;
    }

    public void setDocument(int document) {
        this.document = document;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", document=" + document + ", name=" + name + ", surname=" + surname + ", email=" + email + ", password=" + password + ", rol=" + rol + ", status=" + status + '}';
    }

    
 
}
