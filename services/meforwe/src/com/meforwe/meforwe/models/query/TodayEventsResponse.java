/*Copyright (c) 2015-2016 wavemaker-com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker-com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker-com*/
package com.meforwe.meforwe.models.query;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import com.wavemaker.runtime.data.annotations.ColumnAlias;

public class TodayEventsResponse implements Serializable {


    @ColumnAlias("ID")
    private Integer id;

    @ColumnAlias("EVENT_NAME")
    private String eventName;

    @ColumnAlias("ORG_ID")
    private Integer orgId;

    @ColumnAlias("ZIP_CODE")
    private Integer zipCode;

    @ColumnAlias("EVENT_DATE")
    private LocalDateTime eventDate;

    @ColumnAlias("ADDRESS")
    private String address;

    @ColumnAlias("PHONE")
    private String phone;

    @ColumnAlias("EVENT_DESC")
    private String eventDesc;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEventName() {
        return this.eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Integer getOrgId() {
        return this.orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public Integer getZipCode() {
        return this.zipCode;
    }

    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }

    public LocalDateTime getEventDate() {
        return this.eventDate;
    }

    public void setEventDate(LocalDateTime eventDate) {
        this.eventDate = eventDate;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEventDesc() {
        return this.eventDesc;
    }

    public void setEventDesc(String eventDesc) {
        this.eventDesc = eventDesc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TodayEventsResponse)) return false;
        final TodayEventsResponse todayEventsResponse = (TodayEventsResponse) o;
        return Objects.equals(getId(), todayEventsResponse.getId()) &&
                Objects.equals(getEventName(), todayEventsResponse.getEventName()) &&
                Objects.equals(getOrgId(), todayEventsResponse.getOrgId()) &&
                Objects.equals(getZipCode(), todayEventsResponse.getZipCode()) &&
                Objects.equals(getEventDate(), todayEventsResponse.getEventDate()) &&
                Objects.equals(getAddress(), todayEventsResponse.getAddress()) &&
                Objects.equals(getPhone(), todayEventsResponse.getPhone()) &&
                Objects.equals(getEventDesc(), todayEventsResponse.getEventDesc());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(),
                getEventName(),
                getOrgId(),
                getZipCode(),
                getEventDate(),
                getAddress(),
                getPhone(),
                getEventDesc());
    }
}