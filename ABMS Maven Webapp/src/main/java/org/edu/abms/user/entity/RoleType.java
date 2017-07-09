package org.edu.abms.user.entity;

/**
 * @Description: 用户类型
 * @author: 吴炳生
 * @date: 2017/7/8
 */
public enum RoleType {
    /**
     * 预算人
     */
    COMMON(0),
    /**
     * 经办人（院办公室）
     */
    FACULTY_MGR(1),
    /**
     * 分管领导（院长）
     */
    FACULTY_LD(2),
    /**
     * 资产处
     */
    ASSET_DEPT(3),
    /**
     * 财务处
     */
    FIN_DEPT(4),
    /**
     * 超级管理员
     */
    ADMIN(5);

    private Byte val;

    private RoleType(Integer val) {
        this.val = val.byteValue();
    }

    public Byte getVal() {
        return this.val;
    }

    public int compare(RoleType roleType) {
        return compare(roleType);
    }

    public int compareTo(Byte roleType) {
        return this.val.compareTo(roleType);
    }
}
