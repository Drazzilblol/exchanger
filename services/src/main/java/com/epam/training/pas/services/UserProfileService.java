package com.epam.training.pas.services;

import com.epam.training.pas.models.User;
import com.epam.training.pas.models.UserProfile;

import java.util.List;

/**
 * Created by Drazz on 23.11.2015.
 */
public interface UserProfileService {
    public List<UserProfile> getProfiles();

    public UserProfile getUserProfileById(Long id);

    public Long save(UserProfile userProfile);

    public void update(UserProfile userProfile);

    public int delete(Long userProfileId);
}
