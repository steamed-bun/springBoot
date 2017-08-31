package com.coocaa.springBoot.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Entity
public class User {

    @Id
    @GeneratedValue
    private Integer id;

//    @Pattern(regexp = "(腾讯源|爱奇艺源|爱奇艺\\+优朋混合源)", message = "必须是腾讯源、爱奇艺源、爱奇艺+优朋混合源")
//    @Pattern(regexp = "^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[1-2]\\d|3[0-1]) ([0-1]\\d|2[0-3]):([0-5]\\d):([0-5]\\d)$")
    private String name;

    @Min(value = 12, message = "年龄问题...")
    private Integer age;

    @NotNull(message = "钱必须给...")
//    @Min(value = 0, message = "money 不能大于一")

    @Min(value = 0, message = "min")
    @Max(value = 1, message = "max")
//    @Range(min = 0, max = 0 , message = "money 不能大于1也不能小于0")
    @Digits(integer = 1,fraction = 2, message = "money精度不正确")
    private Float money;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", money=" + money +
                '}';
    }

    public User() {
    }

    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
