package lk.ijse.metropolitan.dto;

import java.time.LocalDate;

public class RAYPAppDTO {
    private String rId;
    private String cId;
    private String appEmp;
    private LocalDate callDate;
    private LocalDate repairDate;
    private String desc;

    public RAYPAppDTO(String rId, String cId, String appEmp, LocalDate callDate, LocalDate repairDate, String desc) {
        this.rId = rId;
        this.cId = cId;
        this.appEmp = appEmp;
        this.callDate = callDate;
        this.repairDate = repairDate;
        this.desc = desc;
    }

    public RAYPAppDTO() {
    }

    public String getrId() {
        return rId;
    }

    public void setrId(String rId) {
        this.rId = rId;
    }

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }

    public String getAppEmp() {
        return appEmp;
    }

    public void setAppEmp(String appEmp) {
        this.appEmp = appEmp;
    }

    public LocalDate getCallDate() {
        return callDate;
    }

    public void setCallDate(LocalDate callDate) {
        this.callDate = callDate;
    }

    public LocalDate getRepairDate() {
        return repairDate;
    }

    public void setRepairDate(LocalDate repairDate) {
        this.repairDate = repairDate;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "RAYPAppDTO{" +
                "rId='" + rId + '\'' +
                ", cId='" + cId + '\'' +
                ", appEmp='" + appEmp + '\'' +
                ", callDate=" + callDate +
                ", repairDate=" + repairDate +
                ", desc='" + desc + '\'' +
                '}';
    }
}
