package org.lemonPig.os.core.pojo;

public class UserPOJO {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column USER.ID
     *
     * @mbggenerated Sun Jun 07 15:19:11 GMT+08:00 2015
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column USER.USERNAME
     *
     * @mbggenerated Sun Jun 07 15:19:11 GMT+08:00 2015
     */
    private String username;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column USER.PASSWORD
     *
     * @mbggenerated Sun Jun 07 15:19:11 GMT+08:00 2015
     */
    private String password;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column USER.STATUS
     *
     * @mbggenerated Sun Jun 07 15:19:11 GMT+08:00 2015
     */
    private Integer status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column USER.SALT
     *
     * @mbggenerated Sun Jun 07 15:19:11 GMT+08:00 2015
     */
    private String salt;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column USER.TEL
     *
     * @mbggenerated Sun Jun 07 15:19:11 GMT+08:00 2015
     */
    private String tel;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column USER.MAIL
     *
     * @mbggenerated Sun Jun 07 15:19:11 GMT+08:00 2015
     */
    private String mail;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column USER.ID
     *
     * @return the value of USER.ID
     *
     * @mbggenerated Sun Jun 07 15:19:11 GMT+08:00 2015
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column USER.ID
     *
     * @param id the value for USER.ID
     *
     * @mbggenerated Sun Jun 07 15:19:11 GMT+08:00 2015
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column USER.USERNAME
     *
     * @return the value of USER.USERNAME
     *
     * @mbggenerated Sun Jun 07 15:19:11 GMT+08:00 2015
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column USER.USERNAME
     *
     * @param username the value for USER.USERNAME
     *
     * @mbggenerated Sun Jun 07 15:19:11 GMT+08:00 2015
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column USER.PASSWORD
     *
     * @return the value of USER.PASSWORD
     *
     * @mbggenerated Sun Jun 07 15:19:11 GMT+08:00 2015
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column USER.PASSWORD
     *
     * @param password the value for USER.PASSWORD
     *
     * @mbggenerated Sun Jun 07 15:19:11 GMT+08:00 2015
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column USER.STATUS
     *
     * @return the value of USER.STATUS
     *
     * @mbggenerated Sun Jun 07 15:19:11 GMT+08:00 2015
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column USER.STATUS
     *
     * @param status the value for USER.STATUS
     *
     * @mbggenerated Sun Jun 07 15:19:11 GMT+08:00 2015
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column USER.SALT
     *
     * @return the value of USER.SALT
     *
     * @mbggenerated Sun Jun 07 15:19:11 GMT+08:00 2015
     */
    public String getSalt() {
        return salt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column USER.SALT
     *
     * @param salt the value for USER.SALT
     *
     * @mbggenerated Sun Jun 07 15:19:11 GMT+08:00 2015
     */
    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column USER.TEL
     *
     * @return the value of USER.TEL
     *
     * @mbggenerated Sun Jun 07 15:19:11 GMT+08:00 2015
     */
    public String getTel() {
        return tel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column USER.TEL
     *
     * @param tel the value for USER.TEL
     *
     * @mbggenerated Sun Jun 07 15:19:11 GMT+08:00 2015
     */
    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column USER.MAIL
     *
     * @return the value of USER.MAIL
     *
     * @mbggenerated Sun Jun 07 15:19:11 GMT+08:00 2015
     */
    public String getMail() {
        return mail;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column USER.MAIL
     *
     * @param mail the value for USER.MAIL
     *
     * @mbggenerated Sun Jun 07 15:19:11 GMT+08:00 2015
     */
    public void setMail(String mail) {
        this.mail = mail == null ? null : mail.trim();
    }
}