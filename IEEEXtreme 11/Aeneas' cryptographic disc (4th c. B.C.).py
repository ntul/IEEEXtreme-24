import re, math

l=int(input())
alphabet={}
length=0

for i in range(1,27):
    a=input().split(' ')
    alphabet[a[0]]=float(a[1])

phrase=input().upper()

regex = re.compile('[^a-zA-Z]')

phrase=regex.sub('', phrase)

for i in range(1,len(phrase)):
    
    si=math.sin(abs(math.radians(alphabet[phrase[i]]-alphabet[phrase[i-1]]))/2)
    length+=2*l*abs(si)   

print(math.ceil(length+l)) 
