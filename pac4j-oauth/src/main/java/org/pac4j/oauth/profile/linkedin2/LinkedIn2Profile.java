/*
  Copyright 2012 - 2015 pac4j organization

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */
package org.pac4j.oauth.profile.linkedin2;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.pac4j.core.profile.AttributesDefinition;
import org.pac4j.oauth.profile.OAuth20Profile;

/**
 * <p>This class is the user profile for LinkedIn with appropriate getters.</p>
 * <p>It is returned by the {@link org.pac4j.oauth.client.LinkedIn2Client}.</p>
 *
 * @author Jerome Leleu
 * @since 1.4.1
 */
@SuppressWarnings("unchecked")
public class LinkedIn2Profile extends OAuth20Profile {
    
    private static final long serialVersionUID = -2652388591255880018L;
    
    public String getOAuth10Id() {
        String url = getSiteStandardProfileRequest();
        return StringUtils.substringBetween(url, "id=", "&authType=");
    }

    private transient final static AttributesDefinition ATTRIBUTES_DEFINITION = new LinkedIn2AttributesDefinition();

    @Override
    public AttributesDefinition getAttributesDefinition() {
        return ATTRIBUTES_DEFINITION;
    }
    
    @Override
    public String getFirstName() {
        return (String) getAttribute(LinkedIn2AttributesDefinition.FIRST_NAME);
    }
    
    @Override
    public String getFamilyName() {
        return (String) getAttribute(LinkedIn2AttributesDefinition.LAST_NAME);
    }
    
    @Override
    public String getDisplayName() {
        return (String) getAttribute(LinkedIn2AttributesDefinition.FORMATTED_NAME);
    }
    
    @Override
    public String getLocation() {
        LinkedIn2Location location = (LinkedIn2Location) getAttribute(LinkedIn2AttributesDefinition.LOCATION);
        if (location != null) {
            return location.getName();
        } else {
            return null;
        }
    }
    
    @Override
    public String getEmail() {
        return (String) getAttribute(LinkedIn2AttributesDefinition.EMAIL_ADDRESS);
    }
    
    @Override
    public String getPictureUrl() {
        return (String) getAttribute(LinkedIn2AttributesDefinition.PICTURE_URL);
    }
    
    @Override
    public String getProfileUrl() {
        return (String) getAttribute(LinkedIn2AttributesDefinition.PUBLIC_PROFILE_URL);
    }
    
    public LinkedIn2Location getCompleteLocation() {
        return (LinkedIn2Location) getAttribute(LinkedIn2AttributesDefinition.LOCATION);
    }
    
    public String getMaidenName() {
        return (String) getAttribute(LinkedIn2AttributesDefinition.MAIDEN_NAME);
    }

    public String getPhoneticFirstName() { return (String) getAttribute(LinkedIn2AttributesDefinition.PHONETIC_FIRST_NAME); }

    public String getPhoneticLastName() { return (String) getAttribute(LinkedIn2AttributesDefinition.PHONETIC_LAST_NAME); }

    public String getFormattedPhoneticName() { return (String) getAttribute(LinkedIn2AttributesDefinition.FORMATTED_PHONETIC_NAME); }

    public String getHeadline() {
        return (String) getAttribute(LinkedIn2AttributesDefinition.HEADLINE);
    }
    
    public String getIndustry() {
        return (String) getAttribute(LinkedIn2AttributesDefinition.INDUSTRY);
    }

    public String getCurrentShare() {
        return (String) getAttribute(LinkedIn2AttributesDefinition.CURRENT_SHARE);
    }
    
    public Integer getNumConnections() {
        return (Integer) getAttribute(LinkedIn2AttributesDefinition.NUM_CONNECTIONS);
    }

    public Boolean getNumConnectionsCapped() {
        return (Boolean) getAttribute(LinkedIn2AttributesDefinition.NUM_CONNECTIONS_CAPPED);
    }
    
    public String getSummary() {
        return (String) getAttribute(LinkedIn2AttributesDefinition.SUMMARY);
    }
    
    public String getSpecialties() {
        return (String) getAttribute(LinkedIn2AttributesDefinition.SPECIALTIES);
    }
    
    public List<LinkedIn2Position> getPositions() {
        return (List<LinkedIn2Position>) getAttribute(LinkedIn2AttributesDefinition.POSITIONS);
    }
    
    public String getSiteStandardProfileRequest() {
        return (String) getAttribute(LinkedIn2AttributesDefinition.SITE_STANDARD_PROFILE_REQUEST);
    }

    public String getApiStandardProfileRequest() {
        return (String) getAttribute(LinkedIn2AttributesDefinition.API_STANDARD_PROFILE_REQUEST);
    }
}
