package org.edu.abms.budget.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.edu.abms.common.entity.AuditState;
import org.edu.abms.user.entity.User;

/**
 * @Description: 预算申请信息
 * @author: 吴炳生
 * @date: 2017/7/8
 */
@Entity
@Table(name = "t_budget_app")
public class BudgetApp implements Serializable {
    /**
     * 主键，自增
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * 项目编号
     */
    @Column(length = 20, nullable = false)
    private String number;
    /**
     * 项目名称
     */
    @Column(length = 45, nullable = false)
    private String name;
    /**
     * 需求时间,只需要年份
     */
    @Column(name = "required_time", length = 5, nullable = false)
    private String requiredTime;
    /**
     * 填表人
     */
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "USER_ID_FK"))
    private User user;
    /**
     * 填表日期
     */
    @Column(name = "fill_date", nullable = false)
    private Date fillDate;
    /**
     * 购置理由
     */
    @Column(length = 100, nullable = false)
    private String reason;

    public Integer getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public String getRequiredTime() {
        return requiredTime;
    }

    public User getUser() {
        return user;
    }

    public Date getFillDate() {
        return fillDate;
    }

    public String getReason() {
        return reason;
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

    public void setRequiredTime(String requiredTime) {
        this.requiredTime = requiredTime;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setFillDate(Date fillDate) {
        this.fillDate = fillDate;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }


    public BudgetApp() {
		super();
	}

	public BudgetApp(String number, String name, String requiredTime, User user, Date fillDate, String reason) {
        this.number = number;
        this.name = name;
        this.requiredTime = requiredTime;
        this.user = user;
        this.fillDate = fillDate;
        this.reason = reason;
    }


}