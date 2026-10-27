/*
 * DexPatcher - Copyright 2015-2020 Rodrigo Balerdi
 * (GNU General Public License version 3 or later)
 *
 * DexPatcher is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published
 * by the Free Software Foundation, either version 3 of the License,
 * or (at your option) any later version.
 */

package io.pfuenzle.dexweaver.gradle.plugins

import groovy.transform.CompileStatic

import io.pfuenzle.dexweaver.gradle.helpers.AndroidPluginHelperInitializer
import io.pfuenzle.dexweaver.gradle.extensions.PatchLibraryExtension

import com.android.build.gradle.LibraryExtension
import com.android.build.gradle.LibraryPlugin
import com.android.build.gradle.api.LibraryVariant
import org.gradle.api.Project

import static io.pfuenzle.dexweaver.gradle.Constants.*

@CompileStatic
class PatchLibraryPlugin extends AbstractPatcherPlugin<PatchLibraryExtension, LibraryExtension, LibraryVariant> {

    @Override
    void apply(Project project) {

        super.apply(project)

        extension = (PatchLibraryExtension) basePlugin.createSubextension(ExtensionNames.PLUGIN_PATCH_LIBRARY,
                PatchLibraryExtension)
        project.plugins.apply(LibraryPlugin)
        AndroidPluginHelperInitializer.init()
        androidExtension = project.extensions.getByType(LibraryExtension)
        androidVariants = androidExtension.libraryVariants

        afterApply()

    }

/*
    @Override
    protected void afterApply() {

        super.afterApply()

    }
*/

}
