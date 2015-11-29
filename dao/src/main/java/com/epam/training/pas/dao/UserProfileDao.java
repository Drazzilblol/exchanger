package com.epam.training.pas.dao;

import com.epam.training.pas.models.UserProfile;

import java.util.List;

/**
 * Created by Drazz on 23.11.2015.
 */
public interface UserProfileDao {

        List<UserProfile> getProfiles();

        UserProfile getUserProfileById(int id);

        void save(UserProfile userProfile);

        void delete(int userProfileId);

}
