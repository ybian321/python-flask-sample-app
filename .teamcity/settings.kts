import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.script
import jetbrains.buildServer.configs.kotlin.v2019_2.triggers.vcs
import jetbrains.buildServer.configs.kotlin.v2019_2.buildFeatures.PullRequests
import jetbrains.buildServer.configs.kotlin.v2019_2.buildFeatures.commitStatusPublisher
import jetbrains.buildServer.configs.kotlin.v2019_2.buildFeatures.pullRequests
import jetbrains.buildServer.configs.kotlin.v2019_2.buildFeatures.dockerSupport
import jetbrains.buildServer.configs.kotlin.v2019_2.vcs.GitVcsRoot



version = "2020.4"


project {

    vcsRoot(VCSExample)


 //   buildType(DockerBuildsteve)

}

//object DockerBuildsteve : DockerBuild({
 //   name = "docker build"

//    vcs {
//        root(VCSExample)
//    }


//    repository = "13.239.84.133:8082"
//    imageName = "python-flask-sample-app"
//    tag = "v1.0.0"
//    artusername = "admin"
//    artpassword = "credentialsJSON:4365953f-8420-45b5-bebe-924c1243cd0a"

//})


object VCSExample : GitVcsRoot({
    name = "VCSExample"
    url = "https://github.com/ybian321/python-flask-sample-app.git"
    branch = "refs/heads/master"
})
