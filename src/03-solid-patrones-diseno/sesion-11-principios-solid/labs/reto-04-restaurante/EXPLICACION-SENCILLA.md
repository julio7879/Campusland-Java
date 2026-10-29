# Explicación Sencilla de los Cambios (Sin tecnicismos)

Este documento explica de forma clara y directa por qué se cambió el código del restaurante al aplicar **Programación Orientada a Objetos (POO)** y **SOLID**, comparando el "Antes" con el "Después".

---

## 1. El Problema: ¿Cómo estaba antes?

Antes todo el restaurante funcionaba dentro de un **único archivo gigante** (`main` de 230 líneas). 
Ese archivo hacía absolutamente todo a la vez:
1. Mostraba el texto en pantalla.
2. Leía lo que el usuario escribía con el teclado.
3. Guardaba las cantidades de comida.
4. Calculaba las matemáticas de los descuentos y el domicilio.
5. Imprimía el recibo final.

### La analogía del restaurante real:
Era como tener a **una sola persona** que al mismo tiempo atiende las mesas, cocina las pizzas, cobra en la caja registradora, hace los envíos en moto y limpia el local. Si esa persona se equivoca en una cosa, arruina todo el restaurante.

---

## 2. El Cambio: ¿Cómo quedó organizado ahora?

Dividimos el trabajo en **roles y especialistas**, igual que en un negocio real:

| Especialista (Clase) | ¿Qué hace en palabras sencillas? |
| :--- | :--- |
| **`Producto` (El Menú)** | Una lista oficial con los nombres y precios (Hamburguesa, Pizza, etc.). Si cambia un precio, solo se modifica aquí. |
| **`Pedido` (La Comanda)** | La hoja de papel donde se anota qué pidió el cliente y cuántas unidades. Solo guarda comida, no sabe de plata ni de cobros. |
| **`DescuentoPorVolumen` (La Promoción)** | El encargado de aplicar la rebaja del 10% o 15% según el monto. |
| **`ReglaDomicilio` (El Domiciliario)** | Decide si el envío vale $5.000 o si sale gratis (compras mayores a $30.000). |
| **`CalculadoraCuenta` (La Caja)** | Toma la comanda (`Pedido`), consulta la rebaja y el domicilio, y genera la cuenta final. |
| **`ConsolaRestaurante` (El Mesero)** | Es quien habla con el cliente por pantalla: muestra el menú, pide las opciones y entrega el recibo impreso. |

---

## 3. ¿Por qué es mucho mejor ahora? (Los 3 grandes motivos)

### 1. Si cambias algo, no rompes lo demás
* **Antes:** Si querías cambiar el texto del menú o corregir un mensaje, corrías el riesgo de borrar sin querer una fórmula matemática y cobrar mal.
* **Ahora:** Si quieres cambiar cómo se ve la pantalla, solo tocas al "Mesero" (`ConsolaRestaurante`). Las matemáticas de la "Caja" ni se enteran y siguen funcionando perfecto.

### 2. Cambiar o agregar promociones es fácil
* **Antes:** Para inventar una promoción nueva (ejemplo: "descuento de fin de semana"), tocaba abrir el archivo principal y modificar un montón de `if/else` enredados.
* **Ahora:** Se crea una nueva regla de promoción aparte y se le entrega a la caja. No hay que reescribir ni tocar el resto del sistema.

### 3. Es fácil de probar
* **Antes:** Para verificar si el descuento de $150.000 funcionaba bien, tenías que arrancar el programa, teclear a mano opción por opción en la consola y hacer la prueba como un usuario.
* **Ahora:** Como el cálculo está separado de la pantalla, podemos probar matemáticamente las cuentas en 1 segundo mediante código sin tener que escribir nada en el teclado.

---

## En resumen
Pasamos de un **"código todero"** donde todo estaba mezclado y cualquier cambio daba miedo, a un **equipo organizado de especialistas**, donde cada parte hace una sola tarea y la hace bien.
