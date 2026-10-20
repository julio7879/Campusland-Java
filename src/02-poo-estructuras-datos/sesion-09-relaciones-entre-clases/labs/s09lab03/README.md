# Lab 03 · Cuestionario y preguntas

**Tiempo: 9 minutos.** El código está completo. Investiga, interpreta y dibuja; no cambies las clases para forzar una clasificación.

## Contexto

Las preguntas registradas son entradas propias de cada cuestionario. Se agregan mediante texto y no se transfieren entradas entre cuestionarios. Dos preguntas con el mismo texto pueden ser entradas distintas.

## Lee y ejecuta

1. [Pregunta.java](Pregunta.java).
2. [Cuestionario.java](Cuestionario.java).
3. [S09Lab03Main.java](S09Lab03Main.java): **ejecuta este Main**.

Los nombres iniciales del programa son válidos. Las operaciones muestran cómo se acepta, rechaza o cambia un enlace. No necesitas añadir capturas ni nuevas pruebas obligatorias para este análisis.

**Qué observar:** Observa qué recibe agregarPregunta, dónde aparece new Pregunta y qué permite obtener resumen. Nadie recibe la lista interna ni sus objetos. Después de vaciar, revisa los conteos de ambos cuestionarios; no interpretes clear como una orden de destruir memoria.

**Salida esperada:**

```text
Java (2): [Que hace main?] [Para que sirve private?]
Git (1): [Que hace git pull?]
Agregar texto en blanco: false
Cantidad Java: 2
Tras vaciar Java:
Java (0):
Git (1): [Que hace git pull?]
```

### Tu tarea de UML

1. Lee las clases en el orden indicado y ejecuta el Main **sin modificarlo**. Compara la salida; no tienes que programar ni completar TODO.
2. Identifica las dos clases del dominio y el campo que mantiene el enlace. El Main prepara el escenario; no hace falta incluirlo en el diagrama del dominio. No dibujes ArrayList o String como clases adicionales.
3. Diseña un diagrama UML propio de **dos clases**: nombre, atributos importantes con tipos y visibilidad, operaciones principales con parámetros y retornos, relación, multiplicidad en ambos extremos y navegabilidad cuando corresponda. Puedes usar Mermaid `classDiagram` o una imagen legible.
4. Clasifica la relación principal como **asociación, agregación o composición**. Si eliges una relación todo–parte, identifica el todo y coloca el rombo en ese extremo.
5. Escribe solo tres justificaciones breves: **¿existe un todo–parte significativo?, ¿puede compartirse la misma instancia?, ¿qué evidencia del contexto y del código sostiene tu clasificación?** Una palabra o un `new` aislado no bastan.
6. Responde la variación conceptual de abajo en una frase. No la implementes ni hagas un segundo diagrama.

Entrega este diagrama y sus respuestas en una sección del README personal o del equipo que indique el docente. Para los cinco labs basta **una investigación común inicial** con definiciones propias y el enlace de la fuente consultada.

**Pista para las multiplicidades:** Distingue la clase Pregunta de cada instancia creada dentro del modelo. Para las entradas de estos cuestionarios, ¿cuántos cuestionarios pueden utilizar simultáneamente la misma instancia? ¿Está permitido un cuestionario vacío?

**Variación conceptual:** Ahora existe un banco externo de preguntas reutilizables y los cuestionarios reciben esas referencias. ¿Qué decisión de propiedad o relación habría que reconsiderar?
