male(sahil).
male(manoj).
male(shivam).
male(vasant).
male(sachin).
male(deepak).
male(yash).
male(sambhaji).
male(dashrat).
male(harsh).
male(aryan).
male(aditya).
male(vijay).
male(prathamesh).

female(sarika).
female(ujwala).
female(mandakini).
female(kaushalya).
female(monica).
female(rajashree).
female(asmita).
female(vaishnavi).
female(sangita).
female(divya).

parent(manoj, sahil).
parent(sarika, sahil).
parent(manoj, shivam).
parent(sarika, shivam).
parent(vasant, manoj).
parent(mandakini, manoj).
parent(vasant, ujwala).
parent(mandakini, ujwala).
parent(dashrat, sarika).
parent(kaushalya, sarika).
parent(dashrat, sachin).
parent(kaushalya, sachin).
parent(dashrat, deepak).
parent(kaushalya, deepak).
parent(sambhaji, yash).
parent(ujwala, yash).
parent(sambhaji,monica).
parent(ujwala, monica).
parent(deepak, harsh).
parent(rajashree, harsh).
parent(deepak, aryan).
parent(rajashree, aryan).
parent(sachin, aditya).
parent(asmita, aditya).
parent(sachin, vaishnavi).
parent(asmita, vaishnavi).
parent(vijay, prathamesh).
parent(sangita, prathamesh).
parent(vijay, divya).
parent(sangita, divya).
parent(dashrat, vijay).
parent(kaushalya, vijay).




married(manoj, sarika).
married(sambhaji, ujwala).
married(vasant, mandakini).
married(dashrat, kaushalya).
married(deepak, rajashree).
married(sachin, asmita).
married(vijay, sangita).



father(X, Y) :- parent(X, Y).
mother(X, Y) :- parent(X, Y).
grandparent(X, Y) :- parent(X, Z), parent(Z, Y).
grandparent_of(Person, Name) :- grandparent(Person, Name).
grandson(Name, Person) :- grandparent(Name, Person).
sibling(X, Y) :- parent(Z, X), parent(Z, Y), X \== Y.
cousin(X, Y) :- parent(Z, X), parent(W, Y), sibling(Z, W).
aunt_or_uncle(X, Y) :-parent(Z, Y),sibling(X, Z).
husband(X, Y) :- married(X, Y).
parent_of(Person, Parent) :- parent(Parent, Person).
son_of(Person, Son) :- parent(Person, Son), male(Son).
daughter_of(Person, Daughter) :- parent(Person, Daughter), female(Daughter).
nephew(X, Y) :- sibling(X, A), parent(A, Y).
cousin_in_law(X, Y) :- parent(Z, X), sibling(A, Z), female(A), husband(B, A),sibling(B, C), parent(C, Y). 
mother_in_law(X, Y) :- parent(X, A),female(X), female(A), married(Y, A).





