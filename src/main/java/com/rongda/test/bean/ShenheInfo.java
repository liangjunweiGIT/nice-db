package com.rongda.test.bean;


public class ShenheInfo {
    private Integer id;
    /**
     *  公告索引
     */
    private String index;
    /**
     * 参会发审委委员
     */
    private String memberName;
    /**
     * 审核的发行人

     */
    private String issuedName;

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "ShenheInfoDao{" +
                "id=" + id +
                ", index='" + index + '\'' +
                ", memberName='" + memberName + '\'' +
                ", issuedName='" + issuedName + '\'' +
                '}';
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getIssuedName() {
        return issuedName;
    }

    public void setIssuedName(String issuedName) {
        this.issuedName = issuedName;
    }
}
