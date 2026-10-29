# Informe de Laboratorios · Sesión 10: Set, Map, Enum y Excepciones

Este documento consolida las comprobaciones, tablas de pruebas, análisis de comportamiento y respuestas conceptuales de los cuatro laboratorios de la sesión 10.

---

## 1. Lab 00 · Materiales pendientes (`Set`)

### Contexto y Análisis
La clase `MaterialesTaller` gestiona dos colecciones `LinkedHashSet<String>`: `requeridos` y `disponibles`. `LinkedHashSet` garantiza unicidad de elementos respetando el orden de inserción. Los valores son normalizados (espacios externos eliminados y convertidos a mayúsculas con `Locale.ROOT`).

### Pregunta Conceptual (Paso 3)
> *Explica en una frase por qué modificar el conjunto original perdería información para futuras consultas.*

**Respuesta:** Si el método `faltantes()` aplicara `removeAll(disponibles)` directamente sobre el conjunto `requeridos` en vez de sobre una copia defensiva, se eliminarían definitivamente los materiales ya conseguidos, perdiendo el registro histórico de cuáles eran todos los insumos que el taller necesitaba originalmente.

### Comprobaciones y Pruebas Registradas
| Entrada / Operación | Estado Requeridos | Estado Disponibles | Salida / Retorno Esperado | Salida Obtenida | Resultado |
|---|---|---|---|---|---|
| Requerir `"CARTULINA"`, `"PEGAMENTO"`, `"TIJERAS"` | `[CARTULINA, PEGAMENTO, TIJERAS]` | `[]` | `true` en cada uno | `true`, `true`, `true` | Correcto |
| Disponer `"cartulina"`, `"REGLA"` | `[CARTULINA, PEGAMENTO, TIJERAS]` | `[CARTULINA, REGLA]` | `true`, `true` | `true`, `true` | Correcto |
| `taller.faltantes()` inicial | 3 elementos | 2 elementos | `[PEGAMENTO, TIJERAS]` | `[PEGAMENTO, TIJERAS]` | Correcto |
| Disponer `"PEGAMENTO"` | 3 elementos | 3 elementos | `true` | `true` | Correcto |
| `taller.faltantes()` tras disponer pegamento | 3 elementos | 3 elementos | `[TIJERAS]` | `[TIJERAS]` | Correcto |
| Disponer `" cartulina "` (duplicado) | 3 elementos | 3 elementos | `false` | `false` | Correcto |
| Disponer `null` | 3 elementos | 3 elementos | `false` (no altera colección) | `false` | Correcto |
| Disponer `"   "` (cadena en blanco) | 3 elementos | 3 elementos | `false` (no altera colección) | `false` | Correcto |
| Disponer `"TIJERAS"` | 3 elementos | 4 elementos | `true`; Faltantes: `[]` | `true`; `[]` | Correcto |

---

## 2. Lab 01 · Recuento de votos (`Map`)

### Contexto y Análisis
La clase `RecuentoVotos` utiliza un `TreeMap<String, Integer>`, inicializado con las opciones `"A"`, `"B"` y `"C"` con contador en 0. `TreeMap` organiza las claves según su orden natural alfabético independientemente del orden en que se emitan los votos.

### Pregunta Conceptual (Paso 2)
> *Explica por qué put debe reemplazar el contador en este caso.*

**Respuesta:** En la interfaz `Map`, cada clave es única; por tanto, `votos.put(opcion, votos.get(opcion) + 1)` reemplaza el valor asociado a la clave con el nuevo total acumulado sin duplicar la opción en la estructura.

### Comprobaciones y Pruebas Registradas
| Secuencia de Entradas | Explicación del Escenario | Reporte Esperado | Total Esperado | Reporte y Total Obtenidos | Resultado |
|---|---|---|---|---|---|
| `{"A", "B", "A", "C", "B", "A"}` | Secuencia del escenario inicial | `{A=3, B=2, C=1}` | `6` | `{A=3, B=2, C=1}`, Total: 6 | Correcto |
| Voto `"X"` (opción no válida) | Opción ausente en claves iniciales | `false` (rechazado) | `6` (conservado) | `false`, Total: 6 | Correcto |
| `{"C", "A", "B", "A", "B", "A"}` | Mismos votos en orden de llegada distinto | `{A=3, B=2, C=1}` | `6` | `{A=3, B=2, C=1}`, Total: 6 (TreeMap ordena por clave) | Correcto |
| `{}` (secuencia vacía) | Sin votos emitidos | `{A=0, B=0, C=0}` | `0` | `{A=0, B=0, C=0}`, Total: 0 | Correcto |
| Voto `" a "` (con espacios y minúscula) | Normalización a mayúscula y strip | `true` (incrementa A) | `1` | `true`, A=1 | Correcto |
| Voto `null` | Entrada nula | `false` | Inalterado | `false`, inalterado | Correcto |

---

## 3. Lab 02 · Prioridad de incidencias (`Enum`)

### Contexto y Análisis
El tipo enumerado `Prioridad` asocia a cada constante (`BAJA`, `MEDIA`, `ALTA`) un límite de tiempo inmutable (`120`, `60`, `15` minutos). La clase `Incidencia` evalúa si el tiempo transcurrido supera el límite asignado para dictaminar vencimiento.

### Pregunta Conceptual (Paso 3)
> *Explica por qué ALTA con 15 minutos no está vencida y con 16 sí. Identifica el operador que expresa esa diferencia.*

**Respuesta:** No está vencida con 15 minutos porque la regla del dominio define que una incidencia solo vence cuando el tiempo transcurrido supera estrictamente el límite fijado; el operador que expresa esta distinción en el método `estaVencida()` es el operador relacional mayor que estricto `>` (`minutosTranscurridos > prioridad.getLimiteMinutos()`).

### Comprobaciones y Pruebas Registradas
| Prioridad | Límite Máximo | Minutos Registrados | ¿Está Vencida? Esperado | ¿Está Vencida? Obtenido | Observaciones |
|---|---|---|---|---|---|
| `ALTA` | 15 min | 15 min | `false` | `false` | En el límite exacto no está vencida |
| `ALTA` | 15 min | 16 min | `true` | `true` | Supera estrictamente el límite |
| `MEDIA` | 60 min | 45 min | `false` | `false` | Dentro del plazo |
| `MEDIA` | 60 min | 60 min | `false` | `false` | En el límite exacto no está vencida |
| `MEDIA` | 60 min | 61 min | `true` | `true` | Supera el límite de 60 minutos |
| `BAJA` | 120 min | 120 min | `false` | `false` | En el límite exacto no está vencida |
| `BAJA` | 120 min | 121 min | `true` | `true` | Vencida por superar 120 minutos |
| `BAJA` | 120 min | -1 min | `false` (rechazo) | `false` (retorno); conserva 121 min (`vencida=true`) | Los minutos negativos se rechazan y no mutan el estado |

---

## 4. Lab 03 · Carga de mediciones (`Excepciones`)

### Contexto y Análisis
`RegistroTemperaturas` procesa cadenas de texto y las convierte en enteros para calcular estadísticas. Implementa control de excepciones específico mediante `try` y `catch (NumberFormatException error)` para garantizar resiliencia: los errores de formato no abortan la ejecución del programa ni corrompen las lecturas válidas previas. Las temperaturas válidas deben ubicarse en el intervalo `[-10, 50]` inclusive.

### Pregunta Conceptual (Paso 6)
> *Responde en una frase qué diferencia hay entre un error de conversión y un rechazo de rango.*

**Respuesta:** Un error de conversión representa una incompatibilidad sintáctica a nivel de tipo de dato capturada mediante una excepción (`NumberFormatException` al no ser un entero válido), mientras que un rechazo de rango es una validación lógica de regla de negocio sobre un número entero sintácticamente válido cuyo valor cuantitativo se sitúa fuera de los límites permitidos `[-10, 50]`.

### Comprobaciones y Pruebas Registradas
| Caso / Lote de Entradas | Clasificación de Cada Entrada | Lecturas Aceptadas | Cantidad Aceptadas | Cantidad Rechazadas | Promedio Obtenido |
|---|---|---|---|---|---|
| `{"20", "abc", " 25 ", "80", "", "-10"}` (Escenario Inicial) | - `"20"`: válida (20)<br>- `"abc"`: error conversión<br>- `" 25 "`: válida (25)<br>- `"80"`: fuera de rango (>50)<br>- `""`: dato obligatorio ausente<br>- `"-10"`: válida (-10) | `[20, 25, -10]` | 3 | 3 | `11.6667`<br>`((20+25-10)/3 = 11.6667)` |
| `{"abc", "", "80"}` (Solo inválidas) | - `"abc"`: no es entero<br>- `""`: dato obligatorio<br>- `"80"`: fuera de rango | `[]` | 0 | 3 | `Sin datos`<br>(Evita división por cero) |
| `{"-10", "50"}` (Límites extremos válidos) | - `"-10"`: límite inferior válido<br>- `"50"`: límite superior válido | `[-10, 50]` | 2 | 0 | `20.0000`<br>`((-10+50)/2 = 20.0000)` |
