package play.ground.playground.app.model;

import java.util.List;
import java.util.Objects;

public class UserEntity {
    private String id;
    private String email;
    private String name;

    private List<ContactMethod> contact_methods;

    public UserEntity(String id, String email, String name, List<ContactMethod> contact_methods) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.contact_methods = contact_methods;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ContactMethod> getContact_methods() {
        return contact_methods;
    }

    public void setContact_methods(List<ContactMethod> contact_methods) {
        this.contact_methods = contact_methods;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", contact_methods=" + contact_methods +
                '}';
    }
}
