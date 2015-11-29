package com.epam.training.pas.dao;

import com.epam.training.pas.models.UserProfile;

import java.util.List;

/**
 * Created by Drazz on 23.11.2015.
 */
public interface UserProfileDao {

        List<UserProfile> getProfiles();

        UserProfile getUserProfileById(Long id);

        Long save(UserProfile userProfile);

        void update(UserProfile userProfile);

        int delete(Long userProfileId);

}
