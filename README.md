# Ejercicio
- **1)** Desarrolla un algoritmo que simule un cajero automático (telecajero), la idea es ser creativo en cuanto a las actividades que realizará (ej. consulta de saldo, depósito, retiro, clave incorrecta, bloquear tarjeta, etc).
- **2)** Utiliza distintas estructuras de control y bucles, usa la lógica de programación para armar el programa.
- **3)** Los datos deben ser ingresados por el usuario a través de los métodos de la clase Scanner para trabajar con el teclado.

> Nota: Escribe cada algoritmo creado.

# Algoritmos

### Inicio del programa:
- Bucle *do-while* donde funciona todo el programa. Finaliza cuando el usuario así lo indique.
```
do {
  $PROGRAMA$
} while ($CONDICIÓN$)
```

### Ingreso a la cuenta:
- Bucles *while* anidados en diferentes *if* a lo largo del programa que atajan posibles errores para verificar y manejar los fallos de ingreso.
```
if ($CONDICIÓN$) {
  while ($CONDICIÓN$){
  System.out.print("El término ingresado no es válido. Inténtelo nuevamente: ");
  $SCANNER$
  }
}
```

### Menú desplegable:
- Bucle *while* para mostrar un menú al usuario y ejecutar la opción seleccionada. Anidado hay una serie de condicionales *if-else* para manejar las diferentes opciones del menú.
```
while ($CONDICIÓN$) {
  $MENÚ IMPRESO$
  $SERIE DE IF-ELSE$
}
```

### Consultar dinero en cuenta:
- Bucle *for* para buscar la clave ingresada en el array y mostrar el saldo correspondiente.
```
for (int i = 0; $CONDICIÓN$; i++) {
  if ($CONDICIÓN$){
    $DATO IMPRESO$
  }
}
```

### Pagar tarjeta de crédito:
- Bucle *for* para buscar la clave ingresada en el array y mostrar la deuda correspondiente. Anidado hay una serie de condicionales *if-else* para manejar diferentes escenarios de pago.
```
for (int i = 0; $CONDICIÓN$; i++) {
  $SERIE DE IF-ELSE$
}
```

### Depositar efectivo:
- Bucle *for* que actualiza el monto correspondiente en el array según el dato que ingresa el usuario.
```
System.out.print("Ingrese el monto de dinero a depositar: $");
$SCANNER$

for (int i = 0; $CONDICIÓN$; i++) {
  if ($CONDICIÓN$) {
    $MONTO ORIGINAL$ += $SCANNER$;
  }
}
```

### Retirar efectivo:
- Bucle *for* similar al detallado en el punto anterior, salvo por la diferencia que se suma un bucle *while* para manejar el caso en que el monto a retirar sea mayor que el saldo disponible.
```
System.out.print("Ingrese el monto de dinero a depositar: $");
$SCANNER$

for (int i = 0; $CONDICIÓN$; i++) {
  if ($CONDICIÓN$) {
    if ($CONDICIÓN$) {
      while ($CONDICIÓN$) {
        System.out.print("El monto ingresado supera la cantidad de dinero disponible en cuenta. Por favor, ingrese un valor menor: $");
        $SCANNER$
      }
      $MONTO ORIGINAL$ -= $SCANNER$;
    }
  }
}
```
