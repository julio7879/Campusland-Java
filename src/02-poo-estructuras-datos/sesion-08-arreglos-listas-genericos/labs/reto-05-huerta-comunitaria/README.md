# Reto 5 · Huerta comunitaria y control del riego

Una huerta necesita conocer el agua necesaria para sus parcelas y evitar que un riego deje el tanque con agua negativa. Construyan una aplicación que recalcule la necesidad cuando se retira una parcela.

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

1. Modelen una parcela con ID, nombre y **1 a 50 plantas**. Dos variantes de una base abstracta calculan la necesidad por ciclo: hortalizas **200 ml por planta** y aromáticas **100 ml por planta**. Son reglas didácticas, no recomendaciones agronómicas.
2. Registren parcelas en una lista: agregar sin ID repetido, buscar, quitar por ID y listar reportes. Cada reporte informa ID, nombre, tipo, plantas y necesidad de agua. Calculen el total recorriendo las parcelas actuales.
3. El tanque comienza con **5000 ml** y admite hasta **20000 ml**. Recargar solo acepta cantidades positivas que quepan. Validar antes de sumar evita sobrepasar el límite.
4. Regar todas las parcelas solo se acepta si hay al menos una parcela y el agua alcanza para todas. Si acepta, descuenten una sola vez la necesidad total; si rechaza, conserven el agua. No hagan riegos parciales.
5. Cada llamada representa un nuevo ciclo de riego. Se puede regar de nuevo si hay agua; no se modelan fechas ni una marca que bloquee riegos posteriores.
6. Guarden lluvia observada de cinco días en un arreglo, enteros de **0 a 200 mm**. Informen total, promedio decimal, máximo y primer día del máximo. La lluvia es informativa: no modifica automáticamente el tanque ni reduce la necesidad del riego.
7. Muestren evidencias genéricas con agua restante del escenario como Integer y conclusión textual como String. No simulen bombas, sensores ni persistencia.

## Escenario base obligatorio

Registren hortalizas `H-01`, nombre `Tomates`, **10 plantas**; y aromáticas `A-01`, nombre `Menta`, **5 plantas**. Sus necesidades son **2000 y 500 ml**: total **2500 ml**.

| Acción en este orden | Resultado | Agua posterior |
| --- | --- | --- |
| Primer riego de todas | Aceptado | 2500 ml |
| Segundo riego de todas | Aceptado | 0 ml |
| Tercer riego de todas | Rechazado | 0 ml |
| Recargar 1000 | Aceptada | 1000 ml |
| Recargar 20000 | Rechazada | 1000 ml |
| Quitar H-01 | Aceptada | 1000 ml; necesidad baja a 500 ml |
| Regar las parcelas actuales | Aceptado | 500 ml |

**Resumen final:** una parcela, necesidad **500 ml**, tanque **500 ml**. La evidencia numérica contiene 500.

Con lluvia `[0, 5, 2, 0, 3]`: total **10 mm**, promedio **2.0 mm**, máximo **5 mm**, día **2**.

**Pruebas adicionales:** plantas 0 y 51 rechazadas; 1 y 50 aceptadas en ejecuciones separadas; ID duplicado normalizado; recarga cero o negativa rechazada. Con lista vacía, necesidad cero y riego rechazado, conservando el tanque inicial de 5000. Prueben completar el tanque hasta 20000 exactamente y rechazar un mililitro adicional.

## Pruebas y entrega del grupo

1. Ejecuten el escenario base y comparen sus resultados con los de este enunciado. No mezclen las pruebas adicionales con ese escenario: usen objetos o ejecuciones nuevas.
2. Prueben al menos un caso normal, un límite exacto, un dato inválido, una operación rechazada que conserve el estado y la lista vacía. Agreguen la búsqueda de un ID inexistente y una posición fuera del arreglo.
3. Registren en el README: entradas, resultado esperado, resultado obtenido y si coincide. Expliquen un breakpoint utilizado en una regla y qué variable observaron antes y después; las capturas son opcionales.
4. Entreguen **un repositorio del grupo** con fuentes Java y README: integrantes y aportes, identificación del problema, reglas, UML inicial, decisiones de estructuras, instrucciones reales de ejecución (paquete y Main), pruebas y UML final coherente con el código.
5. Cada integrante debe poder explicar el flujo principal y una regla aunque repartan las tareas. Compartan el enlace por Campus según indique el docente. No incluyan compilados ni configuraciones personales del IDE.

Pueden elegir nombres y diseños distintos si cumplen las reglas y pueden explicarlos. El reto requiere analizar y diseñar; no hay plantilla TODO para completar.
