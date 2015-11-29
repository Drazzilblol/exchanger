package com.epam.training.pas.services.impl;

import com.epam.training.pas.dao.UserProfileDao;
import com.epam.training.pas.models.UserProfile;
import com.epam.training.pas.services.UserProfileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Drazz on 23.11.2015.
 */
@Service
public class UserProfileServiceImpl implements UserProfileService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserProfileServiceImpl.class);

    @Autowired
    private UserProfileDao userProfileDao;

    @Override
    public List<UserProfile> getProfiles() {
        return userProfileDao.getProfiles();
    }

    @Override
    public UserProfile getUserProfileById(Long id) {
        return userProfileDao.getUserProfileById(id);
    }

    @Override
    public Long save(UserProfile userProfile) {
        LOGGER.info("Save profile {} {}", userProfile.getFirstName(), userProfile.getLastName());
        return userProfileDao.save(userProfile);
    }

    @Override
    public void update(UserProfile userProfile) {
        LOGGER.info("Update profile {} {}", userProfile.getFirstName(), userProfile.getLastName());
        userProfileDao.update(userProfile);
    }

    @Override
    public int delete(Long userProfileId) {
        LOGGER.info("Delete profile with id = {}", userProfileId);
        return userProfileDao.delete(userProfileId);
    }
}
