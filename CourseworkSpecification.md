# Coursework Specification

## Project Overview 
Software Engineering Project for SET08103 - Software Engineering Methods. 

The system will provide an organisation with an easy to use way of accessing and reporting population information from the provided World database.

We will develop the project in a scrum team, following the software engineering practices we will learn throughout the module, including:

- Scrum & Iterative Development 
- User Stories and Use Case
- GitFlow Branching
- Github Issues & Managing Issues
- Continous Integration
- Automated Testing
- Docker Files
- Deployment

The database used for the application is the MyWorld database provided by the organisation. 

## Project Objectives 

The system must allow users to retrieve population information at different geographical levels and generate reports based on population.

The system must support:

1. Country population reports
2. City & Capital City population reports
3. Population statistics for geographical areas
4. Population statistics for people living inside cities and outside cities.
5. Population statistics for specified languages
6. Requests for the top N populated cities, capitals & countries

All reports must represent the information in a clear and understandable way.

## Database 

The application will use the provided World database.

The database contains information relating to:

- Countries.
- Cities.
- Continents.
- Regions.
- Districts.
- Populations.
- Languages.
- Country capitals.

The application should obtain its population information from the database rather than using hard-coded population values.

## Functional Requirements 

### Country Reports 

The system must provide a report containing all countries in the world ordered by population from largest to smallest.

The system must also provide country reports filtered by:

- Continent 
- Region

The system must support requests for the top N populated countries for:

- The World
- A Continent 
- A Region

Where N is supplied by the user, the system must return no more than N results.

### Country Report Fields

Each country report must contain:

- Country Code
- Country Name
- Continent 
- Region
- Population
- Capital City

Countries must be ordered by population from largest to smallest.

### City Reports 

The system must provide a report containing all cities in the world ordered by population from largest to smallest.

The system must also provide city reports filtered by:

- Continent 
- Region
- Country
- District

The system must support requests for the top N populated cities for:

- The world.
- A continent.
- A region.
- A country.
- A district.

Where N is supplied by the user, the system must return no more than N results.

### City Report Fields 

Each City report must contain:

- Name
- Country
- Population
- District

### Capital City Reports 

The system must provide reports containing capital cities ordered by population from largest to smallest.

The reports must be available for:

- The world.
- A continent.
- A region.

The system must also support requests for the top N populated capital cities for:

- The world.
- A continent.
- A region.

Where N is supplied by the user, the system must return no more than N results.

### Capital City Report Fields

Each Capital City Report field must contain:

- Name
- Country
- Population

### Population Reports 

The system must provide population reports for different geographical levels.

Population reports must be available for:

- Continents.
- Regions.
- Countries.

The system must provide the following information for each geographical area:

- Total population.
- Population living in cities.
- Percentage of the population living in cities.
- Population not living in cities.
- Percentage of the population not living in cities.

### Population Report Fields

- Name
- Total Population
- Population in Cities
- % in Cities
- Population not in Cities
- % not in Cities

The percentage values should be calculated from the relevant total population.

### General Population Queries 

The system must allow the organisation to retrieve the population of:

- The world.
- A continent.
- A region.
- A country.
- A district.
- A city.

The returned population should correspond to the population recorded in the database.

### Language Reports 

The system must provide information about the number of people who speak the following languages:

- Chinese.
- English.
- Hindi.
- Spanish.
- Arabic.

The languages must be presented in order from the greatest number of speakers to the smallest number of speakers.

The report must include:

- Language
- Population
- % of World Population

The percentage of the world population should be calculated using the total population of the world.

## User Input

Where a report requires a geographical filter, the user must be able to specify the relevant:

- Continent.
- Region.
- Country.
- District.
- City.

Where a report requires a top N result, the user must be able to provide the value of N.

The system should validate user input and handle invalid or unavailable selections appropriately.

For example:

- An invalid country should not cause the application to crash.
- An invalid N value should be handled appropriately.
- A request that produces no results should provide a suitable response to the user.

## Report Ordering 

Unless otherwise specified, population-based reports must be ordered from:

Largest population to Smallest population

This applies to:

- Countries.
- Cities.
- Capital cities.
- Language populations.

For top N reports, the system should return the highest-population entries first.

## Non-Functional Requirements 

### Maintainability 

The code should be structured so that it can be maintained and extended by the development team.

The project should:

- Follow appropriate Java coding conventions.
- Use meaningful names.
- Avoid unnecessary duplication.
- Include appropriate comments where required.
- Use suitable separation of responsibilities.

### Reliability 

The application should handle invalid input and database queries without unexpectedly terminating.

Errors should be handled in a way that provides useful information to the user.

### Testing 

The project must contain automated tests covering the implemented functionality.

Testing should include:

- Unit tests.
- Integration tests.

Tests must be executed automatically as part of the project's continuous integration process.

### Continuous Integration 

The project must use GitHub Actions for continuous integration.

The CI pipeline must:

- Build the application.
- Run the automated tests.
- Verify that the application can be packaged successfully.

### Docker 

The project must provide a Dockerfile.

The application must be capable of being built and run using Docker.

Docker functionality must also be incorporated into the GitHub Actions workflow where required by the assessment.

## Software Engineering Requirements 
The project must follow the software engineering processes required by the module.
### Scrum

The team will work using Scrum.

The team should maintain:

- A Product Backlog.
- User stories.
- Sprint planning.
- Sprint boards.
- Regular stand-ups.
- Sprint/task tracking.

### Github

GitHub must be used for source control and project management.

The project must use:

- GitHub repository.
- GitHub Issues.
- GitHub Project/Kanban board.
- GitHub Actions.
- Pull requests where appropriate.
- Git history to demonstrate individual contributions.

### GitFlow

The repository must contain the required GitFlow branches:

- master
- develop
- release

Feature development should be managed through appropriate branches before being integrated into the main development branch.

The project must maintain appropriate releases throughout development.

## Documentation Requirements 

The project should document the requirements and design of the system.

The following must be produced:

- Product Backlog.
- User stories.
- Full use cases.
- Use case diagram.
- Testing documentation.
- Code documentation where appropriate.
- Code of Conduct.
- Bug reporting process. 


## Assessment Milestones

The project will be assessed through four code reviews.

Each code review represents 25% of the overall coursework mark.

## Code Review 1 Requirements 

### Objective 

The first code review assesses whether the basic project workflow and development environment have been established.

### Required 

- GitHub project created.
- Product Backlog created.
- Project builds to a self-contained JAR using Maven.
- Dockerfile created and working.
- GitHub Actions configured.
- GitHub Actions builds the JAR.
- Docker is incorporated into GitHub Actions.
- master, develop, and release branches created.
- First GitHub release created.
- Code of Conduct defined.

### Quality Criteria 

The review will also consider:

- GitHub metrics.
- Individual contribution.
- Code quality.
- Code comments where appropriate.

## Code Review 2 Requirements

### Objective
The second code review assesses task management and requirements gathering.

At this stage, the team should have completed approximately 25% of the project work based on its own estimates.

### Required 

- GitHub Issues being used.
- Tasks represented as user stories.
- Zube.io integration completed where required.
- Kanban/Project Board being used.
- Sprint Boards being used.
- Full use cases defined.
- Use case diagram created.

### Quality Criteria 

The review will consider:

- GitHub metrics.
- Individual contribution.
- Code quality.
- Code comments.
- Correct branch usage.
- Continuous integration.
- Quality of use cases.
- Project requirements being met.

## Code Review 3 Requirements 

### Objective 

The third code review assesses the project's testing approach.

At this stage, approximately 50% of the project work should be completed.

### Required 

- Suitable unit tests defined.
- Suitable integration tests defined.
- Tests executing through GitHub Actions.

### Quality Criteria 

The review will consider:

- GitHub metrics.
- Individual contribution.
- Code quality.
- Correct branch usage.
- Continuous integration.
- Kanban/Project Board usage.
- Quality of unit tests.
- Test coverage.
- Project requirements being met.

## Code Review 4 Requirements 

### Objective 

The fourth code review assesses deployment and final project development.

At this stage, approximately 75% of the project work should be completed.

### Required 

- Application deployment working.
- Bug reporting system established.

### Quality Criteria 

e review will consider:

- GitHub metrics.
- Individual contribution.
- Code quality.
- Correct branch usage.
- Continuous integration.
- Kanban/Project Board usage.
- Quality and coverage of unit tests.
- Project requirements being met.

## Team Contribution 

The project must be completed as a group.

All team members are expected to contribute to:

- Development.
- Testing.
- Documentation.
- Project management.
- Code reviews.
- Scrum activities.

Individual contributions will be monitored through:

- Team contribution spreadsheets.
- Attendance.
- Code reviews.
- GitHub activity and metrics.
- Contributions to project tasks.
- Other evidence available to the teaching team.

The team must submit the required contribution spreadsheet at each assessment point.

The contribution percentages for each assessment point must total 100%.

## Contribution Assessment 

Individual contributions can affect the individual marks awarded for the coursework.

For example, if a team receives a group mark for a particular assessment point, that mark may be adjusted for individual team members based on their agreed contribution and evidence available to the teaching team.

Teams should therefore ensure that contributions are accurately recorded throughout the project.

If the team cannot agree on contribution percentages, or a team member disputes the submitted contribution percentages, the teaching team should be contacted.

## Team Conduct 

The team must establish and follow an appropriate Code of Conduct.

Team members are expected to:

- Attend required meetings.
- Participate in Scrum activities.
- Communicate with other team members.
- Complete agreed tasks.
- Contribute to the shared project.
- Follow the team's development processes.

If a team member is considered to have breached the team's Code of Conduct, the issue should be handled according to the procedures specified by the module.

## Code Review Attendance 

Each group will be allocated a time for each code review.

The code review has a maximum duration of 15 minutes.

All team members should attend.

### Late or Not Ready

If a group is late or is not ready when the review begins, the mark for that review may be capped at 40%.

### Non-Attendance 

Failure to attend the review results in the code review being marked at 0%, subject to the module's consideration of relevant circumstances.

The team must be ready to demonstrate the project at the allocated review time.

This includes having:

- Required development tools available.
- GitHub accessible.
- The project available.
- IntelliJ configured where required.
- A working version of the application.
- Required documentation available.

## Definition of Complete 

A feature should not be considered complete until:

- The required functionality has been implemented.
- The code has been reviewed appropriately.
- Appropriate tests have been created.
- Tests pass.
- The feature is integrated into the appropriate branch.
- The feature satisfies the relevant user story.
- Any relevant documentation has been updated.
- The feature can be demonstrated successfully.

## Overall Acceptance Criteria

The completed system should:

- Connect successfully to the World database.
- Generate all required country reports.
- Generate all required city reports.
- Generate all required capital city reports.
- Generate all required population reports.
- Generate the required language report.
- Support geographical filtering.
- Support top N queries.
- Order population-based reports correctly.
- Display the required report fields.
- Calculate population percentages correctly.
- Handle invalid input appropriately.
- Contain appropriate unit tests.
- Contain appropriate integration tests.
- Execute tests through GitHub Actions.
- Build successfully using Maven.
- Produce a self-contained JAR.
- Build successfully using Docker.
- Have a working CI pipeline.
- Be deployable.
- Have a bug reporting mechanism.
- Be maintained using the required Scrum and GitHub practices.

## Traceability

Each functional requirement should be represented by one or more user stories.

Each user story should have:

- A clear description.
- Acceptance criteria.
- Associated GitHub Issue.
- Assigned team member(s).
- Relevant implementation tasks.
- Relevant tests.

The team should be able to trace a requirement through:

Requirement → User Story → Issue → Code → Test → Demonstration

This traceability should be maintained throughout the project.

## Final Deliverable 

The final project must provide a working population reporting system that satisfies the functional requirements in this specification.

The GitHub repository should contain:

- Application source code.
- Maven configuration.
- Dockerfile.
- GitHub Actions workflows.
- Automated tests.
- Project documentation.
- Requirements/user stories.
- Use cases.
- Use case diagram.
- Code of Conduct.
- Bug reporting process.
- Appropriate Git branches and releases.

The final application must be demonstrably functional and satisfy the population reporting requirements defined above.

## Notes

Created by Hunter Macleod 23/09/26