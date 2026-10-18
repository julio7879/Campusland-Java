# Documentación · Reto 4: Sistema de Pedidos de Restaurante

**Clase implementada:** `S03Reto04Restaurante.java`  
**Sesión:** 03 - Estructuras Repetitivas  
**Sector:** Gastronomía | **Nivel:** Intermedio  

---

## 1. Respuestas a las 5 Preguntas Previas ("Antes de Programar")

### 1. ¿Qué ciclo mantiene abierto el menú y cómo termina?
Se utiliza un ciclo **`do-while`**. 
* **Razón:** El menú debe mostrarse al menos una primera vez cuando el cliente llega a realizar su pedido.
* **Terminación:** Finaliza cuando el usuario ingresa la opción `5` (`Finalizar pedido`). Al elegir `5`, se rompe el ciclo (`break;`) inmediatamente sin solicitar cantidad.

### 2. ¿Cómo identificarás el precio del producto elegido?
Se utiliza una estructura **`switch (opcion)`** que asocia cada opción válida (1 al 4) con su respectivo producto y precio constante:
* Opción 1: Hamburguesa -> `$18.000`
* Opción 2: Pizza -> `$25.000`
* Opción 3: Ensalada -> `$15.000`
* Opción 4: Bebida -> `$6.000`

### 3. ¿Cómo impedirás que opción=7 o cantidad=−2 cambien el pedido?
* **Opción inválida (ej. `opcion = 7`):** Se valida al inicio con `if (opcion < 1 || opcion > 5)`. Si no existe en el menú, muestra un mensaje de error y usa `continue;` para volver a presentar el menú sin pedir cantidad ni alterar acumuladores (`subtotal` o unidades).
* **Cantidad inválida (ej. `cantidad = -2` o `<= 0`):** La lectura de la cantidad está encerrada en un bucle `do-while` que exige `cantidad <= 0`. Hasta que no se introduzca un número entero mayor que 0, el programa repite la solicitud y no registra ningún producto.

### 4. ¿Por qué debes comprobar primero el descuento mayor?
Porque las estructuras condicionales encadenadas (`if - else if`) se evalúan en orden secuencial:
* Si evaluáramos primero `if (subtotal > 100000)`, un pedido de `$180.000` entraría de forma errónea en el descuento del 10 %, ignorando el 15 % que le correspondía por superar los `$150.000`.
* Al evaluar primero `if (subtotal > 150000)` para el 15 % y luego `else if (subtotal > 100000)` para el 10 %, se respetan los rangos y los límites estrictos.

### 5. ¿Sobre qué importe calcularás el domicilio y qué efecto tiene esa elección?
* **Regla elegida:** Se calcula sobre el **importe neto** (`neto = subtotal - descuento`), cobrando `$5.000` de domicilio cuando `neto < 30000`.
* **Efecto de la elección:** 
  1. Premia el dinero real que el cliente desembolsa por los alimentos tras beneficiarse de los descuentos.
  2. En los umbrales estándar del reto, ambas opciones (`subtotal < 30000` y `neto < 30000`) dan idéntico resultado porque los descuentos inician en `$100.000`.
  3. En un caso hipotético con promociones menores (por ejemplo, subtotal `$32.000` con descuento que deje el neto en `$27.000`), calcular sobre el neto aplica el cargo de domicilio protegiendo el margen del restaurante.
  4. Si el pedido finaliza vacío (sin productos), el domicilio es estrictamente `$0`.

---

## 2. Decisiones de Diseño y Extensión Opcional

* **Manejo de dinero con `long`:** Todas las variables monetarias (`subtotal`, `descuento`, `neto`, `domicilio`, `total`, acumulados de jornada) usan tipo primitivo `long` para evitar cualquier riesgo de desbordamiento de enteros.
* **Detalle de productos en el resumen:** El programa almacena las unidades solicitadas de cada ítem (`Hamburguesa`, `Pizza`, `Ensalada`, `Bebida`) y las desglosa visualmente en el resumen final.
* **Claridad en descuentos y domicilio:** En el resumen final se especifica claramente si aplica o no aplica descuento (con su porcentaje: `15%`, `10%` o `No aplica`) y la condición de domicilio (`Gratis` o `Aplica recargo`).
* **Extensión Opcional (Jornada con Múltiples Clientes):**
  * Se implementa un ciclo exterior `while (continuarJornada)`.
  * Tras cada pedido, se consulta: `¿Desea registrar otro cliente? (1=Sí, 2=No)`.
  * Si es afirmativo (`1`), se reinicia el pedido para el nuevo cliente (`subtotal = 0`, cantidades = 0).
  * Si es negativo (`2`), finaliza la jornada y muestra el acumulado global: total de clientes atendidos, total de unidades vendidas, desglose de todos los productos vendidos durante la jornada (Hamburguesas, Pizzas, Ensaladas y Bebidas) y total de dinero recaudado.

---

## 3. Tabla de Pruebas Mínimas y Casos Borde

| Caso de Prueba | Productos seleccionados | Unidades | Subtotal ($) | Descuento ($) | Domicilio ($) | Total ($) | Observación / Comportamiento esperado |
| :--- | :--- | :---: | :---: | :---: | :---: | :---: | :--- |
| **Prueba 1** | Bebida × 1 | 1 | 6.000 | 0 (No aplica) | 5.000 | 11.000 | Neto < 30000: aplica recargo de domicilio. |
| **Prueba 2** | Ensalada × 2 | 2 | 30.000 | 0 (No aplica) | 0 | 30.000 | Umbral exacto 30000: domicilio gratis. |
| **Prueba 3** | Pizza × 4 | 4 | 100.000 | 0 (No aplica) | 0 | 100.000 | Límite exacto 100000: no recibe descuento (límite estricto). |
| **Prueba 4** | Pizza × 6 | 6 | 150.000 | 15.000 (10 %) | 0 | 135.000 | Límite exacto 150000: aplica 10 % (no 15 %). |
| **Prueba 5** | Pizza × 7 | 7 | 175.000 | 26.250 (15 %) | 0 | 148.750 | Subtotal > 150000: aplica tasa del 15 %. |
| **Prueba 6** | Hamburguesa × 4 y Pizza × 2 | 6 | 122.000 | 12.200 (10 %) | 0 | 109.800 | 72000 + 50000 = 122000. Aplica tasa del 10 %. |
| **Borde 1** | Opción 5 al comenzar | 0 | 0 | 0 (No aplica) | 0 | 0 | Pedido vacío: no cobra domicilio, todos los valores en 0. |
| **Borde 2** | Opción = 7 | — | — | — | — | — | Muestra error de menú sin alterar acumuladores. |
| **Borde 3** | Cantidad = -2 | — | — | — | — | — | Muestra error y vuelve a solicitar cantidad mayor a 0. |
| **Extensión** | Cliente 1: Bebida × 1 <br> Cliente 2: Ensalada × 2 | 3 | — | — | — | 41.000 | Registra cliente 1 ($11.000), reinicia acumuladores para cliente 2 ($30.000) y consolida la jornada ($41.000). |

---

## 4. Compilación y Ejecución

```bash
# Compilar archivo Java
javac src/01-fundamentos-java/sesion-03-estructuras-repetitivas/labs/reto-04-restaurante/S03Reto04Restaurante.java

# Ejecutar programa
java -cp src/01-fundamentos-java/sesion-03-estructuras-repetitivas/labs/reto-04-restaurante S03Reto04Restaurante
```


