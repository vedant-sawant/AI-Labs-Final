/* 
    Title: Family Tree 
    Language: Prolog
    Name: Vedant Sawant
    Roll Number: 68
    Batch: D2
*/
Male(devram).
male(ashok).
male(ram).
male(shreyash).
male(sagar).
male(rushi).
male(mahendra).
male(satya).
male(raghav).
male(sahil).
male(narendra).
male(rahul).
male(sohan).
male(vedant).

female(sanchitee).
female(vidya).
female(tejal).
female(neeta).
female(rani).
female(aasha).
female(prachi).
female(era).
female(rucha).
female(karishma).
female(nikita).
female(esha).
female(era).
female(karishma).

wife(sanchitee,devram).
wife(vidya,ashok).
wife(tejal,ram).
wife(neeta,shreyash).
wife(rani,sagar).
wife(aasha,rushi).
wife(aaditi,mahendra).
wife(saraswati,satya).
wife(nikita,raghav).
wife(esha,narendra).
wife(prachi,sohan).

parent(devram,ashok).
parent(sanchitee,ashok).
parent(devram,ram).
parent(sanchitee,ram).
parent(ashok,shreyash).
parent(vidya,shreyash).
parent(ashok,sagar).
parent(vidya,sagar).
parent(ashok,rushi).
parent(vidya,rushi).
parent(ram,aaditi).
parent(tejal,aaditi).
parent(ram,satya).
parent(tejal,satya).
parent(aaditi,narendra).
parent(aaditi,rahul).
parent(satya,sohan).
parent(saraswati,sohan).
parent(shreyash,raghav).
parent(neeta,raghav).
parent(sagar,sahil).
parent(rani,sahil).
parent(raghav,karishma).
parent(nikita,karishma).
parent(narendra,era).
parent(esha,era).
parent(mahendra,rahul).
parent(sohan,vedant).
parent(sohan,rucha).
parent(prachi,vedant).
parent(prachi,rucha).


mother(X,Y):- female(X),parent(X,Y).
father(X,Y):-male(X),parent(X,Y).
sibling(X,Y) :- parent(Z, X), parent(Z, Y), X \= Y.
grandparent(X,Z):- parent(Y,Z), parent(X,Y).
sgrandparent(X,Z):-parent(Y,Z),parent(W,Y),sibling(W,X);parent(P,Z),parent(Q,P),cousin(Q,X).
greatgrandfather(X,Y):- male(X),grandparent(_,Y).
cousin(X,Y) :- father(P,X), uncle(P,Y).
uncle(X,Y) :- male(X),sibling(X,P), parent(P,Y);cousin(X,P),parent(P,Y);aunt(X,A),wife(A,Y).
aunt(X,Y) :- female(X),cousin(Y,Z), mother(X,Z);cousin(X,Z),parent(Z,Y).
soninlaw(X,Y):-male(X),wife(A,X),parent(Y,A).
grandsoninlaw(X,Y):-wife(P,X),male(X),parent(Q,P),parent(Y,Q).
daughterinlaw(X,Y):-female(X),wife(X,A),parent(Y,A).
sister(X,Y) :- female(X),parent(P,X), parent(P,Y).
brother(X,Y) :-male(X), parent(P,X),parent(P,Y).
niece(X, Y) :- female(X), parent(Z, X), sibling(Z, Y);female(X), parent(Z, X), cousin(Z,Y).
nephew(X,Y):-male(X),parent(Z,X),sibling(Z,Y);male(X),parent(Z,X),cousin(Z,Y).
sisterinlaw(X,Y):- female(X),wife(X,Z),sibling(Z,Y);female(X),wife(X,Z),cousin(Z,Y).







