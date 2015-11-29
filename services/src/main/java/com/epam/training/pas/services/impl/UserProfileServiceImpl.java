package com.epam.training.pas.services.impl;

import com.epam.training.pas.dao.UserProfileDao;
import com.epam.training.pas.models.UserProfile;
import com.epam.training.pas.services.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Drazz on 23.11.2015.
 */
public class UserProfileServiceImpl implements UserProfileService {
    @Autowired
    private UserProfileDao userProfileDao;

    @Override
    public List<UserProfile> getProfiles() {
        return userProfileDao.getProfiles();
    }

    @Override
    public UserProfile getUserProfileById(int id) {
        return userProfileDao.getUserProfileById(id);
    }

    @Override
    public void save(UserProfile userProfile) {

        userProfileDao.save(userProfile);
    }

    @Override
    public void delete(int userProfileId) {
        userProfileDao.delete(userProfileId);

    }
}
