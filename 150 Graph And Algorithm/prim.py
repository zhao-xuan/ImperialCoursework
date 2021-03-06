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

demo = [[0, 3, 5, 4], 
        [3, 0, 4, 0], 
        [5, 4, 0, 2],
        [4, 0, 2, 0]]

def prim(graph, start):
    tree = []
    fringe = []
    weight = [sys.maxsize for i in range(0, len(graph))]
    parent = [0 for i in range(0, len(graph))]

    tree.append(start)
    for i in range(0, len(graph)):
        if graph[start][i] > 0:
            fringe.append(i)
            parent[i] = start
            weight[i] = graph[start][i]

    while len(fringe) != 0:
        min = sys.maxsize
        jmin = 0
        for i in tree:
            for j in fringe:
                if graph[i][j] > 0 and graph[i][j] < min:
                    min = graph[i][j]
                    jmin = j
        fringe.remove(jmin)
        tree.append(jmin)
        for i in range(0, len(graph)):
            if graph[jmin][i] != 0:
                if i not in tree:
                    if i in fringe:
                        if graph[jmin][i] < weight[i]:
                            weight[i] = graph[jmin][i]
                            parent[i] = jmin
                    else:
                        fringe.append(i)
                        weight[i] = graph[jmin][i]
                        parent[i] = jmin
    return parent

print(prim(demo, 0))