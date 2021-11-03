# Proyecto de Samancito Delivery
## Problema
Ante el auge de los servicios de entregas originado por la cuarentena, un grupo de estudiantes de la Unimet decidió crear una aplicación de delivery. Sin embargo, la competencia contra otras aplicaciones como “Pedidos Ya” y “Yummy” es muy dura.
Los emprendedores unimetanos vieron una oportunidad de mercado al percatarse que los algoritmos de estas empresas son sumamente ineficientes. Gracias a su conocimiento sistémico decidieron contratarlos a ustedes, especialistas en grafos, para generar un sistema que calcule la ruta más corta entre distintos puntos para optimizar los tiempos de entrega y reducir los gastos de gasolina. La naturaleza del problema se puede representar a través de un grafo ponderado y dirigido.
Requerimientos funcionales
### 1.  General
a. Cargar archivo: El usuario puede seleccionar a través de JFileChooser un archivo samancito.txt para ser cargado en el sistema, el cual contará con la información necesaria para la creación del grafo,  es decir: restaurantes, platos, clientes, pedidos y caminos. Cuando el usuario cargue un nuevo archivo, el sistema debe enviar un mensaje de alerta indicando al usuario la necesidad de guardar los datos actualmente cargados en memoria. La estructura del archivo de datos (archivo de texto plano) se indicará posteriormente.
b. Actualizar repositorio:  Esta función permitirá que la información cargada en memoria, referente a los clientes, locales y sus menús. Es decir, los cambios realizados a cualquiera de estos deben de actualizarse en el archivo texto de tal forma que cuando se vuelva a cargar ese archivo contenga  todos los cambios realizados. Al iniciarse el programa por primera vez debe cargarse el archivo de texto dado al final del enunciado (debe de mantener el mismo formato).
c. Mostrar grafo: El sistema deberá mostrar una representación visual del grafo según la información contenida en la memoria, es decir, los caminos disponibles entre los restaurantes y la información de estos.
d. Recorrer grafo: Con el fin de conocer todos los nodos que forman parte del grafo, se podrá seleccionar esta opción, la cual mostrará todos los nodos del grafo mediante el recorrido de anchura (BFS) y el recorrido de profundidad (DFS).
e. Seleccionar rol de usuario: En la ventana inicial del sistema se debe poder seleccionar el rol del usuario, en este caso se contemplarán 3 roles: 
  - Cliente: Pueden registrarse en el sistema y seleccionar el local donde desean hacer su pedido, junto con los platos que quieran del mismo. 
  - Driver: Pueden visualizar las órdenes que han realizado los clientes y el sistema les debe mostrar la ruta ideal para el despacho.  
  - Administrador: Encargado de añadir locales y caminos en el sistema, con sus  respectivos menús. 
### 2. Cliente
a. Nuevo cliente:  Para el registro se solicitan los siguientes datos: nombre, apellido, cédula, dirección. Para la dirección debe seleccionar dos nodos, indicando sus respectivas distancias (elección del usuario). 
b. Ordenar: A la hora de realizar una orden, el usuario deberá seleccionar el número de cliente correspondiente y el restaurante en el cual desea ordenar. Posteriormente se mostrará el menú y se procederá a seleccionar los platos deseados y la cantidad de los mismos. Finalmente, al confirmar toda la información el pedido se añadirá a la lista de entregas pendientes.
### 3. Driver
a. Realizar entrega: Al seleccionar la opción de driver, el usuario podrá realizar la entrega. Esta opción debe mostrar la lista de pedidos pendientes; el driver seleccionará el pedido que desea entregar y se generará la ruta más corta para que el driver despache la orden. Para calcular la ruta más corta se emplearán los algoritmos de Dijkstra y Floyd-Warshall.
### 4. Administrador
a. Agregar nuevos locales al sistema: Al ingresar como administrador al sistema, se podrán agregar nuevas empresas que utilizarán los servicios de Samancito Delivery. Dicha empresa debe tener su respectivo menú, es decir, una lista de platos. Además, los locales deben anexarse al grafo seleccionando dos nodos y agregando sus respectivas distancias.
b. Agregar nuevo camino: El administrador podrá hacer más caminos en el grafo, para esto debe seleccionar los nodos que serán unidos y el tamaño de la arista que los conecta.
c. Agregar platos: Un usuario con el rol de administrador será capaz de agregar nuevos platillos al menú de un restaurante, para esto seleccionará el restaurante y escribirá el nombre del nuevo plato
d. Eliminar platos: Luego de realizar un estudio de mercado, los locales pueden decidir eliminar un platillo de su menú por las pocas ganancias que genera al establecimiento.

## Requerimientos técnicos
a. La solución debe ser implementada con base en un grafo, que a su vez puede ser implementado mediante una matriz de adyacencia o una lista de adyacencia.
b. Puede utilizar cualquier otra estructura auxiliar de ser necesario. Sin embargo, NO podrá utilizar librerías para la implementación de las estructuras de datos, solo podrá utilizar librerías para lo relativo a la representación gráfica del grafo.
c. El programa debe poder representar el grafo correspondiente de manera gráfica. 
d. La aplicación debe ofrecer una interfaz gráfica al usuario.
e. El programa debe poder cargar un archivo de texto para la lectura de datos. Para ello, es requerido el uso del componente JFileChooser.
f. Debe documentar el proyecto con Javadoc.
g. Junto al programa, cada equipo deberá presentar un Diagrama de clases (arquitectura detallada) que explique la solución obtenida.  
