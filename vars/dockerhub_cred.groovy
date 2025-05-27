def call(String Project, String ImageTag, String dockerhubuser , string credentialsId ){
  withCredentials([usernamePassword(credentialsId: '${credentialsId}', passwordVariable: 'dockerhubpass', usernameVariable: 'dockerhubuser')]) {
      sh "docker login -u ${dockerhubuser} -p ${dockerhubpass}"
  }
  sh "docker push ${dockerhubuser}/${Project}:${ImageTag}"
}
