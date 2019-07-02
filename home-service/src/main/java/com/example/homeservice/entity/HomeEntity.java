package com.example.homeservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.Date;


@Entity
public class HomeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(hidden = true)
    private Long id;



    @Column(name = "createtime", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private Date createtime;

    private long userId;
    private String userName;
    private int temperature;
    private int humidity;
    private int heatIndex;
    private boolean lights;
    private boolean  coolingFans;
    private boolean alarms;




    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public int getHeatIndex() {
        return heatIndex;
    }

    public void setHeatIndex(int heatIndex) {
        this.heatIndex = heatIndex;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean isLights() {
        return lights;
    }

    public void setLights(boolean lights) {
        this.lights = lights;
    }

    public boolean isCoolingFans() {
        return coolingFans;
    }

    public void setCoolingFans(boolean coolingFans) {
        this.coolingFans = coolingFans;
    }

    public boolean isAlarms() {
        return alarms;
    }

    public void setAlarms(boolean alarms) {
        this.alarms = alarms;
    }
}
