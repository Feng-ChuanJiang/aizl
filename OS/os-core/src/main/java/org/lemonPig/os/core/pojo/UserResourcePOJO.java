package org.lemonPig.os.core.pojo;

public class UserResourcePOJO {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_resource.id
     *
     * @mbggenerated Sun May 24 19:46:56 GMT+08:00 2015
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_resource.user_id
     *
     * @mbggenerated Sun May 24 19:46:56 GMT+08:00 2015
     */
    private Long user_id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_resource.resource_id
     *
     * @mbggenerated Sun May 24 19:46:56 GMT+08:00 2015
     */
    private Long resource_id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_resource.grant_user_id
     *
     * @mbggenerated Sun May 24 19:46:56 GMT+08:00 2015
     */
    private Long grant_user_id;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_resource.id
     *
     * @return the value of user_resource.id
     *
     * @mbggenerated Sun May 24 19:46:56 GMT+08:00 2015
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_resource.id
     *
     * @param id the value for user_resource.id
     *
     * @mbggenerated Sun May 24 19:46:56 GMT+08:00 2015
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_resource.user_id
     *
     * @return the value of user_resource.user_id
     *
     * @mbggenerated Sun May 24 19:46:56 GMT+08:00 2015
     */
    public Long getUser_id() {
        return user_id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_resource.user_id
     *
     * @param user_id the value for user_resource.user_id
     *
     * @mbggenerated Sun May 24 19:46:56 GMT+08:00 2015
     */
    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_resource.resource_id
     *
     * @return the value of user_resource.resource_id
     *
     * @mbggenerated Sun May 24 19:46:56 GMT+08:00 2015
     */
    public Long getResource_id() {
        return resource_id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_resource.resource_id
     *
     * @param resource_id the value for user_resource.resource_id
     *
     * @mbggenerated Sun May 24 19:46:56 GMT+08:00 2015
     */
    public void setResource_id(Long resource_id) {
        this.resource_id = resource_id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_resource.grant_user_id
     *
     * @return the value of user_resource.grant_user_id
     *
     * @mbggenerated Sun May 24 19:46:56 GMT+08:00 2015
     */
    public Long getGrant_user_id() {
        return grant_user_id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_resource.grant_user_id
     *
     * @param grant_user_id the value for user_resource.grant_user_id
     *
     * @mbggenerated Sun May 24 19:46:56 GMT+08:00 2015
     */
    public void setGrant_user_id(Long grant_user_id) {
        this.grant_user_id = grant_user_id;
    }
}