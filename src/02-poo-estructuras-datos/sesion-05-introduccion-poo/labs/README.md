# Laboratorios de la sesión 5

**Tres actividades en 55 minutos y 5 minutos de revisión.** Completa lo pendiente en casa para la siguiente clase.

## Antes de escribir código

Copia los dos archivos de cada lab a tu proyecto personal. Conserva sus nombres y las firmas de los métodos. Los TODO de campos, constructor y métodos se resuelven en la clase de dominio; los de creación de objetos y salida, dentro de `main` en `S05Lab...`. No crees otro `main` ni declares una clase dentro de un método.

Las plantillas compilan, pero están incompletas: reemplaza cada `return` provisional por el resultado correcto, sin dejar un segundo `return` inalcanzable. Usa datos escritos en el programa; no necesitas Scanner, arreglos, listas ni excepciones. Los datos iniciales de los constructores son válidos. Ejecuta la clase `S05Lab...`, no la clase de dominio.

## Lab 1 · Préstamo de un libro · 15 minutos

Una biblioteca necesita controlar si un ejemplar está prestado. Un segundo intento de préstamo debe rechazarse y devolverlo debe dejarlo disponible.

**Archivos:** [S05LibroPrestamo.java](S05LibroPrestamo.java) y [S05Lab01PrestamoLibro.java](S05Lab01PrestamoLibro.java).

### Pasos para completar la actividad

1. En `S05LibroPrestamo`, **TODO 1: Declarar titulo (String) y prestado (boolean) como campos privados.** Escribe las dos declaraciones en el lugar indicado, fuera de los métodos. Cada objeto conservará su propio título y estado.
2. En el constructor, **TODO 2: Guardar el titulo y establecer prestado en false.** Asigna el parámetro a `this.titulo` y deja el campo `prestado` en `false`: un libro nuevo comienza disponible. No declares variables locales que oculten esos campos.
3. En `obtenerTitulo`, **TODO 3: Devolver el titulo del objeto.** Reemplaza el retorno provisional por el campo. Este método no imprime.
4. En `prestar`, **TODO 4: Rechazar un segundo prestamo; si esta disponible, prestarlo.** Si `prestado` ya es `true`, devuelve `false` sin modificarlo. En caso contrario, cambia el campo a `true` y devuelve `true`. El resultado indica si se pudo realizar la acción.
5. En `devolver`, **TODO 5: Marcar el libro como no prestado.** Cambia el campo a `false`. Como el método es `void`, no devuelve un booleano. Devolver un libro que ya está disponible simplemente lo mantiene disponible.
6. En `estaPrestado`, **TODO 6: Devolver el estado prestado del objeto.** Devuelve el campo sin cambiarlo.
7. En el `main` de `S05Lab01PrestamoLibro`, **TODO 7: Crear primerLibro con El principito y segundoLibro con Matilda.** Declara dos variables de tipo `S05LibroPrestamo` e inicializa cada una con una llamada distinta a `new` y su título entre comillas.
8. **TODO 8: Mostrar titulo, dos intentos de prestamo y estado del primer libro.** Escribe cuatro `System.out.println`: el título obtenido mediante `obtenerTitulo()`, el resultado de llamar a `primerLibro.prestar()`, el resultado de volver a llamarlo y la consulta `primerLibro.estaPrestado()`. Cada intento se realiza una sola vez; imprimirlo también ejecuta el método.
9. **TODO 9: Devolver el primer libro y mostrar el estado de ambos libros.** Llama a `primerLibro.devolver()` y luego imprime dos consultas `estaPrestado()`, una por objeto. Usa las etiquetas del bloque esperado.
10. Ejecuta la clase y compara las seis líneas. Explica oralmente por qué el segundo intento falla y por qué Matilda sigue disponible. Como comprobación adicional, vuelve a prestar el primer libro después de devolverlo: debe aceptar el préstamo.

**Salida esperada antes de la comprobación adicional:**

```text
Libro: El principito
Primer prestamo: true
Segundo intento: false
Prestado antes de devolver: true
Prestado despues de devolver: false
Segundo libro prestado: false
```

## Lab 2 · Medidas de un rectángulo · 20 minutos

Una aplicación debe calcular área y perímetro a partir de las medidas de cada figura. Las consultas deben devolver resultados sin cambiar las medidas.

**Archivos:** [S05Rectangulo.java](S05Rectangulo.java) y [S05Lab02MedidasRectangulo.java](S05Lab02MedidasRectangulo.java).

### Pasos para completar la actividad

1. En `S05Rectangulo`, **TODO 1: Declarar base y altura como campos privados double.** Escribe los dos campos fuera del constructor y los métodos. Las medidas se expresan en metros.
2. En el constructor, **TODO 2: Guardar los dos parametros en los campos usando this.** Guarda `base` en `this.base` y `altura` en `this.altura`; escribir `base = base` no inicializa el campo como necesitas.
3. En `calcularArea`, **TODO 3: Devolver el area calculada con base y altura.** Aplica área = base × altura y devuelve el resultado con `return`. No uses `println` dentro de este método.
4. En `calcularPerimetro`, **TODO 4: Devolver el perimetro calculado con base y altura.** Aplica perímetro = 2 × (base + altura). Conserva los paréntesis para sumar las medidas antes de multiplicar.
5. En `esCuadrado`, **TODO 5: Devolver si base y altura son iguales.** Devuelve el resultado booleano de comparar los dos campos. En este ejercicio las medidas son enteros pequeños guardados como `double`; puedes usar `==` sin introducir tolerancias de cálculo.
6. En el `main` de `S05Lab02MedidasRectangulo`, **TODO 6: Crear primeraFigura de 5 por 3 y segundaFigura de 4 por 4.** Crea dos objetos distintos usando el constructor y los argumentos en el orden base, altura.
7. **TODO 7: Mostrar area, perimetro y esCuadrado de cada figura.** Escribe seis `System.out.println`, tres por objeto, llamando a sus métodos. Usa las etiquetas y el orden del bloque esperado. El área se expresa en metros cuadrados y el perímetro en metros.
8. Ejecuta y compara la salida. La segunda figura tiene área y perímetro con el mismo valor numérico, pero representan magnitudes distintas. Como comprobación adicional, cambia la primera figura a 2 × 7: debe producir 14.0, 18.0 y `false`.

**Salida con las medidas iniciales:**

```text
Figura 1 - Area: 15.0
Figura 1 - Perimetro: 16.0
Figura 1 - Cuadrado: false
Figura 2 - Area: 16.0
Figura 2 - Perimetro: 16.0
Figura 2 - Cuadrado: true
```

## Lab 3 · Reserva de una sala · 20 minutos

Una sala permite reservas de hasta ocho horas. Puedes ampliar una reserva si la cantidad solicitada es positiva y no supera ese límite. Un intento rechazado debe conservar las horas y el costo anteriores.

**Archivos:** [S05ReservaSala.java](S05ReservaSala.java) y [S05Lab03ReservaSala.java](S05Lab03ReservaSala.java).

### Pasos para completar la actividad

1. En `S05ReservaSala`, **TODO 1: Declarar cliente (String), horas (int) y tarifaPorHora (long) privados.** La tarifa y el costo están en pesos enteros, sin decimales. Los datos iniciales serán cliente no vacío, de 1 a 8 horas y tarifa de 1 a 100000 pesos.
2. En el constructor, **TODO 2: Inicializar los tres campos con los parametros.** Usa `this` para distinguir los campos de los parámetros con el mismo nombre.
3. En `obtenerCliente`, **TODO 3: Devolver el cliente.** Reemplaza el retorno provisional por el campo correspondiente.
4. En `obtenerHoras`, **TODO 4: Devolver las horas actuales.** Consulta el campo sin modificarlo.
5. En `calcularCosto`, **TODO 5: Devolver horas por tarifaPorHora.** Multiplica los dos campos y devuelve el resultado `long`. No guardes un costo fijo: debe reflejar una ampliación posterior.
6. En `extender`, **TODO 6: Aceptar solo de 1 a 8 - horas; actualizar si acepta y devolver el resultado.** Rechaza con `false` si `horasAdicionales` es menor que 1 o mayor que `8 - horas`. Si acepta, suma la cantidad al campo `horas` y devuelve `true`. No cambies el campo antes de comprobar las condiciones. Por ejemplo, con 3 horas reservadas puedes agregar hasta 5, no 6.
7. En el `main` de `S05Lab03ReservaSala`, **TODO 7: Crear reservaAna (2 horas, 15000 pesos/hora) y reservaLuis (1, 20000).** Crea dos objetos distintos con clientes `"Ana"` y `"Luis"`; respeta el orden cliente, horas, tarifa del constructor. Puedes escribir las tarifas como `15000L` y `20000L`.
8. **TODO 8: Mostrar los resultados de extender la reserva de Ana en 1, 6 y 0 horas.** Escribe tres `System.out.println` con una llamada a `reservaAna.extender(...)` en cada uno, en ese orden. No amplíes la reserva de Luis. Recuerda que cada llamada puede modificar el objeto.
9. **TODO 9: Mostrar cliente, horas y costo final de ambas reservas.** Escribe tres `println` por reserva usando `obtenerCliente()`, `obtenerHoras()` y `calcularCosto()`. Usa las etiquetas del bloque esperado, sin imprimir directamente los datos iniciales.
10. Ejecuta y compara las nueve líneas. Como comprobación adicional, después de la salida inicial intenta ampliar a Ana en 5 horas: debe aceptar y llegar a 8 horas y 120000 pesos. Otro intento de 1 hora debe devolver `false` y conservar esos valores.

**Salida antes de la comprobación adicional:**

```text
Ampliar 1 hora: true
Ampliar 6 horas: false
Ampliar 0 horas: false
Cliente: Ana
Horas: 3
Costo (pesos): 45000
Cliente: Luis
Horas: 1
Costo (pesos): 20000
```

No construyas un menú ni una agenda completa. El objetivo es que cada reserva calcule su costo y controle su propia ampliación.
