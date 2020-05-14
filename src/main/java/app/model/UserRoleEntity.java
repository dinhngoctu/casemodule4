package app.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user_role", schema = "case4", catalog = "")
public class UserRoleEntity {
    private long id;
    private String userName;
    private String roleName;

    public UserRoleEntity() {
    }

    public UserRoleEntity(String userName, String roleName) {
        this.userName = userName;
        this.roleName = roleName;
    }

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "userName")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "roleName")
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRoleEntity that = (UserRoleEntity) o;
        return id == that.id &&
                Objects.equals(userName, that.userName) &&
                Objects.equals(roleName, that.roleName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, roleName);
    }
}
