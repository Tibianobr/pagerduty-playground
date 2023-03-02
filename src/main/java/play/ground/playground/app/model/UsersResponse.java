package play.ground.playground.app.model;

import java.util.List;

public class UsersResponse {
    private List<UserEntity> users;
    private Boolean more;

    public List<UserEntity> getUsers() {
        return users;
    }

    public void setUsers(List<UserEntity> users) {
        this.users = users;
    }

    public Boolean getMore() {
        return more;
    }

    public void setMore(Boolean more) {
        this.more = more;
    }

    public UsersResponse(List<UserEntity> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "UsersResponse{" +
                "users=" + users +
                ", more=" + more +
                '}';
    }
}
