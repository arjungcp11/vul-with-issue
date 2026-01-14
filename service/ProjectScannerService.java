
package com.hexa.vulnfix.service;

import java.nio.file.Files;
import java.nio.file.Path;

public class ProjectScannerService {

    private final PomUpdateService pomService = new PomUpdateService();

    public void scan(Path projectPath, boolean pomOnly) throws Exception {
        if (!Files.exists(projectPath)) {
            throw new IllegalArgumentException("Project path not found");
        }
        pomService.updatePom(projectPath.resolve("pom.xml"));
    }
}
