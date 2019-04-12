package com.cg.mobinv.general.logic.impl;

import org.springframework.stereotype.Component;

import com.cg.mobinv.general.common.api.UserProfile;
import com.cg.mobinv.general.common.api.Usermanagement;
import com.cg.mobinv.general.common.api.datatype.Role;
import com.cg.mobinv.general.common.api.to.UserDetailsClientTo;
import com.cg.mobinv.general.common.base.AbstractBeanMapperSupport;

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
