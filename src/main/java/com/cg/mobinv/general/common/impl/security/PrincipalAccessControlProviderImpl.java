package com.cg.mobinv.general.common.impl.security;

import io.oasp.module.security.common.api.accesscontrol.PrincipalAccessControlProvider;

import javax.inject.Named;

import com.cg.mobinv.general.common.api.UserProfile;

import java.util.Arrays;
import java.util.Collection;

/**
 * The implementation of {@link PrincipalAccessControlProvider} for this sample application.<br/>
 * ATTENTION:<br/>
<<<<<<< master
 * In reality you would typically receive the user-profile from the central identity-management (via LDAP) and the roles
 * (and groups) from a central access manager (that might also implement the identify-management). This design was only
 * chosen to keep our sample application simple. Otherwise one would have to start a separate external server
 * application to make everything work what would be too complicated to get things running easily.
=======
 * In reality you would typically receive the user-profile from the central identity-management (via
 * LDAP) and the roles (and groups) from a central access manager (that might also implement the
 * identify-management). This design was only chosen to keep our sample application simple.
 * Otherwise one would have to start a separate external server application to make everything work
 * what would be too complicated to get things running easily.
 *
>>>>>>> HEAD~0
 */
@Named
public class PrincipalAccessControlProviderImpl implements PrincipalAccessControlProvider<UserProfile> {

    /**
     * The constructor.
     */
    public PrincipalAccessControlProviderImpl() {

        super();
    }

    @Override
    public Collection<String> getAccessControlIds(UserProfile principal) {

        return Arrays.asList(principal.getRole().getName());
    }

}
