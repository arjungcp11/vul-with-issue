
package com.hexa.vulnfix.service;

import java.nio.file.Files;
import java.nio.file.Path;

public class PomUpdateService {
    public void updatePom(Path pomPath) throws Exception {
        if (!Files.exists(pomPath)) {
            throw new RuntimeException("pom.xml not found");
        }
    }
}
