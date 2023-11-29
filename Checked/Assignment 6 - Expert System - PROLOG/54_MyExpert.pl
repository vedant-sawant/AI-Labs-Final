location(sp_kingstown_hadapsar, apartment, one_cr, swimming_pool, hospitals, no, new).
location(magarpatta_city, penthouse, sixty_to_ninty_lakhs, backyard, school, yes, old).
location(dreams_nandini_kharadi, bunglow, two_cr, private_parking, park, yes, new).
location(dreams_avani_urli, apartment, one_and_half_cr, swimming_pool, school, no, new).
location(kumars_camp, row_house, two_and_half_cr, backyard, hospitals, yes, old).
location(joyville_katraj, apartment, one_cr, private_parking, hospitals, yes, old).
location(viva_sarovar, apartment, fifty_lakhs, swimming_pool, school, yes, new).
location(purandar_society_uk, row_house, sixty_lakhs, backyard, park, no, new).
location(karihma_glory_pimpri, apartment, seventy_lakhs, private_parking, park, yes, new).
location(green_acre_bibwewadi, apartment, thirty_lakhs, backyard, hospitals, yes, old).
 
identify_location(Property_type, Budget, Amenity, Local_services, Negotiable, Construction, Location) :-
    location(Location, Property_type, Budget, Amenity, Local_services, Negotiable, Construction),
    write('Based on your requirement, you should look for: '), write(Location), nl.

identify_location(_, _, _, _, _, _, _) :-
    write('No property identified based on your requirement'), nl.

start :-
    write('Welcome to the Expert Advisor!'), nl,
    write('Please answer the following ques to get a suggestion.'), nl,
    write('What type of property you are looking for (apartment, penthouse, bunglow, row_house)? '), read(Property_type), nl,
    write('What is your budget two_cr, sixty_to_ninty_lakhs, one_cr)? '), read(Budget), nl,
    write('Which amenity do you want to priorotize(swimming_pool, backyard, private_parking)?'), read(Amenity), nl,
    write('Any local servie you want nearby(hospitals, school, park)? '), read(Local_services), nl,
    write('Are you interested in negotiating(yes, no)? '), read(Negotiable), nl,
    write('Are you looking for New or Old construction? '), read(Construction), nl,
    identify_location(Property_type, Budget, Amenity, Local_services, Negotiable, Construction, Location).
