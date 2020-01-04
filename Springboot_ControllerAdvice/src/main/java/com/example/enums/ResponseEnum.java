package com.example.enums;

/**
 * Created by wjd on 2019/4/19.
 */
public enum ResponseEnum implements BaseEnums{

    SUCCESS(200, "成功"),
    TOKEN_FAIL(401, "token失效"),
    FAIL(500, "服务器出了点小故障");
    private Integer value;
    private String label;

    ResponseEnum(Integer value, String label) {
        this.value = value;
        this.label = label;
    }

    @Override
    public Integer getValue() {
        return this.value;
    }

    @Override
    public String getLabel() {
        return this.label;
    }

}
