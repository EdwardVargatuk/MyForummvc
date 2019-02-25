package forum.Model;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author Edward
 */

@Entity
@Table(name = "user")
@NamedQuery(name = "findUserByLogin", query = "select user from User user where user.login=:login")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * user's login
     */
    @Column(name = "login")
    @NaturalId
    private String login;

    /**
     * user's password
     */
    @Column(name = "password")
    private String password;

    /**
     * role of the user
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "role", length = 5)
    private Role role;

    /**
     * all comments list of user
     */
    @OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST)
    private List<Comment> comments;


    /**
     * Enum for access rights
     */
    public enum Role {
        ADMIN, USER
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public User() {
    }

    public User(String login, String password, Role role, List<Comment> comments) {
        this.login = login;
        this.password = password;
        this.role = role;
        this.comments = comments;
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
//                ", role=" + role +
//                ", comments=" + comments +
                '}';
    }

}
