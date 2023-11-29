% Facts:
male(trimbak).
male(ambadas).
male(murlidhar).
male(anil).
male(sunil).
male(sandip).
male(ram).
male(ashok).
male(aniket).
male(nikhil).
male(gaurav).
female(prayaga).
female(kalawati).
female(seema).
female(sunita).
female(jyoti).
female(meera).
female(manisha).
female(rupali).
female(shweta).
female(vaishnavi).
female(prerana).
female(anushka).
female(arushi).
female(arohi).

parent(trimbak, ambadas).
parent(trimbak, murlidhar).
parent(ambadas, anil).
parent(ambadas, sunil).
parent(ambadas, sandip).
parent(prayaga, anil).
parent(prayaga, sunil).
parent(prayaga, sandip).
parent(murlidhar, meera).
parent(murlidhar, ram).
parent(murlidhar, ashok).
parent(kalawati, meera).
parent(kalawati, ram).
parent(kalawati, ashok).
parent(anil, aniket).
parent(anil, vaishnavi).
parent(seema, aniket).
parent(seema, vaishnavi).
parent(sunil, nikhil).
parent(sunil, prerana).
parent(sunita, nikhil).
parent(sunita, prerana).
parent(ram, shweta).
parent(ram, gaurav).
parent(manisha, shweta).
parent(manisha, gaurav).
parent(ashok, anushka).
parent(ashok, arushi).
parent(ashok, arohi).
parent(rupali, anushka).
parent(rupali, arushi).
parent(rupali, arohi).

husband(ambadas, prayaga).
husband(murlidhar, kalawati).
husband(anil, seema).
husband(sunil, sunita).
husband(ram, manisha).
husband(ashok, rupali).

% Rules:
father(X, Y) :- male(X), parent(X, Y).
mother(X, Y) :- female(X), parent(X, Y).

son(X, Y) :- male(X), parent(Y, X).
daughter(X, Y) :- female(X), parent(Y, X).

wife(X, Y) :- husband(Y, X).

grandfather(X, Z) :- father(X, Y), parent(Y, Z).
grandmother(X, Z) :- mother(X, Y), parent(Y, Z).

sibling(X, Y) :- parent(Z, X), parent(Z, Y), X \= Y.
cousin(X, Y) :- parent(Z, X), parent(W, Y), sibling(Z, W).

uncle(X, Y) :- parent(Z, Y), sibling(X, Z), male(X).
%aunt(X, Y) :- cousin(Z, Y), mother(X, Z), female(X).
aunt(X,Y):- father(Z,Y),sibling(Z,X).

brother_in_law(X, Y) :- husband(X, Z), sibling(Z, Y).
sister_in_law(X, Y) :- husband(X, Z), sibling(Z, W), wife(W, Y).
cousin_in_law(X, Y) :- cousin(X, Z), wife(Y, Z).

father_in_law(X, Y) :- husband(X, Z), father(Z, Y).
mother_in_law(X, Y) :- husband(X, Z), mother(Z, Y).
uncle_in_law(X, Y) :- husband(X, Z), uncle(Z, Y).
aunt_in_law(X, Y) :- husband(X, Z), aunt(Z, Y).

grandfather_in_law(X, Y) :- husband(X, Z), grandfather(Z, Y).

great_uncle(X, Y) :- uncle(X, Z), parent(Z, Y).
great_aunt(X, Y) :- aunt(X, Z), parent(Z, Y).

second_cousin(X, Y) :- grandfather(Z, X), grandfather(W,Y),sibling(W, Z).
paternal_cousin(X, Y) :- grandfather(Z, Y), father(W, X), sibling(Z, W).

great_grandfather(X, Z) :- father(X, Y), grandfather(Y, Z).

find_relationship(X, Y) :-
    father(X, Y), write(X), write(' is the father of '), write(Y), nl.
find_relationship(X, Y) :-
    mother(X, Y), write(X), write(' is the mother of '), write(Y), nl.
find_relationship(X, Y) :-
    son(X, Y), write(X), write(' is the son of '), write(Y), nl.
find_relationship(X, Y) :-
    daughter(X, Y), write(X), write(' is the daughter of '), write(Y), nl.
find_relationship(X, Y) :-
    husband(X, Y), write(X), write(' is the husband of '), write(Y), nl.
find_relationship(X, Y) :-
    wife(X, Y), write(X), write(' is the wife of '), write(Y), nl.
find_relationship(X, Y) :-
    grandfather(X, Y), write(X), write(' is the grandfather of '), write(Y), nl.
find_relationship(X, Y) :-
    sibling(X, Y), write(X), write(' is the sibling of '), write(Y), nl.
find_relationship(X, Y) :-
    father(Z, Y), mother(X, Z), write(X), write(' is the grandmother of '), write(Y), nl.
find_relationship(X, Y) :-
    father_in_law(X, Y), write(X), write(' is the father-in-law of '), write(Y), nl.
find_relationship(X, Y) :-
    mother_in_law(X, Y), write(X), write(' is the mother-in-law of '), write(Y), nl.
find_relationship(X, Y) :-
    brother_in_law(X, Y), write(X), write(' is the brother-in-law of '), write(Y), nl.
find_relationship(X, Y) :-
    sister_in_law(X, Y), write(X), write(' is the sister-in-law of '), write(Y), nl.
find_relationship(X, Y) :-
    cousin_in_law(X, Y), write(X), write(' is the cousin-in-law of '), write(Y), nl.
find_relationship(X, Y) :-
    uncle_in_law(X, Y), write(X), write(' is the uncle-in-law of '), write(Y), nl.
find_relationship(X, Y) :-
    aunt_in_law(X, Y), write(X), write(' is the aunt-in-law of '), write(Y), nl.
find_relationship(X, Y) :-
    grandfather_in_law(X, Y), write(X), write(' is the grandfather-in-law of '), write(Y), nl.
find_relationship(X, Y) :-
    great_uncle(X, Y), write(X), write(' is the great-uncle of '), write(Y), nl.
find_relationship(X, Y) :-
    great_aunt(X, Y), write(X), write(' is the great-aunt of '), write(Y), nl.
find_relationship(X, Y) :-
    uncle(X, Y), write(X), write(' is the uncle of '), write(Y), nl.
find_relationship(X, Y) :-
    aunt(X, Y), write(X), write(' is the aunt of '), write(Y), nl.
find_relationship(X, Y) :-
    cousin(X, Y), write(X), write(' is the cousin of '), write(Y), nl.
find_relationship(X, Y) :-
    second_cousin(X, Y), write(X), write(' is the second cousin of '), write(Y), nl.
find_relationship(X, Y) :-
    paternal_cousin(X, Y), write(X), write(' is the paternal cousin of '), write(Y), nl.
find_relationship(X, Y) :-
    great_grandfather(X, Y), write(X), write(' is the great-grandfather of '), write(Y), nl.
find_relationship(X, Y) :- write('Relationship not defined between '), write(X), write(' and '), write(Y), nl.
