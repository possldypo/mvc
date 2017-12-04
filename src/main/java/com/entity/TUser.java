package com.entity;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Date;
import java.util.Map;

@Component
@Scope("prototype")
public class TUser {
    private Integer id;
    @NotEmpty(message = "用户名不能为空")
    @Min(value = 3,message = "最小3位")
    @Max(value = 10,message = "最大10位")
    private String userName;

    @NotEmpty(message = "邮箱不能为空")
    @Email(message = "格式不正确")
    private String email;

    @NotEmpty(message = "请输入密码")
    @Min(value = 8,message = "最小8位")
    @Max(value = 28,message = "最大28位")
    private String password;

    private Integer status;

    private Integer invalid;

    private Date createTime;

    private Date lastUpdateTime;

    public static final Integer INVALID = 0;/*有效 */
    public static final Integer UNVALID = 1;/*无效*/

    public static final Integer NORMAL  = 0 ; /*正常*/
    public static final Integer DELETE = 7 ; /*已注销*/
    public static final Integer UNACTIVE = 9 ; /*未激活*/

    public static final String INVALID_MSG = "账号有效";
    public static final String UNVALID_MSG = "账号无效";

    public static final String NORMAL_MSG = "正常";
    public static final String DELETE_MSG = "删除";
    public static final String UNACTIVE_MSG = "账号未激活";

    public static final Map<Integer,String> USER_STATUS_MAP = null;
    public static final Map<Integer,String> USER_IVALID_MAP = null;

    static{
        USER_IVALID_MAP.put(NORMAL,NORMAL_MSG);
        USER_IVALID_MAP.put(DELETE,DELETE_MSG);
        USER_IVALID_MAP.put(UNACTIVE,UNACTIVE_MSG);

        USER_STATUS_MAP.put(INVALID,INVALID_MSG);
        USER_STATUS_MAP.put(UNVALID,UNVALID_MSG);
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer sgetInvalid() {
        return invalid;
    }

    public void setInvalid(Integer invalid) {
        this.invalid = invalid;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }
}