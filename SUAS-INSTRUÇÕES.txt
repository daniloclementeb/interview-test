# leitorLogCorrida

Para executar é necessário uma maquina com jdk instalado e configurado a variavel de ambiente JAVA_HOME
clone o projeto
entre na pasta do projeto e via linha de comando digite o comando: .\gradlew.bat bootJar
será compilado o projeto
o resultado da compilação poderá ser visualizado na pasta: \interview-test\build\libs
abra a linha de comando e execute: java -jar interview-test.jar
Após a inicialização acesse a url http://localhost:8080/logDir
essa tela irá lhe informar o diretório onde deverá ser inserido o arquivo de log
o arquivo deve se chamar arquivo.log
acesse a url http://localhost:8080/execute para receber o JSON com o resultado do exercicio solicitado
**Importante: é necessário que o arquivo.log esteja no local indicado**