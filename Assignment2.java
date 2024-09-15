package security;
import java.util.*;
import java.util.Scanner;
import java.math.*;


public class Assignment2 
{

public static void main(String[] args) 
{
BigInteger p, g, a, b, A, B, Ka, Kb;
Random number = new Random();
Scanner input = new Scanner(System.in);
int bitSize;

System.out.print("Enter size of p: ");
bitSize = input.nextInt();

p = BigInteger.probablePrime(bitSize, number); //generates a prime value using the chosen bit length
g = new BigInteger(p.bitLength(), number); //generates a random value between 1 and p


while (p.compareTo(g) != 1 || g.equals(BigInteger.ONE) || g.equals(BigInteger.ZERO)) //checks to see if g is less than p, equal to 1 or 0
{
g = new BigInteger(p.bitLength(), number); //if it is, then it keeps generating g until it is greater

}

a = new BigInteger(p.subtract(BigInteger.ONE).bitLength(), number); //generates random a value between 1 and p - 1
b = new BigInteger(p.subtract(BigInteger.ONE).bitLength(), number); //generates random b value between 1 and p - 1

while (p.compareTo(a) != 1 || a.equals(BigInteger.ZERO)) //loop to keep a under p and over zero
{
a = new BigInteger(p.bitLength(), number);
}

while (p.compareTo(b) != 1 || b.equals(BigInteger.ZERO)) //loop to keep b under p and over zero
{
b = new BigInteger(p.bitLength(), number);
}

A = g.modPow(a, p); //Key generated by Alice and sent to Bob. G^a
B = g.modPow(b, p); //Key generated by Bob and sent to Alice. G^b

Ka = B.modPow(a, p); //Secret key generated by Alice. using Bob's Public key B. B^a or (G^b)^a
Kb = A.modPow(b, p); //Secret key generated by Bob. using Alice's Public key A. A^b or (G^a)^b

System.out.println("The value of p selected: " + p);
System.out.println("The value of g selected: " + g);
System.out.println("The value of a selected by Alice: " + a);
System.out.println("The value of b selected by Bob:   " + b);
System.out.println("The value of A sent to Bob by Alice: " + A);
System.out.println("The value of B sent to Alice by Bob: " + B);
System.out.println("The value of shared Key computed by Alice: " + Ka);
System.out.println("The value of shared Key computed by Bob  : " + Kb);
}



}
