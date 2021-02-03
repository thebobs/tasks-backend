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
        stage ('API Test') {
            steps {
                dir('api-test') {
        // serve para colocar os resultados num diretório específico
                    git credentialsId: 'githublogin', url: 'https://github.com/thebobs/tasks-api-test'
                    bat 'mvn test'
                } 
            }
        }
        stage ('Deploy Frontend') {
            steps {
                dir('frontend') {
        // serve para colocar os resultados num diretório específico
                    git credentialsId: 'githublogin', url: 'https://github.com/thebobs/tasks-frontend'
                    bat 'mvn clean package'
                    deploy adapters: [tomcat8(credentialsId: 'TomcatLogin', path: '', url: 'http://localhost:8001/')], contextPath: 'tasks-backend', war: 'target/tasks.war'
                } 
            }
        }
    }
}