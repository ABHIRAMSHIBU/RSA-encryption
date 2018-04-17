import random
from math import gcd



def find_k(phi_n,e):
	k=2
	d=(k*phi_n+1)/e
	while True:
		if d.is_integer():
			break
		k+=1
		d=(k*phi_n+1)/e
	return k

def find_e(phi_n):
	e = random.randrange(59,200,2)
	while gcd(phi_n,e) != 1 :
		e = random.randrange(59,200,2)
	return e



