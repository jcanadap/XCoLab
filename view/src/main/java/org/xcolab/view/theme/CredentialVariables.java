package org.xcolab.view.theme;

import org.xcolab.client.admin.attributes.configuration.ConfigurationAttributeKey;

public class CredentialVariables {
    private final String googleAnalyticsKey;
    private final String pingdomRumId;
    private final String typekitId;
    private final String typekitIdLocal;

    public CredentialVariables() {
        this.googleAnalyticsKey = ConfigurationAttributeKey.GOOGLE_ANALYTICS_KEY.get();
        this.pingdomRumId = ConfigurationAttributeKey.PINGDOM_RUM_ID.get();
        this.typekitId = ConfigurationAttributeKey.TYPEKIT_KIT_ID.get();
        this.typekitIdLocal = ConfigurationAttributeKey.TYPEKIT_KIT_ID_LOCALHOST.get();
    }

    public String getGoogleAnalyticsKey() {
        return googleAnalyticsKey;
    }

    public String getPingdomRumId() {
        return pingdomRumId;
    }

    public String getTypekitId() {
        return typekitId;
    }

    public String getTypekitIdLocal() {
        return typekitIdLocal;
    }
}
