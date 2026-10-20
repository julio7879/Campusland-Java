# Reto 1 · Feria de talleres culturales

Una casa cultural registra talleres presenciales y virtuales. Necesita evitar sobrecupos, conocer la duración de cada actividad y resumir la asistencia de cinco días. Construyan una aplicación de consola que mantenga estas reglas sin repartirlas entre variables sueltas.

**Modalidad:** trabajo grupal en casa. El docente asignará el reto, el tamaño del grupo y la fecha de entrega. Estos cinco retos son alternativas; cada grupo desarrolla el que le corresponda.

## Antes de escribir código

1. En el README del grupo, **identifiquen el problema**: ¿quién necesita la aplicación?, ¿qué dificultad tiene?, ¿qué debe resolver y qué queda fuera? Enumeren entradas, salidas y reglas que siempre deben cumplirse.
2. Identifiquen las responsabilidades y el estado de cada objeto. Propongan una base abstracta con dos variantes y una interfaz pequeña para producir fichas o reportes. Justifiquen «es un» frente a «usa». No creen herencia solo para compartir dos campos.
3. **Elaboren el diagrama UML de clases antes de programar.** Inclúyanlo en su README con Mermaid `classDiagram` o como imagen legible guardada en el repositorio. Debe mostrar clases, atributos importantes con tipos y visibilidad, métodos principales con parámetros y retornos, herencia, interfaz, relaciones de uso y la clase genérica con su parámetro de tipo. Ustedes diseñan el diagrama: no hay un UML resuelto para copiar.
4. Conserven el UML inicial en el historial Git o en una sección/archivo identificado. Al finalizar, actualicen el diagrama para que coincida con el código y expliquen brevemente los cambios, o indiquen que el diseño inicial sigue vigente.
5. Justifiquen una estructura para cada necesidad: **arreglo de cinco datos fijos**, **List tipada de objetos de cantidad variable** y **clase genérica propia**. No usen arreglos paralelos para separar los atributos de un mismo objeto.

## Condiciones de implementación

- Usen IntelliJ IDEA, JDK 21 o 17 y clases con constructor, campos privados y operaciones que protejan sus reglas. Main prepara los escenarios y muestra resultados; no debe contener toda la lógica.
- Una base abstracta y dos subclases deben expresar la variación indicada en el reto. Una interfaz de ficha o reporte debe tener al menos una implementación efectiva. Recorran objetos mediante referencias base y usen un cliente que reciba el contrato; eviten `if` para decidir qué subtipo ejecutar.
- Usen variables, decisiones, ciclos, operaciones y métodos de String. Programen contra `List<T>`, con `ArrayList<>` como opción inicial; expliquen por qué la eligen. No necesitan implementar también LinkedList.
- Diseñen una clase genérica propia, por ejemplo `Evidencia<T>`, que guarde una descripción y un contenido inicializado. Úsenla con `Integer` para el resumen numérico indicado y con `String` para una conclusión del reto; consulten y muestren ambos. Usar solo `List<Entidad>` no cumple este requisito. No usen tipos raw ni casts para mezclar tipos.
- Los IDs son obligatorios, no nulos ni en blanco. Normalicen con `strip()` y `toUpperCase(Locale.ROOT)` al registrar **y al buscar**. Rechacen IDs repetidos tras normalizar. Los nombres pueden repetirse; los IDs no se cambian después del registro. Busquen por ID con un ciclo y `equals`, sin depender de `contains` sobre objetos.
- Rechacen datos inválidos antes de agregarlos y operaciones inválidas antes de cambiar el estado. Las acciones aceptadas o rechazadas deben indicar su resultado, por ejemplo con `boolean`. Si una búsqueda no encuentra el ID, muestren `No encontrado` y no intenten usar un objeto inexistente.
- La lista vacía debe producir contadores y totales cero. Si no hay elementos para calcular un promedio, máximo o líder, indiquen `Sin datos`. No dividan entre cero. No entreguen acceso modificable a las listas o arreglos internos.
- Registren los cinco valores del arreglo en orden de días 1–5, correspondientes a índices 0–4. Cero es un dato válido. Antes de corregir o consultar una posición, comprueben su rango; rechacen posiciones inexistentes sin alterar el arreglo. Si empatan máximos, informen el **primer día**. No ordenen el arreglo: cada posición representa un día.
- Menús y Scanner son opcionales. Debe existir un Main que reproduzca las pruebas del enunciado con datos fijos. Si añaden entrada interactiva, validen los rangos; recuperar texto no numérico es opcional.
- No usen Map, Set, enum, streams, lambdas, patrones, bases de datos, archivos de persistencia, interfaces gráficas, Maven/Gradle ni dependencias externas. No se exige manejo formal de excepciones ni JUnit.

## Lo que deben construir

1. Modelen un taller con ID, nombre, capacidad, minutos de actividad e inscritos. Capacidad de 1 a 30 y actividad de 1 a 180 minutos; inscritos comienzan en cero.
2. Definan dos modalidades: presencial suma **15 minutos** de preparación a la actividad; virtual suma **5 minutos** de conexión. El cálculo debe variar mediante sobrescritura, no con un `if` por modalidad en el reporte.
3. Registren los talleres en una lista. Permitan registrar, buscar por ID y listar fichas en orden de registro. Cada ficha muestra ID, nombre, modalidad, capacidad, inscritos y duración total.
4. Permitan inscribir una cantidad positiva solo si cabe en los cupos restantes. Cancelar una cantidad positiva solo es válido si no supera los inscritos. Los rechazos conservan el número anterior; no puede ser negativo ni superar capacidad.
5. Calculen cantidad de talleres y total de inscritos actuales recorriendo la lista.
6. Guarden en un arreglo cinco asistencias diarias enteras de **0 a 200**. Calculen total, promedio decimal, máximo y primer día del máximo. Son datos históricos externos: no tienen que coincidir con los inscritos actuales de los talleres.
7. Creen las evidencias genéricas: total semanal como Integer y conclusión textual como String. No gestionen nombres de asistentes, pagos, fechas ni videollamadas.

## Escenario base obligatorio

Registren presencial `T-01`, nombre `Pintura`, capacidad 3, actividad 60; y virtual `T-02`, nombre `Fotografia`, capacidad 2, actividad 40.

| Acción en este orden | Resultado | Inscritos posteriores |
| --- | --- | --- |
| Inscribir 2 en T-01 | Aceptada | T-01: 2 |
| Inscribir otros 2 en T-01 | Rechazada | T-01: 2 |
| Inscribir 1 en T-02 | Aceptada | T-02: 1 |
| Cancelar 1 en T-01 | Aceptada | T-01: 1 |

**Resumen final:** 2 talleres, 2 inscritos en total, 1 por taller. Duraciones: T-01 **75 minutos**, T-02 **45 minutos**.

Con asistencias `[12, 8, 15, 0, 10]`: total **45**, promedio **9.0**, máximo **15**, día **3**. La evidencia numérica contiene 45.

**Pruebas adicionales:** ID duplicado ` t-01 `, inscripción cero, cancelación superior a inscritos, capacidad 0 y 31, minutos 0 y 181. En otra ejecución, llenen exactamente un taller y comprueben que un inscrito adicional se rechaza. En lista vacía: 0 talleres y 0 inscritos.

## Pruebas y entrega del grupo

1. Ejecuten el escenario base y comparen sus resultados con los de este enunciado. No mezclen las pruebas adicionales con ese escenario: usen objetos o ejecuciones nuevas.
2. Prueben al menos un caso normal, un límite exacto, un dato inválido, una operación rechazada que conserve el estado y la lista vacía. Agreguen la búsqueda de un ID inexistente y una posición fuera del arreglo.
3. Registren en el README: entradas, resultado esperado, resultado obtenido y si coincide. Expliquen un breakpoint utilizado en una regla y qué variable observaron antes y después; las capturas son opcionales.
4. Entreguen **un repositorio del grupo** con fuentes Java y README: integrantes y aportes, identificación del problema, reglas, UML inicial, decisiones de estructuras, instrucciones reales de ejecución (paquete y Main), pruebas y UML final coherente con el código.
5. Cada integrante debe poder explicar el flujo principal y una regla aunque repartan las tareas. Compartan el enlace por Campus según indique el docente. No incluyan compilados ni configuraciones personales del IDE.

Pueden elegir nombres y diseños distintos si cumplen las reglas y pueden explicarlos. El reto requiere analizar y diseñar; no hay plantilla TODO para completar.
