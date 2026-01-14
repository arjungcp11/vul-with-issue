
package com.hexa.vulnfix.controller;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.osgi.service.prefs.Preferences;

import com.hexa.vulnfix.service.ProjectScannerService;

public class UploadController {

    private final ProjectScannerService scanner = new ProjectScannerService();

    public void scanProject() {
        Preferences prefs = InstanceScope.INSTANCE.getNode("com.hexa.vulnfix");
        String path = prefs.get("scan.project.path", "");
        boolean pomOnly = prefs.getBoolean("scan.pom.only", false);

        Job job = new Job("Vulnerability Scan") {
            @Override
            protected IStatus run(IProgressMonitor monitor) {
                try {
                    scanner.scan(Paths.get(path), pomOnly);
                    return Status.OK_STATUS;
                } catch (Exception e) {
                    return new Status(IStatus.ERROR, "com.hexa.vulnfix", e.getMessage(), e);
                }
            }
        };
        job.setUser(true);
        job.schedule();
    }
}
