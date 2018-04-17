import pickle
def isprime(n):
	prime=True
	for i in range(2,int(n/2)+1):
#		print("iterating to check prime:",i,end="\r")
		if(n%i)==0:
			prime=False
			break
	return prime

f=open("prime.txt","a+")
def find_primes():
	prime_list=[]
	#change the range according to the length of the message send from client
	limit1=0
	limit2=100000000000000
	for i in range(limit1,limit2):
		print("checking for "+str(i),end="\r")
		if(isprime(i)):
			prime_list.append(i)		
			f.write(str(i)+"\n")
find_primes()
