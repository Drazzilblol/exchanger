package com.epam.training.pas.services;

import com.epam.training.pas.models.User;
import com.epam.training.pas.models.UserProfile;

import java.util.List;

/**
 * Created by Drazz on 23.11.2015.
 */
public interface UserProfileService {
    List<UserProfile> getProfiles();

    UserProfile getUserProfileById(Long id);

    Long save(UserProfile userProfile);

    void update(UserProfile userProfile);

    int delete(Long userProfileId);
}
