package org.lemonPig.os.core.pojo;

import java.util.ArrayList;
import java.util.List;

public class ResourcePOJOExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table resource
     *
     * @mbggenerated Sun May 24 19:46:56 GMT+08:00 2015
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table resource
     *
     * @mbggenerated Sun May 24 19:46:56 GMT+08:00 2015
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table resource
     *
     * @mbggenerated Sun May 24 19:46:56 GMT+08:00 2015
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table resource
     *
     * @mbggenerated Sun May 24 19:46:56 GMT+08:00 2015
     */
    public ResourcePOJOExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table resource
     *
     * @mbggenerated Sun May 24 19:46:56 GMT+08:00 2015
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table resource
     *
     * @mbggenerated Sun May 24 19:46:56 GMT+08:00 2015
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table resource
     *
     * @mbggenerated Sun May 24 19:46:56 GMT+08:00 2015
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table resource
     *
     * @mbggenerated Sun May 24 19:46:56 GMT+08:00 2015
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table resource
     *
     * @mbggenerated Sun May 24 19:46:56 GMT+08:00 2015
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table resource
     *
     * @mbggenerated Sun May 24 19:46:56 GMT+08:00 2015
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table resource
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
     * This method corresponds to the database table resource
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
     * This method corresponds to the database table resource
     *
     * @mbggenerated Sun May 24 19:46:56 GMT+08:00 2015
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table resource
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
     * This class corresponds to the database table resource
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
            addCriterion("resource.id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("resource.id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("resource.id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("resource.id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("resource.id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("resource.id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("resource.id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("resource.id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("resource.id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("resource.id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("resource.id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("resource.id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCnameIsNull() {
            addCriterion("resource.cname is null");
            return (Criteria) this;
        }

        public Criteria andCnameIsNotNull() {
            addCriterion("resource.cname is not null");
            return (Criteria) this;
        }

        public Criteria andCnameEqualTo(String value) {
            addCriterion("resource.cname =", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameNotEqualTo(String value) {
            addCriterion("resource.cname <>", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameGreaterThan(String value) {
            addCriterion("resource.cname >", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameGreaterThanOrEqualTo(String value) {
            addCriterion("resource.cname >=", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameLessThan(String value) {
            addCriterion("resource.cname <", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameLessThanOrEqualTo(String value) {
            addCriterion("resource.cname <=", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameLike(String value) {
            addCriterion("resource.cname like", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameNotLike(String value) {
            addCriterion("resource.cname not like", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameIn(List<String> values) {
            addCriterion("resource.cname in", values, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameNotIn(List<String> values) {
            addCriterion("resource.cname not in", values, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameBetween(String value1, String value2) {
            addCriterion("resource.cname between", value1, value2, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameNotBetween(String value1, String value2) {
            addCriterion("resource.cname not between", value1, value2, "cname");
            return (Criteria) this;
        }

        public Criteria andEnameIsNull() {
            addCriterion("resource.ename is null");
            return (Criteria) this;
        }

        public Criteria andEnameIsNotNull() {
            addCriterion("resource.ename is not null");
            return (Criteria) this;
        }

        public Criteria andEnameEqualTo(String value) {
            addCriterion("resource.ename =", value, "ename");
            return (Criteria) this;
        }

        public Criteria andEnameNotEqualTo(String value) {
            addCriterion("resource.ename <>", value, "ename");
            return (Criteria) this;
        }

        public Criteria andEnameGreaterThan(String value) {
            addCriterion("resource.ename >", value, "ename");
            return (Criteria) this;
        }

        public Criteria andEnameGreaterThanOrEqualTo(String value) {
            addCriterion("resource.ename >=", value, "ename");
            return (Criteria) this;
        }

        public Criteria andEnameLessThan(String value) {
            addCriterion("resource.ename <", value, "ename");
            return (Criteria) this;
        }

        public Criteria andEnameLessThanOrEqualTo(String value) {
            addCriterion("resource.ename <=", value, "ename");
            return (Criteria) this;
        }

        public Criteria andEnameLike(String value) {
            addCriterion("resource.ename like", value, "ename");
            return (Criteria) this;
        }

        public Criteria andEnameNotLike(String value) {
            addCriterion("resource.ename not like", value, "ename");
            return (Criteria) this;
        }

        public Criteria andEnameIn(List<String> values) {
            addCriterion("resource.ename in", values, "ename");
            return (Criteria) this;
        }

        public Criteria andEnameNotIn(List<String> values) {
            addCriterion("resource.ename not in", values, "ename");
            return (Criteria) this;
        }

        public Criteria andEnameBetween(String value1, String value2) {
            addCriterion("resource.ename between", value1, value2, "ename");
            return (Criteria) this;
        }

        public Criteria andEnameNotBetween(String value1, String value2) {
            addCriterion("resource.ename not between", value1, value2, "ename");
            return (Criteria) this;
        }

        public Criteria andPermissionIsNull() {
            addCriterion("resource.permission is null");
            return (Criteria) this;
        }

        public Criteria andPermissionIsNotNull() {
            addCriterion("resource.permission is not null");
            return (Criteria) this;
        }

        public Criteria andPermissionEqualTo(String value) {
            addCriterion("resource.permission =", value, "permission");
            return (Criteria) this;
        }

        public Criteria andPermissionNotEqualTo(String value) {
            addCriterion("resource.permission <>", value, "permission");
            return (Criteria) this;
        }

        public Criteria andPermissionGreaterThan(String value) {
            addCriterion("resource.permission >", value, "permission");
            return (Criteria) this;
        }

        public Criteria andPermissionGreaterThanOrEqualTo(String value) {
            addCriterion("resource.permission >=", value, "permission");
            return (Criteria) this;
        }

        public Criteria andPermissionLessThan(String value) {
            addCriterion("resource.permission <", value, "permission");
            return (Criteria) this;
        }

        public Criteria andPermissionLessThanOrEqualTo(String value) {
            addCriterion("resource.permission <=", value, "permission");
            return (Criteria) this;
        }

        public Criteria andPermissionLike(String value) {
            addCriterion("resource.permission like", value, "permission");
            return (Criteria) this;
        }

        public Criteria andPermissionNotLike(String value) {
            addCriterion("resource.permission not like", value, "permission");
            return (Criteria) this;
        }

        public Criteria andPermissionIn(List<String> values) {
            addCriterion("resource.permission in", values, "permission");
            return (Criteria) this;
        }

        public Criteria andPermissionNotIn(List<String> values) {
            addCriterion("resource.permission not in", values, "permission");
            return (Criteria) this;
        }

        public Criteria andPermissionBetween(String value1, String value2) {
            addCriterion("resource.permission between", value1, value2, "permission");
            return (Criteria) this;
        }

        public Criteria andPermissionNotBetween(String value1, String value2) {
            addCriterion("resource.permission not between", value1, value2, "permission");
            return (Criteria) this;
        }

        public Criteria andGrantAbleIsNull() {
            addCriterion("resource.grantAble is null");
            return (Criteria) this;
        }

        public Criteria andGrantAbleIsNotNull() {
            addCriterion("resource.grantAble is not null");
            return (Criteria) this;
        }

        public Criteria andGrantAbleEqualTo(Byte value) {
            addCriterion("resource.grantAble =", value, "grantAble");
            return (Criteria) this;
        }

        public Criteria andGrantAbleNotEqualTo(Byte value) {
            addCriterion("resource.grantAble <>", value, "grantAble");
            return (Criteria) this;
        }

        public Criteria andGrantAbleGreaterThan(Byte value) {
            addCriterion("resource.grantAble >", value, "grantAble");
            return (Criteria) this;
        }

        public Criteria andGrantAbleGreaterThanOrEqualTo(Byte value) {
            addCriterion("resource.grantAble >=", value, "grantAble");
            return (Criteria) this;
        }

        public Criteria andGrantAbleLessThan(Byte value) {
            addCriterion("resource.grantAble <", value, "grantAble");
            return (Criteria) this;
        }

        public Criteria andGrantAbleLessThanOrEqualTo(Byte value) {
            addCriterion("resource.grantAble <=", value, "grantAble");
            return (Criteria) this;
        }

        public Criteria andGrantAbleIn(List<Byte> values) {
            addCriterion("resource.grantAble in", values, "grantAble");
            return (Criteria) this;
        }

        public Criteria andGrantAbleNotIn(List<Byte> values) {
            addCriterion("resource.grantAble not in", values, "grantAble");
            return (Criteria) this;
        }

        public Criteria andGrantAbleBetween(Byte value1, Byte value2) {
            addCriterion("resource.grantAble between", value1, value2, "grantAble");
            return (Criteria) this;
        }

        public Criteria andGrantAbleNotBetween(Byte value1, Byte value2) {
            addCriterion("resource.grantAble not between", value1, value2, "grantAble");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table resource
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
     * This class corresponds to the database table resource
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