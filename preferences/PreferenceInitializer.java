
package com.hexa.vulnfix.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.core.runtime.preferences.DefaultScope;
import org.osgi.service.prefs.Preferences;

public class PreferenceInitializer extends AbstractPreferenceInitializer {
    @Override
    public void initializeDefaultPreferences() {
        Preferences prefs = DefaultScope.INSTANCE.getNode("com.hexa.vulnfix");
        prefs.put("scan.project.path", "");
        prefs.putBoolean("scan.pom.only", false);
    }
}
