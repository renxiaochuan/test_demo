mvn install:install-file -DgroupId=com.neusoft.iam -DartifactId=iam-client -Dversion=1.0 -Dpackaging=jar -Dfile=iam-client.jar
mvn install:install-file -DgroupId=com.neusoft.iam -DartifactId=unieap-core -Dversion=1.0 -Dpackaging=jar -Dfile=unieap-core.jar
mvn install:install-file -DgroupId=com.neusoft.iam -DartifactId=unieap-security -Dversion=1.0 -Dpackaging=jar -Dfile=unieap-security.jar

mvn install:install-file -DgroupId=com.neusoft.datavize -DartifactId=dataviz-system -Dversion=1.0 -Dpackaging=jar -Dfile=dataviz-system.jar
mvn install:install-file -DgroupId=com.neusoft.datavize -DartifactId=dataviz-common -Dversion=1.0 -Dpackaging=jar -Dfile=dataviz-common.jar