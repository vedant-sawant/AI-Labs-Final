% My family tree

% Facts
male(yashwant).
male(vishwas).
male(deepak).
male(arun).
male(nandkumar).
male(aditya).
male(vishal).

female(puja).
female(vimal).
female(vaishali).
female(nilima).
female(manisha).
female(prarthana).
female(saukhya).
female(sakshi).
female(samruddhi).

parent(vishwas,deepak).
parent(yashwant,vishwas).
parent(puja,vishwas).
parent(vishwas,arun ).
parent(vishwas, nandkumar).
parent(vimal, deepak).
parent(vimal,arun ).
parent(vimal, nandkumar).


parent(deepak,vishal).
parent(deepak,aditya).
parent(vaishali,vishal).
parent(vaishali,aditya).

parent(arun,sakshi).
parent(arun,samruddhi).
parent(nilima,sakshi).
parent(nilima,samruddhi).

parent(nandkumar,prarthana).
parent(nandkumar,saukhya).
parent(manisha,prarthana).
parent(manisha,prarthana).


% Rules
sibling(X, Y) :- parent(Z, X), parent(Z, Y), X \= Y.
grandparent(X, Z) :- parent(X, Y), parent(Y, Z).
mother(X,Y) :- parent(X,Y), female(X).
father(X,Y) :- parent(X,Y), male(X).
uncle(X,Y) :- sibling(X,P), parent(P,Y).
cousin(X,Y) :- father(P,X), uncle(P,Y).
aunt(X,Y) :- cousin(Y,Z), mother(X,Z).
sister(X,Y) :- female(X),parent(P,X), parent(P,Y).
brother(X,Y) :-male(X), parent(P,X), parent(P,Y).






