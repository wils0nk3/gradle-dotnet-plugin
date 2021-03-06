package dev.combination.dotnet

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.TaskAction
import org.gradle.api.tasks.Internal

class DotNetBuildTask extends DotNetBaseTask {
    private boolean noDependencies, noIncremental, noRestore, force
    private String projectName, configuration, framework, output, runtime, versionSuffix, configfile
    private def sources = []
    private def runtimes = []

    @Internal
    protected String[] getArgs() {
        def args = ["build"]
        if(projectName != null)
            args += projectName
        if(configuration != null)
            args += ["--configuration", configuration]
        if(configfile != null)
            args += ["--configfile", configfile]
        if(framework != null)
            args += ["--framework", framework]
        if(runtime != null)
            args += ["--runtime", runtime]
        if(output != null)
            args += ["--output", output]
        if(versionSuffix != null)
            args += ["--version-suffix", versionSuffix]
        if(noDependencies)
            args += ["--no-dependencies"]
        if(force)
            args += ["--force"]
        if(noIncremental)
            args += ["--no-incremental"]
        if(noRestore)
            args += ["--no-restore"]
        args += extraArgs
        return args
    }

    @TaskAction
    public def run() {
        exec getArgs()
    }

    public void configfile(String configfile) {
        this.configfile = configfile
    }

    public void configfile(File configfile) {
        this.configfile = configfile.absolutePath
    }

    public void project(String project) {
        this.projectName = project
    }

    public void project(File project) {
        this.projectName = project.absolutePath
    }

    public void output(String output) {
        this.output = output
    }

    public void output(File output) {
        this.output = output.absolutePath
    }

    public void configuration(String configuration) {
        this.configuration = configuration
    }

    public void framework(String framework) {
        this.framework = framework
    }

    public void force(boolean force) {
        this.force = force
    }

    public void noDependencies(boolean noDependencies) {
        this.noDependencies = noDependencies
    }

    public void noIncremental(boolean noIncremental) {
        this.noIncremental = noIncremental
    }

    public void noRestore(boolean noRestore) {
        this.noRestore = noRestore
    }

    public void versionSuffix(String versionSuffix) {
        this.versionSuffix = versionSuffix
    }
}