/*
 * DexWeaver - Copyright 2026 Pfuenzle
 * (GNU General Public License version 3 or later)
 *
 * DexWeaver is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published
 * by the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * DexWeaver is a fork of DexPatcher (https://github.com/DexPatcher/dexpatcher-gradle)
 * by Rodrigo Balerdi (Lanchon), which is licensed under the same terms.
 */

package io.pfuenzle.dexweaver.gradle.tasks

import groovy.transform.CompileStatic
import org.gradle.api.file.DirectoryProperty
import org.gradle.api.provider.Property
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.InputDirectory
import org.gradle.api.tasks.Optional
import org.gradle.api.tasks.PathSensitive
import org.gradle.api.tasks.PathSensitivity

@CompileStatic
class MappingCheckTask extends AbstractJavaExecTask {

    @Input @Optional final Property<String> annotationPackage = project.objects.property(String)

    @PathSensitive(PathSensitivity.RELATIVE)
    @InputDirectory final DirectoryProperty source = project.objects.directoryProperty()

    @PathSensitive(PathSensitivity.RELATIVE)
    @InputDirectory final DirectoryProperty patch = project.objects.directoryProperty()

    MappingCheckTask() {
        main = 'io.pfuenzle.dexweaver.MappingCheckMain'
    }

    @Override List<String> getArgs() {
        def args = ['--check-mappings', '--multi-dex']
        if (annotationPackage.isPresent()) args.addAll '--annotations', annotationPackage.get()
        args.addAll source.get().asFile.path, patch.get().asFile.path
        addExtraArgsTo(args)
        return args
    }

    @Override protected void beforeExec() {}

    @Override protected void afterExec() {}
}
