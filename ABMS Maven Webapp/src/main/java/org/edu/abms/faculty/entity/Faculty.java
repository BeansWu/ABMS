package org.edu.abms.faculty.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Description: 二级单位(部门)信息
 * @author: 吴炳生
 * @date: 2017/7/8
 */
@Entity
@Table(name = "t_faculty")
public class Faculty implements Serializable{
    /** 主键，自增 **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /** 单位编号 **/
    @Column(length = 10, nullable = false)
    private String number;
    /** 单位名称 **/
    @Column(length = 20, nullable = false)
    private String name;
    /** 单位简称 **/
    @Column(name = "simple_name", length = 20, nullable = false)
    private String simpleName;
    /** 单位简码 **/
    @Column(name = "simple_number", length = 20, nullable = false)
    private String simpleNumber;

    public Integer getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public String getSimpleName() {
        return simpleName;
    }

    public String getSimpleNumber() {
        return simpleNumber;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSimpleName(String simpleName) {
        this.simpleName = simpleName;
    }

    public void setSimpleNumber(String simpleNumber) {
        this.simpleNumber = simpleNumber;
    }

    public Faculty() {}

    public Faculty(String number, String name, String simpleName, String simpleNumber) {
        this.number = number;
        this.name = name;
        this.simpleName = simpleName;
        this.simpleNumber = simpleNumber;
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", name='" + name + '\'' +
                ", simpleName='" + simpleName + '\'' +
                ", simpleNumber='" + simpleNumber + '\'' +
                '}';
    }
}