# Reto 2 · Jornadas de adopción de un refugio

Un refugio necesita distinguir animales disponibles de los ya adoptados y estimar el tiempo de cuidado de quienes siguen allí. Construyan una aplicación que conserve el historial y evite registrar dos adopciones del mismo animal.

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

1. Modelen un animal de refugio con ID, nombre, edad de **0 a 240 meses** y disponibilidad inicial verdadera.
2. Representen perros y gatos como variantes de una base abstracta. Minutos diarios de cuidado: perro **30**, más **10** si tiene menos de 12 meses; gato **20**, más **5** si tiene menos de 12. A los 12 exactos no se añade tiempo. Son reglas del ejercicio, no orientación veterinaria.
3. Mantengan una lista que permita registrar, buscar por ID, adoptar y listar fichas. La adopción solo se acepta si el animal está disponible; repetirla se rechaza sin cambiar el registro.
4. Conserven al animal adoptado en la lista para el historial. No implementen devolución ni eliminen animales al adoptar. La ficha informa ID, nombre, especie, edad, disponibilidad y minutos de cuidado.
5. Calculen registrados, disponibles, adoptados y minutos diarios de cuidado **solo de los disponibles**.
6. Guarden visitantes de cinco jornadas en un arreglo, de **0 a 100** por día. Informen total, promedio decimal, máximo y primer día del máximo. Las visitas no equivalen a adopciones.
7. Muestren evidencias genéricas con número de adoptados como Integer y conclusión textual como String. No registren datos personales de adoptantes ni expedientes médicos.

## Escenario base obligatorio

Registren perro `P-01`, nombre `Luna`, 6 meses; y gato `G-01`, nombre `Milo`, 18 meses. Requieren **40** y **20 minutos** diarios, respectivamente.

| Acción en este orden | Resultado | Estado posterior de P-01 |
| --- | --- | --- |
| Adoptar P-01 | Aceptada | No disponible |
| Adoptar nuevamente P-01 | Rechazada | No disponible |

**Resumen final:** 2 registrados, 1 disponible, 1 adoptado, **20 minutos** de cuidado de los disponibles. La evidencia numérica contiene 1.

Con visitantes `[5, 0, 8, 8, 4]`: total **25**, promedio **5.0**, máximo **8**, día **3**, porque se elige el primer empate.

**Pruebas adicionales:** ID duplicado con espacios y minúsculas, nombre en blanco, edad -1 y 241. En ejecuciones separadas, prueben ambas especies con 11 y 12 meses: perro **40/30**, gato **25/20** minutos. Con lista vacía, todos los contadores y el tiempo total son cero; tras adoptar a todos, el tiempo de cuidado de disponibles también es cero.

## Pruebas y entrega del grupo

1. Ejecuten el escenario base y comparen sus resultados con los de este enunciado. No mezclen las pruebas adicionales con ese escenario: usen objetos o ejecuciones nuevas.
2. Prueben al menos un caso normal, un límite exacto, un dato inválido, una operación rechazada que conserve el estado y la lista vacía. Agreguen la búsqueda de un ID inexistente y una posición fuera del arreglo.
3. Registren en el README: entradas, resultado esperado, resultado obtenido y si coincide. Expliquen un breakpoint utilizado en una regla y qué variable observaron antes y después; las capturas son opcionales.
4. Entreguen **un repositorio del grupo** con fuentes Java y README: integrantes y aportes, identificación del problema, reglas, UML inicial, decisiones de estructuras, instrucciones reales de ejecución (paquete y Main), pruebas y UML final coherente con el código.
5. Cada integrante debe poder explicar el flujo principal y una regla aunque repartan las tareas. Compartan el enlace por Campus según indique el docente. No incluyan compilados ni configuraciones personales del IDE.

Pueden elegir nombres y diseños distintos si cumplen las reglas y pueden explicarlos. El reto requiere analizar y diseñar; no hay plantilla TODO para completar.
