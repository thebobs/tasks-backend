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
    }
}