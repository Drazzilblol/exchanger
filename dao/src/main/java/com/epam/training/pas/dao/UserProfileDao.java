package com.epam.training.pas.dao;

import com.epam.training.pas.models.UserProfile;

import java.util.List;

/**
 * Created by Drazz on 23.11.2015.
 */
public interface UserProfileDao {

        List<UserProfile> getUserProfileList();

        UserProfile getUserProfileById(int id);

        int save(UserProfile userProfile);

        void delete(UserProfile userProfile);

        void delete(int userProfileId);

}
