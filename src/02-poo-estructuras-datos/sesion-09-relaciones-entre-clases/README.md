# Sesión 9 · Relaciones entre clases

Esta sesión es de **investigación y análisis autónomo**, sin demos de clase. Recibirás cinco programas completos: tu tarea es interpretar sus relaciones y diseñar UML, no programar nuevas funcionalidades.

## Organización de la hora

| Minutos | Actividad |
| --- | --- |
| 0–8 | Investigar asociación, agregación, composición y notación UML. |
| 8–17 | [Lab 01 · Consultor y cliente](labs/s09lab01/README.md). |
| 17–26 | [Lab 02 · Equipo y jugadores](labs/s09lab02/README.md). |
| 26–35 | [Lab 03 · Cuestionario y preguntas](labs/s09lab03/README.md). |
| 35–44 | [Lab 04 · Álbum y fotografías](labs/s09lab04/README.md). |
| 44–53 | [Lab 05 · Orden de trabajo y pasos](labs/s09lab05/README.md). |
| 53–60 | Comparar diagramas, justificar una decisión y guardar la entrega. |

El máximo en clase es **60 minutos**. Completa lo pendiente en casa según indique el docente. Puedes trabajar individualmente o en el equipo que él establezca.

## Investigación inicial: una sola vez

Consulta una fuente sobre UML y escribe, con tus palabras, una definición breve de asociación, agregación y composición. Guarda el enlace de la fuente. Investiga también multiplicidad y navegabilidad. Esta investigación se hace una vez para toda la sesión; no la repitas en cada lab.

| Pregunta | Qué debes investigar |
| --- | --- |
| ¿Solo necesita conocer o colaborar con otro objeto? | Asociación y dirección de navegación. |
| ¿Hay un conjunto que reúne partes independientes? | Agregación compartida y cuándo una asociación ordinaria basta. |
| ¿Las partes tienen pertenencia exclusiva a un todo del modelo? | Composición y ciclo de vida lógico. |
| ¿Cuántos objetos permite cada extremo? | Multiplicidad: `0..1`, `1`, `0..*`, `1..*`. |

No todas las relaciones se deducen por el nombre de una clase. Agregación y composición son formas de asociación; no hay una palabra clave Java para elegir entre ellas.

## Cómo expresar tu respuesta en UML

- Representa las dos clases del dominio con nombre, atributos y operaciones relevantes. Usa `-` para privado, `+` para público y `#` para protegido cuando corresponda. Un miembro sin modificador Java tiene acceso de paquete; si lo incluyes en UML puedes indicarlo con `~`.
- Una asociación se representa con línea continua; puedes añadir la flecha de navegabilidad hacia la clase que se puede consultar. No confundas conocer un objeto con heredar de él.
- La agregación compartida usa **rombo blanco junto al todo**; la composición, **rombo negro junto al todo**. Debes justificar que existe una relación todo–parte antes de elegir un rombo.
- En Mermaid puedes usar `-->` para asociación dirigida, `o--` para agregación y `*--` para composición. Estas notaciones son un recordatorio, no las respuestas de los labs. La herencia usa otro símbolo y no es el objeto de esta práctica.
- Escribe la multiplicidad en ambos extremos. La cifra junto a una clase indica cuántas instancias de esa clase se pueden vincular a una del extremo opuesto. Distingue los objetos de un Main de todos los que admite el modelo.

Recibir un objeto por parámetro no demuestra agregación; crearlo dentro de un método tampoco demuestra por sí solo composición. Considera los campos, las operaciones permitidas, la exclusividad y el contexto completo.

Java no destruye inmediatamente un objeto al quitar una referencia o vaciar una lista. La gestión de memoria no es la prueba de una relación UML. En una composición se describe quién administra las partes y su vigencia dentro del modelo.

## Preparación en IntelliJ IDEA

1. Actualiza el material con `git pull` y copia los cinco paquetes de `labs/` a tu proyecto personal. Usa JDK 21 o 17, sin Maven ni Gradle.
2. Si conservas la estructura del repositorio, marca **labs/** de esta sesión como **Sources Root**. Los paquetes `s09lab01` a `s09lab05` cuelgan de esa raíz, no son raíces independientes.
3. Si usas el `src` de otro proyecto, conserva rutas como `src/s09lab01/Consultor.java` y su declaración `package s09lab01;`.
4. Cada carpeta tiene un README, dos clases de dominio y un `S09LabNNMain`. Lee las clases y ejecuta el Main indicado. No necesitas completar TODO ni cambiar las salidas.

## Entrega

En tu README, o el del equipo indicado, incluye la investigación común y una sección por lab con:

1. Diagrama propio de dos clases en Mermaid `classDiagram` o imagen legible incluida en el repositorio.
2. Clasificación y tres justificaciones breves: todo–parte, posibilidad de compartir la instancia y evidencia concreta del código y del contexto.
3. Una frase que responda la variación conceptual del enunciado, sin programarla.

No se exige dibujar el Main, ArrayList ni String. El objetivo es explicar la relación del dominio, sus multiplicidades y las operaciones que la sostienen. Comparte el enlace por Campus según indique el docente.
