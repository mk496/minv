package com.cg.hkrbudgeting.general.logic.impl;

import com.cg.hkrbudgeting.general.common.api.UserProfile;
import com.cg.hkrbudgeting.general.common.api.Usermanagement;
import com.cg.hkrbudgeting.general.common.api.datatype.Role;
import com.cg.hkrbudgeting.general.common.api.to.UserDetailsClientTo;
import com.cg.hkrbudgeting.general.common.base.AbstractBeanMapperSupport;
import org.springframework.stereotype.Component;

import javax.inject.Named;

/**
 * Implementation of {@link Usermanagement}.
 */
@Named
@Component
public class UsermanagementDummyImpl extends AbstractBeanMapperSupport implements Usermanagement {

    @Override
    public UserProfile findUserProfileByLogin(String login) {

        // this is only a dummy - please replace with a real implementation
        UserDetailsClientTo profile = new UserDetailsClientTo();
        profile.setName(login);
        profile.setFirstName("Peter");
        profile.setLastName(login);
        profile.setRole(Role.CHIEF);
        return profile;
    }

}
