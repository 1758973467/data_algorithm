## coding utf-8
import sys
graph=dict()
graph["乐谱"]=[("黑胶唱片",5),("海报",sys.maxsize)]
graph["黑胶唱片"]=[("吉他",15),("架子鼓",20)]
graph["海报"]=[("架子鼓",35),("吉他",30)]
graph["吉他"]=[("钢琴",20)]
graph["架子鼓"]=[("钢琴",10)]
graph["钢琴"]=[]

from collections import deque

q=deque()
cost=dict()
for item in graph:
    cost[item]=sys.maxsize

q.append("乐谱")
cost["乐谱"]=0
route=[]
parents=dict()

while len(q)!=0:
    item =q.pop()
    route.append(item)
    
    for node,weight in graph[item]:
        if cost[node] > cost[item]+weight:
            cost[node]=cost[item]+weight
            parents[node]=item
        q.append(node)

print(parents)
# print change list
end="钢琴"
result=[]
result.append(end)

while parents[end]!="乐谱":
    result.append(parents[end])
    end=parents[end]
result.reverse()
print(result)
print(route)
print(cost)
print(cost["钢琴"])
