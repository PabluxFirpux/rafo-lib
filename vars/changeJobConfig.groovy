def call() {
    sh "curl -X GET -u admin:admin http://localhost:8080/job/mec/api/json"
}