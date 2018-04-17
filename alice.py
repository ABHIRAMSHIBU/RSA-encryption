import random
from math import gcd
def isprime(n):
	prime=True
	for i in range(2,int(n/2)+1):
		if(n%i)==0:
			prime=False
			break
	return prime

prime_list=[]
for i in range(2000,10000):
	if(isprime(i)):
		prime_list.append(i)


def find_k(phi_n,e):
	k=2
	d=(k*phi_n+1)/e
	while True:
		if d.is_integer():
			break
		k+=1
		d=(k*phi_n+1)/e
#		print(k,d)
	return k

def find_k_abhijith(phi_n,e,d):
	return (d*e-1)/phi_n
def find_e(phi_n):
	e = random.randrange(59,200,2)
	while gcd(phi_n,e) != 1 :
		e = random.randrange(59,200,2)
	return e


p1,p2=random.choice(prime_list),random.choice(prime_list)
print("p1 = ",p1,"p2 = ",p2)
p1,p2=3,7

n = p1 * p2
print("n = "+str(n))
p1,p2=3,7
phi_n = (p1 - 1)*(p2 - 1)
print("phi_n = ",phi_n)

e = find_e(phi_n)
e=5
print("e = ",e)

k = find_k(phi_n,e)
print("k = ",k)

d = (k*phi_n+1)/e
print("d = ",d)



#print("n = "+str(n)+" , e = "+str(e)+" , phi("+str(n)+") = "+str(phi_n))

#print("k=",k,"d = ",d)

#print("e = ",e,"n = ",n)

