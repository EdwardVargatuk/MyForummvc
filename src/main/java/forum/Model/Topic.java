package forum.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * the topic includes a comments and belongs to the subject
 *
 * @author Edward
 */
@Entity
@Table(name = "topic")
public class Topic implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * the title of the topic
     */
    @Column(name = "topic_name")
    private String topicName;

    /**
     * relation with the subject
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_id")
    private Subject subject;

    /**
     * all comments list in topic
     */
    @OneToMany(mappedBy = "topic", cascade = CascadeType.PERSIST)
    private List<Comment> comments;

    public Topic() {
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Topic(String topicName, Subject subject, List<Comment> comments) {
        this.topicName = topicName;
        this.subject = subject;
        this.comments = comments;
    }

    public Topic(String topicName) {
        this.topicName = topicName;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "id=" + id +
                ", topicName='" + topicName + '\'' +
                ", subject=" + subject +
                ", comments=" + comments +
                '}';
    }
}
