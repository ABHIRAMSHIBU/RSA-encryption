from bob import *
from alice import *
import math

m = 100008
c = encrypt_message(m,e,n)

print("m = ", m , "c = ", c )

import time
start_time = time.time()

dec = pow(c,int(d),n)
a=time.time() - start_time
print("time:",a)
print(dec)

