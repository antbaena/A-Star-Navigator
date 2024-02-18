# Proyecto prLaberinto

## Descripción
Este proyecto consiste en el desarrollo del algoritmo A* en Java para resolver laberintos. El algoritmo A* es un algoritmo de búsqueda informada que encuentra el camino más corto entre un nodo inicial y un nodo objetivo. Es ampliamente utilizado en aplicaciones de inteligencia artificial, como en la resolución de problemas de búsqueda en grafos, planificación de trayectorias, entre otros.

## Algoritmo A*
El algoritmo A* se basa en una combinación de la búsqueda de costo uniforme y la búsqueda heurística. Utiliza una función de evaluación que combina el costo real del camino desde el nodo inicial hasta el nodo actual con una estimación heurística del costo restante hasta el nodo objetivo. La fórmula de evaluación típica es: `f(n) = g(n) + h(n)`, donde:
- `f(n)` es el costo total estimado del camino desde el nodo inicial hasta el nodo objetivo pasando por el nodo actual.
- `g(n)` es el costo real del camino desde el nodo inicial hasta el nodo actual.
- `h(n)` es la estimación heurística del costo desde el nodo actual hasta el nodo objetivo.

## Pasos del Algoritmo A*
El algoritmo A* sigue los siguientes pasos para encontrar el camino más corto en un grafo:

1. **Inicialización**: Se inicializan dos listas, la lista abierta y la lista cerrada. La lista abierta contiene los nodos que se deben explorar, mientras que la lista cerrada contiene los nodos que ya han sido evaluados.
2. **Agregar el nodo inicial a la lista abierta**.
3. **Iteración**:
   - Mientras la lista abierta no esté vacía:
     - Seleccionar el nodo con el menor valor de `f(n)` de la lista abierta. Este será el nodo actual.
     - Si el nodo actual es el nodo objetivo, se ha encontrado el camino más corto y se termina el algoritmo.
     - De lo contrario, se expande el nodo actual y se generan sus nodos sucesores.
     - Para cada sucesor:
       - Si el sucesor ya está en la lista cerrada y el nuevo camino hasta él no es mejor, se descarta este sucesor.
       - Si el sucesor no está en la lista abierta o el nuevo camino hasta él es mejor:
         - Se actualizan los valores `g(n)` y `h(n)` del sucesor.
         - Se establece el nodo padre del sucesor como el nodo actual.
         - Si el sucesor no está en la lista abierta, se agrega a ella.
4. **Construcción del camino**: Una vez que se ha alcanzado el nodo objetivo, se reconstruye el camino desde el nodo objetivo hasta el nodo inicial siguiendo los nodos padres.

## Ejecución del Proyecto
Para ejecutar el proyecto, se debe seguir los siguientes pasos:
1. Clonar este repositorio en su máquina local.
2. Abrir el proyecto en su IDE preferido.
3. Compilar y ejecutar el programa.
4. Proporcionar como entrada el laberinto deseado en el formato adecuado.
5. Observar la salida que muestra el camino más corto encontrado por el algoritmo A*.
