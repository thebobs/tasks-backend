pipeline {
    agent any
    stages {
        stage ('Build backend') {
            steps {
                bat 'mvn clean package -DskipTests=tr'
            }
        }
        stage ('Unit Tests') {
            steps {
                bat 'mvn test' //nao fazemo o clean pq sernão irá apagar a pasta war gerada.
            }
        }
        stage ('Deploy Backend') {
            steps {
                deploy adapters: [tomcat8(credentialsId: 'TomcatLogin', path: '', url: 'http://localhost:8001/')], contextPath: 'tasks-backend', war: 'target/tasks-backend.war'
            }
        }
    }
}