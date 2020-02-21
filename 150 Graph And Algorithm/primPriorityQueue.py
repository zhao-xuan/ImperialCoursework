import sys
from queue import PriorityQueue

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

def primPQ(graph):
    q = PriorityQueue()
    key = [0 for i in range(0, len(graph))]
    parent = [0 for i in range(0, len(graph))]
    for i in range(0, len(graph)):
        key[i] = sys.maxsize
        parent[i] = -1
        q.put(key[i], i)

    ##need to be finished with decreasekey functionality