package com.example.homeservice.home;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;


@Entity
public class Home {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(hidden = true)
    private Long id;

    @NotNull
    // @Size(min = 5, max = 20, message = "terminalId must be between 5 and 10 characters long")
    private String roomName;

    @Column(name = "createtime", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private Date createtime;

    @NotNull
//    @Pattern(regexp = "\\d+\\.\\d+")
    private int temperature;

    @NotNull
    private int humidity;

    @NotNull
    private int heatIndex;

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

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
}
