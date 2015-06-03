package org.lemonPig.os.core.pojo;

import java.util.ArrayList;
import java.util.List;

public class UserResourcePOJOExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table user_resource
     *
     * @mbggenerated Sun May 24 19:46:56 GMT+08:00 2015
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table user_resource
     *
     * @mbggenerated Sun May 24 19:46:56 GMT+08:00 2015
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table user_resource
     *
     * @mbggenerated Sun May 24 19:46:56 GMT+08:00 2015
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_resource
     *
     * @mbggenerated Sun May 24 19:46:56 GMT+08:00 2015
     */
    public UserResourcePOJOExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_resource
     *
     * @mbggenerated Sun May 24 19:46:56 GMT+08:00 2015
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_resource
     *
     * @mbggenerated Sun May 24 19:46:56 GMT+08:00 2015
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_resource
     *
     * @mbggenerated Sun May 24 19:46:56 GMT+08:00 2015
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_resource
     *
     * @mbggenerated Sun May 24 19:46:56 GMT+08:00 2015
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_resource
     *
     * @mbggenerated Sun May 24 19:46:56 GMT+08:00 2015
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_resource
     *
     * @mbggenerated Sun May 24 19:46:56 GMT+08:00 2015
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_resource
     *
     * @mbggenerated Sun May 24 19:46:56 GMT+08:00 2015
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_resource
     *
     * @mbggenerated Sun May 24 19:46:56 GMT+08:00 2015
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_resource
     *
     * @mbggenerated Sun May 24 19:46:56 GMT+08:00 2015
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_resource
     *
     * @mbggenerated Sun May 24 19:46:56 GMT+08:00 2015
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table user_resource
     *
     * @mbggenerated Sun May 24 19:46:56 GMT+08:00 2015
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("userResource.id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("userResource.id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("userResource.id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("userResource.id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("userResource.id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("userResource.id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("userResource.id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("userResource.id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("userResource.id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("userResource.id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("userResource.id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("userResource.id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUser_idIsNull() {
            addCriterion("userResource.user_id is null");
            return (Criteria) this;
        }

        public Criteria andUser_idIsNotNull() {
            addCriterion("userResource.user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUser_idEqualTo(Long value) {
            addCriterion("userResource.user_id =", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idNotEqualTo(Long value) {
            addCriterion("userResource.user_id <>", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idGreaterThan(Long value) {
            addCriterion("userResource.user_id >", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idGreaterThanOrEqualTo(Long value) {
            addCriterion("userResource.user_id >=", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idLessThan(Long value) {
            addCriterion("userResource.user_id <", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idLessThanOrEqualTo(Long value) {
            addCriterion("userResource.user_id <=", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idIn(List<Long> values) {
            addCriterion("userResource.user_id in", values, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idNotIn(List<Long> values) {
            addCriterion("userResource.user_id not in", values, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idBetween(Long value1, Long value2) {
            addCriterion("userResource.user_id between", value1, value2, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idNotBetween(Long value1, Long value2) {
            addCriterion("userResource.user_id not between", value1, value2, "user_id");
            return (Criteria) this;
        }

        public Criteria andResource_idIsNull() {
            addCriterion("userResource.resource_id is null");
            return (Criteria) this;
        }

        public Criteria andResource_idIsNotNull() {
            addCriterion("userResource.resource_id is not null");
            return (Criteria) this;
        }

        public Criteria andResource_idEqualTo(Long value) {
            addCriterion("userResource.resource_id =", value, "resource_id");
            return (Criteria) this;
        }

        public Criteria andResource_idNotEqualTo(Long value) {
            addCriterion("userResource.resource_id <>", value, "resource_id");
            return (Criteria) this;
        }

        public Criteria andResource_idGreaterThan(Long value) {
            addCriterion("userResource.resource_id >", value, "resource_id");
            return (Criteria) this;
        }

        public Criteria andResource_idGreaterThanOrEqualTo(Long value) {
            addCriterion("userResource.resource_id >=", value, "resource_id");
            return (Criteria) this;
        }

        public Criteria andResource_idLessThan(Long value) {
            addCriterion("userResource.resource_id <", value, "resource_id");
            return (Criteria) this;
        }

        public Criteria andResource_idLessThanOrEqualTo(Long value) {
            addCriterion("userResource.resource_id <=", value, "resource_id");
            return (Criteria) this;
        }

        public Criteria andResource_idIn(List<Long> values) {
            addCriterion("userResource.resource_id in", values, "resource_id");
            return (Criteria) this;
        }

        public Criteria andResource_idNotIn(List<Long> values) {
            addCriterion("userResource.resource_id not in", values, "resource_id");
            return (Criteria) this;
        }

        public Criteria andResource_idBetween(Long value1, Long value2) {
            addCriterion("userResource.resource_id between", value1, value2, "resource_id");
            return (Criteria) this;
        }

        public Criteria andResource_idNotBetween(Long value1, Long value2) {
            addCriterion("userResource.resource_id not between", value1, value2, "resource_id");
            return (Criteria) this;
        }

        public Criteria andGrant_user_idIsNull() {
            addCriterion("userResource.grant_user_id is null");
            return (Criteria) this;
        }

        public Criteria andGrant_user_idIsNotNull() {
            addCriterion("userResource.grant_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andGrant_user_idEqualTo(Long value) {
            addCriterion("userResource.grant_user_id =", value, "grant_user_id");
            return (Criteria) this;
        }

        public Criteria andGrant_user_idNotEqualTo(Long value) {
            addCriterion("userResource.grant_user_id <>", value, "grant_user_id");
            return (Criteria) this;
        }

        public Criteria andGrant_user_idGreaterThan(Long value) {
            addCriterion("userResource.grant_user_id >", value, "grant_user_id");
            return (Criteria) this;
        }

        public Criteria andGrant_user_idGreaterThanOrEqualTo(Long value) {
            addCriterion("userResource.grant_user_id >=", value, "grant_user_id");
            return (Criteria) this;
        }

        public Criteria andGrant_user_idLessThan(Long value) {
            addCriterion("userResource.grant_user_id <", value, "grant_user_id");
            return (Criteria) this;
        }

        public Criteria andGrant_user_idLessThanOrEqualTo(Long value) {
            addCriterion("userResource.grant_user_id <=", value, "grant_user_id");
            return (Criteria) this;
        }

        public Criteria andGrant_user_idIn(List<Long> values) {
            addCriterion("userResource.grant_user_id in", values, "grant_user_id");
            return (Criteria) this;
        }

        public Criteria andGrant_user_idNotIn(List<Long> values) {
            addCriterion("userResource.grant_user_id not in", values, "grant_user_id");
            return (Criteria) this;
        }

        public Criteria andGrant_user_idBetween(Long value1, Long value2) {
            addCriterion("userResource.grant_user_id between", value1, value2, "grant_user_id");
            return (Criteria) this;
        }

        public Criteria andGrant_user_idNotBetween(Long value1, Long value2) {
            addCriterion("userResource.grant_user_id not between", value1, value2, "grant_user_id");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table user_resource
     *
     * @mbggenerated do_not_delete_during_merge Sun May 24 19:46:56 GMT+08:00 2015
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table user_resource
     *
     * @mbggenerated Sun May 24 19:46:56 GMT+08:00 2015
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value) {
            super();
            this.condition = condition;
            this.value = value;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.betweenValue = true;
        }
    }
}