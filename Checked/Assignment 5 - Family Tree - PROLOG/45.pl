% Facts
male(ashok).
male(samir).
male(sachin).
male(atul).
male(amit).
male(abhijeet).
male(sujal).
male(om).
male(arham).
male(jay).
male(aditya).
male(rushabh).

female(nirmala).
female(rashmi).
female(rupali).
female(suwarna).
female(neha).
female(poonam).
female(jinal).
female(sakshi).
female(jiya).
female(urvi).

% Parent relations
parent(ashok,samir).
parent(ashok,sachin).
parent(ashok,atul).
parent(ashok,neha).
parent(samir,sujal).
parent(samir,jinal).
parent(sachin,om).
parent(sachin,sakshi).
parent(atul,aditya).
parent(atul,rushabh).
parent(amit,jay).
parent(amit,jiya).
parent(aditya,arham).
parent(abhijeet,urvi).
parent(nirmala,samir).
parent(nirmala,sachin).
parent(nirmala,atul).
parent(nirmala,neha).
parent(rashmi,sujal).
parent(rashmi,jinal).
parent(rupali,om).
parent(rupali,sakshi).
parent(suwarna,aditya).
parent(suwarna,rushabh).
parent(neha,jay).
parent(neha,jiya).
parent(poonam,arham).
parent(sakshi,urvi).

% Mother relation
mother(X,Y) :- parent(X,Y), female(X).

% Father relation
father(X,Y) :- parent(X,Y), male(X).

% Wife relation
wife(X,Y) :- female(X), male(Y), parent(X,Z), parent(Y,Z), X \= Y.

% Wife relation
husband(X,Y) :- male(X), female(Y), parent(X,Z), parent(Y,Z), X \= Y.

% Sibling relation
sibling(X,Y) :- parent(P,X), parent(P,Y),X \= Y.

% Grandfather relation
grandfather(X,Z) :- parent(X,Y), parent(Y,Z), male(X).

% Grandmother relation
grandmother(X,Z) :- parent(X,Y), parent(Y,Z), female(X).

% Uncle relation
uncle(X,Y) :- parent(P,Y), sibling(X,P), male(X).

% Cousin relation
cousin(X,Y) :- parent(P1,X), parent(P2,Y), sibling(P1,P2), X \= Y.

% Aunt relation
aunt(X,Y) :- parent(P,Y), sister(X,P).

% Sister relation
sister(X,Y) :- female(X), sibling(X,Y).

% Brother relation
brother(X,Y) :- male(X), sibling(X,Y).

% Father in law relation
fatherinlaw(X,Y) :- wife(Z,Y), father(X,Z),male(Y).

% Mother in law relation
motherinlaw(X,Y) :- wife(Z,Y), mother(X,Z),male(Y).

% Niece relation
niece(X,Y) :- female(X), mother(Z,X), sister(Z,Y).

% Nephew relation
nephew(X,Y) :- male(X), mother(Z,X), sister(Z,Y).

% Brother in law
brotherinlaw(X,Y) :- wife(Z,Y), brother(X,Z),male(Y).

% GreatGrandfather relation
greatgrandfather(W,Z) :- parent(W,X), parent(X,Y), parent(Y,Z), male(X).

% GreatGrandmother relation
greatgrandmother(W,Z) :- parent(W,X), parent(X,Y), parent(Y,Z), female(X).

% Grand Niece relation
grandniece(X,Y) :- female(X), grandfather(Z,X), sibling(Y,Z).

greatgrandson(W,Z):-male(W), parent(X,W), parent(Y,X), parent(Z,Y).

soninlaw(X,Z):-male(X), wife(Y,X), father(Z,Y).