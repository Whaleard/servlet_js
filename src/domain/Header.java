package domain;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @author Mr MC
 */
public class Header {

    private String language;

    private Date sendTime;

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    @Override
    public String toString() {
        return "Header{" +
                "language='" + language + '\'' +
                ", sendTime=" + sendTime +
                '}';
    }
}
