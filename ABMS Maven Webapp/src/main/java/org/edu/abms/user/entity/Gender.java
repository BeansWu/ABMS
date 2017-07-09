package org.edu.abms.user.entity;

/**
 * @Description: 性别
 * @author: 吴炳生
 * @date: 2017/7/8
 */
public enum Gender {
    /** 未知 **/
    UNKNOWN(0),

    /** 男 **/
    MALE(1),

    /** 女 **/
    FEMALE(2);

    private Byte val;

    private Gender(Integer val) {
        this.val = val.byteValue();
    }

    public Byte getVal() {
        return this.val;
    }

    public int compare(Gender gender) {
        return compare(gender);
    }

    public int compareTo(Byte gender) {
        return this.val.compareTo(gender);
    }
}
