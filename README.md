# MazeSolver Project

## Description
This project involves the development of the A* algorithm in Java to solve mazes. The A* algorithm is an informed search algorithm that finds the shortest path between a start node and a goal node. It is widely used in artificial intelligence applications, such as solving search problems in graphs, path planning, and more.

## A* Algorithm
The A* algorithm is based on a combination of uniform-cost search and heuristic search. It uses an evaluation function that combines the actual cost of the path from the start node to the current node with a heuristic estimate of the remaining cost to the goal node. The typical evaluation formula is: `f(n) = g(n) + h(n)`, where:
- `f(n)` is the estimated total cost of the path from the start node to the goal node passing through the current node.
- `g(n)` is the actual cost of the path from the start node to the current node.
- `h(n)` is the heuristic estimate of the cost from the current node to the goal node.

## Steps of the A* Algorithm
The A* algorithm follows these steps to find the shortest path in a graph:

1. **Initialization**: Initialize two lists, the open list and the closed list. The open list contains nodes to be explored, while the closed list contains nodes that have already been evaluated.
2. **Add the start node to the open list**.
3. **Iteration**:
   - While the open list is not empty:
     - Select the node with the lowest `f(n)` value from the open list. This will be the current node.
     - If the current node is the goal node, the shortest path has been found and the algorithm terminates.
     - Otherwise, expand the current node and generate its successor nodes.
     - For each successor:
       - If the successor is already in the closed list and the new path to it is not better, discard this successor.
       - If the successor is not in the open list or the new path to it is better:
         - Update the successor's `g(n)` and `h(n)` values.
         - Set the successor's parent node to the current node.
         - If the successor is not in the open list, add it.
4. **Path Construction**: Once the goal node is reached, reconstruct the path from the goal node to the start node by following the parent nodes.

## Running the Project
To run the project, follow these steps:
1. Clone this repository.
2. Open the project in your preferred IDE.
3. Compile and run the mainTest to see it in action.
4. Observe the output showing the shortest path found by the A* algorithm.

------------------------------------------------------------------------------------

🇪🇸
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
1. Clonar este repositorio.
2. Abrir el proyecto en su IDE preferido.
3. Compilar y ejecutar el mainTest para ver su funcionamiento.
5. Observar la salida que muestra el camino más corto encontrado por el algoritmo A*.
