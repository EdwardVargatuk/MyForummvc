package forum.Model;

import java.util.Map;

/**
 * 25.02.2019 18:24
 *
 * @author Edward
 */
public class CommentJsonResponse {
    private Comment comment;
    private boolean validated;
    private Map<String, String> errorMessages;

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public boolean isValidated() {
        return validated;
    }

    public void setValidated(boolean validated) {
        this.validated = validated;
    }

    public Map<String, String> getErrorMessages() {
        return errorMessages;
    }

    public void setErrorMessages(Map<String, String> errorMessages) {
        this.errorMessages = errorMessages;
    }

    @Override
    public String toString() {
        return "CommentJsonResponse{" +
                "comment=" + comment +
                ", validated=" + validated +
                ", errorMessages=" + errorMessages +
                '}';
    }
}
