package web.model;


import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role {


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(name = "role")
    private String role;

    public Role() {

    }

    public Role(int id, String role){
        this.id = id;
        this.role = role;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }







}
