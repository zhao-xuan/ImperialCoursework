import sys

'''
DFS algorithm for graphs on 150 note page 155.
'''
undirected =   [[ 0, 3, 0, 0, 0, 8, 0, 2, 0, 3, 2 ],
                [ 3, 0, 5, 0, 0, 0, 0, 0, 0, 0, 4 ],
                [ 0, 5, 0, 4, 3, 3, 0, 0, 0, 0, 0 ], 
                [ 0, 0, 4, 0, 3, 0, 0, 0, 0, 0, 0 ],
                [ 0, 0, 3, 3, 0, 4, 0, 0, 0, 0, 0 ], 
                [ 8, 0, 3, 0, 4, 0, 4, 0, 0, 0, 0 ],
                [ 0, 0, 0, 0, 0, 4, 0, 3, 0, 0, 0 ], 
                [ 2, 0, 0, 0, 0, 0, 3, 0, 3, 2, 0 ],
                [ 0, 0, 0, 0, 0, 0, 0, 3, 0, 2, 0 ], 
                [ 3, 0, 0, 0, 0, 0, 0, 2, 2, 0, 2 ],
                [ 2, 4, 0, 0, 0, 0, 0, 0, 0, 2, 0 ]]

'''
This can be found in coursework 5, directed graph
'''
directed = [[ 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 2 ], 
            [ 0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0 ],
            [ 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0 ],
            [ 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0 ],
            [ 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0 ],
            [ 8, 0, 3, 0, 4, 0, 4, 0, 0, 0, 0 ],
            [ 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0 ],
            [ 2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0 ],
            [ 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0 ],
            [ 3, 0, 0, 0, 0, 0, 0, 0, 2, 0, 2 ],
            [ 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0 ]]

demo = [[0, 10, 3, 8, 0, 0, 0], 
        [10, 0, 0, 9, 0, 7, 0],
        [3, 0, 0, 4, 0, 0, 0],
        [8, 9, 4, 0, 6, 0, 0],
        [0, 0, 0, 6, 0, 3, 0],
        [0, 7, 0, 0, 3, 0, 4],
        [0, 0, 0, 0, 0, 4, 0]]

def dijkstra(graph, start, finish):
    tree = []
    fringe = []
    parent = [0 for i in range(0, len(graph))]
    distance = [sys.maxsize for i in range(0, len(graph))]
    
    tree.append(start)
    for i in range(0, len(graph)):
        if graph[start][i] > 0:
            fringe.append(i)
            parent[i] = start
            distance[i] = graph[start][i]

    while (finish not in tree) and len(fringe) != 0:
        min = sys.maxsize
        jmin = 0
        for i in fringe:
            if distance[i] < min:
                min = distance[i]
                jmin = i

        tree.append(jmin)
        fringe.remove(jmin)

        for i in range(0, len(graph)):
            if graph[jmin][i] != 0:
                if i not in tree:
                    if i in fringe:
                        if graph[jmin][i] + distance[jmin] < distance[i]:
                            distance[i] = graph[jmin][i] + distance[jmin]
                            parent[i] = jmin
                    else:
                        fringe.append(i)
                        parent[i] = jmin
                        distance[i] = graph[jmin][i] + distance[jmin]

    return distance[finish]

print(dijkstra(demo, 0, 6))