package cq.anbu.modules.bill.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cq.anbu.common.base.BaseEntity;

import java.math.BigDecimal;


/**
 * 包材表
 *
 * @author tangzhonggui
 * @email java_tangzg@163.com
 * @date 2018-06-12 09:49:45
 */
public class BillPackingMaterialsEntity extends BaseEntity {

    //序号
    @Excel(name = "序号")
    private Long serialNo;
    //地点
    @Excel(name = "地点")
    private String address;
    //运输供应商
    @Excel(name = "运输供应商")
    private String transpotSupplier;
    //运费类型
    @Excel(name = "运费类型")
    private String freightType;
    //运输单号
    @Excel(name = "运输单号")
    private String transpotNo;
    //日期
    @Excel(name = "日期")
    private String date;
    //起点
    @Excel(name = "起点")
    private String lineStart;
    //线路终点
    @Excel(name = "线路终点")
    private String lineEnd;
    //运输产品
    @Excel(name = "运输产品")
    private String transpotProduct;
    //运输方式
    @Excel(name = "运输方式")
    private String transpotMode;
    //车型
    @Excel(name = "车型")
    private String motorcycleType;
    //运输单价(含税保险)
    @Excel(name = "运输单价")
    private BigDecimal transpotPrice;
    //纸箱
    @Excel(name = "纸箱")
    private BigDecimal carton;
    //1#泡棉
    @Excel(name = "1#泡棉")
    private BigDecimal foamOne;
    //2#泡棉
    @Excel(name = "2#泡棉")
    private BigDecimal foamTwo;
    //3#泡棉
    @Excel(name = "3#泡棉")
    private BigDecimal foamThree;
    //4#泡棉
    @Excel(name = "4#泡棉")
    private BigDecimal foamFour;
    //纸角撑
    @Excel(name = "纸角撑")
    private BigDecimal paperBrace;
    //数量
    @Excel(name = "数量")
    private BigDecimal quantity;
    //总体积
    @Excel(name = "总体积")
    private BigDecimal voluneSum;
    //总重量
    @Excel(name = "总重量")
    private BigDecimal weightSum;
    //提送运费
    @Excel(name = "提送运费")
    private BigDecimal deliveryFee;
    //预提运费合计（含税10%）
    @Excel(name = "预提运费合计（含税10%）")
    private BigDecimal advanceFeeIncludeTax;
    //预提运费合计（不含税）
    @Excel(name = "预提运费合计（不含税）")
    private BigDecimal advanceFeeNoTax;
    //
    @Excel(name = "状态")
    private Integer status;
    //备注
    @Excel(name = "备注")
    private String comment;
    //预留字段1
    private String reserveOne;
    //预留字段2
    private String reserveTwo;

    /**
     * 设置：序号
     */
    public void setSerialNo(Long serialNo) {
        this.serialNo = serialNo;
    }

    /**
     * 获取：序号
     */
    public Long getSerialNo() {
        return serialNo;
    }

    /**
     * 设置：地点
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取：地点
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置：运输供应商
     */
    public void setTranspotSupplier(String transpotSupplier) {
        this.transpotSupplier = transpotSupplier;
    }

    /**
     * 获取：运输供应商
     */
    public String getTranspotSupplier() {
        return transpotSupplier;
    }

    /**
     * 设置：运费类型
     */
    public void setFreightType(String freightType) {
        this.freightType = freightType;
    }

    /**
     * 获取：运费类型
     */
    public String getFreightType() {
        return freightType;
    }

    /**
     * 设置：运输单号
     */
    public void setTranspotNo(String transpotNo) {
        this.transpotNo = transpotNo;
    }

    /**
     * 获取：运输单号
     */
    public String getTranspotNo() {
        return transpotNo;
    }

    /**
     * 设置：日期
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * 获取：日期
     */
    public String getDate() {
        return date;
    }

    /**
     * 设置：起点
     */
    public void setLineStart(String lineStart) {
        this.lineStart = lineStart;
    }

    /**
     * 获取：起点
     */
    public String getLineStart() {
        return lineStart;
    }

    /**
     * 设置：线路终点
     */
    public void setLineEnd(String lineEnd) {
        this.lineEnd = lineEnd;
    }

    /**
     * 获取：线路终点
     */
    public String getLineEnd() {
        return lineEnd;
    }

    /**
     * 设置：运输产品
     */
    public void setTranspotProduct(String transpotProduct) {
        this.transpotProduct = transpotProduct;
    }

    /**
     * 获取：运输产品
     */
    public String getTranspotProduct() {
        return transpotProduct;
    }

    /**
     * 设置：运输方式
     */
    public void setTranspotMode(String transpotMode) {
        this.transpotMode = transpotMode;
    }

    /**
     * 获取：运输方式
     */
    public String getTranspotMode() {
        return transpotMode;
    }

    /**
     * 设置：车型
     */
    public void setMotorcycleType(String motorcycleType) {
        this.motorcycleType = motorcycleType;
    }

    /**
     * 获取：车型
     */
    public String getMotorcycleType() {
        return motorcycleType;
    }

    /**
     * 设置：运输单价(含税保险)
     */
    public void setTranspotPrice(BigDecimal transpotPrice) {
        this.transpotPrice = transpotPrice;
    }

    /**
     * 获取：运输单价(含税保险)
     */
    public BigDecimal getTranspotPrice() {
        return transpotPrice;
    }

    /**
     * 设置：纸箱
     */
    public void setCarton(BigDecimal carton) {
        this.carton = carton;
    }

    /**
     * 获取：纸箱
     */
    public BigDecimal getCarton() {
        return carton;
    }

    /**
     * 设置：1#泡棉
     */
    public void setFoamOne(BigDecimal foamOne) {
        this.foamOne = foamOne;
    }

    /**
     * 获取：1#泡棉
     */
    public BigDecimal getFoamOne() {
        return foamOne;
    }

    /**
     * 设置：2#泡棉
     */
    public void setFoamTwo(BigDecimal foamTwo) {
        this.foamTwo = foamTwo;
    }

    /**
     * 获取：2#泡棉
     */
    public BigDecimal getFoamTwo() {
        return foamTwo;
    }

    /**
     * 设置：3#泡棉
     */
    public void setFoamThree(BigDecimal foamThree) {
        this.foamThree = foamThree;
    }

    /**
     * 获取：3#泡棉
     */
    public BigDecimal getFoamThree() {
        return foamThree;
    }

    /**
     * 设置：4#泡棉
     */
    public void setFoamFour(BigDecimal foamFour) {
        this.foamFour = foamFour;
    }

    /**
     * 获取：4#泡棉
     */
    public BigDecimal getFoamFour() {
        return foamFour;
    }

    /**
     * 设置：纸角撑
     */
    public void setPaperBrace(BigDecimal paperBrace) {
        this.paperBrace = paperBrace;
    }

    /**
     * 获取：纸角撑
     */
    public BigDecimal getPaperBrace() {
        return paperBrace;
    }

    /**
     * 设置：数量
     */
    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    /**
     * 获取：数量
     */
    public BigDecimal getQuantity() {
        return quantity;
    }

    /**
     * 设置：总体积
     */
    public void setVoluneSum(BigDecimal voluneSum) {
        this.voluneSum = voluneSum;
    }

    /**
     * 获取：总体积
     */
    public BigDecimal getVoluneSum() {
        return voluneSum;
    }

    /**
     * 设置：总重量
     */
    public void setWeightSum(BigDecimal weightSum) {
        this.weightSum = weightSum;
    }

    /**
     * 获取：总重量
     */
    public BigDecimal getWeightSum() {
        return weightSum;
    }

    /**
     * 设置：提送运费
     */
    public void setDeliveryFee(BigDecimal deliveryFee) {
        this.deliveryFee = deliveryFee;
    }

    /**
     * 获取：提送运费
     */
    public BigDecimal getDeliveryFee() {
        return deliveryFee;
    }

    /**
     * 设置：预提运费合计（含税10%）
     */
    public void setAdvanceFeeIncludeTax(BigDecimal advanceFeeIncludeTax) {
        this.advanceFeeIncludeTax = advanceFeeIncludeTax;
    }

    /**
     * 获取：预提运费合计（含税10%）
     */
    public BigDecimal getAdvanceFeeIncludeTax() {
        return advanceFeeIncludeTax;
    }

    /**
     * 设置：预提运费合计（不含税）
     */
    public void setAdvanceFeeNoTax(BigDecimal advanceFeeNoTax) {
        this.advanceFeeNoTax = advanceFeeNoTax;
    }

    /**
     * 获取：预提运费合计（不含税）
     */
    public BigDecimal getAdvanceFeeNoTax() {
        return advanceFeeNoTax;
    }

    /**
     * 设置：
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取：
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置：备注
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * 获取：备注
     */
    public String getComment() {
        return comment;
    }

    /**
     * 设置：预留字段1
     */
    public void setReserveOne(String reserveOne) {
        this.reserveOne = reserveOne;
    }

    /**
     * 获取：预留字段1
     */
    public String getReserveOne() {
        return reserveOne;
    }

    /**
     * 设置：预留字段2
     */
    public void setReserveTwo(String reserveTwo) {
        this.reserveTwo = reserveTwo;
    }

    /**
     * 获取：预留字段2
     */
    public String getReserveTwo() {
        return reserveTwo;
    }
}
