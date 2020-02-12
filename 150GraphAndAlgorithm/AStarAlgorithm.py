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

def AStar(graph, start, finish, h):
    tree = []
    fringe = []
    parent = [0 for i in range(len(graph))]
    g = [0 for i in range(len(graph))]
    f = [0 for i in range(len(graph))]
    f[start] = g[start] + h[start]

    tree.append(start)
    for i in range(len(graph)):
        if graph[start][i] > 0:
            fringe.append(i)
            parent[i] = start
            g[i] = graph[start][i]
            f[i] = g[i] + h[i]

    while (finish not in tree) and len(fringe) != 0:
        min = sys.maxsize
        imin = 0
        for i in fringe:
            if f[i] < min:
                min = f[i]
                imin = i
        tree.append(imin)
        fringe.remove(imin)

        for i in range(len(graph)):
            if graph[imin][i] > 0:
                if i not in tree:
                    if i in fringe:
                        if g[imin] + graph[imin][i] < g[i]:
                            g[i] = g[imin] + graph[imin][i]
                            f[i] = g[i] + h[i]
                            parent[i] = imin
                    else:
                        fringe.append(i)
                        g[i] = g[imin] + graph[imin][i]
                        f[i] = g[i] + h[i]
                        parent[i] = imin
    return g[finish]

h = [0 for i in range(len(undirected))]
print(AStar(undirected, 0, 3, h))