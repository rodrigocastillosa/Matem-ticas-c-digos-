# -*- coding: utf-8 -*-
"""
Fibonacci hacia adelante

Objetivo: Calcular el valor n-ésimo de la suceción de Fibonacci
          sin saturar la memoria
    
Tema: Cálculo de una sucesión recursiva hacia adelante
      para evitar llamadas redundantes
    
      if __name__ == "__main__":
        Sirve para ejecutar un bloque de código solo cuando el script se
        ejecuta directamente, y no cuando se importa como un módulo en otro
        archivo.


Referencia: Classic Computer Science Problems with Python
            pag 11  fib5.py 

Software: Python 3.12.12

Created on Fri Jun 14 2024
Edited: 8 Nov 2025
"""

def fibAdel(n: int) -> int:
    # --- Mejora: Validación de entrada ---
    if n < 0:
        raise ValueError("La posición debe ser un entero no negativo.")
    # ------------------------------------

    if n == 0: return n
    penultimo: int = 0
    ultimo:    int = 1
    for _ in range(1, n):
        penultimo, ultimo = ultimo, penultimo + ultimo
    return ultimo

if __name__ == "__main__":
    try:
        n = int(input("¿De qué posición quieres el valor de Fibonacci?: "))
        print(f"El {n}-ésimo valor de Fibonacci es: {fibAdel(n)}")
    except ValueError as e:
        print(e)