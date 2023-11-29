start :- hypothesize(Crop),
      write('I Suggest the Crop to grow: '),
      write(Crop), nl, undo.

hypothesize(wheat) :- wheat, !.
hypothesize(maize) :- maize, !.
hypothesize(rice) :- rice, !.
hypothesize(soybean) :- soybean, !.
hypothesize(cotton) :- cotton, !.
hypothesize(coffee) :- coffee, !.
hypothesize(sugercane) :- sugercane, !.
hypothesize(unknown).


wheat :- verify(has_temperature_moderate_climate), verify(have_pervious_crops_Legumes_Crops_Fallow_Crops_Root_Crops_And_Forage_Crops), verify(land_is_located_in_north_india), verify(has_loamy_soil), verify(has_rainfall_level_above_300mm).
coffee :- verify(has_temperature_moderate_climate), verify(have_pervious_crops_Legumes_Crops_Fallow_Crops_Root_Crops_And_Forage_Crops), verify(has_altitude_ranging_from_600_to_2000), verify(has_rainfall_level_above_1500mm).
rice :- verify(has_temperature_moderate_climate), verify(has_abundant_water_supply), verify(has_good_water_retention_capacity).
sugercane :- verify(has_temperature_average_25C),verify(has_pervious_crop_Cereals_Cover_Crops_Vegetables_And_Legumes_Crops), verify(has_loamy_soil), verify(has_rainfall_level_above_300mm).
maize :- verify(has_temperature_average_25C), verify(soil_has_well_drainage_and_adequate_fertility), verify(has_rainfall_level_above_500mm).
soybean :- verify(has_pervious_crop_Grains_Corn_Cover_Crops_And_Legumes_Crops), verify(has_soil_ph_6_to_7).
cotton :- verify(has_loamy_soil), verify(has_rainfall_level_above_300mm).

ask(Question) :- write('Does the land have the following attribute: '), write(Question), write('? '), read(Response), nl, ( (Response == yes ; Response == y) -> assert(yes(Question)) ; assert(no(Question)), fail).

:- dynamic yes/1, no/1.

verify(S) :- (yes(S) -> true ; (no(S) -> fail ; ask(S))).

undo :- retract(yes(_)), fail.
undo :- retract(no(_)), fail.
undo.
