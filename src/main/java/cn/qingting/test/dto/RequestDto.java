package cn.qingting.test.dto;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * Created by howeTong on 2017/7/18 0018.
 */
public class RequestDto {

    @NotNull
    private int id;

    @NotBlank
    private String custName;

    @NotBlank
    private String cardNo;

    @NotBlank
    private String cardBindMobile;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getCardBindMobile() {
        return cardBindMobile;
    }

    public void setCardBindMobile(String cardBindMobile) {
        this.cardBindMobile = cardBindMobile;
    }
}
