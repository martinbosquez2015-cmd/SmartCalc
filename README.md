# SmartCalc

Aplicación de calculadora desarrollada en **Kotlin** para Android utilizando **Material Design 3**, **colores dinámicos** adaptados al fondo de pantalla y soporte para **modo claro y oscuro**.

## Características

- **Operaciones básicas:** suma (`+`), resta (`-`), multiplicación (`×`) y división (`÷`).
- **Soporte decimal:** gestión del punto decimal (`.`) evitando duplicados en una misma cifra.
- **Funciones especiales:** cambio de signo (`±`), borrado del último carácter (`DEL`), reinicio completo (`C`) y cálculo (`=`).
- **Doble pantalla:** visualización de la operación en curso y del resultado o cifra actual.
- **Control de errores:** manejo seguro de la división por cero sin cerrar la aplicación.
- **Diseño adaptable:** estilos centralizados en XML, esquinas personalizadas y paleta dinámica según el sistema.

## Estructura del proyecto

- `App.kt`: inicialización de colores dinámicos en la aplicación.
- `MainActivity.kt`: gestión de la interfaz y eventos de usuario mediante View Binding.
- `CalculatorEngine.kt`: lógica matemática, estados y validación de errores.
- `res/layout/activity_main.xml`: distribución de la pantalla y el teclado.
- `res/values/styles.xml` y `themes.xml`: estilos reutilizables y configuración de tema.

## Requisitos

- Android Studio
- SDK de Android compatible con Material Components (Material 3) y Kotlin
