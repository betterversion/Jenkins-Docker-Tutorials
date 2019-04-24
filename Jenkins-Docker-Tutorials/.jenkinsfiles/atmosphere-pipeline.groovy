node {
    

    notify('started')
    try {
        stage 'Git Checkout'     
        git credentialsId: 'github04012019', url: 'https://github.com/betterversion/jenkins2-course-spring-boot.git'

        def project_path = "spring-boot-samples/spring-boot-sample-atmosphere"
        dir(project_path) {
            stage 'Compiling and Packaging'     
                    bat label: '', script: 'mvn clean package'
            stage'Archiving Artifacts'
                    archiveArtifacts "target/*.jar"
        }
    }

    catch (err){
        echo "Caught: ${err}"
        currentBuild.result = 'FAILURE'
    }
    
    notify('Success')
}


// reusable function to send an email
def notify(status){
    emailext (
      to: "d.zhernoviy@gmail.com",
      subject: "${status}: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'",
      body: """<p>${status}: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]':</p>
        <p>Check console output at <a href='${env.BUILD_URL}'>${env.JOB_NAME} [${env.BUILD_NUMBER}]</a></p>""",
    )
}