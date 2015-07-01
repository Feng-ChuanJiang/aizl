package org.lemonPig.os.core.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.lemonPig.os.core.pojo.UserMetadataPOJO;
import org.lemonPig.os.core.pojo.UserMetadataPOJOExample;

public interface UserMetadataPOJOMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table USER_METADATA
     *
     * @mbggenerated Sun Jun 07 15:19:11 GMT+08:00 2015
     */
    int countByExample(UserMetadataPOJOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table USER_METADATA
     *
     * @mbggenerated Sun Jun 07 15:19:11 GMT+08:00 2015
     */
    int deleteByExample(UserMetadataPOJOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table USER_METADATA
     *
     * @mbggenerated Sun Jun 07 15:19:11 GMT+08:00 2015
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table USER_METADATA
     *
     * @mbggenerated Sun Jun 07 15:19:11 GMT+08:00 2015
     */
    int insert(UserMetadataPOJO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table USER_METADATA
     *
     * @mbggenerated Sun Jun 07 15:19:11 GMT+08:00 2015
     */
    int insertSelective(UserMetadataPOJO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table USER_METADATA
     *
     * @mbggenerated Sun Jun 07 15:19:11 GMT+08:00 2015
     */
    List<UserMetadataPOJO> selectByExample(UserMetadataPOJOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table USER_METADATA
     *
     * @mbggenerated Sun Jun 07 15:19:11 GMT+08:00 2015
     */
    UserMetadataPOJO selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table USER_METADATA
     *
     * @mbggenerated Sun Jun 07 15:19:11 GMT+08:00 2015
     */
    int updateByExampleSelective(@Param("record") UserMetadataPOJO record, @Param("example") UserMetadataPOJOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table USER_METADATA
     *
     * @mbggenerated Sun Jun 07 15:19:11 GMT+08:00 2015
     */
    int updateByExample(@Param("record") UserMetadataPOJO record, @Param("example") UserMetadataPOJOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table USER_METADATA
     *
     * @mbggenerated Sun Jun 07 15:19:11 GMT+08:00 2015
     */
    int updateByPrimaryKeySelective(UserMetadataPOJO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table USER_METADATA
     *
     * @mbggenerated Sun Jun 07 15:19:11 GMT+08:00 2015
     */
    int updateByPrimaryKey(UserMetadataPOJO record);
}