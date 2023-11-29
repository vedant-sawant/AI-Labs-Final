% Define the main interaction loop.
start :-
    writeln('Amazon Help Message. what can I help you with?'),
    provide_assistance_options.

% Provide assistance options.
provide_assistance_options :-
    writeln('Please choose a category of assistance:'),
    writeln('1. An item I ordered'),
    writeln('2. Questions not related to an ordered item'),
    writeln('3. Managing my account, Prime, or gift cards'),
    writeln('4. Help with a Kindle, Fire, or Amazon device'),
    writeln('5. Prime Music, eBooks, Prime Videos, etc.'),
    read(UserChoice),
    handle_assistance_choice(UserChoice).

% Handle the user's choice for assistance.
handle_assistance_choice(1) :-
    writeln('Let\'s see. Could you select the item you\'re looking for from your recent orders below?'),
    writeln('Choose an item:'),
    writeln('1. Simple Kind to Skin Refreshing Facial Foam with Brush| For all Skin Types| No Soap| No Perfume| No Harsh Chemicals & Parabens| Tested on Sensitive Skin (Delivered on October 21)'),
    writeln('2. crocs Unisex Adult Baya White Clog-4 Men/ 5 UK Women (Delivered on October 13)'),
    writeln('3. crocs unisex-adult Bayaband Clog LIGHT GREY/CANDY PINK Clog - 3 UK Men/ 4 UK Women (Delivered on October 12)'),
    writeln('4. JB SUPER Bass Portable Wireless Bluetooth Speaker JB TG113 with Aux Cable 10W with Built-in mic, TF Card Slot, USB Port - Multi Color (Delivered on October 12)'),
    writeln('5. Sebamed Clear Face Cleansing Foam for Acne prone Skin (Delivered on October 12)'),
    read(ItemChoice),
    provide_order_item_details(ItemChoice).

% START for 1st menu option 2 %
handle_assistance_choice(2) :-
    writeln('OK, what can I help you with today?'),
    writeln('1. Invoice and warranty'),
    writeln('2. Account security and KYC'),
    writeln('3. Deals, cashbacks, and offers'),
    provide_non_order_item_assistance_options.

provide_non_order_item_assistance_options :-
    writeln('What are you looking for?'),
    read(UserChoice),
    handle_non_order_item_option(UserChoice).

handle_non_order_item_option(ItemChoice) :-
    ItemChoice == 1,
    writeln('You selected "Invoice and warranty."'),
    writeln('Products sold on Amazon.in come with the same warranty as provided by the manufacturer'),
	writeln('Just visit the product page, and look for the warranty information icon.'),
	abort.

:- discontiguous handle_non_order_item_option/1.
handle_non_order_item_option(ItemChoice) :-
    ItemChoice == 2,
    writeln('You selected "Account security and KYC."'),
    writeln('Amazon takes account security seriously, implementing multiple layers of protection such as '),
	writeln('two-factor authentication and continuous monitoring to safeguard customer information. Know Your Customer (KYC) procedures are in place to verify the identity of users, ensuring a secure and trusted online shopping experience.').
	
% for 1st menu option 2 %
:- discontiguous handle_non_order_item_option/1.
handle_non_order_item_option(ItemChoice) :-
    ItemChoice == 3,
    writeln('You selected "Deals, cashbacks, and offers"'),
	writeln('The Amazon Great Indian Sale is currently live, offering incredible deals, substantial cashbacks, and irresistible of'),
	writeln('miss out on this limited-time opportunity to save up to 30% on a wide range of products.'), 
    writeln('Shop through Amazons dedicated page now and enjoy the discounts while they last! Hurry up!').
	
% END for 1st menu option 2 %

% START for 1st menu option 3 %
:- discontiguous handle_assistance_choice/1.
 handle_assistance_choice(3) :-
 writeln('Easily manage your Amazon account, Prime membership, and gift cards by simply clicking'),
 writeln('the Manage Account button. This convenient feature provides quick access to all your account-related needs in one place.').
 
% END for 1st menu option 3 %

% START for 1st menu option 4 %
 handle_assistance_choice(4) :-
writeln('OK, you can chat with an agent now or request a call back through our contact us page'),
writeln('You can also go to your Customer Service Hub to fix most things or to search help pages.').
% END for 1st menu option 4 %

% START for 1st menu option 5 %
handle_assistance_choice(5) :-
    writeln('We have a dedicated team for managing Prime. Is your registered mobile number: +91 8726364527? (yes/no)'),
    read(RegisteredMobileResponse),
    handle_registered_mobile_response(RegisteredMobileResponse).

handle_registered_mobile_response(yes) :-
    writeln('Thank you for confirming. Our team will call you for Prime queries on your registered mobile number.').
handle_registered_mobile_response(no) :-
    writeln('If you have any Prime-related queries, please contact our dedicated Prime support team.').
handle_registered_mobile_response(_) :-
    writeln('Please respond with "yes" or "no" to confirm your registered mobile number.').
                                                                                                                             
% END for 1st menu option 5 % 

                                                                                                                             % Provide details of the selected order item.
:- discontiguous provide_order_item_assistance_options/0. % Suppress the warning message
:- discontiguous provide_order_item_details/1.
provide_order_item_details(ItemChoice) :-
    ItemChoice == 1,
    writeln('You selected "Simple Kind to Skin Refreshing Facial Foam."'),
    writeln('Looks like this item was delivered on Sunday, 22 Oct.'),
    provide_order_item_assistance_options.
provide_order_item_details(ItemChoice) :-
    ItemChoice == 2,
    writeln('You selected "crocs Unisex Adult Baya White Clog-4 Men/ 5 UK Women."'),
    writeln('Looks like this item was delivered on Sunday, 22 Oct.'),
    provide_order_item_assistance_options.
provide_order_item_details(ItemChoice) :-
    ItemChoice == 3,
    writeln('You selected "crocs unisex-adult Bayaband Clog." How can I assist you with this item?'),
    provide_order_item_assistance_options.
provide_order_item_details(ItemChoice) :-
    ItemChoice == 4,
    writeln('You selected "JB SUPER Bass Portable Wireless Bluetooth Speaker JB TG113." How can I assist you with this item?'),
    provide_order_item_assistance_options.
provide_order_item_details(ItemChoice) :-
    ItemChoice == 5,
    writeln('You selected "Sebamed Clear Face Cleansing Foam." How can I assist you with this item?'),
    provide_order_item_assistance_options.

provide_order_item_assistance_options :-
    writeln('How can I help you with this item?'),
    writeln('1. Return or exchange item'),
    writeln('2. Didnt get it'),
    writeln('3. Need details of cashback/rewards'),
    writeln('4. No, Im all set'),
    read(OrderItemOption),
    handle_order_item_option(OrderItemOption).

handle_order_item_option(1) :-
    writeln('You selected "Return or exchange item." kindly head over to Return Section in amazon app').
	:- discontiguous handle_order_item_option/1.
handle_order_item_option(2) :-
    writeln('You selected "Didn’t get it."'),
    writeln('We have a dedicated team to solve your issue. Is your registered mobile number: +91 8726364527? (yes/no)'),
    read(RegisteredMobileResponse),
    handle_registered_mobile_response(RegisteredMobileResponse).
	
handle_order_item_option(3) :-
    writeln('You selected "Need details of cashback/rewards."'),
	writeln('The Amazon Great Indian Sale is currently live, offering incredible deals, substantial cashbacks, and irresistible offers. Dont miss out on this limited-time opportunity to save up to 30 percent on a wide range of products. Shop through Amazons dedicated help page now and enjoy the discounts while they last! Hurry up!').
handle_order_item_option(4) :-
    writeln('Okay, let me know if you need further assistance. Have a great day!').

% Start the expert system.
:- start.

:-abort.
halt.



