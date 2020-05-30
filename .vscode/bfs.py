graph=dict()
graph["me"]=["alice","bob","claire"]
graph["bob"]=["anuj","peggy"]
graph["alice"]=["peggy","jonny"]
graph["claire"]=["thom"]
graph["anuj"]=[]
graph["peggy"]=[]
graph["jonny"]=[]
graph["thom"]=[]

from collections import deque
swqs
q=deque()
searched=[]
q.append("me")
while len(q)!=0:
    item=q.pop()
    searched.append(item)
    if item == "jonny":
        break
    for key in graph[item]:
        if key not in searched :
            q.append(key)

print(searched)