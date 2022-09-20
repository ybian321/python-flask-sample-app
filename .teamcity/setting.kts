import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.projectFeatures.buildReportTab
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.script
import jetbrains.buildServer.configs.kotlin.v2019_2.triggers.vcs
import jetbrains.buildServer.configs.kotlin.v2019_2.buildFeatures.PullRequests
import jetbrains.buildServer.configs.kotlin.v2019_2.buildFeatures.commitStatusPublisher
import jetbrains.buildServer.configs.kotlin.v2019_2.buildFeatures.pullRequests
import jetbrains.buildServer.configs.kotlin.v2019_2.vcs.GitVcsRoot

/*
The settings script is an entry point for defining a TeamCity
project hierarchy. The script should contain a single call to the
project() function with a Project instance or an init function as
an argument.

VcsRoots, BuildTypes, Templates, and subprojects can be
registered inside the project using the vcsRoot(), buildType(),
template(), and subProject() methods respectively.

To debug settings scripts in command-line, run the

    mvnDebug org.jetbrains.teamcity:teamcity-configs-maven-plugin:generate

command and attach your debugger to the port 8000.

To debug in IntelliJ Idea, open the 'Maven Projects' tool window (View
-> Tool Windows -> Maven Projects), find the generate task node
(Plugins -> teamcity-configs -> teamcity-configs:generate), the
'Debug' option is available in the context menu for the task.
*/

version = "2020.2"

project {
    description = "Contains all other projects"

    params {
        // This makes it impossible to change the build settings through the UI
        param("teamcity.ui.settings.readOnly", "true")
    }

    vcsRoot(VCSExample)
    buildType(RunBuild)
}

object RunBuild : BuildType({
    name = "RunBuild"

    vcs {
        root(VCSExample)
        cleanCheckout = true
    }

    steps {
        script {
            name = "Hello TeamCity"
            scriptContent = """
                echo "hello teamcity! I'm a build"
            """.trimIndent()
        }
    }

    triggers {
        vcs {
            branchFilter = """
               +:<default>
            """.trimIndent()
        }
    }
})

object VCSExample : GitVcsRoot({
    name = "python-blog"
    url = "https://github.com/ybian321/python-flask-sample-app.git"
    branch = "refs/heads/master"
    authMethod = password {
        userName = "ybian321"
        password = "zxx764b715656c4a90db45f46eaac1bc2a0"
    }
})
