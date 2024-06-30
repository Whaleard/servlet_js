package domain;

/**
 * @author Mr MC
 */
public class Message {

    private Header header;

    private User user;

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
