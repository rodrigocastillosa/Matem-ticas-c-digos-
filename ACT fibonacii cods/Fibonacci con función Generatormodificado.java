# -*- coding: utf-8 -*-
"""
Fibonacci con función Generator versión 2

Calcula hacia adelante

Tema: yield
        La sentencia yield suspende la ejecución de una función y devuelve
        un valor al invocador, pero conserva suficiente estado para que la
        función pueda reanudarse donde la dejó. Cuando la función se reanuda,
        continúa la ejecución mmediatamente después de la última ejecución
        de yield. Esto permite que su código genere una serie de valores a
        lo largo del tiempo, en lugar de calcularlos de una vez y devolverlos
        como una lista.
    
      if __name__ == "__main__":
        Sirve para ejecutar un bloque de código solo cuando el script se
        ejecuta directamente, y no cuando se importa como un módulo en otro
        archivo.

Referencia: Classic Computer Science Problems with Python
            pag 12  fib9.py
        
            https://www.geeksforgeeks.org/python/use-yield-keyword-instead-return-keyword-python/

Created on Fri Jun 14 2024
Edited: 8 Nov 2025
"""
from typing import Generator

def fibGen(n: int) -> Generator[int, None, None]:
    # --- Mejora: Validación de entrada ---
    if n < 0:
        raise ValueError("La posición debe ser un entero no negativo.")
    # ------------------------------------

    yield 0
    if n > 0:
        yield 1
    penultimo: int = 0
    ultimo:    int = 1
    for _ in range(1, n):
        penultimo, ultimo = ultimo, penultimo + ultimo
        yield ultimo

if __name__ == "__main__":
    try:
        n = int(input("¿Fibonacci hasta la posición?: "))
        print(f"Sucesión de Fibonacci hasta la posición {n}:")
        for i in fibGen(n):
            print(i)
    except ValueError as e:
        print(e)