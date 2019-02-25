package forum.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * The subjects of discuss on forum includes topics
 *
 * @author Edward
 */
@Entity
@Table(name = "subject")
public class Subject implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * the title of the subject
     */
    @Column(name = "subject_name")
    private String subjectName;

    /**
     * the lists of topics
     */
    @OneToMany(mappedBy = "subject", cascade = CascadeType.PERSIST)
    private List<Topic> topicList;

    public Subject() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public List<Topic> getTopicList() {
        return topicList;
    }

    public void setTopicList(List<Topic> topicList) {
        this.topicList = topicList;
    }

    public Subject(String subjectName, List<Topic> topicList) {
        this.subjectName = subjectName;
        this.topicList = topicList;
    }

    public Subject(String subjectName) {
        this.subjectName = subjectName;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", subjectName='" + subjectName + '\'' +
                ", topicList=" + topicList +
                '}';
    }
}
