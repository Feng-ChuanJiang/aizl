package org.lemonPig.os.core.pojo;

public class RolePermissionPOJO {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ROLE_PERMISSION.ROLE_ID
     *
     * @mbggenerated Fri Jul 10 19:11:38 GMT+08:00 2015
     */
    private Long roleId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ROLE_PERMISSION.PERMISSION_ID
     *
     * @mbggenerated Fri Jul 10 19:11:38 GMT+08:00 2015
     */
    private Long permissionId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ROLE_PERMISSION.ROLE_ID
     *
     * @return the value of ROLE_PERMISSION.ROLE_ID
     *
     * @mbggenerated Fri Jul 10 19:11:38 GMT+08:00 2015
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ROLE_PERMISSION.ROLE_ID
     *
     * @param roleId the value for ROLE_PERMISSION.ROLE_ID
     *
     * @mbggenerated Fri Jul 10 19:11:38 GMT+08:00 2015
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ROLE_PERMISSION.PERMISSION_ID
     *
     * @return the value of ROLE_PERMISSION.PERMISSION_ID
     *
     * @mbggenerated Fri Jul 10 19:11:38 GMT+08:00 2015
     */
    public Long getPermissionId() {
        return permissionId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ROLE_PERMISSION.PERMISSION_ID
     *
     * @param permissionId the value for ROLE_PERMISSION.PERMISSION_ID
     *
     * @mbggenerated Fri Jul 10 19:11:38 GMT+08:00 2015
     */
    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }
}