% Define job options and their attributes.
job_option(programmer, it, high_salary, permanent, office, 5, 80000, full_time, yes, no, yes, english).
job_option(marketing_manager, marketing, high_salary, permanent, office, 8, 90000, full_time, no, yes, yes, english).
job_option(teacher, education, moderate_salary, permanent, office, 3, 50000, full_time, yes, no, no, english).
job_option(freelancer, self_employed, variable_income, contract, remote, 2, 60000, full_time, no, yes, no, english).
job_option(data_analyst, it, moderate_salary, permanent, office, 4, 70000, full_time, no, yes, no, english).
job_option(nurse, healthcare, moderate_salary, permanent, office, 3, 55000, full_time, yes, no, no, english).
job_option(web_developer, it, moderate_salary, permanent, office, 2, 65000, full_time, no, yes, no, english).
job_option(content_writer, media, low_salary, permanent, office, 1, 45000, full_time, no, no, no, english).
job_option(chef, culinary, moderate_salary, permanent, office, 5, 60000, full_time, no, no, no, english).
job_option(graphic_designer, design, moderate_salary, permanent, office, 3, 55000, full_time, no, no, no, english).
job_option(accountant, finance, moderate_salary, permanent, office, 4, 70000, full_time, yes, no, no, english).

% Define rules to recommend job options based on user preferences.
recommend_job(User, JobOption) :-
    ask_job_preferences(User, Field, SalaryExpectation, JobType, WorkLocation, Experience, AnnualSalary, WorkHours, Certifications, Relocation, Management, LanguageSkills),
    job_option(JobOption, Field, SalaryExpectation, JobType, WorkLocation, MinExperience, MinSalary, WorkHours, Certifications, Relocation, Management, LanguageSkills),
    Experience >= MinExperience,
    AnnualSalary >= MinSalary,
    display_job_attributes(JobOption).

% Display the recommended job and its attributes.
display_job_attributes(JobOption) :-
    job_option(JobOption, Field, _, _, WorkLocation, _, _, _, _, _, _, _),
    write('Congratulations, we have a job recommendation based on your preferences:'), nl,
    write('Job Title: '), write(JobOption), nl,
    write('Field: '), write(Field), nl,
    write('Work Location: '), write(WorkLocation), nl.

% Ask the user about their job preferences.
ask_job_preferences(User, Field, SalaryExpectation, JobType, WorkLocation, Experience, AnnualSalary, WorkHours, Certifications, Relocation, Management, LanguageSkills) :-
    write('Hello, '), write(User), write('! Please answer the following questions:'), nl,
    write('1. What field are you interested in? (it/marketing/education/self_employed/healthcare/culinary/design/finance)'),
    read(Field),
    write('2. What is your salary expectation? (low_salary/moderate_salary/high_salary)'),
    read(SalaryExpectation),
    write('3. What type of job are you looking for? (permanent/contract)'),
    read(JobType),
    write('4. Where would you prefer to work? (office/remote)'),
    read(WorkLocation),
    write('5. How many years of experience do you have?'),
    read(Experience),
    write('6. What is your desired annual salary?'),
    read(AnnualSalary),
    write('7. What are your preferred work hours? (full_time/part_time)'),
    read(WorkHours),
    write('8. Do you have any specific certifications? (yes/no)'),
    read(Certifications),
    write('9. Are you open to relocation? (yes/no)'),
    read(Relocation),
    write('10. Are you interested in management roles? (yes/no)'),
    read(Management),
    write('11. What are your language skills? (english/spanish/french/other)'),
    read(LanguageSkills).
