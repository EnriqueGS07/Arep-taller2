# Laboratio 2 AREP
## TALLER DISEÑO Y ESTRUCTURACIÓN DE APLICACIONES DISTRIBUIDAS EN INTERNET
- Escriba un servidor web que soporte múlltiples solicitudes seguidas (no concurrentes). El servidor debe leer los archivos del disco local y retornar todos los archivos solicitados, incluyendo páginas html, archivos java script, css e imágenes. Construya una aplicación web con  javascript, css, e imágenes para probar su servidor. Incluya en la aplicación la comunicación asíncrona con unos servicios REST en el backend. NO use frameworks web como Spark o Spring, use solo Java y las librerías para manejo de la red.

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
git clone https://github.com/EnriqueGS07/Arep-taller2.git
cd /Arep-taller2
```
Verificamos que la aplicación compile correctamente con el siguiente comando
```
mvn package
```


### Construcción:
- .
- [Maven](https://maven.apache.org/) - Dependency Management
Podemos encontrar la documentación del proyecto en la ruta 
```
/target/site/apidocts
```

### Arquitectura de la aplicación



### Versionamiento
- Version 1.0.0
### Autores
- Enrique González Suárez
### Ejecuar
Para ejecutar el servidor web escribimos el comando
```
mvn clean package exec:java -D"exec.mainClass"="edu.escuelaing.arep.app.Main"
```

