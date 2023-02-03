# Laboratio 1 AREP
## APLICACIONES DISTRIBUIDAS (HTTP, SOCKETS, HTML, JS,MAVEN, GIT)
- Se construyó una aplicación para consultar la información de películas de cine.  La aplicación recibe una frase de búsqueda del título, por ejemplo “Guardians of the galaxy” y muestra el los datos de la película correspondiente en formato JSON. Para esto se utilizo el API gratuito de https://www.omdbapi.com/. Se realizó implementación eficiente en cuanto a recursos con un caché integrado que permite evitar hacer consultas repetidas al API externo.

## Iniciando
### Prerrequisitos
- GIT
- Meaven
- Compilador de codigo java
### Instalando
Abrimos la consola en la ruta que deseamos tener el proyecto
Clonamos el repositorio 
Y entramos a la carpeta raiz del proyecto
```
git clone https://github.com/EnriqueGS07/arep-lab1.git
cd /arep-lab1
```
Verificamos que la aplicación compile correctamente con el siguiente comando
```
mvn package
```
### Corriendo las pruebas
Desde la consola en la raiz del proyecto ponemos el comando
```
mvn test
```
![image](https://user-images.githubusercontent.com/98104282/216484967-beddca11-88e3-4cd5-af65-0e2ea1ab403a.png)
### Construcción:
- La aplicación esta programada de forma que se puede agregar en un futuro alguna ootra api que se quiera consultar, se uso modulación por capas, el HTTP server se encarga de ser un servidor web y ser la parte de la aplicación que usa el cliente, la clase "Buscador" se encarga de conectarse directamente con la api de peliculas y la clase HTTPcontection se encarga de establecer un socket y una conexoón por medio de http a alguna api
- [Maven](https://maven.apache.org/) - Dependency Management
Podemos encontrar la documentación del proyecto en la ruta 
```
/target/site/apidocts
```

### Arquitectura de la aplicación
![image](https://user-images.githubusercontent.com/98104282/216489244-396923f9-17cb-4edc-8c00-e3ea4fbe17c1.png)


### Versionamiento
- Version 1.0.0
### Autores
- Enrique González Suárez
### Ejecuar
Para ejecutar el servidor web escribimos el comando
```
mvn exec:java
```

