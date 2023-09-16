def compute(n):
    if n < 10:
        out = n ** 2
    elif n < 20:
        out = 1
         #changed (n - 10) => (n - 9) because this value is exclusive in python 
         # for n = 15 we (n - 10) which includes 5 but when we write (n - 10) it will exclude 5 also and goes till 4 only.
        for i in range(1, n-9):
            out *= i
    else:
        lim = n - 20
        out = lim * lim
        out = out + lim # sum of numbers from 1 to n = n (n + 1) / 2 = ((n * n) + n) / 2 so changed (out - lim) => out + lim
        out = out / 2 
    print(out)


n = int(input("Enter an integer: "))
compute(n)