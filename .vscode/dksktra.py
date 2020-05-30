# dksktra alg
graph=dict()
graph["start"]=[("A",6),("B",2)]
graph["A"]=[("end",1)]
graph["B"]=[("A",3),("end",5)]
graph["end"]=[]

from collections import deque
import sys

q=deque()
cost=dict()
for item in graph:
    cost[item]=sys.maxsize
q.append("start")
cost["start"]=0

route=[]

while len(q)!=0:
    item = q.pop()
    route.append(item)

    # update cost
    for node ,weight in graph[item]:
        if cost[node]>cost[item]+weight:
            cost[node]=cost[item]+weight
        q.append(node)
        
print(route)
print(cost)