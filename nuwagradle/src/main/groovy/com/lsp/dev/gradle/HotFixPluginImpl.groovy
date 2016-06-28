package com.lsp.dev.gradle

import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * Nuwa gradle 插件
 */
public class HotFixPluginImpl implements Plugin<Project> {

    @Override
    void apply(Project project) {
        project.task('nuwaTestTask')<<{
            println 'Hello ,i am Nuwa Gradle'
        }

    }
}