package org.lemonPig.os.core.mapper;

import org.apache.ibatis.annotations.Param;
import org.lemonPig.os.core.pojo.RolePermissionPOJO;
import org.lemonPig.os.core.pojo.RolePermissionPOJOExample;

public interface RolePermissionPOJOMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ROLE_PERMISSION
     *
     * @mbggenerated Fri Jul 10 19:11:38 GMT+08:00 2015
     */
    int countByExample(RolePermissionPOJOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ROLE_PERMISSION
     *
     * @mbggenerated Fri Jul 10 19:11:38 GMT+08:00 2015
     */
    int deleteByExample(RolePermissionPOJOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ROLE_PERMISSION
     *
     * @mbggenerated Fri Jul 10 19:11:38 GMT+08:00 2015
     */
    int insert(RolePermissionPOJO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ROLE_PERMISSION
     *
     * @mbggenerated Fri Jul 10 19:11:38 GMT+08:00 2015
     */
    int insertSelective(RolePermissionPOJO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ROLE_PERMISSION
     *
     * @mbggenerated Fri Jul 10 19:11:38 GMT+08:00 2015
     */
    int updateByExampleSelective(@Param("record") RolePermissionPOJO record, @Param("example") RolePermissionPOJOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ROLE_PERMISSION
     *
     * @mbggenerated Fri Jul 10 19:11:38 GMT+08:00 2015
     */
    int updateByExample(@Param("record") RolePermissionPOJO record, @Param("example") RolePermissionPOJOExample example);
}