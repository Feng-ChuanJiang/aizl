package org.lemonPig.os.core.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.lemonPig.os.core.pojo.ResourcePOJO;
import org.lemonPig.os.core.pojo.ResourcePOJOExample;

public interface ResourcePOJOMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RESOURCE
     *
     * @mbggenerated Fri Jul 10 19:11:38 GMT+08:00 2015
     */
    int countByExample(ResourcePOJOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RESOURCE
     *
     * @mbggenerated Fri Jul 10 19:11:38 GMT+08:00 2015
     */
    int deleteByExample(ResourcePOJOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RESOURCE
     *
     * @mbggenerated Fri Jul 10 19:11:38 GMT+08:00 2015
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RESOURCE
     *
     * @mbggenerated Fri Jul 10 19:11:38 GMT+08:00 2015
     */
    int insert(ResourcePOJO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RESOURCE
     *
     * @mbggenerated Fri Jul 10 19:11:38 GMT+08:00 2015
     */
    int insertSelective(ResourcePOJO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RESOURCE
     *
     * @mbggenerated Fri Jul 10 19:11:38 GMT+08:00 2015
     */
    List<ResourcePOJO> selectByExample(ResourcePOJOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RESOURCE
     *
     * @mbggenerated Fri Jul 10 19:11:38 GMT+08:00 2015
     */
    ResourcePOJO selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RESOURCE
     *
     * @mbggenerated Fri Jul 10 19:11:38 GMT+08:00 2015
     */
    int updateByExampleSelective(@Param("record") ResourcePOJO record, @Param("example") ResourcePOJOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RESOURCE
     *
     * @mbggenerated Fri Jul 10 19:11:38 GMT+08:00 2015
     */
    int updateByExample(@Param("record") ResourcePOJO record, @Param("example") ResourcePOJOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RESOURCE
     *
     * @mbggenerated Fri Jul 10 19:11:38 GMT+08:00 2015
     */
    int updateByPrimaryKeySelective(ResourcePOJO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RESOURCE
     *
     * @mbggenerated Fri Jul 10 19:11:38 GMT+08:00 2015
     */
    int updateByPrimaryKey(ResourcePOJO record);
}