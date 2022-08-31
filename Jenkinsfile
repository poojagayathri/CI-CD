//pipeline for ec2 + ecr
pipeline {
    agent any
    environment {
        AWS_ACCOUNT_ID="712525545119"
        AWS_DEFAULT_REGION="us-east-1" 
        IMAGE_REPO_NAME="sportyshoesecr"
        IMAGE_TAG="latest"
        REPOSITORY_URI = "${AWS_ACCOUNT_ID}.dkr.ecr.${AWS_DEFAULT_REGION}.amazonaws.com/${IMAGE_REPO_NAME}"
    }
   
    stages {
        
         stage('Logging into AWS ECR') {
            steps {
                script {
                sh "aws ecr get-login-password --region ${AWS_DEFAULT_REGION} | docker login --username AWS --password-stdin ${AWS_ACCOUNT_ID}.dkr.ecr.${AWS_DEFAULT_REGION}.amazonaws.com"
                }
                 
            }
        }
        
        stage('Cloning Git') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: '', url: 'https://github.com/poojagayathri/CI-CD.git']]])     
            }
        }
         stage('Compile and Clean') { 
            steps {
                script {
                // Run Maven on a Unix agent.
                echo "mvn -version"
                sh "mvn -version"
              
                sh "mvn clean compile"
                }
            }
        }
        stage('deploy') { 
            
            steps {
                script {
                sh "mvn package"
                }
            }
        }
  
  
    // Building Docker images
    stage('Building image') {
      steps{
        script {
          //dockerImage = docker build -t . "${IMAGE_REPO_NAME}:${IMAGE_TAG}"
          sh "docker build -t ${IMAGE_REPO_NAME}:${IMAGE_TAG} ."
        }
      }
    }
   
    // Uploading Docker images into AWS ECR
    stage('Pushing to ECR') {
     steps{  
         script {
                sh "docker tag ${IMAGE_REPO_NAME}:${IMAGE_TAG} ${REPOSITORY_URI}:$IMAGE_TAG"
                sh "docker push ${AWS_ACCOUNT_ID}.dkr.ecr.${AWS_DEFAULT_REGION}.amazonaws.com/${IMAGE_REPO_NAME}:${IMAGE_TAG}"
         }
        }
      }
    }
}


//pipeline for ec2 + docker hub registry
pipeline {
    agent any
   
    stages {
        
        stage('Cloning Git') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: '', url: 'https://github.com/poojagayathri/CI-CD.git']]])     
            }
        }
         stage('Compile and Clean') { 
            steps {
                script {
                // Run Maven on a Unix agent.
                echo "mvn -version"
                sh "mvn -version"
              
                sh "mvn clean compile"
                }
            }
        }
        stage('deploy') { 
            
            steps {
                script {
                sh "mvn package"
                }
            }
        }
  
  
    // Building Docker images
    stage('Building image') {
      steps{
        script {
          //dockerImage = docker build -t . "${IMAGE_REPO_NAME}:${IMAGE_TAG}"
          sh "docker build -t poojapv/pipe:latest ."
        }
      }
    }
   
   // Building Docker images
    stage('Docker Login') {
      steps{
        script {
          sh "docker login -u poojapv -p !Poojaarathi300"
        }
      }
    }
    
     stage('Docker Push') {
      steps{
        script {
          sh "docker push poojapv/pipe:latest"
        }
      }
    }
    
    stage('Docker Deploy') {
      steps{
        script {
          sh "docker run -p 8092:8092 poojapv/pipe:latest"
        }
      }
    }
   
   
    }
}

//install Maven
sudo wget http://repos.fedorapeople.org/repos/dchen/apache-maven/epel-apache-maven.repo -O /etc/yum.repos.d/epel-apache-maven.repo
sudo sed -i s/\$releasever/6/g /etc/yum.repos.d/epel-apache-maven.repo
sudo yum install -y apache-maven
mvn –version
