# Lab 04 · Álbum y fotografías

**Tiempo: 9 minutos.** El código está completo. Investiga, interpreta y dibuja; no cambies las clases para forzar una clasificación.

## Contexto

Las fotografías ya existen antes de crear los álbumes. Un álbum las agrupa para presentarlas y la misma fotografía puede aparecer en varios álbumes. Vaciar uno no debe alterar los originales.

## Lee y ejecuta

1. [Fotografia.java](Fotografia.java).
2. [Album.java](Album.java).
3. [S09Lab04Main.java](S09Lab04Main.java): **ejecuta este Main**.

Los nombres iniciales del programa son válidos. Las operaciones muestran cómo se acepta, rechaza o cambia un enlace. No necesitas añadir capturas ni nuevas pruebas obligatorias para este análisis.

**Qué observar:** Identifica las referencias playa y montana del Main y dónde se crean. Sigue la incorporación de playa a dos álbumes. Después de vaciar Vacaciones, comprueba qué conserva Favoritas y qué puedes consultar desde las referencias originales. No se duplican referencias de una misma foto en un mismo álbum.

**Salida esperada:**

```text
Vacaciones (2): Playa Montana
Favoritas (1): Playa
Tras vaciar Vacaciones:
Vacaciones (0):
Favoritas (1): Playa
Fotos originales: Playa, Montana
```

### Tu tarea de UML

1. Lee las clases en el orden indicado y ejecuta el Main **sin modificarlo**. Compara la salida; no tienes que programar ni completar TODO.
2. Identifica las dos clases del dominio y el campo que mantiene el enlace. El Main prepara el escenario; no hace falta incluirlo en el diagrama del dominio. No dibujes ArrayList o String como clases adicionales.
3. Diseña un diagrama UML propio de **dos clases**: nombre, atributos importantes con tipos y visibilidad, operaciones principales con parámetros y retornos, relación, multiplicidad en ambos extremos y navegabilidad cuando corresponda. Puedes usar Mermaid `classDiagram` o una imagen legible.
4. Clasifica la relación principal como **asociación, agregación o composición**. Si eliges una relación todo–parte, identifica el todo y coloca el rombo en ese extremo.
5. Escribe solo tres justificaciones breves: **¿existe un todo–parte significativo?, ¿puede compartirse la misma instancia?, ¿qué evidencia del contexto y del código sostiene tu clasificación?** Una palabra o un `new` aislado no bastan.
6. Responde la variación conceptual de abajo en una frase. No la implementes ni hagas un segundo diagrama.

Entrega este diagrama y sus respuestas en una sección del README personal o del equipo que indique el docente. Para los cinco labs basta **una investigación común inicial** con definiciones propias y el enlace de la fuente consultada.

**Pista para las multiplicidades:** ¿Cuántas fotografías permite cada álbum? ¿Cuántos álbumes pueden utilizar una misma fotografía? ¿Quién conserva una referencia en el código, Album o Fotografia?

**Variación conceptual:** El sistema cambia a imágenes internas de una ficha que no pueden reutilizarse ni obtenerse desde fuera y se crean al recibir sus datos. ¿Qué tendrías que revisar para clasificarlas?
