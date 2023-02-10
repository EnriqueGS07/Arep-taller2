# Laboratio 2 AREP
## TALLER DISEÑO Y ESTRUCTURACIÓN DE APLICACIONES DISTRIBUIDAS EN INTERNET
- Se escribio un servidor web que soporta múlltiples solicitudes seguidas (no concurrentes). El servidor lee los archivos del disco local y retorna todos los archivos solicitados, incluyendo páginas html, archivos java script, css e imágenes. Se construyo una aplicación web con  javascript, css, e imágenes(**jpg**) para probar su servidor. Se invluyo tambien en la aplicación la comunicación asíncrona con unos servicios REST en el backend sin el uso de frameworks. 
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
- La aplicacion consta de una clase "HTTPServer"  la cual se encarga de hacer el papel de servidor web, a parte se creo una interface "Service" que la implementa diferentes clases que son servicios html, css, javascript y otro para imagenes, cada uno de estos servicios se agrega a una lista de servicios del servidor web el cual realiza las peticiones a cada uno de estos servicios y le responden con un encabezado que varia dependiendo del tipo de archivo y el cuerpo del archivo ya sea texto plano o en el caso de las imagenes en binario.
- [Maven](https://maven.apache.org/) - Dependency Management
Podemos encontrar la documentación del proyecto en la ruta 
```
/target/site/apidocts
```

### Ejecuar
Para ejecutar el servidor web escribimos el comando
```
mvn clean package exec:java -D"exec.mainClass"="edu.escuelaing.arep.app.Main"
```

### Pruebas
Se realizo la peticion al url 
```
localhost:35000/apps/pagina
```
Y arrojo el siguiente resultado


![image](https://user-images.githubusercontent.com/98104282/217971308-11415e1a-9d38-495f-85ef-f7713ff5db43.png)


Carga exitosamente el html, css y la imagen, si probamos el boton confirmamos que el metodo js que esta conectado al boton tambien funciona


![image](https://user-images.githubusercontent.com/98104282/217971375-55aaa9d3-9635-461f-8337-281a1335a9cb.png)


### Versionamiento
- Version 1.0.0
### Autores
- Enrique González Suárez


