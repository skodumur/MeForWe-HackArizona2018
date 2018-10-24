/*Copyright (c) 2015-2016 wavemaker-com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker-com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker-com*/
package com.meforwe.meforwe.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.wavemaker.runtime.data.dao.WMGenericDao;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.DataExportOptions;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.model.Downloadable;

import com.meforwe.meforwe.Ratings;


/**
 * ServiceImpl object for domain model class Ratings.
 *
 * @see Ratings
 */
@Service("meforwe.RatingsService")
@Validated
public class RatingsServiceImpl implements RatingsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RatingsServiceImpl.class);


    @Autowired
    @Qualifier("meforwe.RatingsDao")
    private WMGenericDao<Ratings, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Ratings, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "meforweTransactionManager")
    @Override
    public Ratings create(Ratings ratings) {
        LOGGER.debug("Creating a new Ratings with information: {}", ratings);

        Ratings ratingsCreated = this.wmGenericDao.create(ratings);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(ratingsCreated);
    }

    @Transactional(readOnly = true, value = "meforweTransactionManager")
    @Override
    public Ratings getById(Integer ratingsId) {
        LOGGER.debug("Finding Ratings by id: {}", ratingsId);
        return this.wmGenericDao.findById(ratingsId);
    }

    @Transactional(readOnly = true, value = "meforweTransactionManager")
    @Override
    public Ratings findById(Integer ratingsId) {
        LOGGER.debug("Finding Ratings by id: {}", ratingsId);
        try {
            return this.wmGenericDao.findById(ratingsId);
        } catch (EntityNotFoundException ex) {
            LOGGER.debug("No Ratings found with id: {}", ratingsId, ex);
            return null;
        }
    }

    @Transactional(readOnly = true, value = "meforweTransactionManager")
    @Override
    public List<Ratings> findByMultipleIds(List<Integer> ratingsIds, boolean orderedReturn) {
        LOGGER.debug("Finding Ratings by ids: {}", ratingsIds);

        return this.wmGenericDao.findByMultipleIds(ratingsIds, orderedReturn);
    }


    @Transactional(rollbackFor = EntityNotFoundException.class, value = "meforweTransactionManager")
    @Override
    public Ratings update(Ratings ratings) {
        LOGGER.debug("Updating Ratings with information: {}", ratings);

        this.wmGenericDao.update(ratings);
        this.wmGenericDao.refresh(ratings);

        return ratings;
    }

    @Transactional(value = "meforweTransactionManager")
    @Override
    public Ratings delete(Integer ratingsId) {
        LOGGER.debug("Deleting Ratings with id: {}", ratingsId);
        Ratings deleted = this.wmGenericDao.findById(ratingsId);
        if (deleted == null) {
            LOGGER.debug("No Ratings found with id: {}", ratingsId);
            throw new EntityNotFoundException(String.valueOf(ratingsId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "meforweTransactionManager")
    @Override
    public void delete(Ratings ratings) {
        LOGGER.debug("Deleting Ratings with {}", ratings);
        this.wmGenericDao.delete(ratings);
    }

    @Transactional(readOnly = true, value = "meforweTransactionManager")
    @Override
    public Page<Ratings> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Ratings");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "meforweTransactionManager")
    @Override
    public Page<Ratings> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Ratings");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "meforweTransactionManager", timeout = 300)
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service meforwe for table Ratings to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

    @Transactional(readOnly = true, value = "meforweTransactionManager", timeout = 300)
    @Override
    public void export(DataExportOptions options, Pageable pageable, OutputStream outputStream) {
        LOGGER.debug("exporting data in the service meforwe for table Ratings to {} format", options.getExportType());
        this.wmGenericDao.export(options, pageable, outputStream);
    }

    @Transactional(readOnly = true, value = "meforweTransactionManager")
    @Override
    public long count(String query) {
        return this.wmGenericDao.count(query);
    }

    @Transactional(readOnly = true, value = "meforweTransactionManager")
    @Override
    public Page<Map<String, Object>> getAggregatedValues(AggregationInfo aggregationInfo, Pageable pageable) {
        return this.wmGenericDao.getAggregatedValues(aggregationInfo, pageable);
    }



}