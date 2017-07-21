package org.xcolab.entity.utils;

import org.json.JSONObject;

import org.xcolab.client.admin.AdminClient;
import org.xcolab.client.admin.pojo.ConfigurationAttribute;
import org.xcolab.util.attributes.AttributeGetter;
import org.xcolab.util.i18n.I18nUtils;

import java.util.ArrayList;
import java.util.List;

public abstract class WidgetPreference {

    private final static String DEFAULT_ID = "default";
    private final static String PREFERENCES_JSON_OBJECT = "preferences";
    private final static String UNDERSCOREDIVIDER = "_";
    private final List<String> allPreferenceIds = new ArrayList<>();
    protected String preferenceId;
    protected String language;


    protected JSONObject prefs;

    public WidgetPreference() {
        this(DEFAULT_ID, I18nUtils.DEFAULT_LANGUAGE);
    }

    public WidgetPreference(String id, String language) {

        if(id==null){
            id = DEFAULT_ID;
        }
        if (language != null) {
            id += UNDERSCOREDIVIDER + language;
        }

        prefs = new JSONObject(getConfigurationAttribute().get());

        if (prefs.has(PREFERENCES_JSON_OBJECT)) {

            JSONObject preferencesArray = prefs.getJSONObject(PREFERENCES_JSON_OBJECT);
            //preferencesArray.keySet().stream().forEach(s -> allPreferenceIds.add(s));
            for (int i = 0; i < preferencesArray.names().length(); i++) {
                allPreferenceIds.add(preferencesArray.names().get(i).toString());
            }

            if (id != null) {
                preferenceId = id;
            } else {
                preferenceId = UNDERSCOREDIVIDER + language;
                //allPreferenceIds.add(DEFAULT_ID);
            }
            if (preferencesArray.has(preferenceId)) {
                prefs = preferencesArray.getJSONObject(preferenceId);
            } else {
                prefs = preferencesArray.getJSONObject(DEFAULT_ID);
                preferenceId = DEFAULT_ID + UNDERSCOREDIVIDER + language;
            }

        } else {
            allPreferenceIds.add(DEFAULT_ID);
            preferenceId = DEFAULT_ID;
        }
    }


    public abstract AttributeGetter<String> getConfigurationAttribute();

    protected void savePreferences(JSONObject prefsToSave, String id) {
        id = (id == null ? (DEFAULT_ID) : (id));
        JSONObject currentPreferences = new JSONObject(getConfigurationAttribute().get());
        if (!currentPreferences.has(PREFERENCES_JSON_OBJECT)) {
            JSONObject defaultPrefs = currentPreferences;

            currentPreferences = new JSONObject();
            JSONObject preferences = new JSONObject();
            preferences.put(id, prefsToSave);
            if (!id.equals(DEFAULT_ID)) {
                preferences.put(DEFAULT_ID, defaultPrefs);
            }

            currentPreferences.put(PREFERENCES_JSON_OBJECT, preferences);

        } else {

            JSONObject preferences = currentPreferences.getJSONObject(PREFERENCES_JSON_OBJECT);

            preferences.put(id, prefsToSave);
            currentPreferences.put(PREFERENCES_JSON_OBJECT, preferences);
        }
        ConfigurationAttribute configurationAttribute = new ConfigurationAttribute();
        configurationAttribute.setName(getConfigurationAttribute().name());
        configurationAttribute.setStringValue(currentPreferences.toString());
        AdminClient.updateConfigurationAttribute(configurationAttribute);
    }

    public String getPreferenceId() {
        return preferenceId;
    }

    public void setPreferenceId(String preferenceId) {
        this.preferenceId = preferenceId;
    }

    public JSONObject getPrefs() {
        return prefs;
    }

    public void setPrefs(JSONObject prefs) {
        this.prefs = prefs;
    }

    public List<String> getAllPreferenceIds() {
        return allPreferenceIds;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

}
