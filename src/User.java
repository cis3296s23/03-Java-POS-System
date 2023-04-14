package src;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;
    private String password;
    private List<Timecard> timecards;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.timecards = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public List<Timecard> getTimecards() {
        return timecards;
    }

    @Override
    public String toString() {
        return username;
    }
}
