# Laboratorios de la sesión 6

Tienes **55 minutos para tres labs y 5 minutos de revisión**. Completa lo pendiente en casa para la siguiente clase. Cada problema pide proteger una regla mediante métodos; poner `private` sin validar los cambios no es suficiente.

## Antes de escribir código

Copia los dos archivos de cada lab a tu proyecto personal. Conserva nombres y firmas. Completa campos, constructor y métodos en la clase de dominio, fuera de `main`. En el archivo terminado en `Main`, crea los objetos y escribe las comprobaciones con `System.out.println`. No accedas directamente a los campos ni agregues setters.

Las plantillas compilan pero están incompletas: reemplaza cada retorno provisional por la lógica correcta, sin dejar otro `return` inalcanzable. Usa valores escritos en el programa; no necesitas Scanner, colecciones ni excepciones. Ejecuta el archivo terminado en `Main`.

Una llamada a una operación puede modificar el objeto. Hazla **una sola vez por prueba**, imprime su booleano y, en la siguiente línea, consulta el estado. No vuelvas a ejecutar la operación para conocer qué ocurrió.

## Lab 1 · Termostato doméstico · 15 minutos

Un termostato comienza en **20 °C** y permite ajustar su temperatura objetivo entre **16 y 30 °C, inclusive**. Si recibe otra temperatura, debe rechazarla y conservar la anterior.

**Archivos:** [S06Termostato.java](S06Termostato.java) y [S06Lab01TermostatoMain.java](S06Lab01TermostatoMain.java).

### Pasos para completar la actividad

1. En `S06Termostato`, **TODO 1: Declarar temperaturaObjetivo como campo privado int.** Escribe la declaración en el lugar indicado, fuera del constructor y de los métodos. El campo pertenece a cada objeto, no es `static`.
2. Dentro del constructor, **TODO 2: Inicializar la temperatura objetivo en 20.** Asigna 20 al campo. No declares otra variable local con el mismo nombre.
3. En `getTemperaturaObjetivo`, **TODO 3: Devolver la temperatura objetivo actual.** Reemplaza el retorno provisional por el campo. Consultar no debe cambiar el valor.
4. En `ajustarTemperatura`, **TODO 4: Aceptar solo de 16 a 30 inclusive; cambiar si acepta y devolver el resultado.** Si `nuevaTemperatura` es menor que 16 o mayor que 30, devuelve `false` sin modificar el campo. Si está dentro del intervalo, guarda el parámetro en el campo y devuelve `true`. Usa llaves en los bloques.
5. En el `main` de `S06Lab01TermostatoMain`, **TODO 5: Crear un termostato y mostrar su temperatura inicial.** Declara `S06Termostato termostato`, créalo con `new S06Termostato()` y escribe un `println` con la etiqueta `Temperatura inicial: ` y la llamada a `getTemperaturaObjetivo()`.
6. **TODO 6: Solicitar 24, 31 y 16; mostrar cada resultado y la temperatura posterior.** Escribe tres pares de `println`. El primero de cada par muestra la etiqueta `Ajustar 24: `, `Ajustar 31: ` o `Ajustar 16: ` y el resultado de llamar a `ajustarTemperatura` con ese número. El segundo muestra `Temperatura: ` y la consulta del campo mediante el getter. Respeta ese orden de solicitudes.
7. Ejecuta la clase y compara las siete líneas. Al rechazar 31, la temperatura debe seguir en 24. Si cambia a 31, revisa que la asignación ocurra después de validar.

**Salida esperada:**

```text
Temperatura inicial: 20
Ajustar 24: true
Temperatura: 24
Ajustar 31: false
Temperatura: 24
Ajustar 16: true
Temperatura: 16
```

**Ampliación opcional para casa:** solicita 30 y después 15. Debe aceptar 30, rechazar 15 y conservar 30. No simules sensores ni ciclos de calefacción.

## Lab 2 · Existencias de un almacén · 20 minutos

Un almacén comienza con **cero unidades** y puede guardar **hasta 100**. Solo admite ingresos y retiros de cantidades positivas; no puede quedar con existencias negativas ni superar su capacidad.

**Archivos:** [S06Inventario.java](S06Inventario.java) y [S06Lab02InventarioMain.java](S06Lab02InventarioMain.java).

### Pasos para completar la actividad

1. En `S06Inventario`, **TODO 1: Declarar existencias como int privado y capacidad como final int privado igual a 100.** Escribe los dos campos fuera de los métodos. `final` indica que la capacidad no se reasigna; no crees `setCapacidad` ni `setExistencias`.
2. En el constructor, **TODO 2: Inicializar las existencias en cero.** Asigna el valor al campo, sin crear una variable local.
3. En `getExistencias`, **TODO 3: Devolver las existencias actuales.** Sustituye el retorno provisional por el campo.
4. En `ingresar`, **TODO 4: Validar cantidad positiva y espacio disponible antes de sumar.** Rechaza con `false` si `cantidad <= 0` o si `cantidad > capacidad - existencias`. Si acepta, suma la cantidad al campo y devuelve `true`. Compara con el espacio restante antes de sumar; no cambies primero las existencias para luego deshacer el cambio.
5. En `retirar`, **TODO 5: Validar cantidad positiva y existencias suficientes antes de restar.** Rechaza con `false` una cantidad no positiva o superior a las existencias. Si acepta, réstala y devuelve `true`. Retirar exactamente todo lo disponible sí está permitido.
6. En el `main` de `S06Lab02InventarioMain`, **TODO 6: Crear un inventario y mostrar sus existencias iniciales.** Usa `S06Inventario inventario = new S06Inventario()` e imprime `Existencias iniciales: ` con `getExistencias()`.
7. **TODO 7: Ingresar 10, retirar 11 y retirar 10; mostrar resultado y existencias tras cada accion.** Escribe un par de `println` por movimiento: uno que llame a `ingresar(10)`, `retirar(11)` o `retirar(10)` y muestre su resultado; otro que consulte las existencias. Usa las etiquetas del bloque esperado. Después del retiro rechazado de 11, todavía deben quedar 10.
8. **TODO 8: Intentar ingresar 0 y 101; mostrar resultado y existencias tras cada accion.** Escribe otros dos pares de `println`. Ambos ingresos se rechazan y las existencias permanecen en cero.
9. Ejecuta y compara las once líneas. Si una acción devuelve `false`, la consulta siguiente debe mostrar el valor anterior a esa acción.

**Salida esperada:**

```text
Existencias iniciales: 0
Ingresar 10: true
Existencias: 10
Retirar 11: false
Existencias: 10
Retirar 10: true
Existencias: 0
Ingresar 0: false
Existencias: 0
Ingresar 101: false
Existencias: 0
```

**Ampliación opcional para casa:** después de esas pruebas, ingresa 100 y luego intenta ingresar 1. Debe aceptar el primer ingreso, rechazar el segundo y conservar 100. No construyas un menú ni una lista de artículos.

## Lab 3 · Despacho de un pedido · 20 minutos

Un pedido comienza en `PENDIENTE`. Desde ese estado se puede **enviar o cancelar**. Después de enviarlo o cancelarlo, no se permite ninguna de esas dos acciones otra vez.

| Estado actual | Solicitud | Resultado | Estado posterior |
| --- | --- | --- | --- |
| PENDIENTE | enviar | true | ENVIADO |
| PENDIENTE | cancelar | true | CANCELADO |
| ENVIADO o CANCELADO | enviar o cancelar | false | Conserva su estado |

**Archivos:** [S06Pedido.java](S06Pedido.java) y [S06Lab03PedidoMain.java](S06Lab03PedidoMain.java).

### Pasos para completar la actividad

1. En `S06Pedido`, **TODO 1: Declarar estado como campo privado String.** No lo declares `static` ni agregues un setter que permita asignarle cualquier texto.
2. En el constructor, **TODO 2: Inicializar el estado en PENDIENTE.** Asigna al campo el texto `"PENDIENTE"`, entre comillas y en mayúsculas.
3. En `getEstado`, **TODO 3: Devolver el estado actual.** Reemplaza la cadena vacía provisional por el campo, sin modificarlo.
4. En `enviar`, **TODO 4: Enviar solo un pedido PENDIENTE; cambiar a ENVIADO y devolver si acepta.** Compara el contenido del campo con `"PENDIENTE"` usando `equals`, no `==`. Si es distinto, devuelve `false`. Si coincide, asigna `"ENVIADO"` al campo y devuelve `true`.
5. En `cancelar`, **TODO 5: Cancelar solo un pedido PENDIENTE; cambiar a CANCELADO y devolver si acepta.** Aplica la misma regla de estado inicial, pero cambia a `"CANCELADO"` cuando acepta. Un pedido enviado no se puede cancelar en este ejercicio.
6. En el `main` de `S06Lab03PedidoMain`, **TODO 6: Crear primerPedido y segundoPedido; mostrar el estado inicial de ambos.** Crea dos objetos mediante dos llamadas a `new S06Pedido()`. Imprime sus consultas con las etiquetas `Pedido 1 inicial: ` y `Pedido 2 inicial: `.
7. **TODO 7: Enviar primerPedido y luego intentar cancelarlo; consultar tras cada accion.** Escribe cuatro `println`: resultado de `primerPedido.enviar()`, estado mediante `getEstado()`, resultado de `primerPedido.cancelar()` y estado otra vez. Debe quedar enviado, incluso después del rechazo.
8. **TODO 8: Cancelar segundoPedido y luego intentar enviarlo; consultar tras cada accion.** Escribe cuatro `println` equivalentes para el segundo objeto, primero cancelando y luego intentando enviar. Debe quedar cancelado. Usa las etiquetas del bloque esperado.
9. Ejecuta y compara las diez líneas. Los pedidos tienen estados independientes. El Main debe solicitar acciones; no debe decidir ni asignar el estado por fuera de `S06Pedido`.

**Salida esperada:**

```text
Pedido 1 inicial: PENDIENTE
Pedido 2 inicial: PENDIENTE
Enviar pedido 1: true
Pedido 1: ENVIADO
Cancelar pedido 1: false
Pedido 1: ENVIADO
Cancelar pedido 2: true
Pedido 2: CANCELADO
Enviar pedido 2: false
Pedido 2: CANCELADO
```

**Ampliación opcional para casa:** vuelve a llamar a `primerPedido.enviar()` y `segundoPedido.cancelar()`. Ambos deben devolver `false` y mantener su estado. No agregues pagos, productos ni otros estados.
