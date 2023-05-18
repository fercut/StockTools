# Stock Tools

<a name="br2"></a>**Prólogo**

Con respecto a lo vivido en empresas dedicadas a la construcción, a veces los
operarios tienen la necesidad de usar determinadas herramientas poco convencionales
o algo más costosas que las simples herramientas de mano (destornilladores,
alicates….) . Por lo que se les asigna personalmente para que se hagan responsables
de las mismas.

A veces estas herramientas son marcadas con un número para inventariar o asignar
de alguna manera a los trabajadores . Esto es una tarea que suele hacerse a mano o
en un excel, sin bases de datos y posible pérdida de registros o errores por registros
duplicados o entregas no anotadas.

La ***SOLUCIÓN*** la tiene esta aplicación llamada **Stock Tools**, que consiste en poder
hacer un inventario correctamente de las herramientas que dispone la empresa y un
registro de los trabajadores que hay en ella. Todo ello con una interfaz gráfica super
intuitiva y con aspecto de acero.

Tiene avisos y alertas para evitar errores. Prácticamente es innecesario una explicación
de la misma al personal que se encargue de usarla. Pudiendo siempre modificar,
asignar o eliminar cualquier registro cómodamente usando una base de datos asociada
a la app.

Para usar correctamente la aplicación deberemos tener un gestor de bases de datos
local abierto y arrancado, ya que trabajaremos sobre una base de datos que la propia
aplicación creará de forma automática la primera vez que se inicie. Si ya está creada
simplemente se conectara.

#

<a name="br4"></a>**Función Log in y nuevo responsable:**

Solo se podrá loguear un responsable de la empresa ya que será registrado con su
nombre de usuario y contraseña en un archivo interno de la aplicación (.txt). El usuario
responsable será leído por la aplicación en dicho fichero y si es así podrá entrar en ella.

También se podrá incluir un nuevo responsable, que éste será añadido por un
responsable anterior, ya que tendrá que introducir previamente sus credenciales en el
login para poder insertar al nuevo responsable.

` `Para evitar uso malintencionado de la aplicación por parte de los operarios se podrá
eliminar a los responsables que se consideren directamente borrando su usuario y
contraseña del archivo .txt , el cual podrá tener la propiedad oculto para su dificultar la
manipulación.

#

<a name="br5"></a>**La aplicación:**

Una vez logueado el responsable, nos aparecerá un menú con diferentes botones,
algunos nos mostrarán datos de nuestro inventario en la parte derecha de nuestra
ventana (que parece vacía), disponibilidad de herramientas, herramientas asignadas y
demás. Y otros nos dirigirán a unas nuevas ventanas tipo formulario para poder hacer
funciones como asignación de herramienta, dar de alta una nueva herramienta, dar de
alta a un trabajador y algunas otras más.

#

<a name="br6"></a>**Función Herramientas:**

El botón **Herramienta** de la app nos mostrará una tabla a la derecha que contiene todo
el inventario del que dispone la empresa, ya sean herramientas asignadas o sin asignar
a un trabajador.

#

<a name="br7"></a>**Función Disponibles:**

El botón **Disponibles** de la app nos mostrará una tabla a la derecha con las herramientas del inventario que están disponibles para asignar a un trabajador.

#

<a name="br8"></a>**Función Asignadas:**

El botón **Asignadas** de la app nos mostrará una tabla a la derecha con las herramientas del inventario que están asignadas a un trabajador.

#

<a name="br9"></a>**Función Nueva Herramienta:**

El botón **Nueva Herramienta** nos abrirá una nueva ventana con un formulario para
rellenar los diferentes campos, y una vez hecho ya podremos introducir la herramienta
en el inventario pulsando el botón aceptar. Los campos de este formulario tienen unas
alertas en caso de rellenarlos de forma incorrecta, para que la inserción en la BBDD
sea correcta.

La imagen de la herramienta es para controlar el desgaste de la misma y poder saber
en qué estado se asigna y en qué estado se entrega la herramienta. Puede añadir la
ruta escribiendo o en el botón examinar podrás importar la ruta seleccionando la
imagen.

#

<a name="br10"></a>**Función Asignar Herramienta:**

El botón **Asignar Herramienta** nos abrirá una nueva ventana la cual nos indicará las
herramientas disponibles con checkBox y la lista de trabajadores de la empresa
también con checkBox. Y clicando en una herramienta, en un trabajador y dándole al
botón **ASIGNAR HERRAMIENTA** se nos asigna correctamente, con una sola
excepción, que es que a un trabajador que tiene una categoría de “Técnico” no se le
puede asignar una herramienta eléctrica por asuntos legales. Tendría que ser su oficial
quien la retirara.

En caso de que tengamos un gran inventario o una larga lista de trabajadores se
activará un scroll en cada menú para poder visualizarlos sin problemas.

#

<a name="br11"></a>**Función Desasignar Herramienta:**

El botón **Desasignar Herramienta** nos abrirá una nueva ventana la cual nos indicará
las herramientas que están asignadas y a que trabajador. En una lista muy cómoda de
leer y con unos checkBox para poder seleccionar cual quieres desasignar, con el único
pero que tiene que ser de una en una. Si pulsas varias solo desasignarias la última que
selecciones.

#

<a name="br12"></a>**Función Eliminar Herramienta:**

El botón **Eliminar Herramienta** nos abrirá una nueva ventana la cual nos indicará las
herramientas en una lista con sus correspondientes check box. Solo nos mostrará las
herramientas que no están asignadas para evitar errores y que sea un proceso de
desasignar y posteriormente eliminarla. Evitando así la posibilidad de eliminar por error
una herramienta asignada.

Solo podrás eliminar herramientas de una en una. De lo contrario, si seleccionas más
de una y pulsamos en ELIMINAR HERRAMIENTA se eliminará solo la última que has
seleccionado.

#

<a name="br13"></a>**Función Modificar Herramienta:**

El botón **Modificar Herramienta** nos abrirá una nueva ventana la cual nos indicará las
herramientas que hay en inventario con un checkbox para seleccionar la que queremos
modificar y al lado derecho un formulario para rellenar los nuevos datos que queramos
introducir. Si obviamos la ruta de la imagen, por defecto permanecerá en la BBDD la
imagen anterior.

Al seleccionar una herramienta se rellenaran los datos del formulario automáticamente,
para modificarlo de una manera más cómoda.

#

<a name="br14"></a>**Función Trabajadores:**

El botón **Trabajadores** de la app nos mostrará una tabla a la derecha que nos mostrará la lista de trabajadores que hay en la empresa.

#

<a name="br15"></a>**Función Nuevo Trabajador:**

El botón **Nuevo Trabajador** nos abrirá una nueva ventana con un formulario para
rellenar los diferentes campos, una vez hecho pulsamos el botón Aceptar y el
trabajador se añadirá a la lista de trabajadores.

#

<a name="br16"></a>**Función Eliminar Trabajador:**

El botón **Nuevo Trabajador** nos abrirá una nueva ventana que nos mostrará una lista
de todos los trabajadores con sus correspondientes check box y pulsando el botón
ELIMINAR TRABAJADOR eliminaremos el trabajador seleccionado.

Solo se podrá borrar los trabajadores de uno en uno. De lo contrario, si seleccionamos
más de uno, solo se borrará el último que has seleccionado.

#

<a name="br17"></a>**Función Modificar Trabajador:**

El botón **Modificar Trabajador** nos abrirá una nueva ventana que nos mostrará por un
lado una lista de los trabajadores con su correspondiente checkbox para poder
seleccionarlo, y por otro lado un formulario para reintroducir sus datos.

Esta función es muy útil para cambiar la categoría del trabajador o corregir algún error
de ortografía. Y al seleccionar el trabajador a modificar los campos del formulario se
rellenará automáticamente con sus datos para que sea más cómodo.

#

<a name="br18"></a>**Datos del proyecto**

En la carpeta del proyecto se incluye una carpeta “imagenes” con imágenes de
herramientas y en la carpeta “txt” que se encuentra una descripción de cada
herramienta para poder probar la aplicación con datos reales si se desea.
También en la propia carpeta StockTools donde se encuentra la carpeta src, hay un
ejecutable de Windows (.exe) llamado “Stock Tools.exe” el cual nos permite ejecutar la
aplicación sin necesidad de compilarla en un IDE. Este .exe está hecho creando un
Runnable JAR file de la clase Main y usando Launch4j.

Se ha usado continuamente github durante el proyecto desde el mismo IDE de Eclipse.
Y se puede ver en <https://github.com/fercut/StockTools>. 
