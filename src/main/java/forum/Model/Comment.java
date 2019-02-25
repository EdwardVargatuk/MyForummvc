package forum.Model;



import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;


/**
 * comments of user
 * belongs to the topic and user
 *
 * @author Edward
 */
@Entity
@Table(name = "comment")
public class Comment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * added comment by user
     */
    @Column(name = "user_comment", length = 1000)
    private String userComment;

    /**
     * time of creation
     */
    @Column
//    @Temporal(value = TemporalType.DATE)
    private LocalDate date;

    /**
     * the comment belongs to the topic
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "topic_id")
    private Topic topic;

    /**
     * the comment belongs to the user
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public Comment() {
    }


    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserComment() {
        return userComment;
    }

    public void setUserComment(String userComment) {
        this.userComment = userComment;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Comment(String userComment, LocalDate date, Topic topic, User user) {
        this.userComment = userComment;
        this.date = date;
        this.topic = topic;
        this.user = user;
    }

    public Comment(String userComment) {
        this.userComment = userComment;
    }

    public Comment(String userComment, LocalDate date) {
        this.userComment = userComment;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", userComment='" + userComment + '\'' +
                ", date=" + date +
                ", topic=" + topic +
                ", user=" + user +
                '}';
    }
}
