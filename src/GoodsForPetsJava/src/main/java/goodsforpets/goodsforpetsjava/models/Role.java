package goodsforpets.goodsforpetsjava.models;

import javax.persistence.*;

public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private String Name;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id")
    private User User;

    public Role() {

    }

    public Role(String name) {
        Name = name;
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

    public void setUser(User user) {
        User = user;
    }

    public User getUser() {
        return User;
    }
}
