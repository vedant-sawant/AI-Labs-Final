% Facts: Define relationships in the family tree
male(chandrabhan).
male(suryabhan).
male(ashok).
male(bhimrao).
male(raju).
male(janardan).
male(goverdhan).
male(sumit).
male(aditya).
male(tejas).
male(amol).

female(shindu).
female(saraswati).
female(padma).
female(suman).
female(mahananda).
female(surekha).
female(ratna).
female(mohini).
female(samiksha).
female(pari).
female(ranu).
female(swati).
female(komal).
female(mamta).

parent(chandrabhan, suryabhan).
parent(chandrabhan, ashok).
parent(shindu, suryabhan).
parent(shindu, ashok).
parent(suryabhan, suman).
parent(suryabhan, mahananda).
parent(suryabhan, janardan).
parent(suryabhan, goverdhan).
parent(saraswati, suman).
parent(saraswati, mahananda).
parent(saraswati, janardan).
parent(saraswati, goverdhan).
parent(suman,samiksha).
parent(suman,sumit).
parent(bhimrao,samiksha).
parent(bhimrao,sumit).
parent(mahananda,pari).
parent(raju,pari).
parent(janardan,aditya).
parent(janardan,ranu).
parent(surekha,aditya).
parent(surekha,ranu).
parent(goverdhan,tejas).
parent(goverdhan,swati).
parent(goverdhan,komal).
parent(ratna,tejas).
parent(ratna,swati).
parent(ratna,komal).
parent(ashok,mohini).
parent(padma,mohini).
parent(mohini,mamta).
parent(amol,mamta).


father(X, Y) :- male(X), parent(X, Y).

mother(X, Y) :- female(X), parent(X, Y).

wife(X,Y) :- parent(X,Z),parent(Y,Z).

husband(X,Y) :- wife(Y,X). 

father_in_law(X, Y) :- male(X),female(Y),parent(Y,T),grandfather(X,T).

mother_in_law(X, Y) :- female(X),female(Y),parent(Y,T),grandmother(X,T).

brother_in_law(X, Y) :- husband(X, Z), sibling(Z, Y).

sister_in_law(X, Y) :- sibling(X, Z), wife(Z, Y).

cousin_in_law(X, Y) :- cousin(Z, X), wife(Y, Z).

son(X, Y) :- male(X), parent(Y, X).

daughter(X, Y) :- female(X), parent(Y, X).

grandfather(X, Z) :- father(X, Y), parent(Y, Z).

grandmother(X, Z) :- mother(X, Y), parent(Y, Z).

sibling(X, Y) :- parent(Z, X), parent(Z, Y), X \= Y.

cousin(X, Y) :- parent(Z, X), parent(W, Y), sibling(Z, W).

uncle(X, Y) :- parent(Z, Y), sibling(X, Z), male(X) ; parent(Z,Y), sibling(Z,W),husband(X,W),female(W),female(Z).

aunt(X, Y) :- cousin(Z, Y), mother(X, Z), female(X).

nephew(X,Y) :- uncle(Y,X),male(X).

neice(X,Y) :- aunt(Y,X),female(X).

second_uncle(X, Y) :-male(X),grandfather(W, Y), sibling(W,Z),son(X,Z).

second_aunt(X, Y) :-female(X),grandfather(W, Y), sibling(W,Z),grandfather(Z,D),mother(X,D).

second_cousin(X, Y) :- grandfather(W, Y), sibling(W,Z),grandfather(Z,X).

second_grandfather(X,Y) :- grandfather(W,Y),sibling(W,X).

second_grandmother(X,Y) :- second_uncle(W,Y),mother(X,W).

grandmother_in_law(X,Y) :- husband(X,Z), grandmother(Y,Z).

great_grandfather(X, Z) :- father(X, Y), grandfather(Y, Z).

great_grandmother(X, Z) :- mother(X, Y), grandfather(Y, Z).


% Your family relationships and rules here
find_relationship(X, Y) :-
    father(X, Y), write(X), write(' is the father of '), write(Y), nl.

find_relationship(X, Y) :-
    wife(X, Y), write(X), write(' is the wife of '), write(Y), nl.

find_relationship(X, Y) :-
    mother(X, Y), write(X), write(' is the mother of '), write(Y), nl.

find_relationship(X, Y) :-
    son(X, Y), write(X), write(' is the son of '), write(Y), nl.

find_relationship(X, Y) :-
    daughter(X, Y), write(X), write(' is the daughter of '), write(Y), nl.

find_relationship(X, Y) :-
    grandfather(X, Y), write(X), write(' is the grandfather of '), write(Y), nl.

find_relationship(X, Y) :-
    sibling(X, Y), write(X), write(' is the sibling of '), write(Y), nl.

find_relationship(X, Y) :-
    father(Z, Y), mother(X, Z), write(X), write(' is the grandmother of '), write(Y), nl.

find_relationship(X, Y) :-
    second_grandmother(X,Y), write(X), write(' is the second grandmother of '), write(Y), nl.

find_relationship(X, Y) :-
    second_grandfather(X,Y), write(X), write(' is the second grandfather of '), write(Y), nl. 

find_relationship(X, Y) :-
    second_uncle(X, Y), write(X), write(' is the second-uncle of '), write(Y), nl.

find_relationship(X, Y) :-
    second_aunt(X, Y), write(X), write(' is the second-aunt of '), write(Y), nl.

find_relationship(X, Y) :-
    uncle(X, Y), write(X), write(' is the uncle of '), write(Y), nl.

find_relationship(X, Y) :-
    aunt(X, Y), write(X), write(' is the aunt of '), write(Y), nl.

find_relationship(X, Y) :-
    cousin(X, Y), write(X), write(' is the cousin of '), write(Y), nl.

find_relationship(X, Y) :-
    second_cousin(X, Y), write(X), write(' is the second cousin of '), write(Y), nl.

find_relationship(X, Y) :-
    nephew(X, Y), write(X), write(' is the nephew of '), write(Y), nl.
find_relationship(X, Y) :-
    neice(X, Y), write(X), write(' is the neice of '), write(Y), nl.

find_relationship(X, Y) :-
    second_cousin(X, Y), write(X), write(' is the second cousin of '), write(Y), nl.

find_relationship(X, Y) :-
    father_in_law(X, Y), write(X), write(' is the father-in-law of '), write(Y), nl.

find_relationship(X, Y) :-
    mother_in_law(X, Y), write(X), write(' is the mother-in-law of '), write(Y), nl.

find_relationship(X, Y) :-
    brother_in_law(X, Y), write(Y), write(' is the brother-in-law of '), write(X), nl.

find_relationship(X, Y) :-
    cousin_in_law(X, Y), write(Y), write(' is the cousin-in-law of '), write(X), nl.

find_relationship(X, Y) :-
    grandmother_in_law(X, Y), write(Y), write(' is the grandmother_in_law of '), write(X), nl.

find_relationship(X, Y) :-
    sister_in_law(X, Y), write(Y), write(' is the sister-in-law of '), write(X), nl.

find_relationship(X, Y) :-
    great_grandfather(X, Y), write(X), write(' is the great-grandfather of '), write(Y), nl.

find_relationship(X, Y) :-
    great_grandmother(X, Y), write(X), write(' is the great-grandmother of '), write(Y), nl.    

find_relationship(X, Y) :- write('Relationship not defined between '), write(X), write(' and '), write(Y), nl.