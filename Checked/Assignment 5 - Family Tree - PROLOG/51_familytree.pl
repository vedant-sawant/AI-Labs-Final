% Facts: Define relationships in the family tree
male(govind).
male(sitaram).
male(virendra).
male(umesh).
male(ashok).
male(vijay).
male(ginandev).
male(raghav).
male(mahindra).
male(krishna).
male(vivek).
male(jitesh).
male(ashish).
male(karan).


female(mira).
female(rajkuar).
female(asha).
female(smita).
female(ranjana).
female(mohini).
female(jyoti).
female(prajakta).
female(vaishnavi).
female(tanmayee).
female(gauri).
female(neha).
female(sadhna).
female(punam).
female(aradhya).
female(gita).
female(riddhi).

parent(govind,sitaram).
parent(govind,virendra).
parent(mira,sitaram).
parent(mira,virendra).
parent(sitaram,umesh).
parent(sitaram,ashok).
parent(sitaram,vijay).
parent(sitaram,ginandev).
parent(rajkuar,umesh).
parent(rajkuar,ashok).
parent(rajkuar,vijay).
parent(rajkuar,ginandev).
parent(umesh,raghav).
parent(smita,raghav).
parent(ashok,prajakta).
parent(ashok,vaishnavi).
parent(ashok,mahindra).
parent(ranjana,prajakta).
parent(ranjana,vaishnavi).
parent(ranjana,mahindra).
parent(vijay,tanmayee).
parent(mohini,tanmayee).
parent(ginandev,gauri).
parent(ginandev,krishna).
parent(jyoti,gauri).
parent(jyoti,krishna).
parent(virendra,vivek).
parent(virendra,sadhna).
parent(virendra,punam).
parent(asha,vivek).
parent(asha,sadhna).
parent(asha,punam).
parent(vivek,aradhya).
parent(neha,aradhya).
parent(jitesh,gita).
parent(sadhna,gita).
parent(jitesh,riddhi).
parent(sadhna,riddhi).
parent(ashish,karan).
parent(punam,karan).

father(X, Y) :- male(X), parent(X, Y).

mother(X, Y) :- female(X), parent(X, Y).

wife(X,Y) :- parent(X,Z), parent(Y,Z).

father_in_law(X, Y) :- male(X),female(Y),parent(Y,T),grandfather(X,T).

secondfather_in_law(X, Y) :- male(X), father_in_law(Z, Y), sibling(X, Z).

mother_in_law(X, Y) :- female(X),female(Y),parent(Y,T),grandmother(X,T).

secondmother_in_law(X, Y) :- female(X),female(Y),mother_in_law(Z, Y), sister_in_law(Z, X).

son_in_law(X, Y) :- male(X), wife(Z, X), father(Y, Z).

son(X, Y) :- male(X), parent(Y, X).

daughter(X, Y) :- female(X), parent(Y, X).

grandfather(X, Z) :- father(X, Y), parent(Y, Z).

brother_in_law(X,Y) :- male(W),male(X),sibling(X,W),father(W,T),mother(Y,T).

brother_in_law2(X,Y) :- male(X), male(Y), sibling(Z, X), wife(Z, Y).

sister_in_law(X,Y) :- mother(X,W),cousin(W,T),mother(Y,T).

grandmother(X, Z) :- mother(X, Y), parent(Y, Z).

sibling(X, Y) :- parent(Z, X), parent(Z, Y), X \= Y.

cousin(X, Y) :- parent(Z, X), parent(W, Y), sibling(Z, W).

uncle(X, Y) :- parent(Z, Y), sibling(X, Z), male(X).

aunt(X, Y) :- cousin(Z, Y), mother(X, Z), female(X).

second_uncle(X, Y) :-male(X),grandfather(W, Y), sibling(W,Z),father(Z,X);son_in_law(X, Z).

second_aunt(X, Y) :-female(X),grandfather(W, Y), sibling(W,Z),grandfather(Z,D),mother(X,D).

second_cousin(X, Y) :- grandfather(W, Y), sibling(Z,W),grandfather(Z,X).

second_grandfather(X,Y) :- grandfather(W,Y),sibling(W,X).

second_grandmother(X,Y) :- second_uncle(W,Y),mother(X,W).

great_grandfather(X, Z) :- father(X, Y), grandfather(Y, Z).

great_grandmother(X, Z) :- mother(X, Y), grandfather(Y, Z).

great_grandmother_in_law(X, Y) :- mother(Y,Z), great_grandmother(X, Z).

great_grandfather_in_law(X, Y) :- mother(Y, Z), great_grandfather(X, Z).

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
    sister_in_law(X, Y), write(X), write(' is the sister in law of '), write(Y), nl.

find_relationship(X, Y) :-
    brother_in_law(X, Y), write(X), write(' is the brother_in_law of '), write(Y), nl.

find_relationship(X, Y) :-
    brother_in_law2(X, Y), write(X), write(' is the brother_in_law of '), write(Y), nl.

find_relationship(X, Y) :-
    son_in_law(X, Y), write(X), write(' is the son_in_law of '), write(Y), nl.

find_relationship(X, Y) :-
    second_cousin(X, Y), write(X), write(' is the second cousin of '), write(Y), nl.

find_relationship(X, Y) :-
    father_in_law(X, Y), write(X), write(' is the father-in-law of '), write(Y), nl.

find_relationship(X, Y) :-
    secondfather_in_law(X, Y), write(X), write(' is the secondfather-in-law of '), write(Y), nl.

find_relationship(X, Y) :-
    mother_in_law(X, Y), write(X), write(' is the mother-in-law of '), write(Y), nl.

find_relationship(X, Y) :-
    secondmother_in_law(X, Y), write(X), write(' is the secondmother-in-law of '), write(Y), nl.

find_relationship(X, Y) :-
    great_grandfather(X, Y), write(X), write(' is the great-grandfather of '), write(Y), nl.

find_relationship(X, Y) :-
    great_grandmother(X, Y), write(X), write(' is the great-grandmother of '), write(Y), nl.

find_relationship(X, Y) :-
    great_grandmother_in_law(X, Y), write(X), write(' is the great-grandmother in law of '), write(Y), nl.

find_relationship(X, Y) :-
    great_grandfather_in_law(X, Y), write(X), write(' is the great-grandfather in law of '), write(Y), nl.

find_relationship(X, Y) :- write('Relationship not defined between '), write(X), write(' and '), write(Y), nl.
