package org.lemonPig.os.core.pojo;

public class RolePOJO {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role.id
     *
     * @mbggenerated Sun May 24 19:46:56 GMT+08:00 2015
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role.ename
     *
     * @mbggenerated Sun May 24 19:46:56 GMT+08:00 2015
     */
    private String ename;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role.cname
     *
     * @mbggenerated Sun May 24 19:46:56 GMT+08:00 2015
     */
    private String cname;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role.grantAble
     *
     * @mbggenerated Sun May 24 19:46:56 GMT+08:00 2015
     */
    private Byte grantAble;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role.id
     *
     * @return the value of role.id
     *
     * @mbggenerated Sun May 24 19:46:56 GMT+08:00 2015
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role.id
     *
     * @param id the value for role.id
     *
     * @mbggenerated Sun May 24 19:46:56 GMT+08:00 2015
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role.ename
     *
     * @return the value of role.ename
     *
     * @mbggenerated Sun May 24 19:46:56 GMT+08:00 2015
     */
    public String getEname() {
        return ename;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role.ename
     *
     * @param ename the value for role.ename
     *
     * @mbggenerated Sun May 24 19:46:56 GMT+08:00 2015
     */
    public void setEname(String ename) {
        this.ename = ename == null ? null : ename.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role.cname
     *
     * @return the value of role.cname
     *
     * @mbggenerated Sun May 24 19:46:56 GMT+08:00 2015
     */
    public String getCname() {
        return cname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role.cname
     *
     * @param cname the value for role.cname
     *
     * @mbggenerated Sun May 24 19:46:56 GMT+08:00 2015
     */
    public void setCname(String cname) {
        this.cname = cname == null ? null : cname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role.grantAble
     *
     * @return the value of role.grantAble
     *
     * @mbggenerated Sun May 24 19:46:56 GMT+08:00 2015
     */
    public Byte getGrantAble() {
        return grantAble;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role.grantAble
     *
     * @param grantAble the value for role.grantAble
     *
     * @mbggenerated Sun May 24 19:46:56 GMT+08:00 2015
     */
    public void setGrantAble(Byte grantAble) {
        this.grantAble = grantAble;
    }
}