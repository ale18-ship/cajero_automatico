# Cajero Automático 💵

Este proyecto es una simulación de un cajero automático en **Java**, desarrollado como ejercicio de la materia **Estructuras de Datos**.

---

## 🚀 Funcionalidades

- Consultar saldo disponible.
- Depositar dinero (solo múltiplos de $5000).
- Retirar dinero (validando disponibilidad de billetes).
- Mostrar detalle de los billetes entregados.

---

##  📊 Uso de Estructuras de Datos
🧩 Uso de Arreglos (Arrays)

El ejercicio asignado fue el **cajero automático**, por lo tanto se aplican **arreglos unidimensionales** y **no matrices**.

- Se usan **arreglos (`int[]`)** para almacenar:
    - Las denominaciones de billetes: `{50000, 20000, 10000, 5000}`.
    - Las cantidades disponibles de cada billete.

- Relación entre arreglos:
    - La posición `i` en ambos arreglos representa el mismo billete.
    - Ejemplo: `billetes[0] = 50000` y `cantidades[0] = 10` → hay diez billetes de $50.000.

- Operaciones implementadas con arreglos:
    - **Declaración e inicialización**
    - **Recorrido con for y for-each**
    - **Modificación de valores** (al depositar o retirar)
    - **Búsqueda lineal** (para seleccionar billetes disponibles en un retiro)

👉 Aunque el proyecto principal usa arreglos unidimensionales, se puede extender fácilmente a matrices para representar billetes por denominación y ubicación en diferentes cajeros.

---

## 📂 Estructura del Proyecto  
```
cajero_automatico/
│ ── src/
│ └── main/
│ └── java/
│ └── com/
│ └── cajero/
│ └── CajeroAutomatico.java # Clase principal
│── pom.xml # Configuración de Maven
│── .gitignore # Archivos y carpetas ignoradas por Git
│── README.md # Documentación del proyecto
```
---

## ▶️ Ejecución

1. Compilar con Maven o desde el IDE (IntelliJ, Eclipse, NetBeans).
2. Ejecutar la clase principal:

```bash

mvn clean compile
mvn exec:java -Dexec.mainClass="com.cajero.CajeroAutomatico"

```



