/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jobimprove.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "station_info")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StationInfo.findAll", query = "SELECT s FROM StationInfo s"),
    @NamedQuery(name = "StationInfo.findByStationInfoId", query = "SELECT s FROM StationInfo s WHERE s.stationInfoId = :stationInfoId"),
    @NamedQuery(name = "StationInfo.findBy\u6240\u5c5e\u5730\u5e02", query = "SELECT s FROM StationInfo s WHERE s.\u6240\u5c5e\u5730\u5e02 = :\u6240\u5c5e\u5730\u5e02"),
    @NamedQuery(name = "StationInfo.findBy\u6240\u5c5e\u7f51\u683c", query = "SELECT s FROM StationInfo s WHERE s.\u6240\u5c5e\u7f51\u683c = :\u6240\u5c5e\u7f51\u683c"),
    @NamedQuery(name = "StationInfo.findBy\u6240\u5c5e\u673a\u623f\u5b89\u88c5\u70b9\u7f16\u53f7", query = "SELECT s FROM StationInfo s WHERE s.\u6240\u5c5e\u673a\u623f\u5b89\u88c5\u70b9\u7f16\u53f7 = :\u6240\u5c5e\u673a\u623f\u5b89\u88c5\u70b9\u7f16\u53f7"),
    @NamedQuery(name = "StationInfo.findBy\u7ad9\u5740\u7f16\u53f7", query = "SELECT s FROM StationInfo s WHERE s.\u7ad9\u5740\u7f16\u53f7 = :\u7ad9\u5740\u7f16\u53f7"),
    @NamedQuery(name = "StationInfo.findBy\u6240\u5c5e\u673a\u623f\u5b89\u88c5\u70b9\u540d\u79f0", query = "SELECT s FROM StationInfo s WHERE s.\u6240\u5c5e\u673a\u623f\u5b89\u88c5\u70b9\u540d\u79f0 = :\u6240\u5c5e\u673a\u623f\u5b89\u88c5\u70b9\u540d\u79f0"),
    @NamedQuery(name = "StationInfo.findBy\u7ad9\u5740\u540d\u79f0", query = "SELECT s FROM StationInfo s WHERE s.\u7ad9\u5740\u540d\u79f0 = :\u7ad9\u5740\u540d\u79f0"),
    @NamedQuery(name = "StationInfo.findBy\u7f51\u5143\u53f7rpt\u91c7\u7528\u76f4\u653e\u7ad9\u7f16\u53f7", query = "SELECT s FROM StationInfo s WHERE s.\u7f51\u5143\u53f7rpt\u91c7\u7528\u76f4\u653e\u7ad9\u7f16\u53f7 = :\u7f51\u5143\u53f7rpt\u91c7\u7528\u76f4\u653e\u7ad9\u7f16\u53f7"),
    @NamedQuery(name = "StationInfo.findBy\u7f51\u5143\u540d\u79f0", query = "SELECT s FROM StationInfo s WHERE s.\u7f51\u5143\u540d\u79f0 = :\u7f51\u5143\u540d\u79f0"),
    @NamedQuery(name = "StationInfo.findBy\u7ad9\u5740\u6700\u9ad8\u7ea7\u522b\u8bbe\u5907", query = "SELECT s FROM StationInfo s WHERE s.\u7ad9\u5740\u6700\u9ad8\u7ea7\u522b\u8bbe\u5907 = :\u7ad9\u5740\u6700\u9ad8\u7ea7\u522b\u8bbe\u5907"),
    @NamedQuery(name = "StationInfo.findBy\u7ad9\u5740\u5f52\u5c5e", query = "SELECT s FROM StationInfo s WHERE s.\u7ad9\u5740\u5f52\u5c5e = :\u7ad9\u5740\u5f52\u5c5e"),
    @NamedQuery(name = "StationInfo.findBy\u52a8\u529b\u914d\u5957\u7ef4\u62a4\u65b9", query = "SELECT s FROM StationInfo s WHERE s.\u52a8\u529b\u914d\u5957\u7ef4\u62a4\u65b9 = :\u52a8\u529b\u914d\u5957\u7ef4\u62a4\u65b9"),
    @NamedQuery(name = "StationInfo.findBy\u5408\u540c\u5c5e\u6027", query = "SELECT s FROM StationInfo s WHERE s.\u5408\u540c\u5c5e\u6027 = :\u5408\u540c\u5c5e\u6027"),
    @NamedQuery(name = "StationInfo.findBy\u5408\u540c\u57fa\u7ad9\u7c7b\u522b", query = "SELECT s FROM StationInfo s WHERE s.\u5408\u540c\u57fa\u7ad9\u7c7b\u522b = :\u5408\u540c\u57fa\u7ad9\u7c7b\u522b")})
public class StationInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "station_info_id")
    private Integer stationInfoId;
    @Basic(optional = false)
    private String 所属地市;
    @Basic(optional = false)
    private String 所属网格;
    @Basic(optional = false)
    private String 所属机房安装点编号;
    @Basic(optional = false)
    private String 站址编号;
    @Basic(optional = false)
    private String 所属机房安装点名称;
    @Basic(optional = false)
    private String 站址名称;
    @Basic(optional = false)
    private String 网元号rpt采用直放站编号;
    @Basic(optional = false)
    private String 网元名称;
    @Basic(optional = false)
    private String 站址最高级别设备;
    @Basic(optional = false)
    private String 站址归属;
    @Basic(optional = false)
    private String 动力配套维护方;
    @Basic(optional = false)
    private String 合同属性;
    @Basic(optional = false)
    private String 合同基站类别;
    public StationInfo() {
    }

    public StationInfo(Integer stationInfoId) {
        this.stationInfoId = stationInfoId;
    }

    public StationInfo(Integer stationInfoId, String 所属地市, String 所属网格, String 所属机房安装点编号, String 站址编号, String 所属机房安装点名称, String 站址名称, String 网元号rpt采用直放站编号, String 网元名称, String 站址最高级别设备, String 站址归属, String 动力配套维护方, String 合同属性, String 合同基站类别) {
        this.stationInfoId = stationInfoId;
        this.所属地市 = 所属地市;
        this.所属网格 = 所属网格;
        this.所属机房安装点编号 = 所属机房安装点编号;
        this.站址编号 = 站址编号;
        this.所属机房安装点名称 = 所属机房安装点名称;
        this.站址名称 = 站址名称;
        this.网元号rpt采用直放站编号 = 网元号rpt采用直放站编号;
        this.网元名称 = 网元名称;
        this.站址最高级别设备 = 站址最高级别设备;
        this.站址归属 = 站址归属;
        this.动力配套维护方 = 动力配套维护方;
        this.合同属性 = 合同属性;
        this.合同基站类别 = 合同基站类别;
    }

    public Integer getStationInfoId() {
        return stationInfoId;
    }

    public void setStationInfoId(Integer stationInfoId) {
        this.stationInfoId = stationInfoId;
    }

    public String get所属地市() {
        return 所属地市;
    }

    public void set所属地市(String 所属地市) {
        this.所属地市 = 所属地市;
    }

    public String get所属网格() {
        return 所属网格;
    }

    public void set所属网格(String 所属网格) {
        this.所属网格 = 所属网格;
    }

    public String get所属机房安装点编号() {
        return 所属机房安装点编号;
    }

    public void set所属机房安装点编号(String 所属机房安装点编号) {
        this.所属机房安装点编号 = 所属机房安装点编号;
    }

    public String get站址编号() {
        return 站址编号;
    }

    public void set站址编号(String 站址编号) {
        this.站址编号 = 站址编号;
    }

    public String get所属机房安装点名称() {
        return 所属机房安装点名称;
    }

    public void set所属机房安装点名称(String 所属机房安装点名称) {
        this.所属机房安装点名称 = 所属机房安装点名称;
    }

    public String get站址名称() {
        return 站址名称;
    }

    public void set站址名称(String 站址名称) {
        this.站址名称 = 站址名称;
    }

    public String get网元号rpt采用直放站编号() {
        return 网元号rpt采用直放站编号;
    }

    public void set网元号rpt采用直放站编号(String 网元号rpt采用直放站编号) {
        this.网元号rpt采用直放站编号 = 网元号rpt采用直放站编号;
    }

    public String get网元名称() {
        return 网元名称;
    }

    public void set网元名称(String 网元名称) {
        this.网元名称 = 网元名称;
    }

    public String get站址最高级别设备() {
        return 站址最高级别设备;
    }

    public void set站址最高级别设备(String 站址最高级别设备) {
        this.站址最高级别设备 = 站址最高级别设备;
    }

    public String get站址归属() {
        return 站址归属;
    }

    public void set站址归属(String 站址归属) {
        this.站址归属 = 站址归属;
    }

    public String get动力配套维护方() {
        return 动力配套维护方;
    }

    public void set动力配套维护方(String 动力配套维护方) {
        this.动力配套维护方 = 动力配套维护方;
    }

    public String get合同属性() {
        return 合同属性;
    }

    public void set合同属性(String 合同属性) {
        this.合同属性 = 合同属性;
    }

    public String get合同基站类别() {
        return 合同基站类别;
    }

    public void set合同基站类别(String 合同基站类别) {
        this.合同基站类别 = 合同基站类别;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stationInfoId != null ? stationInfoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StationInfo)) {
            return false;
        }
        StationInfo other = (StationInfo) object;
        if ((this.stationInfoId == null && other.stationInfoId != null) || (this.stationInfoId != null && !this.stationInfoId.equals(other.stationInfoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jobimprove.model.StationInfo[ stationInfoId=" + stationInfoId + " ]";
    }
    
}
