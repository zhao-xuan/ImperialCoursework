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

def checkCycle(graph):
    ##random starting root
    root = 0
    visited = []
    parents = []

    for i in range(0, len(graph)):
        visited.append(False)
        parents.append(root)
    
    return DFS(graph, root, root, visited, parents)

def DFS(graph, prev, node, visited, parents):
    visited[node] = True

    for i in range(0, len(graph)):
        if prev != i:
            if graph[node][i] > 0 and visited[i]:
                parents[i] = node
                return (True, parents)
            elif graph[node][i] > 0 and not visited[i]:
                parents[i] = node
                return DFS(graph, node, i, visited, parents)

    return (False, [])

print(checkCycle(undirected))