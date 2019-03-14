import sys

N=int(input())
x=2**N-1
i=0
while(1==1):    
    Q=list(bin(x))
    while(len(Q)<N+2):
        Q.insert(2,"0")
    Q[0]="Q"
    Q.remove("b")
    print(" ".join(Q))
    sys.stdout.flush()
    A=int(input())
    if(A==N):
        break
    else:
        x=x-2**i
        if(i!=0 and A<=Ap):
            x=x+2**(i-1)
        Ap=A
        i=i+1

Q[0]="A"
print(" ".join(Q))
sys.stdout.flush()
