package goodsforpets.goodsforpetsjava.models;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private String Name;
    private String Surname;
    private String Patronymic;
    private String Login;
    private String Password;
    @OneToMany(mappedBy = "User", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Role> Roles;

    public User(String name, String surname, String patronymic, String login, String password) {
        Name = name;
        Surname = surname;
        Patronymic = patronymic;
        Login = login;
        Password = password;
        Roles = new ArrayList<>();
    }

    public User() {

    }

    public int getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getPatronymic() {
        return Patronymic;
    }

    public void setPatronymic(String patronymic) {
        Patronymic = patronymic;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String login) {
        Login = login;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public void addRole(Role role) {
        role.setUser(this);
    }

    public void removeRole(Role role) {
        Roles.remove(role);
    }

    public List<Role> getRoles() {
        return Roles;
    }

    public void setARoles(List<Role> roles) {
        Roles = roles;
    }
}
