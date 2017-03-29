# RaspiTown WebApp


# Installation

0.Installer les librairies phidgets sur le système :

	Voir phidgets.com en fonction de l'OS
1.Installer la librairie phidget dans le repository maven :

	mvn org.apache.maven.plugins:maven-install-plugin:2.5.2:install-file "-DgroupId=com.phidgets" "-DartifactId=phidget" "-Dversion=2.1" "-Dpackaging=jar" "-Dfile=phidget21.jar"
2.Lancer le serveur :

	mvn jetty:run

