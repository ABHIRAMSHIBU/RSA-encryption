from bob import *
from alice import *
import math
import time
import pickle
import random

start_time = time.time()
m = input("Enter the message to encrypt as nos")
p=open("prime.txt").read().split("\n")
while True:
	p1,p2 = random.choice(p).strip(" "),random.choice(p).strip(" ")
	print(p1,p2)
	p1,p2=int(p1),int(p2)
	n=p1*p2
	if(n> int(m) and p1!=p2):
		break
print("p1 = ",p1,"p2 = ",p2)
m=int(m)	
print("n = p1*p2="+str(p1)+"*"+str(p2)+" = "+str(n))

phi_n = (p1 - 1)*(p2 - 1)
print("phi("+str(n)+") = ",phi_n)

e = find_e(phi_n)
print("public key = ",e)

k = find_k(phi_n,e)
print("k = ",k)

d = (k*phi_n+1)/e
print("Private key : ",d)
c = encrypt_message(m,e,n)

print("message to encrypt :", m)
print("cypher text(encrypted message):", c )


dec = pow(c,int(d),n)
a=time.time() - start_time
print("time taken for establishing connection:",a)
print("Decoded message:",dec)

