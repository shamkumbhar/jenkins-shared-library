def call(String project, String imageTag, String dockerhubUser, String credentialsId) {
    withCredentials([usernamePassword(credentialsId: credentialsId, passwordVariable: 'dockerhubPass', usernameVariable: 'dockerhubUser')]) {
        sh "docker login -u ${dockerhubUser} -p ${dockerhubPass}"
    }
    sh "docker push ${dockerhubUser}/${project}:${imageTag}"
}
