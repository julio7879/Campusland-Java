# Lab 05 · Orden de trabajo y pasos

**Tiempo: 9 minutos.** El código está completo. Investiga, interpreta y dibuja; no cambies las clases para forzar una clasificación.

## Contexto

Una orden contiene sus propios pasos de trabajo; cada paso de este modelo corresponde a esa orden y no se transfiere a otra. Completar un paso de una orden no debe alterar otra orden.

## Lee y ejecuta

1. [Paso.java](Paso.java).
2. [OrdenTrabajo.java](OrdenTrabajo.java).
3. [S09Lab05Main.java](S09Lab05Main.java): **ejecuta este Main**.

Los nombres iniciales del programa son válidos. Las operaciones muestran cómo se acepta, rechaza o cambia un enlace. No necesitas añadir capturas ni nuevas pruebas obligatorias para este análisis.

**Qué observar:** Lee agregarPaso: recibe una descripción y crea un Paso. completarPaso recibe un índice, valida su rango y solicita completar al objeto. No se ofrecen métodos para insertar un Paso externo ni para obtener sus referencias. Compara ambas órdenes tras completar y tras los rechazos.

**Salida esperada:**

```text
OT-01 - pendientes: 2 [Revisar cable: pendiente] [Probar encendido: pendiente]
OT-02 - pendientes: 1 [Limpiar filtro: pendiente]
Completar indice 0: true
Repetir indice 0: false
Completar indice 8: false
OT-01 - pendientes: 1 [Revisar cable: completado] [Probar encendido: pendiente]
OT-02 - pendientes: 1 [Limpiar filtro: pendiente]
```

### Tu tarea de UML

1. Lee las clases en el orden indicado y ejecuta el Main **sin modificarlo**. Compara la salida; no tienes que programar ni completar TODO.
2. Identifica las dos clases del dominio y el campo que mantiene el enlace. El Main prepara el escenario; no hace falta incluirlo en el diagrama del dominio. No dibujes ArrayList o String como clases adicionales.
3. Diseña un diagrama UML propio de **dos clases**: nombre, atributos importantes con tipos y visibilidad, operaciones principales con parámetros y retornos, relación, multiplicidad en ambos extremos y navegabilidad cuando corresponda. Puedes usar Mermaid `classDiagram` o una imagen legible.
4. Clasifica la relación principal como **asociación, agregación o composición**. Si eliges una relación todo–parte, identifica el todo y coloca el rombo en ese extremo.
5. Escribe solo tres justificaciones breves: **¿existe un todo–parte significativo?, ¿puede compartirse la misma instancia?, ¿qué evidencia del contexto y del código sostiene tu clasificación?** Una palabra o un `new` aislado no bastan.
6. Responde la variación conceptual de abajo en una frase. No la implementes ni hagas un segundo diagrama.

Entrega este diagrama y sus respuestas en una sección del README personal o del equipo que indique el docente. Para los cinco labs basta **una investigación común inicial** con definiciones propias y el enlace de la fuente consultada.

**Pista para las multiplicidades:** ¿Puede existir una orden sin pasos? ¿Cuántas órdenes admiten simultáneamente la misma instancia de Paso según el contrato? Diferencia el estado completado del paso y el vínculo entre clases.

**Variación conceptual:** Se introduce un catálogo de tareas reutilizables que varias órdenes pueden consultar. ¿Conviene reutilizar el mismo Paso con su estado completado o separar la descripción de tarea del paso de cada orden? Explica en una frase.
