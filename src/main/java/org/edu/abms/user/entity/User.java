package org.edu.abms.user.entity;

import org.edu.abms.faculty.entity.Faculty;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Description: 用户信息
 * @author: 吴炳生
 * @date: 2017/7/8
 */
@Entity
@Table(name = "t_user")
public class User implements Serializable {
    /**
     * 主键，自增
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * 账户，人事编号
     */
    @Column(length = 20, nullable = false)
    private String account;
    /**
     * 密码,默认为身份证后六位
     */
    @Column(length = 45, nullable = false)
    private String password = "666666";
    /**
     * 姓名
     */
    @Column(length = 10, nullable = false)
    private String name;
    /**
     * 性别
     **/
    @Column(length = 1, nullable = false)
    private Gender gender = Gender.UNKNOWN;
    /**
     * 所在部门
     */
    @ManyToOne
    @JoinColumn(name = "faculty_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FACULTY_ID_FK"))
    private Faculty faculty;
    /**
     * 用户类型
     */
    @Column(length = 1, nullable = false)
    private RoleType roleType;

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

    public RoleType getRoleType() {

        return roleType;
    }

    public Integer getId() {
        return id;
    }

    public String getAccount() {
        return account;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", faculty=" + faculty +
                '}';
    }
}