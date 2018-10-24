/*Copyright (c) 2015-2016 wavemaker-com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker-com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker-com*/
package com.meforwe.meforwe;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * OrgLocations generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`ORG_LOCATIONS`")
public class OrgLocations implements Serializable {

    private Integer orgId;
    private Integer zipCode;
    private String address;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`ORG_ID`", nullable = false, scale = 0, precision = 10)
    public Integer getOrgId() {
        return this.orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    @Column(name = "`ZIP_CODE`", nullable = true, scale = 0, precision = 10)
    public Integer getZipCode() {
        return this.zipCode;
    }

    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }

    @Column(name = "`ADDRESS`", nullable = true, length = 1000)
    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrgLocations)) return false;
        final OrgLocations orgLocations = (OrgLocations) o;
        return Objects.equals(getOrgId(), orgLocations.getOrgId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOrgId());
    }
}