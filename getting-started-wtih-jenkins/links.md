Link to these links:
https://git.io/vKSVZ

Module 1:
- Run jenkins from war file: `jenkins -jar jenkins.war`
- Run jenkins from docker: 
```sh
docker run -d \
           --restart unless-stopped \
           --name jenkins \
           -v /your/home:/var/jenkins_home \
           -p 8080:8080 \
           -p 50000:50000 \
           jenkins
```

Module 2:

- https://github.com/g0t4/jenkins2-course-spring-boot
- What am I config.xml: https://gist.github.com/g0t4/12d888d0ce9e40b79d8454dabdad7033

Module 3:

- On Windows:
  - use the `bat` step type instead of `sh`
  - or, install the powershell plugin: https://wiki.jenkins-ci.org/display/JENKINS/PowerShell+Plugin
  - use `\\` instead of `/` in paths inside of strings in the script, though we don't use any of these in this course
  - for cleaning, instead of `rm -rf *` use `del /S /Q *` to delete all files, folders will remain but that's fine (this is used in Module 4)
- https://github.com/g0t4/jenkins2-course-spring-petclinic
- Notify function:
```groovy
def notify(status){
    emailext (
      to: "you@gmail.com",
      subject: "${status}: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'",
      body: """<p>${status}: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]':</p>
        <p>Check console output at <a href='${env.BUILD_URL}'>${env.JOB_NAME} [${env.BUILD_NUMBER}]</a></p>""",
    )
}
```
- Start mailhog with docker: 
```bash
docker run -d \
           --restart unless-stopped \
           --name mailhog \
           -p 1025:1025 \
           -p 8025:8025 \
           mailhog/mailhog
```

Module 4:

- https://github.com/jenkinsci/pipeline-plugin/blob/master/COMPATIBILITY.md

Module 5:

- https://github.com/g0t4/solitaire-systemjs-course/tree/jenkins2-course
- Pipeline starting point: https://gist.github.com/g0t4/fbae18da660f35fb1377505df347417d
- Pipeline ending point in Jenkinsfile: https://github.com/g0t4/solitaire-systemjs-course/blob/jenkins2-course-jf/Jenkinsfile
  - If you are using windows, please refer to this sample for equivalent commands to use on windows in the comments

Cleanup:
- Remove jenkins data directory: `rm -rf ~/.jenkins` (or back it up if you want)
- `docker ps` to see running containers, `docker ps -a` to see stopped containers too
- `docker rm -fv NAME` to remove container (NAME is whatever you passed to docker run's --name argument)

Links
- https://jenkins.io
- https://go.cloudbees.com/docs/cloudbees-documentation/cookbook/ch01.html#ch01__hardware_recommendations
